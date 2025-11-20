package pinata3d;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Aplicación JavaFX 3D de Piñata Navideña - Versión Mejorada
 * 
 * CARACTERÍSTICAS:
 * ==================
 * 1. Carga de Escena 3D:
 *    - Importa modelo posada.obj desde recursos (/assets/posada.obj)
 *    - Sistema de cámara PerspectiveCamera con controles FPS
 *    - Fondo azul medianoche (MIDNIGHTBLUE)
 * 
 * 2. Controles de Cámara:
 *    - W/A/S/D: Movimiento (adelante/izquierda/atrás/derecha)
 *    - Mouse Drag: Rotación de cámara (MouseLook)
 *    - Shift: Acelerar movimiento (2x velocidad)
 *    - ESC: Salir de la aplicación
 * 
 * 3. Lógica de la Piñata:
 *    - Busca el nodo con ID 'pinata_mesh'
 *    - Animación: Rotación constante en eje Y
 *    - Al hacer clic:
 *      * Reproduce sonido de golpe (golpe.wav)
 *      * Sistema de partículas: 15 figuras primitivas (Box/Sphere 0.2)
 *      * Colores aleatorios vibrantes
 *      * Animación de caída con física (3 segundos)
 *      * Auto-destrucción de partículas
 * 
 * 4. Luces Navideñas:
 *    - Busca todos los nodos con ID que comience con 'luz_'
 *    - Efecto parpadeante: Alterna entre ROJO y VERDE cada 1 segundo
 *    - Timeline infinito para animación continua
 * 
 * 5. Música de Fondo:
 *    - Usa MPV (externo) para reproducir audio/musica.mp3
 *    - Reproducción en loop infinito
 *    - Se detiene automáticamente al cerrar la aplicación
 * 
 * REQUISITOS:
 * ===========
 * - Java 17+
 * - JavaFX 24
 * - MPV instalado en el sistema (brew install mpv / apt-get install mpv)
 * - Archivos de recursos:
 *   * /assets/posada.obj (modelo 3D)
 *   * /audio/golpe.wav (sonido de golpe)
 *   * audio/musica.mp3 (música de fondo, ruta relativa)
 * 
 * @author StringBuilder
 * @version 2.0
 */
public class PinataApp3D extends Application {
    
    // ============== CONSTANTES ==============
    private static final double CAMERA_SPEED = 3.0;
    private static final double CAMERA_SPEED_FAST = 6.0;
    private static final double MOUSE_SENSITIVITY = 0.2;
    private static final int PARTICLE_COUNT = 15;
    private static final double PARTICLE_SIZE = 0.2;
    private static final Duration PARTICLE_DURATION = Duration.seconds(3);
    private static final Duration LIGHT_BLINK_DURATION = Duration.seconds(1);
    
    // ============== COMPONENTES DE ESCENA ==============
    private Group root;
    private Group sceneRoot;
    private PerspectiveCamera camera;
    private MusicController musicController;
    
    // ============== CONTROL DE CÁMARA ==============
    private double mouseOldX, mouseOldY;
    private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
    private final Translate translateCamera = new Translate(0, -50, -300);
    
    // ============== REFERENCIAS A OBJETOS ==============
    private Node pinataNode;
    private RotateTransition pinataRotation;
    private List<Node> lightNodes = new ArrayList<>();
    private Timeline lightsTimeline;
    
    // ============== CONTROL DE TECLAS ==============
    private boolean keyW, keyA, keyS, keyD, keyShift;
    
    // ============== UTILIDADES ==============
    private final Random random = new Random();
    private AnimationTimer cameraUpdateTimer;

    @Override
    public void start(Stage primaryStage) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   PIÑATA NAVIDEÑA 3D - JAVAFX 24     ║");
        System.out.println("║   Versión 2.0 - StringBuilder         ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        primaryStage.setTitle("🎄 Piñata Navideña 3D - JavaFX 🎄");
        
        // Crear estructura de escena
        root = new Group();
        sceneRoot = new Group();
        root.getChildren().add(sceneRoot);
        
        // Crear escena con antialiasing
        Scene scene = new Scene(root, 1280, 720, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.MIDNIGHTBLUE);
        
        // Configurar componentes
        setupCamera(scene);
        loadObjModel();
        setupLighting();
        setupPinata();
        setupChristmasLights();
        setupDonkey();
        setupControls(scene);
        
        // Iniciar música
        startBackgroundMusic();
        
        // Configurar cierre limpio
        primaryStage.setOnCloseRequest(event -> cleanup());
        
        // Mostrar ventana
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Iniciar loop de actualización
        startCameraUpdateLoop();
        
        System.out.println("\n✅ Aplicación iniciada correctamente");
        System.out.println("📋 Controles:");
        System.out.println("   - W/A/S/D: Mover cámara");
        System.out.println("   - Mouse Drag: Rotar vista");
        System.out.println("   - Shift: Movimiento rápido");
        System.out.println("   - Click en piñata: ¡Golpear!");
        System.out.println("   - ESC: Salir\n");
    }

    /**
     * Configura la cámara perspectiva con transformaciones
     */
    private void setupCamera(Scene scene) {
        camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setFieldOfView(45);
        
        camera.getTransforms().addAll(
            translateCamera,
            rotateY,
            rotateX
        );
        
        scene.setCamera(camera);
        System.out.println("📷 Cámara configurada");
    }

    /**
     * Carga el modelo OBJ desde recursos
     */
    private void loadObjModel() {
        try {
            System.out.println("📦 Cargando modelo 3D...");
            
            ObjImporter objImporter = new ObjImporter();
            String objPath = getClass().getResource("/assets/posada.obj").toExternalForm();
            
            MeshView[] meshViews = objImporter.load(objPath);
            
            for (MeshView meshView : meshViews) {
                if (meshView.getMaterial() == null) {
                    PhongMaterial material = new PhongMaterial(Color.LIGHTGRAY);
                    material.setSpecularColor(Color.WHITE);
                    meshView.setMaterial(material);
                }
                sceneRoot.getChildren().add(meshView);
            }
            
            System.out.println("✅ Modelo cargado: " + meshViews.length + " meshes");
            
        } catch (Exception e) {
            System.err.println("⚠️  Error al cargar modelo OBJ: " + e.getMessage());
            System.out.println("📦 Creando escena de demostración...");
            createDummyScene();
        }
    }

    /**
     * Crea una escena de prueba si no se puede cargar el OBJ
     */
    private void createDummyScene() {
        // Suelo
        Box floor = new Box(500, 1, 500);
        floor.setTranslateY(50);
        PhongMaterial floorMaterial = new PhongMaterial(Color.DARKGREEN);
        floorMaterial.setSpecularColor(Color.LIGHTGREEN);
        floor.setMaterial(floorMaterial);
        sceneRoot.getChildren().add(floor);
        
        // Piñata dummy (esfera colorida)
        Sphere pinataSphere = new Sphere(20);
        pinataSphere.setId("pinata_mesh");
        PhongMaterial pinataMaterial = new PhongMaterial(Color.MAGENTA);
        pinataMaterial.setSpecularColor(Color.PINK);
        pinataSphere.setMaterial(pinataMaterial);
        pinataSphere.setTranslateY(-10);
        sceneRoot.getChildren().add(pinataSphere);
        
        // Luces dummy en fila
        for (int i = 0; i < 8; i++) {
            Sphere light = new Sphere(3);
            light.setId("luz_" + i);
            light.setTranslateX(-70 + i * 20);
            light.setTranslateY(-30);
            light.setTranslateZ(30);
            PhongMaterial lightMaterial = new PhongMaterial(i % 2 == 0 ? Color.RED : Color.GREEN);
            lightMaterial.setSpecularColor(Color.WHITE);
            light.setMaterial(lightMaterial);
            sceneRoot.getChildren().add(light);
        }
        
        // Texto 3D simulado con cajas
        createTextDummy("PINATA", -80, -50, -50);
        
        System.out.println("✅ Escena de demostración creada");
    }

    /**
     * Crea texto 3D simple con cajas
     */
    private void createTextDummy(String text, double x, double y, double z) {
        for (int i = 0; i < text.length(); i++) {
            Box letterBox = new Box(8, 10, 2);
            letterBox.setTranslateX(x + i * 12);
            letterBox.setTranslateY(y);
            letterBox.setTranslateZ(z);
            PhongMaterial material = new PhongMaterial(Color.YELLOW);
            material.setSpecularColor(Color.LIGHTYELLOW);
            letterBox.setMaterial(material);
            sceneRoot.getChildren().add(letterBox);
        }
    }

    /**
     * Configura iluminación de la escena
     */
    private void setupLighting() {
        // Luz ambiental (iluminación base)
        AmbientLight ambientLight = new AmbientLight(Color.color(0.3, 0.3, 0.4));
        sceneRoot.getChildren().add(ambientLight);
        
        // Luz principal (key light)
        PointLight mainLight = new PointLight(Color.WHITE);
        mainLight.setTranslateX(100);
        mainLight.setTranslateY(-100);
        mainLight.setTranslateZ(-200);
        sceneRoot.getChildren().add(mainLight);
        
        // Luz de relleno (fill light)
        PointLight fillLight = new PointLight(Color.color(0.5, 0.5, 0.6));
        fillLight.setTranslateX(-100);
        fillLight.setTranslateY(-50);
        fillLight.setTranslateZ(-150);
        sceneRoot.getChildren().add(fillLight);
        
        // Luz trasera (rim light)
        PointLight rimLight = new PointLight(Color.color(0.4, 0.4, 0.5));
        rimLight.setTranslateZ(200);
        rimLight.setTranslateY(-50);
        sceneRoot.getChildren().add(rimLight);
        
        System.out.println("💡 Sistema de iluminación configurado");
    }

    /**
     * Busca el nodo de la piñata y configura su animación
     */
    private void setupPinata() {
        pinataNode = findNodeById(sceneRoot, "pinata_mesh");
        
        if (pinataNode != null) {
            System.out.println("🎯 Piñata encontrada: " + pinataNode.getId());
            
            // Animación de rotación idle
            pinataRotation = new RotateTransition(Duration.seconds(4), pinataNode);
            pinataRotation.setByAngle(360);
            pinataRotation.setAxis(Rotate.Y_AXIS);
            pinataRotation.setCycleCount(Animation.INDEFINITE);
            pinataRotation.setInterpolator(Interpolator.LINEAR);
            pinataRotation.play();
            
            // Evento de clic
            pinataNode.setOnMouseClicked(this::onPinataClicked);
            
            // Hacer la piñata más fácil de clickear
            if (pinataNode instanceof Shape3D) {
                ((Shape3D) pinataNode).setMouseTransparent(false);
            }
            
        } else {
            System.out.println("⚠️  Piñata 'pinata_mesh' no encontrada, buscando alternativas...");
            pinataNode = findNodeByIdContains(sceneRoot, "pinata");
            if (pinataNode != null) {
                System.out.println("🎯 Nodo alternativo encontrado: " + pinataNode.getId());
                pinataNode.setOnMouseClicked(this::onPinataClicked);
            } else {
                System.out.println("❌ No se encontró ningún nodo de piñata");
            }
        }
    }

    /**
     * Maneja el clic en la piñata
     */
    private void onPinataClicked(MouseEvent event) {
        System.out.println("💥 ¡PIÑATA GOLPEADA!");
        
        // Reproducir sonido
        SoundController.playHitSound();
        
        // Efecto de golpe (sacudir la piñata)
        if (pinataNode != null) {
            createShakeEffect(pinataNode);
        }
        
        // Generar partículas
        if (pinataNode != null) {
            generateParticles(
                pinataNode.getTranslateX(),
                pinataNode.getTranslateY(),
                pinataNode.getTranslateZ()
            );
        }
        
        event.consume();
    }

    /**
     * Crea un efecto de sacudida en un nodo
     */
    private void createShakeEffect(Node node) {
        Timeline shake = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(node.translateXProperty(), node.getTranslateX())),
            new KeyFrame(Duration.millis(50), new KeyValue(node.translateXProperty(), node.getTranslateX() + 2)),
            new KeyFrame(Duration.millis(100), new KeyValue(node.translateXProperty(), node.getTranslateX() - 2)),
            new KeyFrame(Duration.millis(150), new KeyValue(node.translateXProperty(), node.getTranslateX() + 1)),
            new KeyFrame(Duration.millis(200), new KeyValue(node.translateXProperty(), node.getTranslateX()))
        );
        shake.play();
    }

    /**
     * Genera sistema de partículas en la posición especificada
     */
    private void generateParticles(double x, double y, double z) {
        System.out.println("✨ Generando " + PARTICLE_COUNT + " partículas...");
        
        for (int i = 0; i < PARTICLE_COUNT; i++) {
            // Crear partícula (alterna entre Box y Sphere)
            Shape3D particle;
            if (random.nextBoolean()) {
                particle = new Box(PARTICLE_SIZE, PARTICLE_SIZE, PARTICLE_SIZE);
            } else {
                particle = new Sphere(PARTICLE_SIZE);
            }
            
            // Color aleatorio vibrante
            Color randomColor = Color.hsb(
                random.nextDouble() * 360,  // Hue: 0-360
                0.8 + random.nextDouble() * 0.2,  // Saturation: 0.8-1.0
                0.8 + random.nextDouble() * 0.2   // Brightness: 0.8-1.0
            );
            PhongMaterial material = new PhongMaterial(randomColor);
            material.setSpecularColor(Color.WHITE);
            particle.setMaterial(material);
            
            // Posición inicial
            particle.setTranslateX(x);
            particle.setTranslateY(y);
            particle.setTranslateZ(z);
            
            sceneRoot.getChildren().add(particle);
            
            // Velocidades aleatorias
            double randomOffsetX = (random.nextDouble() - 0.5) * 30;
            double randomOffsetZ = (random.nextDouble() - 0.5) * 30;
            double fallDistance = 40 + random.nextDouble() * 40;
            
            // Animación de caída
            TranslateTransition fall = new TranslateTransition(PARTICLE_DURATION, particle);
            fall.setByX(randomOffsetX);
            fall.setByY(fallDistance);
            fall.setByZ(randomOffsetZ);
            fall.setInterpolator(Interpolator.EASE_IN);
            
            // Rotación durante caída
            RotateTransition spin = new RotateTransition(PARTICLE_DURATION, particle);
            spin.setByAngle(360 * (1 + random.nextInt(4)));
            spin.setAxis(new javafx.geometry.Point3D(
                random.nextDouble(),
                random.nextDouble(),
                random.nextDouble()
            ));
            
            // Fade out
            FadeTransition fade = new FadeTransition(PARTICLE_DURATION, particle);
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            
            // Ejecutar animaciones y eliminar después
            ParallelTransition parallel = new ParallelTransition(fall, spin, fade);
            parallel.setOnFinished(e -> sceneRoot.getChildren().remove(particle));
            parallel.play();
        }
    }

    /**
     * Busca y configura las luces navideñas (nodos que empiezan con "luz_")
     */
    private void setupChristmasLights() {
        findLightNodes(sceneRoot);
        
        System.out.println("🎄 Luces navideñas encontradas: " + lightNodes.size());
        
        if (!lightNodes.isEmpty()) {
            // Timeline para alternar colores
            lightsTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> setLightsColor(Color.RED)),
                new KeyFrame(LIGHT_BLINK_DURATION, e -> setLightsColor(Color.LIME))
            );
            lightsTimeline.setCycleCount(Animation.INDEFINITE);
            lightsTimeline.play();
            
            System.out.println("✅ Animación de luces navideñas iniciada");
        } else {
            System.out.println("⚠️  No se encontraron luces navideñas (nodos con 'luz_')");
        }
    }

    /**
     * Busca recursivamente nodos con ID que empiece con "luz_"
     */
    private void findLightNodes(Node node) {
        if (node.getId() != null && node.getId().startsWith("luz_")) {
            lightNodes.add(node);
        }
        
        if (node instanceof Parent) {
            for (Node child : ((Parent) node).getChildrenUnmodifiable()) {
                findLightNodes(child);
            }
        }
    }

    /**
     * Cambia el color de todas las luces navideñas
     */
    private void setLightsColor(Color color) {
        for (Node lightNode : lightNodes) {
            if (lightNode instanceof Shape3D) {
                Shape3D shape = (Shape3D) lightNode;
                if (shape.getMaterial() instanceof PhongMaterial) {
                    PhongMaterial material = (PhongMaterial) shape.getMaterial();
                    material.setDiffuseColor(color);
                    material.setSpecularColor(Color.WHITE);
                }
            }
        }
    }

    /**
     * Configura el burro estático en el fondo
     */
    private void setupDonkey() {
        try {
            System.out.println("🐴 Configurando burro estático...");

            // Cargar imagen del burro
            Image donkeyImage = new Image(getClass().getResourceAsStream("/textures/burro.png"));

            if (donkeyImage.isError()) {
                System.err.println("❌ Error al cargar imagen del burro");
                return;
            }

            System.out.println("✅ Imagen del burro cargada: " + donkeyImage.getWidth() + "x" + donkeyImage.getHeight());

            // Crear un plano 2D personalizado usando TriangleMesh
            TriangleMesh planeMesh = new TriangleMesh();

            // Dimensiones del plano (basadas en la proporción de la imagen)
            float width = 50f;
            float height = 50f;

            // Definir los 4 vértices del plano rectangular
            planeMesh.getPoints().addAll(
                -width/2, -height/2, 0,  // Vértice 0: inferior izquierda
                 width/2, -height/2, 0,  // Vértice 1: inferior derecha
                 width/2,  height/2, 0,  // Vértice 2: superior derecha
                -width/2,  height/2, 0   // Vértice 3: superior izquierda
            );

            // Coordenadas de textura (UV mapping)
            planeMesh.getTexCoords().addAll(
                0, 1,  // Coordenada 0: inferior izquierda
                1, 1,  // Coordenada 1: inferior derecha
                1, 0,  // Coordenada 2: superior derecha
                0, 0   // Coordenada 3: superior izquierda
            );

            // Definir las dos caras del triángulo (6 índices = 2 triángulos)
            // Primer triángulo: vértices 0, 1, 2
            planeMesh.getFaces().addAll(
                0, 0, 1, 1, 2, 2,  // Triángulo 1
                0, 0, 2, 2, 3, 3   // Triángulo 2
            );

            // Crear MeshView con el plano
            MeshView donkeyPlane = new MeshView(planeMesh);
            donkeyPlane.setCullFace(CullFace.NONE); // Visible desde ambos lados

            // Aplicar la textura del burro con luz propia
            PhongMaterial donkeyMaterial = new PhongMaterial();
            donkeyMaterial.setDiffuseMap(donkeyImage);
            donkeyMaterial.setDiffuseColor(Color.WHITE);
            donkeyMaterial.setSelfIlluminationMap(donkeyImage); // Luz propia
            donkeyMaterial.setSpecularColor(Color.color(0.1, 0.1, 0.1));
            donkeyPlane.setMaterial(donkeyMaterial);

            // Posicionar el burro al lado de la piñata
            double burroX = 40;  // A la derecha de la piñata
            double burroY = 0;   // Mismo nivel que la piñata
            double burroZ = 0;   // Misma profundidad que la piñata

            donkeyPlane.setTranslateX(burroX);
            donkeyPlane.setTranslateY(burroY);
            donkeyPlane.setTranslateZ(burroZ);

            // Agregar a la escena
            sceneRoot.getChildren().add(donkeyPlane);

            // Agregar luz dedicada para el burro
            PointLight donkeyLight = new PointLight(Color.WHITE);
            donkeyLight.setTranslateX(burroX);
            donkeyLight.setTranslateY(burroY);
            donkeyLight.setTranslateZ(burroZ - 20);
            sceneRoot.getChildren().add(donkeyLight);

            System.out.println("✅ Burro agregado al lado de la piñata (x=" + burroX + ") como plano 2D");

        } catch (Exception e) {
            System.err.println("⚠️  Error al cargar burro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Configura controles de teclado y mouse
     */
    private void setupControls(Scene scene) {
        // Controles de teclado
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W: keyW = true; break;
                case S: keyS = true; break;
                case A: keyA = true; break;
                case D: keyD = true; break;
                case SHIFT: keyShift = true; break;
                case ESCAPE: {
                    System.out.println("👋 Cerrando aplicación...");
                    cleanup();
                    System.exit(0);
                    break;
                }
                case SPACE: {
                    // Easter egg: resetear posición de cámara
                    translateCamera.setX(0);
                    translateCamera.setY(-50);
                    translateCamera.setZ(-300);
                    rotateX.setAngle(0);
                    rotateY.setAngle(0);
                    System.out.println("📷 Cámara reseteada");
                    break;
                }
            }
        });
        
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W: keyW = false; break;
                case S: keyS = false; break;
                case A: keyA = false; break;
                case D: keyD = false; break;
                case SHIFT: keyShift = false; break;
            }
        });
        
        // Controles de mouse (look around)
        scene.setOnMousePressed(event -> {
            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
        });
        
        scene.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseOldX;
            double deltaY = event.getSceneY() - mouseOldY;
            
            rotateY.setAngle(rotateY.getAngle() - deltaX * MOUSE_SENSITIVITY);
            rotateX.setAngle(Math.max(-90, Math.min(90, 
                rotateX.getAngle() + deltaY * MOUSE_SENSITIVITY)));
            
            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
        });
        
        System.out.println("🎮 Controles configurados");
    }

    /**
     * Inicia el loop de actualización de posición de cámara
     */
    private void startCameraUpdateLoop() {
        cameraUpdateTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateCameraPosition();
            }
        };
        cameraUpdateTimer.start();
    }

    /**
     * Actualiza la posición de la cámara según las teclas presionadas
     */
    private void updateCameraPosition() {
        double speed = keyShift ? CAMERA_SPEED_FAST : CAMERA_SPEED;
        double angleRad = Math.toRadians(rotateY.getAngle());
        double dx = 0, dz = 0;
        
        if (keyW) {
            dx += Math.sin(angleRad) * speed;
            dz += Math.cos(angleRad) * speed;
        }
        if (keyS) {
            dx -= Math.sin(angleRad) * speed;
            dz -= Math.cos(angleRad) * speed;
        }
        if (keyA) {
            dx -= Math.cos(angleRad) * speed;
            dz += Math.sin(angleRad) * speed;
        }
        if (keyD) {
            dx += Math.cos(angleRad) * speed;
            dz -= Math.sin(angleRad) * speed;
        }
        
        translateCamera.setX(translateCamera.getX() + dx);
        translateCamera.setZ(translateCamera.getZ() + dz);
    }

    /**
     * Inicia la música de fondo
     */
    private void startBackgroundMusic() {
        try {
            musicController = new MusicController();
            musicController.startMusic();
            System.out.println("🎵 Música de fondo iniciada");
        } catch (Exception e) {
            System.err.println("⚠️  Error al iniciar música: " + e.getMessage());
        }
    }

    /**
     * Busca un nodo por ID exacto
     */
    private Node findNodeById(Node node, String id) {
        if (id.equals(node.getId())) {
            return node;
        }
        
        if (node instanceof Parent) {
            for (Node child : ((Parent) node).getChildrenUnmodifiable()) {
                Node result = findNodeById(child, id);
                if (result != null) return result;
            }
        }
        
        return null;
    }

    /**
     * Busca un nodo cuyo ID contenga el texto especificado
     */
    private Node findNodeByIdContains(Node node, String text) {
        if (node.getId() != null && node.getId().toLowerCase().contains(text.toLowerCase())) {
            return node;
        }
        
        if (node instanceof Parent) {
            for (Node child : ((Parent) node).getChildrenUnmodifiable()) {
                Node result = findNodeByIdContains(child, text);
                if (result != null) return result;
            }
        }
        
        return null;
    }

    /**
     * Limpia recursos antes de cerrar
     */
    private void cleanup() {
        System.out.println("\n🧹 Limpiando recursos...");
        
        if (musicController != null) {
            musicController.stopMusic();
        }
        
        if (cameraUpdateTimer != null) {
            cameraUpdateTimer.stop();
        }
        
        if (pinataRotation != null) {
            pinataRotation.stop();
        }
        
        if (lightsTimeline != null) {
            lightsTimeline.stop();
        }
        
        System.out.println("✅ Recursos liberados");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
