package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PasswordFieldEje extends Application {
    @Override
    public void start(Stage stage) {
        PasswordField pf = new PasswordField();
        pf.setPromptText("Ingresa tu contraseña");
        pf.setOnAction(e -> System.out.println(pf.getText()));

        StackPane root = new StackPane(pf);
        root.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("PasswordField");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
