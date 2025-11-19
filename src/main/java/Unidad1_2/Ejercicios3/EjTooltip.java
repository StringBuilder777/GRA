package Unidad1_2.Ejercicios3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjTooltip extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tooltip");

        Button boton = new Button("");

        // Crear y asignar el tooltip
        Tooltip tooltip = new Tooltip("Este es un mensaje emergente.");
        boton.setTooltip(tooltip);

        VBox vbox = new VBox(boton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}