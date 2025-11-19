package Unidad1_2.Ejercicios3;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.net.URI;

public class EjHyperlink extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de Hyperlink");

        Label etiqueta = new Label("Haz clic en el enlace:");
        Hyperlink hyperlink = new Hyperlink("Visita Google");

        Label feedback = new Label();

        hyperlink.setOnAction(e -> {
            try {
                // Abre el navegador con Google
                Desktop.getDesktop().browse(new URI("https://www.google.com"));
                feedback.setText("Abriendo Google en el navegador...");
            } catch (Exception ex) {
                ex.printStackTrace();
                feedback.setText("Error al intentar abrir la página.");
            }
        });

        VBox vbox = new VBox(10, etiqueta, hyperlink, feedback);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
