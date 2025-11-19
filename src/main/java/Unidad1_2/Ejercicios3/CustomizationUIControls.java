package Unidad1_2.Ejercicios3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomizationUIControls extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("");

        Label label = new Label("");
        Slider slider = new Slider(0, 1, 0.5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.25);


        ProgressIndicator progressIndicator = new ProgressIndicator(slider.getValue());

        // Sincronizamos la barra y el indicador con el slider
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            progressIndicator.setProgress(newVal.doubleValue());
        });

        VBox root = new VBox(15, label, slider, progressIndicator);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #1e1e2f; -fx-text-fill: white;");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

