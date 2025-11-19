import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 *
 * @author
 */
public class BotonEvento1 extends Application
{
    @Override
    public void start(Stage theStage)
    {
        VBox root = new VBox();
        HBox hb = new HBox();

        Canvas canvas = new Canvas(500, 500);

        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button btn = new Button();
        btn.setText("Color Azul");
        btn.setDefaultButton(true);
        btn.setOnAction((ActionEvent event) -> {
            drawRectangulo(gc, Color.BLUE);
        });

        Button btn2 = new Button();
        btn2.setText("Color Rojo");
        btn2.setOnAction((ActionEvent event) -> {
            drawRectangulo(gc, Color.RED);
        });

        Button btn3 = new Button();
        btn3.setText("Color Verde");
        btn3.setOnAction((ActionEvent event) -> {
            drawRectangulo(gc, Color.GREEN);
        });

        hb.getChildren().addAll(btn, btn2, btn3);

        root.getChildren().add(btn);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        Scene scene = new Scene(root, 600, 600, Color.LIGHTGRAY);
        theStage.setScene(scene);
        // Título que se aparecerá en la ventana
        theStage.setTitle("Eventos");
        theStage.show();
    }


    private void drawRectangulo(GraphicsContext gc, Color color)
    {
        //Dibujo de rectangulo
        gc.setFill(color);
        gc.fillRoundRect(110, 100, 150, 100, 10, 10);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
