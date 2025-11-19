package Unidad1_2.Ejercicios3;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EjProgreso extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de Progreso");

        Label labelBar = new Label("ProgressBar:");
        ProgressBar progressBar = new ProgressBar(0);

        Label labelIndicator = new Label("ProgressIndicator:");
        ProgressIndicator progressIndicator = new ProgressIndicator(0);

        VBox vbox = new VBox(10, labelBar, progressBar, labelIndicator, progressIndicator);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Timeline para actualizar el progreso cada 100ms
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100), event -> {
                    double progreso = progressBar.getProgress() + 0.01;
                    if (progreso > 1) {
                        progreso = 0; // reinicia el progreso
                    }
                    progressBar.setProgress(progreso);
                    progressIndicator.setProgress(progreso);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
