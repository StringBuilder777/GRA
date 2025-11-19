package Unidad1_2.Ejercicios1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Lineas2D extends Application {
    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(600, 400);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Dibujo de lineas");
        primaryStage.show();

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(0, 0, 100, 10);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
