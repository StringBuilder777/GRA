package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;

public class Practica1U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Crear material para el cubo
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKBLUE);
        material.setSpecularColor(Color.LIGHTBLUE);

        // Crear cubo
        Box cubo = new Box(100, 100, 100);
        cubo.setMaterial(material);
        cubo.setTranslateX(250);
        cubo.setTranslateY(200);
        cubo.setRotate(45);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(250);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        // Crear escena
        Group root = new Group(cubo, light);
        Scene scene = new Scene(root, 500, 400, true);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("Práctica 1 - Cubo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
