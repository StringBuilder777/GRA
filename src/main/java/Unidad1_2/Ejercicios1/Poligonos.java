package Unidad1_2.Ejercicios1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class Poligonos extends Application {
    public void start(Stage stage){
        SVGPath svgPath = new SVGPath();
        StringBuilder path = new StringBuilder("M 300 100 L 400 150 L 400 300 L 200 300 L 200 150");

        svgPath.setContent(path.toString());
        Group root = new Group(svgPath);
        Scene scene = new Scene(root,600,600);

        stage.setTitle("Unidad1_2.Ejercicios1.Poligonos");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
