package Unidad1_2.Ejercicios1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Circulo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root ,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circulo");
        primaryStage.show();

        gc.setLineWidth(5.0);
        gc.setStroke(Color.BLUE);
        gc.fillOval(150, 100, 300, 300);
    }
}
