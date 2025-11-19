package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChoiceBoxEje extends Application {
    @Override
    public void start(Stage stage) {
        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.getItems().addAll("A", "B", "C");
        cb.setValue("Opciones");
        cb.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
                System.out.println("Seleccionado: " + newValue)
        );

        StackPane root = new StackPane(cb);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("ChoiceBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}