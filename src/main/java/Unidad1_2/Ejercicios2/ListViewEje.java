package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListViewEje extends Application {
    @Override
    public void start(Stage stage) {
        ListView<String> lv = new ListView<>();
        lv.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
        lv.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
                System.out.println(newValue)
        );

        StackPane root = new StackPane(lv);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("ListView");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}