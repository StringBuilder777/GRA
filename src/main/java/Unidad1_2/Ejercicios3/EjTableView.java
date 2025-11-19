package Unidad1_2.Ejercicios3;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjTableView extends Application {

    // Clase modelo para los datos de la tabla
    public static class Persona {
        private final String nombre;
        private final String apellido;

        public Persona(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombre() { return nombre; }
        public String getApellido() { return apellido; }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de TableView");

        TableView<Persona> tableView = new TableView<>();

        // Columna para el nombre
        TableColumn<Persona, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        // Columna para el apellido
        TableColumn<Persona, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        tableView.getColumns().addAll(colNombre, colApellido);

        // Datos de ejemplo
        ObservableList<Persona> data = FXCollections.observableArrayList(
                new Persona("Luis", "Luis.1"),
                new Persona("Luis1", "Luis1.1"),
                new Persona("Luis2", "Luis2.1")
        );
        tableView.setItems(data);

        VBox vbox = new VBox(tableView);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
