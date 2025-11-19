package Unidad1_2.Ejercicios3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjSlider extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de Slider");

        Label etiqueta = new Label("");
        Label valorSlider = new Label("Valor: 50.0");

        // Slider con rango de 0 a 100, valor inicial 50
        Slider slider = new Slider(0, 100, 50);
        slider.setShowTickLabels(true); // Muestra números
        slider.setShowTickMarks(true); // Muestra marcas

        // Actualizar la etiqueta cuando cambia el valor
        slider.valueProperty().addListener((obs, oldVal, newVal) ->
                valorSlider.setText("Valor: " + String.format("%.2f", newVal))
        );

        VBox vbox = new VBox(10, etiqueta, slider, valorSlider);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}