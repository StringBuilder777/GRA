package UNIDAD3_5;

import javafx.application.Application;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.stage.Stage;

public class FigurasT extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    private void applyTransform(Shape3D target, Transform transform) {
        if (target != null && transform != null) {
            target.getTransforms().add(transform);
            //drawShape(root, active);
        }
    }

    @Override
    public void start(Stage stage){
        MenuBar menuBar = new MenuBar();

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

        Transform[][] base_transforms = {
            {new Rotate(30, Rotate.X_AXIS), new Rotate(45, Rotate.Y_AXIS)},
            null,
            {new Rotate(45, Rotate.Y_AXIS), new Rotate(45, Rotate.Z_AXIS)},
        };

        for(int i=0; i<shapes.length; i++) {
            shapes[i].setTranslateX(coords[i][0]);
            shapes[i].setTranslateY(coords[i][1]);
            shapes[i].setTranslateZ(coords[i][2]);

            shapes[i].setMaterial(new PhongMaterial(colors[i]));
            if(base_transforms[i] != null) shapes[i].getTransforms().addAll(base_transforms[i]);

            shapesGroup.getChildren().add(shapes[i]);
        }

        String[] figuras = {"Cubo", "Esfera", "Cilindro"};
        String[] transformaciones = {"Trasladar", "Rotar", "Escalar", "Sesgar"};

        Transform[][] transforms = {
            // Box transforms
            {
                new Translate(50, 0, 0),                          // Move right
                new Rotate(45, Rotate.Y_AXIS),                   // Rotate around Y
                new Scale(1.5, 1.5, 1.5),                         // Enlarge
                new Shear(0.3, 0.0)                               // Shear in X
            },
            // Sphere transforms
            {
                new Translate(-50, 30, 0),                        // Move left & up
                new Rotate(60, Rotate.X_AXIS),                   // Rotate around X
                new Scale(0.8, 0.8, 0.8),                         // Shrink
                new Shear(0.0, 0.2)                               // Shear in Y
            },
            // Cylinder transforms
            {
                new Translate(0, -50, 20),                        // Move down & forward
                new Rotate(90, Rotate.Z_AXIS),                   // Rotate around Z
                new Scale(1, 2, 1),                               // Stretch vertically
                new Shear(0.2, 0.2)                               // Shear diagonally
            }
        };

        Menu[] menus = new Menu[3];

        for(int i=0; i<figuras.length; i++){
            final int ii = i;

            menus[i] = new Menu(figuras[i]);

            for(int j=0; j<transformaciones.length; j++){
                final int jj = j;

                MenuItem item = new MenuItem(transformaciones[j]);
             
                item.setOnAction(e -> applyTransform(shapes[ii], transforms[ii][jj]));
                menus[i].getItems().add(item);
            }
        }

        menuBar.getMenus().addAll(menus);

        // Add a point light
        PointLight light = new PointLight(Color.DARKRED);
        light.setTranslateX(450);
        light.setTranslateY(100);
        light.setTranslateZ(100);

        AmbientLight ambient = new AmbientLight(Color.DARKGRAY);

        // Group and scene
        Group shapeRoot = new Group(shapesGroup, light, ambient);
        SubScene subScene = new SubScene(shapeRoot, 1000, 500, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.GRAY);
        //subScene.setCamera(camera);

        VBox vbox = new VBox(menuBar, subScene);
        Scene scene = new Scene(vbox);

        stage.setTitle("Figuras 3D y Transformaciones");
        stage.setScene(scene);
        stage.show();
    }
}
