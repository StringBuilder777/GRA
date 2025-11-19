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
    private Group pinataGroup; // Grupo para la piñata completa (cuerpo y picos)
    private Timeline animacionLuces;

    // Luces navideñas
    private List<Node> lucesNavidenas = new ArrayList<>();
    private List<PointLight> lucesPuntuales = new ArrayList<>();
    private int patronLucesActual = 0;
    private Color[] coloresNavidenos = {
        Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
        Color.ORANGE, Color.PURPLE, Color.WHITE, Color.GOLD
    };

    public EscenaNavidad() {
        inicializarEscena();
        configurarCieloEstrellado(); // Crear el cielo estrellado
        configurarLuna(); // Añadir la luna
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

    private void configurarLuna() {
        try {
            // Cargar la textura de la luna. Asumimos que se llama 'luna.jpg' o 'moon.png'
            InputStream textureStream = getClass().getResourceAsStream("/textures/luna.jpg");
            if (textureStream == null) {
                textureStream = getClass().getResourceAsStream("/textures/moon.png"); // Intento alternativo
            }
            if (textureStream == null) {
                 System.err.println("No se encontró la textura de la luna en /textures/luna.jpg o /textures/moon.png");
                 return;
            }

            javafx.scene.image.Image moonTexture = new javafx.scene.image.Image(textureStream);

            if (moonTexture.isError()) {
                System.err.println("Error al decodificar la textura de la luna.");
                return;
            }

            // Crear el material para la luna. La clave es el 'selfIlluminationMap'.
            PhongMaterial moonMaterial = new PhongMaterial();
            moonMaterial.setDiffuseMap(moonTexture);
            moonMaterial.setSelfIlluminationMap(moonTexture); // Esto hace que la luna brille.
            moonMaterial.setSpecularColor(Color.TRANSPARENT); // No queremos reflejos de luz en la luna.

            // Crear la esfera que representará la luna
            Sphere luna = new Sphere(50); // Un tamaño visible a la distancia
            luna.setMaterial(moonMaterial);

            // Posicionar la luna en una esquina superior del cielo
            luna.setTranslateX(300);
            luna.setTranslateY(-350); // Muy arriba en la escena
            luna.setTranslateZ(800);  // Lejos en la distancia

            root.getChildren().add(luna);
            System.out.println("Luna añadida a la escena.");

        } catch (Exception e) {
            System.err.println("No se pudo configurar la luna. Causa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configurarCieloEstrellado() {
        Group estrellasGroup = new Group();
        Random rand = new Random();

        // Material para las estrellas (blanco y no reflectante para que no dependan de la luz)
        PhongMaterial starMaterial = new PhongMaterial(Color.WHITE);
        starMaterial.setSpecularColor(Color.TRANSPARENT); // Sin brillo especular

        for (int i = 0; i < 1500; i++) { // 1500 estrellas para un cielo poblado
            double size = 0.05 + rand.nextDouble() * 0.1;
            Sphere estrella = new Sphere(size);
            estrella.setMaterial(starMaterial);

            // Posición aleatoria en una esfera grande alrededor de la escena para dar profundidad
            double distancia = 400 + rand.nextDouble() * 1000;
            double anguloTheta = rand.nextDouble() * 2 * Math.PI;
            double anguloPhi = Math.acos(2 * rand.nextDouble() - 1);

            double x = distancia * Math.sin(anguloPhi) * Math.cos(anguloTheta);
            // La Y del modelo está invertida, por eso se ajusta la Y de las estrellas
            double y = - (distancia * Math.cos(anguloPhi));
            double z = distancia * Math.sin(anguloPhi) * Math.sin(anguloTheta);

            estrella.setTranslateX(x);
            estrella.setTranslateY(y);
            estrella.setTranslateZ(z);

            estrellasGroup.getChildren().add(estrella);

            // Añadir animación de parpadeo a un 10% de las estrellas para dar vida a la escena
            if (rand.nextDouble() < 0.1) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1.5 + rand.nextDouble() * 2), estrella);
                ft.setFromValue(0.3);
                ft.setToValue(1.0);
                ft.setCycleCount(Timeline.INDEFINITE);
                ft.setAutoReverse(true);
                ft.setInterpolator(Interpolator.EASE_BOTH);
                ft.play();
            }
        }

        // Añadir el grupo de estrellas al principio del 'root' para que actúe como fondo
        root.getChildren().add(0, estrellasGroup);
        System.out.println("Cielo estrellado configurado.");
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
        // Luz ambiental muy oscura para simular la noche.
        AmbientLight luzAmbiental = new AmbientLight(Color.gray(0.15));
        root.getChildren().add(luzAmbiental);

        // Luz principal que simula un farol o una fuente de luz cálida cercana.
        PointLight luzPrincipal = new PointLight(Color.ORANGE.deriveColor(0, 1, 0.7, 1));
        luzPrincipal.setTranslateX(0);
        luzPrincipal.setTranslateY(-10); // Posicionada más abajo
        luzPrincipal.setTranslateZ(-15);
        root.getChildren().add(luzPrincipal);

        // Luz de relleno azulada y muy sutil para simular el reflejo del cielo nocturno.
        PointLight luzRelleno = new PointLight(Color.rgb(100, 120, 180, 0.25)); // Azulada y débil
        luzRelleno.setTranslateX(0);
        luzRelleno.setTranslateY(-40);
        luzRelleno.setTranslateZ(50); // Posicionada detrás de la escena
        root.getChildren().add(luzRelleno);
        
        System.out.println("Iluminación nocturna configurada.");
    }

    private void configurarPinata() {
        // Buscar TODAS las partes de la piñata, ya que el log muestra que todas se llaman 'pinata_mesh'
        List<Node> partesPinata = buscarTodosLosNodosPorId(modeloGroup, "pinata_mesh");

        if (partesPinata.isEmpty()) {
            System.out.println("No se encontró ninguna parte de la piñata (ID: pinata_mesh) en el modelo.");
            return;
        }

        System.out.println("Encontradas " + partesPinata.size() + " partes de la piñata. Agrupando para rotación unificada...");

        // Tomamos el primero como referencia para encontrar el padre en la escena.
        pinataMesh = partesPinata.get(0);
        Parent originalParent = pinataMesh.getParent();

        // Crear un grupo para unir todas las partes.
        // Al usar addAll, los nodos se mueven de `originalParent` a `pinataGroup`.
        pinataGroup = new Group();
        pinataGroup.getChildren().addAll(partesPinata);

        // Añadir el nuevo grupo consolidado de vuelta al padre original.
        if (originalParent instanceof Group) {
            ((Group) originalParent).getChildren().add(pinataGroup);
            System.out.println("Grupo de piñata re-insertado en la escena correctamente.");
        } else {
            System.err.println("El padre de la piñata no es un grupo o es nulo. La rotación podría ser incorrecta.");
            root.getChildren().add(pinataGroup);
        }
        
        // Aplicar rotación continua al grupo completo.
        RotateTransition rotacion = new RotateTransition(Duration.seconds(8), pinataGroup);
        rotacion.setAxis(Rotate.Y_AXIS);
        rotacion.setByAngle(360);
        rotacion.setCycleCount(Timeline.INDEFINITE);
        rotacion.setInterpolator(Interpolator.LINEAR);
        rotacion.play();

        // El evento de click se asigna al grupo para que funcione en cualquier parte de la piñata.
        pinataGroup.setOnMouseClicked(event -> romperPinata());
        
        System.out.println("Animación de rotación configurada para el grupo completo de la piñata.");
    }

    private void romperPinata() {
        System.out.println("¡Piñata golpeada!");

        // Reproducir sonido
        SoundController.reproducirGolpe();

        if (pinataGroup == null || pinataGroup.getParent() == null || !(pinataGroup.getParent() instanceof Group)) {
            System.err.println("No se puede generar partículas: pinataGroup o su padre no son válidos.");
            return;
        }
        
        // Las partículas deben añadirse al mismo padre que la piñata para compartir el sistema de coordenadas.
        Group particleParent = (Group) pinataGroup.getParent();

        // Calcular el centro del grupo de la piñata en el sistema de coordenadas de su padre.
        // Este será el punto de origen de la explosión de partículas.
        javafx.geometry.Bounds bounds = pinataGroup.getBoundsInParent();
        double centerX = bounds.getCenterX();
        double centerY = bounds.getCenterY();
        double centerZ = bounds.getCenterZ();

        Random rand = new Random();
        // Aumentar drásticamente el número de partículas para un efecto más vistoso.
        for (int i = 0; i < 150; i++) {
            Node particula;
            // Aumentar el tamaño de las partículas
            double size = 0.2 + rand.nextDouble() * 0.3;
            if (rand.nextBoolean()) {
                particula = new Box(size, size, size);
            } else {
                particula = new Sphere(size / 2);
            }

            PhongMaterial material = new PhongMaterial();
            material.setDiffuseColor(Color.hsb(rand.nextDouble() * 360, 1.0, 1.0));
            material.setSpecularColor(Color.WHITE);

            if (particula instanceof Box) {
                ((Box) particula).setMaterial(material);
            } else {
                ((Sphere) particula).setMaterial(material);
            }

            // Posición inicial de la partícula en el centro de la piñata
            particula.setTranslateX(centerX);
            particula.setTranslateY(centerY);
            particula.setTranslateZ(centerZ);
            
            // Añadir partícula al mismo padre que la piñata
            particleParent.getChildren().add(particula);

            // Animación de caída con mayor dispersión y velocidad
            TranslateTransition caida = new TranslateTransition(Duration.seconds(1.5 + rand.nextDouble() * 2), particula);
            caida.setByY(15 + rand.nextDouble() * 10); // Caer más lejos
            caida.setByX((rand.nextDouble() - 0.5) * 30); // Dispersarse mucho más
            caida.setByZ((rand.nextDouble() - 0.5) * 30);
            caida.setInterpolator(Interpolator.EASE_OUT); // Usar Ease_Out para un inicio rápido
            
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1.5 + rand.nextDouble()), particula);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            
            ParallelTransition pt = new ParallelTransition(caida, fadeOut);
            
            // Eliminar la partícula de la escena una vez que la animación ha terminado
            final Node finalParticle = particula;
            pt.setOnFinished(e -> particleParent.getChildren().remove(finalParticle));
            pt.play();
        }
    }

    private void configurarLucesNavidenas() {
        lucesNavidenas = buscarNodosPorPrefijo(modeloGroup, "luz_");

        if (!lucesNavidenas.isEmpty()) {
            System.out.println("Encontradas " + lucesNavidenas.size() + " luces navideñas. Creando efectos de luz y aura...");

            for (Node luzMesh : lucesNavidenas) {
                Parent parent = luzMesh.getParent();
                if (parent == null || !(parent instanceof Group)) {
                    System.err.println("No se pudo obtener el padre de la luz " + luzMesh.getId() + ". Usando root como fallback.");
                    parent = root;
                }

                javafx.geometry.Bounds bounds = luzMesh.getBoundsInParent();
                double centerX = bounds.getCenterX();
                double centerY = bounds.getCenterY();
                double centerZ = bounds.getCenterZ();

                // --- Crear PointLight ---
                PointLight puntoDeLuz = new PointLight();
                puntoDeLuz.setColor(Color.WHITE); // Se establecerá en la animación
                puntoDeLuz.setTranslateX(centerX);
                puntoDeLuz.setTranslateY(centerY);
                puntoDeLuz.setTranslateZ(centerZ);
                ((Group) parent).getChildren().add(puntoDeLuz);
                lucesPuntuales.add(puntoDeLuz);
            }

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
                    aplicarColorALuz(i, i % 2 == 0 ? Color.RED : Color.LIMEGREEN);
                }
            }),
            new KeyFrame(Duration.seconds(0.8), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(i, i % 2 == 0 ? Color.LIMEGREEN : Color.RED);
                }
            })
        );
    }

    private Timeline crearPatronIntermitente() {
        // Un color base para cuando están "apagadas"
        Color colorApagado = Color.gray(0.2);

        return new Timeline(
            new KeyFrame(Duration.ZERO, e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(i, Color.GOLD);
                }
            }),
            new KeyFrame(Duration.seconds(0.4), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(i, colorApagado, false); // Apagar la luz puntual y el aura
                }
            })
        );
    }

    private Timeline crearPatronOla() {
        return new Timeline(
            new KeyFrame(Duration.seconds(0.2), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(i, coloresNavidenos[(i) % coloresNavidenos.length]);
                }
            }),
            new KeyFrame(Duration.seconds(0.4), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(i, coloresNavidenos[(i + 1) % coloresNavidenos.length]);
                }
            }),
            new KeyFrame(Duration.seconds(0.6), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    aplicarColorALuz(i, coloresNavidenos[(i + 2) % coloresNavidenos.length]);
                }
            })
        );
    }

    private Timeline crearPatronAleatorio() {
        Random rand = new Random();
        return new Timeline(
            new KeyFrame(Duration.seconds(0.5), e -> {
                for (int i = 0; i < lucesNavidenas.size(); i++) {
                    Color colorAleatorio = coloresNavidenos[rand.nextInt(coloresNavidenos.length)];
                    aplicarColorALuz(i, colorAleatorio);
                }
            })
        );
    }

    private void aplicarColoresRotados(int offset) {
        for (int i = 0; i < lucesNavidenas.size(); i++) {
            Color color = coloresNavidenos[(i + offset) % coloresNavidenos.length];
            aplicarColorALuz(i, color);
        }
    }

    // Sobrecarga para control de encendido/apagado
    private void aplicarColorALuz(int index, Color color) {
        aplicarColorALuz(index, color, true);
    }

    private void aplicarColorALuz(int index, Color color, boolean encendida) {
        // 1. Actualizar el mesh original
        Node luzMesh = lucesNavidenas.get(index);
        if (luzMesh instanceof MeshView) {
            MeshView meshView = (MeshView) luzMesh;
            if (meshView.getMaterial() instanceof PhongMaterial) {
                ((PhongMaterial) meshView.getMaterial()).setDiffuseColor(color);
            }
        }

        // 2. Actualizar la luz puntual
        PointLight puntoDeLuz = lucesPuntuales.get(index);
        puntoDeLuz.setColor(encendida ? color : Color.BLACK); // Usar NEGRO para "apagar" la luz
        puntoDeLuz.setLightOn(encendida);
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

    private List<Node> buscarTodosLosNodosPorId(Node nodo, String id) {
        List<Node> resultados = new ArrayList<>();
        if (nodo == null) {
            return resultados;
        }

        if (id.equals(nodo.getId())) {
            resultados.add(nodo);
        }

        if (nodo instanceof Parent) {
            for (Node hijo : ((Parent) nodo).getChildrenUnmodifiable()) {
                resultados.addAll(buscarTodosLosNodosPorId(hijo, id));
            }
        }
        return resultados;
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
        // Crear SubScene con fondo negro para la noche
        SubScene subScene = new SubScene(root, 1280, 720, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.BLACK);
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
