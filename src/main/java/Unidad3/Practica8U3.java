package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;

public class Practica8U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Esfera 1 - Textura 1.jpg
        PhongMaterial material1 = new PhongMaterial();
        try {
            Image texture1 = new Image(getClass().getResourceAsStream("/textures/1.jpg"));
            material1.setDiffuseMap(texture1);
            material1.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material1.setDiffuseColor(Color.web("#696969"));
        }
        material1.setSpecularColor(Color.gray(0.1));
        material1.setSpecularPower(2);

        Sphere esfera1 = new Sphere(60);
        esfera1.setMaterial(material1);
        esfera1.setTranslateX(150);
        esfera1.setTranslateY(200);

        // Esfera 2 - Textura 2.jpg
        PhongMaterial material2 = new PhongMaterial();
        try {
            Image texture2 = new Image(getClass().getResourceAsStream("/textures/2.jpg"));
            material2.setDiffuseMap(texture2);
            material2.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material2.setDiffuseColor(Color.web("#B0E0E6"));
        }
        material2.setSpecularColor(Color.gray(0.1));
        material2.setSpecularPower(2);

        Sphere esfera2 = new Sphere(60);
        esfera2.setMaterial(material2);
        esfera2.setTranslateX(350);
        esfera2.setTranslateY(200);

        // Esfera 3 - Textura 3.jpg
        PhongMaterial material3 = new PhongMaterial();
        try {
            Image texture3 = new Image(getClass().getResourceAsStream("/textures/3.jpg"));
            material3.setDiffuseMap(texture3);
            material3.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material3.setDiffuseColor(Color.web("#FFD700"));
        }
        material3.setSpecularColor(Color.gray(0.1));
        material3.setSpecularPower(2);

        Sphere esfera3 = new Sphere(60);
        esfera3.setMaterial(material3);
        esfera3.setTranslateX(550);
        esfera3.setTranslateY(200);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        AmbientLight ambientLight = new AmbientLight(Color.gray(0.3));

        // Crear escena
        Group root = new Group(esfera1, esfera2, esfera3, light, ambientLight);
        Scene scene = new Scene(root, 700, 400, true);
        scene.setFill(Color.DARKGRAY);

        stage.setTitle("Práctica 8 - Tres Esferas con Texturas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
