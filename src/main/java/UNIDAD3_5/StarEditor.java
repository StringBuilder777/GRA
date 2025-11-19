package UNIDAD3_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StarEditor extends Application {

    private final ArrayList<double[]> coords = new ArrayList<>();
    private final ArrayList<int[]> connections = new ArrayList<>();

    private boolean connectMode = false;
    private int selectedIndex = -1;

    // Set the image path here
    private final String imagePath = "/Users/Emiliano/Downloads/hola fx/src/main/java/UNIDAD3_5/img/constellations/osa.jpg"; // Example path
    private final double scale = 2.0; // 70% of original size

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        Image image = new Image(new FileInputStream(new File(imagePath)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth() * scale);
        imageView.setFitHeight(image.getHeight() * scale);
        imageView.setPreserveRatio(true);

        Pane pane = new Pane(imageView);
        Scene scene = new Scene(pane, image.getWidth() * scale, image.getHeight() * scale);

        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            double x = e.getX() / scale;
            double y = e.getY() / scale;

            double nx = x / image.getWidth();
            double ny = y / image.getHeight();

            if (!connectMode) {
                double mag = 0.5 + Math.random() * 3.5; // Random magnitude (0.5 to 3.0)
                coords.add(new double[]{nx, ny, mag});
                Circle dot = new Circle(x * scale, y * scale, 10, Color.GREENYELLOW);
                pane.getChildren().add(dot);
                System.out.printf("Star: x=%.4f y=%.4f mag=%.2f%n", nx, ny, mag);
            } else {
                int index = findNearestStar(nx, ny);
                if (index != -1) {
                    if (selectedIndex == -1) {
                        selectedIndex = index;
                        System.out.println("Selected star " + selectedIndex);
                    } else {
                        connections.add(new int[]{selectedIndex, index});
                        double[] p1 = coords.get(selectedIndex);
                        double[] p2 = coords.get(index);

                        Line line = new Line(
                            p1[0] * image.getWidth() * scale,
                            p1[1] * image.getHeight() * scale,
                            p2[0] * image.getWidth() * scale,
                            p2[1] * image.getHeight() * scale
                        );
                        line.setStroke(Color.LIGHTBLUE);
                        line.setStrokeWidth(2);
                        pane.getChildren().add(line);

                        System.out.printf("Connection: [%d, %d]%n", selectedIndex, index);
                        selectedIndex = -1;
                    }
                }
            }
        });

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case C -> {
                    connectMode = !connectMode;
                    selectedIndex = -1;
                    System.out.println("Connect mode: " + connectMode);
                }
                case D -> printData(); // Dump all data
            }
        });

        stage.setTitle("Star Selector");
        stage.setScene(scene);
        stage.show();
    }

    private int findNearestStar(double x, double y) {
        int nearest = -1;
        double minDist = 1.00;

        for (int i = 0; i < coords.size(); i++) {
            double[] c = coords.get(i);
            double dx = x - c[0];
            double dy = y - c[1];
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist < minDist) {
                nearest = i;
                minDist = dist;
            }
        }

        return nearest;
    }

    private void printData() {
        System.out.println("\n// --- Star Data ---");
        System.out.println("new double[][] {");
        for (double[] c : coords)
            System.out.printf("  {%.4f, %.4f, %.2f},%n", c[0], c[1], c[2]);
        System.out.println("},");

        System.out.println("\nnew int[][] {");
        for (int[] con : connections)
            System.out.printf("  {%d, %d},%n", con[0], con[1]);
        System.out.println("}");
    }

    public static void main(String[] args) {
        launch(args);
    }
}