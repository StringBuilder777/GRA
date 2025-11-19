package Unidad1_2.Ejercicios3;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EjColorPicker extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ColorPicker");

        Label etiqueta = new Label("Selecciona un color:");
        ColorPicker colorPicker = new ColorPicker(Color.LIGHTGRAY);

        Rectangle rectangulo = new Rectangle(150, 60);
        rectangulo.setFill(colorPicker.getValue());

        colorPicker.setOnAction(e -> rectangulo.setFill(colorPicker.getValue()));

        VBox vbox = new VBox(10, etiqueta, colorPicker, rectangulo);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}