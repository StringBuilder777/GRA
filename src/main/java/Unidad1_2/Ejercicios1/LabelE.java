package Unidad1_2.Ejercicios1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelE extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("");
        label.setWrapText(true);

        label.setStyle("-fx-font-size: 18px; -fx-text-fill: #2b5797;");

        Button btn = new Button("Saludar");
        btn.setOnAction(e -> label.setText("Hola!!!!"));

        VBox root = new VBox(12, label, btn);
        root.setStyle("-fx-padding: 20; -fx-alignment: center_left;");

        Scene scene = new Scene(root, 100, 150);
        stage.setTitle("Label");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
