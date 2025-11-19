package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;

public class Practica5U3 extends Application {
    @Override
    public void start(Stage stage) {
        // Esfera 1 - Amarilla
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.YELLOW);
        material1.setSpecularColor(Color.LIGHTYELLOW);

        Sphere esfera1 = new Sphere(60);
        esfera1.setMaterial(material1);
        esfera1.setTranslateX(150);
        esfera1.setTranslateY(200);

        // Esfera 2 - Magenta
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.MAGENTA);
        material2.setSpecularColor(Color.PINK);

        Sphere esfera2 = new Sphere(60);
        esfera2.setMaterial(material2);
        esfera2.setTranslateX(350);
        esfera2.setTranslateY(200);

        // Esfera 3 - Cyan
        PhongMaterial material3 = new PhongMaterial();
        material3.setDiffuseColor(Color.CYAN);
        material3.setSpecularColor(Color.LIGHTCYAN);

        Sphere esfera3 = new Sphere(60);
        esfera3.setMaterial(material3);
        esfera3.setTranslateX(550);
        esfera3.setTranslateY(200);

        // Crear iluminación
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(-500);

        // Crear escena
        Group root = new Group(esfera1, esfera2, esfera3, light);
        Scene scene = new Scene(root, 700, 400, true);
        scene.setFill(Color.LIGHTGRAY);

        stage.setTitle("Práctica 5 - Tres Esferas de Colores");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
