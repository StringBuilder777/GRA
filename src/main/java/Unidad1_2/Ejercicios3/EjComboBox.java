package Unidad1_2.Ejercicios3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjComboBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de ComboBox");

        Label etiqueta = new Label("Selecciona una opcion:");
        Label seleccion = new Label("Selección: Ninguna");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("A", "B", "C");
        comboBox.setPromptText("Elige una opción");

        // Acción al seleccionar un elemento
        comboBox.setOnAction(e -> seleccion.setText("Selección: " + comboBox.getValue()));

        VBox vbox = new VBox(10, etiqueta, comboBox, seleccion);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}