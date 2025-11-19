package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;

public class Practica9U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Cilindro 1 - Textura 1.jpg
        PhongMaterial material1 = new PhongMaterial();
        try {
            Image texture1 = new Image(getClass().getResourceAsStream("/textures/1.jpg"));
            material1.setDiffuseMap(texture1);
            material1.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material1.setDiffuseColor(Color.web("#B87333"));
        }
        material1.setSpecularColor(Color.gray(0.1));
        material1.setSpecularPower(2);

        Cylinder cilindro1 = new Cylinder(40, 120);
        cilindro1.setMaterial(material1);
        cilindro1.setTranslateX(150);
        cilindro1.setTranslateY(200);
        cilindro1.setRotate(15);

        // Cilindro 2 - Textura 2.jpg
        PhongMaterial material2 = new PhongMaterial();
        try {
            Image texture2 = new Image(getClass().getResourceAsStream("/textures/2.jpg"));
            material2.setDiffuseMap(texture2);
            material2.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material2.setDiffuseColor(Color.web("#C0C0C0"));
        }
        material2.setSpecularColor(Color.gray(0.1));
        material2.setSpecularPower(2);

        Cylinder cilindro2 = new Cylinder(40, 120);
        cilindro2.setMaterial(material2);
        cilindro2.setTranslateX(350);
        cilindro2.setTranslateY(200);
        cilindro2.setRotate(30);

        // Cilindro 3 - Textura 3.jpg
        PhongMaterial material3 = new PhongMaterial();
        try {
            Image texture3 = new Image(getClass().getResourceAsStream("/textures/3.jpg"));
            material3.setDiffuseMap(texture3);
            material3.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material3.setDiffuseColor(Color.web("#CD7F32"));
        }
        material3.setSpecularColor(Color.gray(0.1));
        material3.setSpecularPower(2);

        Cylinder cilindro3 = new Cylinder(40, 120);
        cilindro3.setMaterial(material3);
        cilindro3.setTranslateX(550);
        cilindro3.setTranslateY(200);
        cilindro3.setRotate(45);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        AmbientLight ambientLight = new AmbientLight(Color.gray(0.3));

        // Crear escena
        Group root = new Group(cilindro1, cilindro2, cilindro3, light, ambientLight);
        Scene scene = new Scene(root, 700, 400, true);
        scene.setFill(Color.DARKGRAY);

        stage.setTitle("Práctica 9 - Tres Cilindros con Texturas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
