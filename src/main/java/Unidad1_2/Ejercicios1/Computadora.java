package Unidad1_2.Ejercicios1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Computadora extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(400, 500);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 400, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Unidad1_2.Ejercicios1.Computadora");
        primaryStage.show();

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.strokeRect(80, 40, 230, 280);
        gc.strokeRect(120, 80, 150, 200);
        gc.strokeRect(120, 320, 150, 30);
        gc.strokeRect(60, 350, 270, 120);
        gc.strokeRect(250, 380, 50, 10);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
