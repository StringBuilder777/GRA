package UNIDAD3_5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class SolarSystem3D extends Application {

    private double angle = 0;

    @Override
    public void start(Stage stage) {
        Group root = new Group();

        // Camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(3000.0);

        // Lighting
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(0);
        light.setTranslateY(0);
        light.setTranslateZ(-500);

        AmbientLight ambient = new AmbientLight(Color.color(0.3, 0.3, 0.3));

        // Sun
        Sphere sun = new Sphere(100);
        PhongMaterial sunMaterial = new PhongMaterial(Color.GOLD);
        sun.setMaterial(sunMaterial);

        // Planet 1 (e.g., Earth)
        Sphere earth = new Sphere(30);
        PhongMaterial earthMaterial = new PhongMaterial(Color.CORNFLOWERBLUE);
        earth.setMaterial(earthMaterial);

        Group earthOrbit = new Group(earth);
        earth.setTranslateX(200);  // Distance from the sun

        // Planet 2 (e.g., Mars)
        Sphere mars = new Sphere(20);
        PhongMaterial marsMaterial = new PhongMaterial(Color.DARKRED);
        mars.setMaterial(marsMaterial);

        Group marsOrbit = new Group(mars);
        mars.setTranslateX(300);

        Group solarSystem = new Group(sun, earthOrbit, marsOrbit, light, ambient);

        root.getChildren().add(solarSystem);

        Scene scene = new Scene(root, 800, 600, true);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);

        // Animation
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                angle += 0.5;

                // Earth's orbit
                earthOrbit.setRotationAxis(Rotate.Y_AXIS);
                earthOrbit.setRotate(angle);

                // Mars's orbit
                marsOrbit.setRotationAxis(Rotate.Y_AXIS);
                marsOrbit.setRotate(angle * 0.8);

                // Earth's own spin
                earth.setRotationAxis(Rotate.Y_AXIS);
                earth.setRotate(angle * 5);

                // Mars's own spin
                mars.setRotationAxis(Rotate.Y_AXIS);
                mars.setRotate(angle * 4);
            }
        };
        timer.start();

        stage.setTitle("JavaFX 3D Solar System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

