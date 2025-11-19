package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TextFieldEje extends Application {
    @Override
    public void start(Stage stage) {
        TextField tf = new TextField();
        tf.setOnAction(e -> System.out.println(tf.getText()));

        StackPane root = new StackPane(tf);
        root.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("TextField");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
