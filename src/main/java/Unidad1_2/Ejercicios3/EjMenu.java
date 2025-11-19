package Unidad1_2.Ejercicios3;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EjMenu extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menú");

        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();

        // Menú "Archivo"
        Menu menuArchivo = new Menu("Archivo");
        MenuItem itemAbrir = new MenuItem("Abrir");
        MenuItem itemGuardar = new MenuItem("Guardar");
        MenuItem itemSalir = new MenuItem("Salir");
        itemSalir.setOnAction(e -> System.exit(0)); // Cierra la app
        menuArchivo.getItems().addAll(itemAbrir, itemGuardar, new SeparatorMenuItem(), itemSalir);

        // Menú "Editar"
        Menu menuEditar = new Menu("Editar");
        menuEditar.getItems().addAll(new MenuItem("Copiar"), new MenuItem("Pegar"));

        menuBar.getMenus().addAll(menuArchivo, menuEditar);

        root.setTop(menuBar);
        root.setCenter(new Label("Contenido de la aplicación"));

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}