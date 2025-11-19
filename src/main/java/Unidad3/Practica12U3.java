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

public class Practica12U3 extends Application {
    private Cylinder cilindro;
    private Timeline currentAnimation;

    @Override
    public void start(Stage stage) {
        // Crear material para el cilindro
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKRED);
        material.setSpecularColor(Color.LIGHTCORAL);

        // Crear cilindro
        cilindro = new Cylinder(50, 150);
        cilindro.setMaterial(material);
        cilindro.setTranslateX(300);
        cilindro.setTranslateY(200);
        cilindro.setTranslateZ(0);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(300);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        AmbientLight ambientLight = new AmbientLight(Color.gray(0.3));

        // Crear grupo para la escena 3D
        Group group3D = new Group(cilindro, light, ambientLight);

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
        stage.setTitle("Práctica 12 - Animación de Cilindro");
        stage.setScene(scene);
        stage.show();
    }

    private void detenerAnimacion() {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }
        // Resetear posición y escala
        cilindro.setTranslateX(300);
        cilindro.setTranslateY(200);
        cilindro.setScaleX(1);
        cilindro.setScaleY(1);
        cilindro.setScaleZ(1);
        cilindro.setRotate(0);
    }

    private void iniciarTraslacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(cilindro.translateXProperty(), 300),
                new KeyValue(cilindro.translateYProperty(), 200)
            ),
            new KeyFrame(Duration.seconds(2),
                new KeyValue(cilindro.translateXProperty(), 450),
                new KeyValue(cilindro.translateYProperty(), 100)
            ),
            new KeyFrame(Duration.seconds(4),
                new KeyValue(cilindro.translateXProperty(), 300),
                new KeyValue(cilindro.translateYProperty(), 200)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    private void iniciarRotacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(cilindro.rotateProperty(), 0)
            ),
            new KeyFrame(Duration.seconds(3),
                new KeyValue(cilindro.rotateProperty(), 360)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    private void iniciarEscalacion() {
        detenerAnimacion();

        currentAnimation = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(cilindro.scaleXProperty(), 1),
                new KeyValue(cilindro.scaleYProperty(), 1),
                new KeyValue(cilindro.scaleZProperty(), 1)
            ),
            new KeyFrame(Duration.seconds(1.5),
                new KeyValue(cilindro.scaleXProperty(), 1.8),
                new KeyValue(cilindro.scaleYProperty(), 1.8),
                new KeyValue(cilindro.scaleZProperty(), 1.8)
            ),
            new KeyFrame(Duration.seconds(3),
                new KeyValue(cilindro.scaleXProperty(), 1),
                new KeyValue(cilindro.scaleYProperty(), 1),
                new KeyValue(cilindro.scaleZProperty(), 1)
            )
        );
        currentAnimation.setCycleCount(Timeline.INDEFINITE);
        currentAnimation.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
