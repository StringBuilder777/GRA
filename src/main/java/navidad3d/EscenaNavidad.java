package navidad3d;

import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.InputStream;
import java.util.*;

/**
 * Controlador principal de la escena 3D navideña
 */
public class EscenaNavidad {

    private Group root;
    private PerspectiveCamera camera;
    private Group modeloGroup;
    private MusicController musicController;

    // Control de cámara
    private double velocidadCamara = 1.0;
    private Rotate rotacionX = new Rotate(0, Rotate.X_AXIS);
    private Rotate rotacionY = new Rotate(0, Rotate.Y_AXIS);
    private double mouseAnteriorX, mouseAnteriorY;

    // Teclas presionadas
    private Set<KeyCode> teclasPresionadas = new HashSet<>();

    // Piñata
    private Node pinataMesh;
    private Timeline animacionLuces;

    // Luces navideñas
    private List<Node> lucesNavidenas = new ArrayList<>();
    private int patronLucesActual = 0;
    private Color[] coloresNavidenos = {
        Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
        Color.ORANGE, Color.PURPLE, Color.WHITE, Color.GOLD
    };

    public EscenaNavidad() {
        inicializarEscena();
        configurarCamara();
        cargarModelo();
        configurarIluminacion();
        configurarPinata();
        configurarLucesNavidenas();
        configurarControles();
        iniciarAnimacionCamara();
    }

    private void inicializarEscena() {
        root = new Group();
        musicController = new MusicController();
    }

    private void configurarCamara() {
        camera = new PerspectiveCamera(true);
        camera.setFieldOfView(45);
        camera.setNearClip(0.1);
        camera.setFarClip(10000);

        // Posición inicial
        camera.setTranslateX(0);
        camera.setTranslateY(5);
        camera.setTranslateZ(-50);

        // Aplicar rotaciones
        camera.getTransforms().addAll(rotacionX, rotacionY);
    }

    private void cargarModelo() {
        try {
            System.out.println("Cargando modelo posada.obj...");
            InputStream objStream = getClass().getResourceAsStream("/assets/posada.obj");

            if (objStream == null) {
                System.err.println("No se encontró el archivo posada.obj");
                return;
            }

            ObjImporter importer = new ObjImporter();
            modeloGroup = importer.cargarModelo(objStream);

            // Aplicar escala para mejor visualización
            modeloGroup.setScaleX(3.0);
            modeloGroup.setScaleY(-3.0);  // Invertir eje Y para corregir orientación
            modeloGroup.setScaleZ(3.0);

            root.getChildren().add(modeloGroup);

            // TEST: Agregar un cubo con la textura del piso para verificar que funciona
            try {
                javafx.scene.image.Image testTexture = new javafx.scene.image.Image(
                    getClass().getResourceAsStream("/textures/piso.jpg")
                );
                PhongMaterial testMaterial = new PhongMaterial();
                testMaterial.setDiffuseMap(testTexture);
                testMaterial.setDiffuseColor(Color.WHITE);
                testMaterial.setSpecularColor(Color.gray(0.1));  // Muy poco brillo
                testMaterial.setSpecularPower(2);  // Brillo muy difuso

                Box testBox = new Box(10, 0.5, 10);
                testBox.setMaterial(testMaterial);
                testBox.setTranslateX(-20);
                testBox.setTranslateY(0);
                testBox.setTranslateZ(0);
                root.getChildren().add(testBox);
                System.out.println("TEST: Cubo de prueba con textura agregado");
            } catch (Exception ex) {
                System.err.println("TEST: Error creando cubo de prueba: " + ex.getMessage());
            }

            System.out.println("Modelo cargado correctamente");

        } catch (Exception e) {
            System.err.println("Error al cargar el modelo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configurarIluminacion() {
        // Luz ambiental
        AmbientLight luzAmbiental = new AmbientLight(Color.gray(0.4));
        root.getChildren().add(luzAmbiental);

        // Luz puntual 1 (frontal)
        PointLight luz1 = new PointLight(Color.WHITE);
        luz1.setTranslateX(0);
        luz1.setTranslateY(-30);
        luz1.setTranslateZ(-20);
        root.getChildren().add(luz1);

        // Luz puntual 2 (lateral derecha)
        PointLight luz2 = new PointLight(Color.gray(0.8));
        luz2.setTranslateX(20);
        luz2.setTranslateY(-20);
        luz2.setTranslateZ(10);
        root.getChildren().add(luz2);

        // Luz puntual 3 (lateral izquierda)
        PointLight luz3 = new PointLight(Color.gray(0.6));
        luz3.setTranslateX(-20);
        luz3.setTranslateY(-20);
        luz3.setTranslateZ(10);
        root.getChildren().add(luz3);

        System.out.println("Iluminación configurada");
    }

    private void configurarPinata() {
        // Buscar el nodo de la piñata en el grafo de escena
        pinataMesh = buscarNodoPorId(modeloGroup, "pinata_mesh");

        if (pinataMesh != null) {
            System.out.println("Piñata encontrada, configurando animación...");

            // Aplicar rotación continua sobre su propio eje (Y) para mostrar los picos laterales
            RotateTransition rotacion = new RotateTransition(Duration.seconds(3), pinataMesh);
            rotacion.setAxis(Rotate.Y_AXIS);  // Gira sobre sí misma mostrando los picos de los lados
            rotacion.setByAngle(360);
            rotacion.setCycleCount(Timeline.INDEFINITE);
            rotacion.setInterpolator(Interpolator.LINEAR);
            rotacion.play();

            // Configurar evento de click
            pinataMesh.setOnMouseClicked(event -> romperPinata());

        } else {
            System.out.println("No se encontró la piñata (pinata_mesh) en el modelo");
        }
    }

    private void romperPinata() {
        System.out.println("¡Piñata golpeada!");

        // Reproducir sonido
        SoundController.reproducirGolpe();

        // Generar partículas
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            // Crear partícula (alternando entre Box y Sphere)
            Node particula;
            if (rand.nextBoolean()) {
                particula = new Box(0.2, 0.2, 0.2);
            } else {
                particula = new Sphere(0.2);
            }

            // Color aleatorio
            PhongMaterial material = new PhongMaterial();
            material.setDiffuseColor(Color.hsb(rand.nextDouble() * 360, 0.8, 0.9));
            material.setSpecularColor(Color.WHITE);

            if (particula instanceof Box) {
                ((Box) particula).setMaterial(material);
            } else {
                ((Sphere) particula).setMaterial(material);
            }

            // Posición inicial (donde está la piñata)
            if (pinataMesh != null) {
                particula.setTranslateX(pinataMesh.getTranslateX());
                particula.setTranslateY(pinataMesh.getTranslateY());
                particula.setTranslateZ(pinataMesh.getTranslateZ());
            }

            // Añadir a la escena
            root.getChildren().add(particula);

            // Animación de caída con dispersión
            TranslateTransition caida = new TranslateTransition(Duration.seconds(2), particula);
            caida.setByY(5 + rand.nextDouble() * 3);
            caida.setByX((rand.nextDouble() - 0.5) * 4);
            caida.setByZ((rand.nextDouble() - 0.5) * 4);
            caida.setInterpolator(Interpolator.EASE_IN);
            caida.play();

            // Eliminar partícula después de 3 segundos
            final Node particulaFinal = particula;
            Timeline eliminar = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                root.getChildren().remove(particulaFinal);
            }));
            eliminar.play();
        }
    }

    private void configurarLucesNavidenas() {
        // Buscar todas las luces navideñas
        lucesNavidenas = buscarNodosPorPrefijo(modeloGroup, "luz_");

        if (!lucesNavidenas.isEmpty()) {
            System.out.println("Encontradas " + lucesNavidenas.size() + " luces navideñas");
            iniciarPatronLuces();
        } else {
            System.out.println("No se encontraron luces navideñas (luz_*) en el modelo");
        }
    }

    private void iniciarPatronLuces() {
        if (animacionLuces != null) {
            animacionLuces.stop();
        }

        switch (patronLucesActual) {
            case 0: // Patrón arcoíris rotatorio
                animacionLuces = crearPatronArcoiris();
                break;
            case 1: // Patrón rojo-verde tradicional
                animacionLuces = crearPatronTradicional();
                break;
            case 2: // Patrón intermitente sincronizado
                animacionLuces = crearPatronIntermitente();
                break;
            case 3: // Patrón ola de colores
                animacionLuces = crearPatronOla();
                break;
            case 4: // Patrón aleatorio
                animacionLuces = crearPatronAleatorio();
                break;
        }

        if (animacionLuces != null) {
            animacionLuces.setCycleCount(Timeline.INDEFINITE);
            animacionLuces.play();
        }
    }

    private Timeline crearPatronArcoiris() {
        return new Timeline(
            new KeyFrame(Duration.seconds(0.5), e -> aplicarColoresRotados(0)),
            new KeyFrame(Duration.seconds(1), e -> aplicarColoresRotados(1)),
            new KeyFrame(Duration.seconds(1.5), e -> aplicarColoresRotados(2)),
            new KeyFrame(Duration.seconds(2), e -> aplicarColoresRotados(3))
        );
    }

    private Timeline crearPatronTradicional() {
        return new Timeline(
            new KeyFrame(Duration.ZERO, e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(lucesNavidenas.get(i), i % 2 == 0 ? Color.RED : Color.GREEN);
                }
            }),
            new KeyFrame(Duration.seconds(0.8), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(lucesNavidenas.get(i), i % 2 == 0 ? Color.GREEN : Color.RED);
                }
            })
        );
    }

    private Timeline crearPatronIntermitente() {
        return new Timeline(
            new KeyFrame(Duration.ZERO, e -> {
                for (Node luz : lucesNavidenas) {
                    aplicarColorALuz(luz, Color.GOLD);
                }
            }),
            new KeyFrame(Duration.seconds(0.3), e -> {
                for (Node luz : lucesNavidenas) {
                    aplicarColorALuz(luz, Color.DARKGRAY);
                }
            })
        );
    }

    private Timeline crearPatronOla() {
        return new Timeline(
            new KeyFrame(Duration.seconds(0.2), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    int colorIndex = (i) % coloresNavidenos.length;
                    aplicarColorALuz(lucesNavidenas.get(i), coloresNavidenos[colorIndex]);
                }
            }),
            new KeyFrame(Duration.seconds(0.4), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    int colorIndex = (i + 1) % coloresNavidenos.length;
                    aplicarColorALuz(lucesNavidenas.get(i), coloresNavidenos[colorIndex]);
                }
            }),
            new KeyFrame(Duration.seconds(0.6), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    int colorIndex = (i + 2) % coloresNavidenos.length;
                    aplicarColorALuz(lucesNavidenas.get(i), coloresNavidenos[colorIndex]);
                }
            })
        );
    }

    private Timeline crearPatronAleatorio() {
        Random rand = new Random();
        return new Timeline(
            new KeyFrame(Duration.seconds(0.5), e -> {
                for (Node luz : lucesNavidenas) {
                    Color colorAleatorio = coloresNavidenos[rand.nextInt(coloresNavidenos.length)];
                    aplicarColorALuz(luz, colorAleatorio);
                }
            })
        );
    }

    private void aplicarColoresRotados(int offset) {
        for (int i = 0; i < lucesNavidenas.size(); i++) {
            Color color = coloresNavidenos[(i + offset) % coloresNavidenos.length];
            aplicarColorALuz(lucesNavidenas.get(i), color);
        }
    }

    private void aplicarColorALuz(Node luz, Color color) {
        if (luz instanceof MeshView) {
            MeshView meshView = (MeshView) luz;
            if (meshView.getMaterial() instanceof PhongMaterial) {
                ((PhongMaterial) meshView.getMaterial()).setDiffuseColor(color);
            }
        }
    }

    private void cambiarPatronLuces() {
        patronLucesActual = (patronLucesActual + 1) % 5;
        String[] nombrePatrones = {
            "Arcoíris Rotatorio",
            "Rojo-Verde Tradicional",
            "Intermitente Sincronizado",
            "Ola de Colores",
            "Aleatorio"
        };
        System.out.println("Patrón de luces cambiado a: " + nombrePatrones[patronLucesActual]);
        iniciarPatronLuces();
    }

    private void configurarControles() {
        // No podemos añadir listeners aquí porque no tenemos acceso a Scene
        // Esto se hará desde Main.java o se puede hacer cuando se obtenga la escena
    }

    public void configurarControladores(Scene scene) {
        // Control de teclado
        scene.setOnKeyPressed(event -> {
            teclasPresionadas.add(event.getCode());

            // Tecla L para cambiar patrón de luces
            if (event.getCode() == KeyCode.L && lucesNavidenas != null && !lucesNavidenas.isEmpty()) {
                cambiarPatronLuces();
            }
        });

        scene.setOnKeyReleased(event -> {
            teclasPresionadas.remove(event.getCode());
        });

        // Control de mouse para mirar alrededor
        scene.setOnMousePressed(event -> {
            mouseAnteriorX = event.getSceneX();
            mouseAnteriorY = event.getSceneY();
        });

        scene.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseAnteriorX;
            double deltaY = event.getSceneY() - mouseAnteriorY;

            rotacionY.setAngle(rotacionY.getAngle() + deltaX * 0.2);
            rotacionX.setAngle(Math.max(-90, Math.min(90, rotacionX.getAngle() - deltaY * 0.2)));

            mouseAnteriorX = event.getSceneX();
            mouseAnteriorY = event.getSceneY();
        });
    }

    private void iniciarAnimacionCamara() {
        // AnimationTimer para movimiento continuo de cámara
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                actualizarCamara();
            }
        };
        timer.start();
    }

    private void actualizarCamara() {
        double movX = 0;
        double movY = 0;
        double movZ = 0;

        // Calcular dirección de movimiento según rotación de cámara
        double angleY = Math.toRadians(rotacionY.getAngle());

        if (teclasPresionadas.contains(KeyCode.W)) {
            movX += Math.sin(angleY) * velocidadCamara;
            movZ += Math.cos(angleY) * velocidadCamara;
        }
        if (teclasPresionadas.contains(KeyCode.S)) {
            movX -= Math.sin(angleY) * velocidadCamara;
            movZ -= Math.cos(angleY) * velocidadCamara;
        }
        if (teclasPresionadas.contains(KeyCode.A)) {
            movX += Math.cos(angleY) * velocidadCamara;
            movZ -= Math.sin(angleY) * velocidadCamara;
        }
        if (teclasPresionadas.contains(KeyCode.D)) {
            movX -= Math.cos(angleY) * velocidadCamara;
            movZ += Math.sin(angleY) * velocidadCamara;
        }

        // Aplicar movimiento
        camera.setTranslateX(camera.getTranslateX() + movX);
        camera.setTranslateY(camera.getTranslateY() + movY);
        camera.setTranslateZ(camera.getTranslateZ() + movZ);
    }

    private Node buscarNodoPorId(Node nodo, String id) {
        if (id.equals(nodo.getId())) {
            return nodo;
        }

        if (nodo instanceof Parent) {
            for (Node hijo : ((Parent) nodo).getChildrenUnmodifiable()) {
                Node resultado = buscarNodoPorId(hijo, id);
                if (resultado != null) {
                    return resultado;
                }
            }
        }

        return null;
    }

    private List<Node> buscarNodosPorPrefijo(Node nodo, String prefijo) {
        List<Node> resultados = new ArrayList<>();

        if (nodo.getId() != null && nodo.getId().startsWith(prefijo)) {
            resultados.add(nodo);
        }

        if (nodo instanceof Parent) {
            for (Node hijo : ((Parent) nodo).getChildrenUnmodifiable()) {
                resultados.addAll(buscarNodosPorPrefijo(hijo, prefijo));
            }
        }

        return resultados;
    }

    public void iniciarMusica() {
        musicController.iniciar();
    }

    public void cerrar() {
        if (animacionLuces != null) {
            animacionLuces.stop();
        }
        musicController.detener();
    }

    public Group getRoot() {
        // Crear SubScene con fondo
        SubScene subScene = new SubScene(root, 1280, 720, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.MIDNIGHTBLUE);
        subScene.setCamera(camera);

        // Configurar controles cuando se añada a una escena
        subScene.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                configurarControladores(newScene);

                // Ajustar SubScene al tamaño de la ventana
                subScene.widthProperty().bind(newScene.widthProperty());
                subScene.heightProperty().bind(newScene.heightProperty());
            }
        });

        // Retornar grupo contenedor
        Group contenedor = new Group(subScene);
        return contenedor;
    }

    public PerspectiveCamera getCamera() {
        return camera;
    }
}
