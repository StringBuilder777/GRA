package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScrollBarEje extends Application {
    @Override
    public void start(Stage stage) {
        ScrollBar sb = new ScrollBar();
        sb.setMax(100);
        sb.setMin(0);
        sb.setValue(50);
        sb.valueProperty().addListener((v, oldValue, newValue) ->
                System.out.println(newValue.intValue())
        );

        StackPane root = new StackPane(sb);
        root.setPadding(new javafx.geometry.Insets(10));
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("ScrollBar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
