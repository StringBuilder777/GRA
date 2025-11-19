package UNIDAD3_5;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.Box;

public class EJE1 extends Application {
    public void start(Stage primaryStage) {
        Box box = new Box(100,100,100);
        Group root = new Group(box);

        Scene scene = new Scene(root,400,200,true,SceneAntialiasing.DISABLED);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
