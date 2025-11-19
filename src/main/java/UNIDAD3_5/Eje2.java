package UNIDAD3_5;
import javafx.application.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.Box;
public class Eje2 extends Application {
    public void start(Stage primaryStage) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        material.setSpecularColor(Color.rgb(0,0,0,0));

        PointLight pointLight = new PointLight();
        pointLight.setTranslateX(-350);
        pointLight.setTranslateY(-270);
        pointLight.setTranslateZ(-500);

        Box box = new Box(250,250,250);
        box.setMaterial(material);
        box.setTranslateX(300);
        box.setTranslateY(300);
        box.setTranslateZ(100);
        box.setRotate(15);
        box.setDrawMode(DrawMode.FILL);
        box.setCullFace(CullFace.BACK);

        PointLight pointLight2 = new PointLight();
        pointLight2.setTranslateX(80);
        pointLight2.setTranslateY(-1000);
        pointLight2.setTranslateZ(-1000);

        Group group = new Group(box,pointLight);
        group.getChildren().add(pointLight2);
        Scene scene = new Scene(group,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
