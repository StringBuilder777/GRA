package Unidad1_2.Ejercicios2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonEje extends Application {
    @Override
    public void start(Stage stage) {
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("1");
        RadioButton rb2 = new RadioButton("2");
        RadioButton rb3 = new RadioButton("3");

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        VBox root = new VBox(10, rb1, rb2, rb3);
        root.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("RadioButton");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}