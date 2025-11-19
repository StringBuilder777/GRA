package Unidad1_2.Ejercicios3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjAccordion extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Accordion");

        TitledPane panel1 = new TitledPane("Información Personal", new Label("Contenido del panel de información personal."));
        TitledPane panel2 = new TitledPane("Configuración", new Label("Contenido del panel de configuración."));
        TitledPane panel3 = new TitledPane("Ayuda", new Label("Contenido del panel de ayuda."));

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(panel1, panel2, panel3);

        VBox vbox = new VBox(accordion);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}