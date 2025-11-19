package Unidad1_2.Ejercicios1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Poligono2 extends Application {
    public void start(Stage stage) {
        Group root = new Group();
        Canvas canvas = new Canvas(600, 600);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 600, 600, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Estrella con SVGPath");

        stage.show();

        gc.setLineWidth(5.0);
        gc.setStroke(Color.BLUE);
        gc.setFill(Color.RED);

        gc.beginPath();
        gc.appendSVGPath("M 226 279 L 196 388 L 82 386 L 177 449"+
                "L 139 557 L 229 486 L 320 555 L 280 448"+
                "L 373 383 L 259 388L 226 279 z");
        gc.fill();
        gc.stroke();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
