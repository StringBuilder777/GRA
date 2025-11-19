package Unidad3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.PhongMaterial;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import java.util.Random;

public class Practica13U3 extends Application {

    @Override
    public void start(Stage stage) {
        // Obtener dimensiones de la pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();

        // Grupo principal para todos los objetos
        Group root = new Group();

        // Crear estrellas de fondo
        crearEstrellas(root, 500);

        // Crear el Sol en el centro (más pequeño)
        Sphere sol = crearSol();
        root.getChildren().add(sol);

        // Crear planetas con sus órbitas y animaciones (más pequeños y separados)
        crearPlaneta(root, "Mercurio", 8, 150, Color.GRAY, 4, 0);
        crearPlaneta(root, "Venus", 12, 220, Color.SANDYBROWN, 6, 45);
        crearTierraConTextura(root, 13, 290, 8, 90);
        crearPlaneta(root, "Marte", 10, 360, Color.RED, 10, 135);
        crearPlaneta(root, "Júpiter", 28, 500, Color.ORANGE, 16, 180);

        // Saturno con anillos
        Group saturno = crearSaturnoConAnillos();
        animarPlaneta(saturno, 640, 20, 225);
        root.getChildren().add(saturno);

        crearPlaneta(root, "Urano", 20, 760, Color.LIGHTBLUE, 24, 270);
        crearPlaneta(root, "Neptuno", 19, 880, Color.DARKBLUE, 28, 315);

        // Crear iluminación
        AmbientLight ambientLight = new AmbientLight(Color.gray(0.1));

        PointLight sunLight = new PointLight(Color.WHITE);
        sunLight.setTranslateX(0);
        sunLight.setTranslateY(0);
        sunLight.setTranslateZ(0);

        root.getChildren().addAll(ambientLight, sunLight);

        // Configurar cámara (más alejada para ver todo el sistema)
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1500);
        camera.setTranslateY(-200);
        camera.setNearClip(0.1);
        camera.setFarClip(4000.0);
        camera.setFieldOfView(45);

        // Crear escena con tamaño de pantalla completa
        SubScene subScene = new SubScene(root, screenWidth, screenHeight, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.BLACK);
        subScene.setCamera(camera);

        Group mainRoot = new Group(subScene);
        Scene scene = new Scene(mainRoot, screenWidth, screenHeight);

        stage.setTitle("Práctica 13 - Sistema Solar");
        stage.setScene(scene);
        stage.setMaximized(true);  // Maximizar ventana
        stage.setFullScreen(true);  // Pantalla completa
        stage.setFullScreenExitHint("Presiona ESC para salir de pantalla completa");
        stage.show();

        // Permitir rotar la cámara con el mouse
        configurarControlCamara(subScene, camera);
    }

    private Sphere crearSol() {
        Sphere sol = new Sphere(35);

        // Material brillante para el sol
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.YELLOW);
        material.setSpecularColor(Color.YELLOW.brighter());
        WritableImage texturaBrillante = crearTexturaBrillante(100, 100, Color.YELLOW, Color.ORANGE);
        material.setDiffuseMap(texturaBrillante);
        material.setSelfIlluminationMap(texturaBrillante);

        sol.setMaterial(material);

        // Animación de rotación del sol
        RotateTransition rotacion = new RotateTransition(Duration.seconds(10), sol);
        rotacion.setByAngle(360);
        rotacion.setAxis(Rotate.Y_AXIS);
        rotacion.setCycleCount(Animation.INDEFINITE);
        rotacion.setInterpolator(Interpolator.LINEAR);
        rotacion.play();

        return sol;
    }

    private void crearPlaneta(Group root, String nombre, double radio, double distanciaOrbita,
                              Color color, double velocidadOrbita, double anguloInicial) {
        // Crear el planeta
        Sphere planeta = new Sphere(radio);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        material.setSpecularColor(color.brighter());
        planeta.setMaterial(material);

        // Crear grupo para el planeta (para rotación propia)
        Group grupoPlaneta = new Group(planeta);

        // Animación de rotación propia del planeta
        RotateTransition rotacionPropia = new RotateTransition(Duration.seconds(2), planeta);
        rotacionPropia.setByAngle(360);
        rotacionPropia.setAxis(Rotate.Y_AXIS);
        rotacionPropia.setCycleCount(Animation.INDEFINITE);
        rotacionPropia.setInterpolator(Interpolator.LINEAR);
        rotacionPropia.play();

        // Animar órbita
        animarPlaneta(grupoPlaneta, distanciaOrbita, velocidadOrbita, anguloInicial);

        root.getChildren().add(grupoPlaneta);
    }

    private void crearTierraConTextura(Group root, double radio, double distanciaOrbita,
                                       double velocidadOrbita, double anguloInicial) {
        // Crear la esfera de la Tierra
        Sphere tierra = new Sphere(radio);

        // Cargar la textura del mapa mundial
        PhongMaterial material = new PhongMaterial();
        try {
            Image textura = new Image(getClass().getResourceAsStream("/textures/earth_texture.jpg"));
            material.setDiffuseMap(textura);
            material.setSpecularColor(Color.color(0.3, 0.3, 0.5)); // Reflejo del agua
        } catch (Exception e) {
            // Si no se puede cargar la textura, usar color azul por defecto
            material.setDiffuseColor(Color.BLUE);
            material.setSpecularColor(Color.LIGHTBLUE);
            System.out.println("No se pudo cargar la textura de la Tierra: " + e.getMessage());
        }
        tierra.setMaterial(material);

        // Crear grupo para la Tierra (para rotación propia)
        Group grupoTierra = new Group(tierra);

        // Animación de rotación propia de la Tierra
        RotateTransition rotacionPropia = new RotateTransition(Duration.seconds(2), tierra);
        rotacionPropia.setByAngle(360);
        rotacionPropia.setAxis(Rotate.Y_AXIS);
        rotacionPropia.setCycleCount(Animation.INDEFINITE);
        rotacionPropia.setInterpolator(Interpolator.LINEAR);
        rotacionPropia.play();

        // Animar órbita
        animarPlaneta(grupoTierra, distanciaOrbita, velocidadOrbita, anguloInicial);

        root.getChildren().add(grupoTierra);
    }

    private void animarPlaneta(Group grupoPlaneta, double radio, double velocidad, double anguloInicial) {
        // Crear transformaciones para la órbita
        Rotate rotacionOrbita = new Rotate(anguloInicial, Rotate.Y_AXIS);
        grupoPlaneta.getTransforms().add(rotacionOrbita);

        // Posicionar en la órbita
        grupoPlaneta.setTranslateX(radio);

        // Animación de traslación orbital
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(rotacionOrbita.angleProperty(), anguloInicial, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(velocidad), new KeyValue(rotacionOrbita.angleProperty(), anguloInicial + 360, Interpolator.LINEAR))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private Group crearSaturnoConAnillos() {
        // Crear el planeta Saturno (más pequeño)
        Sphere saturno = new Sphere(24);
        PhongMaterial materialSaturno = new PhongMaterial();
        materialSaturno.setDiffuseColor(Color.WHEAT);
        materialSaturno.setSpecularColor(Color.LIGHTYELLOW);
        saturno.setMaterial(materialSaturno);

        // Crear anillos usando cilindros aplanados (proporcionalmente más pequeños)
        Cylinder anillo1 = new Cylinder(38, 2);
        PhongMaterial materialAnillo1 = new PhongMaterial();
        materialAnillo1.setDiffuseColor(Color.color(0.8, 0.7, 0.5, 0.7));
        anillo1.setMaterial(materialAnillo1);
        anillo1.setRotationAxis(Rotate.X_AXIS);
        anillo1.setRotate(90);

        Cylinder anillo2 = new Cylinder(32, 2);
        PhongMaterial materialAnillo2 = new PhongMaterial();
        materialAnillo2.setDiffuseColor(Color.color(0.7, 0.6, 0.4, 0.6));
        anillo2.setMaterial(materialAnillo2);
        anillo2.setRotationAxis(Rotate.X_AXIS);
        anillo2.setRotate(90);

        // Agrupar Saturno con sus anillos
        Group grupoSaturno = new Group(saturno, anillo1, anillo2);

        // Rotación propia de Saturno
        RotateTransition rotacion = new RotateTransition(Duration.seconds(3), grupoSaturno);
        rotacion.setByAngle(360);
        rotacion.setAxis(Rotate.Y_AXIS);
        rotacion.setCycleCount(Animation.INDEFINITE);
        rotacion.setInterpolator(Interpolator.LINEAR);
        rotacion.play();

        return grupoSaturno;
    }

    private void crearEstrellas(Group root, int cantidad) {
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            // Crear estrella pequeña
            Sphere estrella = new Sphere(random.nextDouble() * 2 + 0.5);

            PhongMaterial material = new PhongMaterial();
            material.setDiffuseColor(Color.WHITE);
            material.setSelfIlluminationMap(crearTexturaBrillante(10, 10, Color.WHITE, Color.LIGHTGRAY));
            estrella.setMaterial(material);

            // Posición aleatoria en el espacio (área más amplia)
            estrella.setTranslateX(random.nextDouble() * 3500 - 1750);
            estrella.setTranslateY(random.nextDouble() * 2500 - 1250);
            estrella.setTranslateZ(random.nextDouble() * 2000 + 200);

            root.getChildren().add(estrella);

            // Animación de parpadeo para algunas estrellas
            if (random.nextDouble() > 0.7) {
                FadeTransition parpadeo = new FadeTransition(Duration.seconds(random.nextDouble() * 3 + 1), estrella);
                parpadeo.setFromValue(1.0);
                parpadeo.setToValue(0.3);
                parpadeo.setCycleCount(Animation.INDEFINITE);
                parpadeo.setAutoReverse(true);
                parpadeo.play();
            }
        }
    }

    private WritableImage crearTexturaBrillante(int width, int height, Color color1, Color color2) {
        WritableImage image = new WritableImage(width, height);
        PixelWriter pixelWriter = image.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Crear gradiente radial
                double dx = (x - width / 2.0) / (width / 2.0);
                double dy = (y - height / 2.0) / (height / 2.0);
                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance <= 1.0) {
                    Color color = color1.interpolate(color2, distance);
                    pixelWriter.setColor(x, y, color);
                } else {
                    pixelWriter.setColor(x, y, color2);
                }
            }
        }
        return image;
    }

    private void configurarControlCamara(SubScene subScene, PerspectiveCamera camera) {
        final double[] mouseX = {0};
        final double[] mouseY = {0};

        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        camera.getTransforms().addAll(rotateX, rotateY);

        subScene.setOnMousePressed(event -> {
            mouseX[0] = event.getSceneX();
            mouseY[0] = event.getSceneY();
        });

        subScene.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseX[0];
            double deltaY = event.getSceneY() - mouseY[0];

            rotateY.setAngle(rotateY.getAngle() + deltaX * 0.3);
            rotateX.setAngle(rotateX.getAngle() - deltaY * 0.3);

            mouseX[0] = event.getSceneX();
            mouseY[0] = event.getSceneY();
        });

        // Zoom con scroll
        subScene.setOnScroll(event -> {
            double delta = event.getDeltaY();
            camera.setTranslateZ(camera.getTranslateZ() + delta);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
