package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;

public class Practica4U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Cubo 1 - Rojo
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.RED);
        material1.setSpecularColor(Color.LIGHTCORAL);

        Box cubo1 = new Box(80, 80, 80);
        cubo1.setMaterial(material1);
        cubo1.setTranslateX(150);
        cubo1.setTranslateY(200);
        cubo1.setRotate(20);

        // Cubo 2 - Verde
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.GREEN);
        material2.setSpecularColor(Color.LIGHTGREEN);

        Box cubo2 = new Box(80, 80, 80);
        cubo2.setMaterial(material2);
        cubo2.setTranslateX(350);
        cubo2.setTranslateY(200);
        cubo2.setRotate(45);

        // Cubo 3 - Azul
        PhongMaterial material3 = new PhongMaterial();
        material3.setDiffuseColor(Color.BLUE);
        material3.setSpecularColor(Color.LIGHTBLUE);

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

        // Crear escena
        Group root = new Group(cubo1, cubo2, cubo3, light);
        Scene scene = new Scene(root, 700, 400, true);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("Práctica 4 - Tres Cubos de Colores");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
