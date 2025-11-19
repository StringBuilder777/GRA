package Unidad1_2.Ejercicios3;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class EjFileChooser extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FileChooser");

        Label archivoSeleccionado = new Label("Ningún archivo seleccionado");
        Button btnAbrir = new Button("Abrir archivo...");

        btnAbrir.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar un archivo de texto");

            // Filtro para mostrar solo ciertos tipos de archivos
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt")
            );

            File archivo = fileChooser.showOpenDialog(primaryStage);

            if (archivo != null) {
                archivoSeleccionado.setText("Archivo: " + archivo.getName());
                System.out.println("Ruta: " + archivo.getAbsolutePath());
            }
        });

        VBox vbox = new VBox(10, btnAbrir, archivoSeleccionado);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}