package Unidad1_2.Ejercicios1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Curva extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root ,600,600, Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Unidad1_2.Ejercicios1.Curva");
        primaryStage.show();

        gc.setLineWidth(5.0);
        gc.setStroke(Color.BLUE);

        gc.bezierCurveTo(75,25,25,75,75,150);
        gc.stroke();

        gc.setFont(Font.font("Arial",20));
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Ejemplo curva", 200, 125);
        gc.setFill(Color.BROWN);
        gc.fillText("Unidad1_2.Ejercicios1.Curva de Bezier", 200, 200);
    }
}
