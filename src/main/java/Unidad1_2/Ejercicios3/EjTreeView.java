package Unidad1_2.Ejercicios3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjTreeView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de TreeView");

        // Nodo raíz
        TreeItem<String> rootItem = new TreeItem<>("Raiz");
        rootItem.setExpanded(true); // Inicia expandido

        // Nodos hijos
        TreeItem<String> itemDocumentos = new TreeItem<>("Nodo");
        TreeItem<String> itemImagenes = new TreeItem<>("Nodo");

        // Nodos nieto
        itemDocumentos.getChildren().add(new TreeItem<>("Hoja"));
        itemImagenes.getChildren().add(new TreeItem<>("Hoja"));

        rootItem.getChildren().addAll(itemDocumentos, itemImagenes);

        TreeView<String> treeView = new TreeView<>(rootItem);

        VBox vbox = new VBox(treeView);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
