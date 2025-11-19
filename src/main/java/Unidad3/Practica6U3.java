package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;

public class Practica6U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Cilindro 1 - Naranja
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.ORANGE);
        material1.setSpecularColor(Color.LIGHTYELLOW);

        Cylinder cilindro1 = new Cylinder(40, 120);
        cilindro1.setMaterial(material1);
        cilindro1.setTranslateX(150);
        cilindro1.setTranslateY(200);
        cilindro1.setRotate(15);

        // Cilindro 2 - Púrpura
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.PURPLE);
        material2.setSpecularColor(Color.LAVENDER);

        Cylinder cilindro2 = new Cylinder(40, 120);
        cilindro2.setMaterial(material2);
        cilindro2.setTranslateX(350);
        cilindro2.setTranslateY(200);
        cilindro2.setRotate(30);

        // Cilindro 3 - Verde Oliva
        PhongMaterial material3 = new PhongMaterial();
        material3.setDiffuseColor(Color.OLIVE);
        material3.setSpecularColor(Color.LIGHTGREEN);

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

        // Crear escena
        Group root = new Group(cilindro1, cilindro2, cilindro3, light);
        Scene scene = new Scene(root, 700, 400, true);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("Práctica 6 - Tres Cilindros de Colores");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
