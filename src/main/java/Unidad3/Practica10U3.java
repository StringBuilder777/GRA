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

public class Practica10U3 extends Application {
    private Box cubo;
    private Timeline currentAnimation;

    @Override
    public void start(Stage stage) {
        // Crear material para el cubo
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKBLUE);
        material.setSpecularColor(Color.LIGHTBLUE);

        // Crear cubo
        cubo = new Box(100, 100, 100);
        cubo.setMaterial(material);
        cubo.setTranslateX(300);
        cubo.setTranslateY(200);
        cubo.setTranslateZ(0);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(300);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        AmbientLight ambientLight = new AmbientLight(Color.gray(0.3));

        // Crear grupo para la escena 3D
        Group group3D = new Group(cubo, light, ambientLight);

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
        stage.setTitle("Práctica 10 - Animación de Cubo");
        stage.setScene(scene);
        stage.show();
    }

    private void detenerAnimacion() {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }
        // Resetear posición y escala
        cubo.setTranslateX(300);
        cubo.setTranslateY(200);
        cubo.setScaleX(1);
        cubo.setScaleY(1);
        cubo.setScaleZ(1);
        cubo.setRotate(0);
    }

    private void iniciarTraslacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(cubo.translateXProperty(), 300),
                new KeyValue(cubo.translateYProperty(), 200)
            ),
            new KeyFrame(Duration.seconds(2),
                new KeyValue(cubo.translateXProperty(), 450),
                new KeyValue(cubo.translateYProperty(), 100)
            ),
            new KeyFrame(Duration.seconds(4),
                new KeyValue(cubo.translateXProperty(), 300),
                new KeyValue(cubo.translateYProperty(), 200)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    private void iniciarRotacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(cubo.rotateProperty(), 0)
            ),
            new KeyFrame(Duration.seconds(3),
                new KeyValue(cubo.rotateProperty(), 360)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    private void iniciarEscalacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(cubo.scaleXProperty(), 1),
                new KeyValue(cubo.scaleYProperty(), 1),
                new KeyValue(cubo.scaleZProperty(), 1)
            ),
            new KeyFrame(Duration.seconds(1.5),
                new KeyValue(cubo.scaleXProperty(), 1.8),
                new KeyValue(cubo.scaleYProperty(), 1.8),
                new KeyValue(cubo.scaleZProperty(), 1.8)
            ),
            new KeyFrame(Duration.seconds(3),
                new KeyValue(cubo.scaleXProperty(), 1),
                new KeyValue(cubo.scaleYProperty(), 1),
                new KeyValue(cubo.scaleZProperty(), 1)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
