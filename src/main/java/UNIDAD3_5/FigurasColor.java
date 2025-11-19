package UNIDAD3_5;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class FigurasColor extends Application {
    @Override
    public void start(Stage stage) {
        Shape3D[] shapes = {
                new Box(200, 200, 200),
                new Sphere(150, 100),
                new Cylinder(80, 200)
        };
        Group shapesGroup = new Group();

        int[][] coords = {
                {470, 200, 400},
                {820, 200, 400},
                {180, 200, 400}

        };

        Color[] colors = {
                Color.MEDIUMSEAGREEN,
                Color.LIGHTSALMON,
                Color.BLUEVIOLET
        };

        Transform[][] transforms = {
            {new Rotate(30, Rotate.X_AXIS), new Rotate(45, Rotate.Y_AXIS)},
            null,
            {new Rotate(45, Rotate.Y_AXIS), new Rotate(45, Rotate.Z_AXIS)},
        };

        for(int i=0; i<shapes.length; i++) {
            shapes[i].setTranslateX(coords[i][0]);
            shapes[i].setTranslateY(coords[i][1]);
            shapes[i].setTranslateZ(coords[i][2]);

            shapes[i].setMaterial(new PhongMaterial(colors[i]));
            if(transforms[i] != null) shapes[i].getTransforms().addAll(transforms[i]);

            shapesGroup.getChildren().add(shapes[i]);
        }

        // Add a point light
        PointLight light = new PointLight(Color.DARKRED);
        light.setTranslateX(450);
        light.setTranslateY(100);
        light.setTranslateZ(100);

        AmbientLight ambient = new AmbientLight(Color.DARKGRAY);

        // Group and scene
        Group root = new Group(shapesGroup, light, ambient);
        Scene scene = new Scene(root, 1000, 500, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.GRAY);

        stage.setTitle("Figuras 3D a Color");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
