package Unidad1_2.Ejercicios2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollPaneEje extends Application {
    @Override
    public void start(Stage stage) {
        VBox content = new VBox();
        for (int i = 65; i <= 100; i++) {
            char caracter = (char) i;
            content.getChildren().add(new Text("\t\t\t\t\t\t" + caracter));
        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(content);
        sp.setFitToWidth(true);

        StackPane root = new StackPane(sp);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("ScrollPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}