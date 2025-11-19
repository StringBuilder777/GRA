package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelWriter;
import javafx.scene.transform.Rotate;

public class Practica11U3 extends Application {
    private Sphere esfera;
    private Timeline currentAnimation;
    private Rotate rotateY;

    @Override
    public void start(Stage stage) {
        // Crear textura con patrón de rayas para visualizar la rotación
        WritableImage textureImage = createStripedTexture(200, 200);

        // Crear material para la esfera con textura
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(textureImage);
        material.setSpecularColor(Color.LIGHTGREEN);

        // Crear esfera
        esfera = new Sphere(80);
        esfera.setMaterial(material);
        esfera.setTranslateX(300);
        esfera.setTranslateY(200);
        esfera.setTranslateZ(0);

        // Crear transformación de rotación 3D
        rotateY = new Rotate(0, Rotate.Y_AXIS);
        esfera.getTransforms().add(rotateY);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(300);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        AmbientLight ambientLight = new AmbientLight(Color.gray(0.3));

        // Crear grupo para la escena 3D
        Group group3D = new Group(esfera, light, ambientLight);

        // Crear subescena 3D
        SubScene subScene = new SubScene(group3D, 600, 400, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.LIGHTGRAY);

        // Crear botones del menú
        Button btnTraslacion = new Button("Traslación");
        Button btnRotacion = new Button("Rotación");
        Button btnEscalacion = new Button("Escalación");
        Button btnDetener = new Button("Detener");

        btnTraslacion.setPrefWidth(120);
        btnRotacion.setPrefWidth(120);
        btnEscalacion.setPrefWidth(120);
        btnDetener.setPrefWidth(120);

        // Configurar acciones de botones
        btnTraslacion.setOnAction(e -> iniciarTraslacion());
        btnRotacion.setOnAction(e -> iniciarRotacion());
        btnEscalacion.setOnAction(e -> iniciarEscalacion());
        btnDetener.setOnAction(e -> detenerAnimacion());

        // Crear panel de menú
        VBox menuPanel = new VBox(10);
        menuPanel.setPadding(new Insets(10));
        menuPanel.getChildren().addAll(
            new Label("Menú de Animaciones:"),
            btnTraslacion,
            btnRotacion,
            btnEscalacion,
            btnDetener
        );
        menuPanel.setStyle("-fx-background-color: #f0f0f0;");

        // Layout principal
        BorderPane root = new BorderPane();
        root.setCenter(subScene);
        root.setRight(menuPanel);

        Scene scene = new Scene(root, 750, 400);
        stage.setTitle("Práctica 11 - Animación de Esfera");
        stage.setScene(scene);
        stage.show();
    }

    private void detenerAnimacion() {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }
        // Resetear posición y escala
        esfera.setTranslateX(300);
        esfera.setTranslateY(200);
        esfera.setScaleX(1);
        esfera.setScaleY(1);
        esfera.setScaleZ(1);
        esfera.setRotate(0);
        rotateY.setAngle(0);
    }

    private void iniciarTraslacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(esfera.translateXProperty(), 300),
                new KeyValue(esfera.translateYProperty(), 200)
            ),
            new KeyFrame(Duration.seconds(2),
                new KeyValue(esfera.translateXProperty(), 450),
                new KeyValue(esfera.translateYProperty(), 100)
            ),
            new KeyFrame(Duration.seconds(4),
                new KeyValue(esfera.translateXProperty(), 300),
                new KeyValue(esfera.translateYProperty(), 200)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    private void iniciarRotacion() {
        detenerAnimacion();

        // Usar rotación 3D en el eje Y para ver mejor el patrón de colores
        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(rotateY.angleProperty(), 0)
            ),
            new KeyFrame(Duration.seconds(3),
                new KeyValue(rotateY.angleProperty(), 360)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    private void iniciarEscalacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(esfera.scaleXProperty(), 1),
                new KeyValue(esfera.scaleYProperty(), 1),
                new KeyValue(esfera.scaleZProperty(), 1)
            ),
            new KeyFrame(Duration.seconds(1.5),
                new KeyValue(esfera.scaleXProperty(), 1.8),
                new KeyValue(esfera.scaleYProperty(), 1.8),
                new KeyValue(esfera.scaleZProperty(), 1.8)
            ),
            new KeyFrame(Duration.seconds(3),
                new KeyValue(esfera.scaleXProperty(), 1),
                new KeyValue(esfera.scaleYProperty(), 1),
                new KeyValue(esfera.scaleZProperty(), 1)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    // Método para crear una textura con rayas de colores
    private WritableImage createStripedTexture(int width, int height) {
        WritableImage image = new WritableImage(width, height);
        PixelWriter pixelWriter = image.getPixelWriter();

        // Crear patrón de rayas verticales y horizontales
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color;
                // Rayas verticales cada 20 píxeles
                if ((x / 20) % 3 == 0) {
                    color = Color.DARKGREEN;
                } else if ((x / 20) % 3 == 1) {
                    color = Color.YELLOW;
                } else {
                    color = Color.ORANGE;
                }

                // Agregar rayas horizontales para mayor visibilidad
                if ((y / 20) % 2 == 0) {
                    color = color.brighter();
                }

                pixelWriter.setColor(x, y, color);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
