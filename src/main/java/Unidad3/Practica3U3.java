package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;

public class Practica3U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Crear material para el cilindro
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKRED);
        material.setSpecularColor(Color.LIGHTCORAL);

        // Crear cilindro
        Cylinder cilindro = new Cylinder(50, 150);
        cilindro.setMaterial(material);
        cilindro.setTranslateX(250);
        cilindro.setTranslateY(200);
        cilindro.setRotate(30);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(250);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        // Crear escena
        Group root = new Group(cilindro, light);
        Scene scene = new Scene(root, 500, 400, true);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("Práctica 3 - Cilindro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
