package UNIDAD3_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Planeta extends Application{
    public static int[] center = {470, 300, 5000};
    public static int[] dims;
    public static Color[] colores = {Color.LIGHTSKYBLUE, Color.WHITE, Color.LIGHTBLUE, Color.LIGHTSKYBLUE, Color.WHITE, Color.GOLD};
    public static int n_estrellas = 800;
    public static int radio_planeta = 200;
    public static int max_radio_estrella = 4;
    public static int max_distancia = 600;
    public Random generador;

    public Image readImage(String path) {
        String[] extensions = {".jpg", ".png", ".jpeg"};
        for (String ext : extensions) {
            try {
                return new Image(new FileInputStream(new File(path + ext)));
            } catch (FileNotFoundException ignored) {}
        }
        return null;
    }

    public int coordenadaAleatoria(){
        int coord = generador.nextInt(1, max_distancia);
        if(generador.nextBoolean()){
            coord *= -1;
        }
        return coord;
    }

    public Sphere crearEstrella(){
        Sphere estrella = new Sphere(generador.nextInt(1, max_radio_estrella), 50);
        estrella.setMaterial(new PhongMaterial(colores[generador.nextInt(colores.length)]));
        estrella.setTranslateX(generador.nextInt(1, dims[0]));
        estrella.setTranslateY(generador.nextInt(1, dims[1]));
        estrella.setTranslateZ(generador.nextInt(dims[2], dims[2] + 5));

        return estrella;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        stage.setFullScreen(false);
        stage.setMaximized(true);

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double width = screenBounds.getWidth();
        double height = screenBounds.getHeight();
        center = new int[]{(int) width / 2, (int) height / 2, 500};
        dims = new int[] {(int) width, (int) height, center[2]};

        Group root = new Group();
        generador = new Random();

        // Estrellas
        Group estrellas = new Group();
        for (int i = 0; i < n_estrellas; i++) {
            estrellas.getChildren().add(crearEstrella());
        }

        // Planeta
        Sphere planeta = new Sphere(radio_planeta, 100);
        planeta.setTranslateX(center[0]);
        planeta.setTranslateY(center[1]);
        planeta.setTranslateZ(center[2]);

        Image img = readImage("/Users/Emiliano/Downloads/hola fx/src/main/java/UNIDAD3_5/img/earth");
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(img);
        planeta.setMaterial(material);

        // Create a RotateTransition
        RotateTransition rotate = new RotateTransition(Duration.seconds(5), planeta);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(RotateTransition.INDEFINITE); // Infinite loop
        rotate.setInterpolator(javafx.animation.Interpolator.LINEAR); // Smooth constant speed
        rotate.play();       

        // Add a point light
        PointLight light = new PointLight(Color.GOLD);
        light.setTranslateX(450);
        light.setTranslateY(100);
        light.setTranslateZ(100);
        AmbientLight ambient = new AmbientLight(Color.DARKGRAY);


        root.getChildren().addAll(estrellas, planeta, light, ambient);
        Scene scene = new Scene(root, 1000, 600, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);

        stage.setTitle("Planeta y Estrellas");
        stage.setScene(scene);
        stage.show();
    }
}