package Unidad1_2.Ejercicios3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class EjHTMLEditor extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(200);
        root.getChildren().add(htmlEditor);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("HTMLEditor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}