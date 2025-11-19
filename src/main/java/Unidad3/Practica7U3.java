package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;

public class Practica7U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Cubo 1 - Textura 1.jpg
        PhongMaterial material1 = new PhongMaterial();
        try {
            Image texture1 = new Image(getClass().getResourceAsStream("/textures/1.jpg"));
            material1.setDiffuseMap(texture1);
            material1.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material1.setDiffuseColor(Color.web("#8B4513"));
        }
        material1.setSpecularColor(Color.gray(0.1));
        material1.setSpecularPower(2);

        Box cubo1 = new Box(80, 80, 80);
        cubo1.setMaterial(material1);
        cubo1.setTranslateX(150);
        cubo1.setTranslateY(200);
        cubo1.setRotate(20);

        // Cubo 2 - Textura 2.jpg
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

        Box cubo2 = new Box(80, 80, 80);
        cubo2.setMaterial(material2);
        cubo2.setTranslateX(350);
        cubo2.setTranslateY(200);
        cubo2.setRotate(45);

        // Cubo 3 - Textura 3.jpg
        PhongMaterial material3 = new PhongMaterial();
        try {
            Image texture3 = new Image(getClass().getResourceAsStream("/textures/3.jpg"));
            material3.setDiffuseMap(texture3);
            material3.setDiffuseColor(Color.WHITE);
        } catch (Exception e) {
            material3.setDiffuseColor(Color.web("#8B7355"));
        }
        material3.setSpecularColor(Color.gray(0.1));
        material3.setSpecularPower(2);

        Box cubo3 = new Box(80, 80, 80);
        cubo3.setMaterial(material3);
        cubo3.setTranslateX(550);
        cubo3.setTranslateY(200);
        cubo3.setRotate(60);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        AmbientLight ambientLight = new AmbientLight(Color.gray(0.3));

        // Crear escena
        Group root = new Group(cubo1, cubo2, cubo3, light, ambientLight);
        Scene scene = new Scene(root, 700, 400, true);
        scene.setFill(Color.DARKGRAY);

        stage.setTitle("Práctica 7 - Tres Cubos con Texturas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
