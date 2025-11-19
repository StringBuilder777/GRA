package Unidad1_2.Ejercicios2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButtonEje extends Application {
    @Override
    public void start(Stage stage) {
        ToggleButton tb = new ToggleButton();
        tb.setOnAction(e -> {
            if (tb.isSelected()) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        });

        HBox root = new HBox(tb);
        root.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("ToggleButton");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}