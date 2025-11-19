package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckboxEje extends Application {
    @Override
    public void start(Stage stage) {
        CheckBox cb1 = new CheckBox("Opción A");
        CheckBox cb2 = new CheckBox("Opción B");
        CheckBox cb3 = new CheckBox("Opción C");

        cb1.setOnAction(e -> System.out.println("Opción A: " + cb1.isSelected()));
        cb2.setOnAction(e -> System.out.println("Opción B: " + cb2.isSelected()));
        cb3.setOnAction(e -> System.out.println("Opción C: " + cb3.isSelected()));

        VBox root = new VBox(10, cb1, cb2, cb3);
        root.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("CheckBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}