package UNIDAD3_5;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class MainC extends Application{
    //Configuración

    // Tamaño de ventana
    public static final float tamaño_controles = 0.25f;
    public static final float tamaño_lienzo = 1 - tamaño_controles;

    // Constelaciones
    public static Group constelacionActual;
    public static Map<String, Constelacion> constelaciones;
    public static final String inicial = "Orión";

    // Estilos
    public static final String style = "-fx-text-fill: white;";

    //Estrellas
    public Random generador;
    public static double[] dims;
    public static final Color[] colores = {Color.GOLD, Color.WHITE, Color.LIGHTSKYBLUE, Color.ALICEBLUE, Color.WHITE, Color.LIGHTSKYBLUE, Color.ALICEBLUE};
    public static int n_estrellas = 800;
    public static int radio_planeta = 150;
    public static int max_radio_estrella = 4;
    public static int max_distancia = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Utilidades
        generador = new Random();

        //Maximizar ventana
        stage.setMaximized(true);
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double width = screenBounds.getWidth();
        double height = screenBounds.getHeight();
        dims = new double[]{width, height};

        stage.setScene(crearEscena());
        stage.setTitle("Explorador de Constelaciones");
        stage.show();
    }

    public Scene crearEscena(){
        // Contenedores de GUI
        BorderPane rootPane = new BorderPane();
        VBox controlPanel = new VBox(10);
        controlPanel.setPadding(new Insets(5));
        controlPanel.setMinWidth(dims[0] * tamaño_controles);
        controlPanel.setStyle("-fx-background-color: #110e0e; -fx-text-fill: white; -fx-font-size: 16px");

        // Constelaciones
        constelacionActual = new Group();
        constelaciones = importarConstelaciones();
        Constelacion constelacion_inicial = constelaciones.get(inicial);
        constelacion_inicial.trazar();

        // Controles
        ComboBox<String> selector = new ComboBox<>();
        selector.getItems().addAll(constelaciones.keySet());
        selector.setValue(inicial);

        Label label = new Label("Constelación");
        label.setStyle(style);
        Button resetView = new Button("Restablecer");

        HBox button_box = new HBox(10);
        button_box.getChildren().addAll(selector, resetView);

        // Rotación
        Slider sliderX = new Slider(0, 360, 0);
        Slider sliderY = new Slider(0, 360, 0);
        Slider sliderZ = new Slider(0, 360, 0);

        Label label2 = new Label("Rotar en X"); label2.setStyle(style);
        Label label3 = new Label("Rotar en Y"); label3.setStyle(style);
        Label label4 = new Label("Rotar en Z"); label4.setStyle(style);

        // Traslación
        Slider sliderTX = new Slider(-500, 500, 0);
        Slider sliderTY = new Slider(-500, 500, 0);

        Label label5 = new Label("Traslación en X"); label5.setStyle(style);
        Label label6 = new Label("Traslación en Y"); label6.setStyle(style);

        // Escalado
        Slider sliderScale = new Slider(0.1, 5, 1);
        Label label8 = new Label("Escalar"); label8.setStyle(style);
        
        Slider sliderShearX = new Slider(-1, 1, 0);
        Slider sliderShearY = new Slider(-1, 1, 0);
        Label label9 = new Label("Sesagdo en X"); label9.setStyle(style);
        Label label10 = new Label("Sesgado en Y"); label10.setStyle(style);

        // Agregar todos los controles
        controlPanel.getChildren().addAll(
            label, button_box,
            label2, sliderX, label3, sliderY, label4, sliderZ,
            label5, sliderTX, label6, sliderTY,
            label8, sliderScale,
            label9, sliderShearX, label10, sliderShearY
        );
        rootPane.setLeft(controlPanel);

        // Escena 3D
        Group sceneRoot = new Group();
        SubScene subScene = new SubScene(sceneRoot, dims[0] * 0.75, dims[1], true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.BLACK);
        rootPane.setCenter(subScene);

        // Luces y estrellas
        PointLight light = new PointLight(Color.GOLD);
        AmbientLight ambient = new AmbientLight(Color.DARKGRAY);
        sceneRoot.getChildren().addAll(light, ambient);

        Group estrellas = new Group();
        for (int i = 0; i < n_estrellas; i++) {
            estrellas.getChildren().add(crearEstrella());
        }

        // Transformaciones
        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        Rotate rotateZ = new Rotate(0, Rotate.Z_AXIS);
        Translate translate = new Translate(0, 0, 0);
        Scale scale = new Scale(1, 1, 1);

        // Sesgado
        Scale shear = new Scale(1, 1, 1);

        constelacionActual.getTransforms().addAll(rotateX, rotateY, rotateZ, translate, scale, shear);
        sceneRoot.getChildren().addAll(constelacionActual, estrellas);

        // Funcionalidad controles
        selector.setOnAction(e -> {
            constelacionActual.getChildren().clear();
            String nombre = selector.getValue();
            Constelacion nueva = constelaciones.get(nombre);
            if (nueva != null) nueva.trazar();
        });

        sliderX.valueProperty().addListener((obs, oldVal, newVal) -> rotateX.setAngle(newVal.doubleValue()));
        sliderY.valueProperty().addListener((obs, oldVal, newVal) -> rotateY.setAngle(newVal.doubleValue()));
        sliderZ.valueProperty().addListener((obs, oldVal, newVal) -> rotateZ.setAngle(newVal.doubleValue()));

        sliderTX.valueProperty().addListener((obs, oldVal, newVal) -> translate.setX(newVal.doubleValue()));
        sliderTY.valueProperty().addListener((obs, oldVal, newVal) -> translate.setY(newVal.doubleValue()));

        sliderScale.valueProperty().addListener((obs, oldVal, newVal) -> {
            double val = newVal.doubleValue();
            scale.setX(val);
            scale.setY(val);
            scale.setZ(val);
        });

        sliderShearX.valueProperty().addListener((obs, oldVal, newVal) -> shear.setX(1 + newVal.doubleValue()));
        sliderShearY.valueProperty().addListener((obs, oldVal, newVal) -> shear.setY(1 + newVal.doubleValue()));

        resetView.setOnAction(e -> {
                sliderX.setValue(0);
                sliderY.setValue(0);
                sliderZ.setValue(0);
                sliderTX.setValue(0);
                sliderTY.setValue(0);
                sliderScale.setValue(1);
                sliderShearX.setValue(0);
                sliderShearY.setValue(0);
            }
        );

        return new Scene(rootPane);
    }


    public Map<String, Constelacion> importarConstelaciones(){
        Map<String, Constelacion> constelaciones = new HashMap<>();

        for(DatosConstelaciones dc: DatosConstelaciones.values()){
            constelaciones.put(dc.getName(), new Constelacion(constelacionActual, dims, dc));
        }

        return constelaciones;
    }

    public Sphere crearEstrella(){
        Sphere estrella = new Sphere(generador.nextInt(1, max_radio_estrella), 50);

        estrella.setMaterial(new PhongMaterial(colores[generador.nextInt(colores.length)]));
        estrella.setTranslateX(generador.nextInt(1, (int) dims[0]));
        estrella.setTranslateY(generador.nextInt(1, (int) dims[1]));
        estrella.setTranslateZ(0);

        return estrella;
    }
}