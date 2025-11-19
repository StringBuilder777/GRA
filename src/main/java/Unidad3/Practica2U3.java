package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;

public class Practica2U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Crear material para la esfera
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.DARKGREEN);
        material.setSpecularColor(Color.LIGHTGREEN);

        // Crear esfera
        Sphere esfera = new Sphere(80);
        esfera.setMaterial(material);
        esfera.setTranslateX(250);
        esfera.setTranslateY(200);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(250);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        // Crear escena
        Group root = new Group(esfera, light);
        Scene scene = new Scene(root, 500, 400, true);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("Práctica 2 - Esfera");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
