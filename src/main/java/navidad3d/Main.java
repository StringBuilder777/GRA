package navidad3d;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación JavaFX 3D de la Posada Navideña
 */
public class Main extends Application {

    private EscenaNavidad escenaNavidad;
    private MusicController musicController;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Crear la escena navideña 3D
            escenaNavidad = new EscenaNavidad();
            Scene scene = new Scene(escenaNavidad.getRoot(), 1280, 720, true);

            // Configurar el Stage
            primaryStage.setTitle("Posada Navideña 3D");
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);

            // Manejar el cierre de ventana
            primaryStage.setOnCloseRequest(event -> {
                System.out.println("Cerrando aplicación...");
                if (escenaNavidad != null) {
                    escenaNavidad.cerrar();
                }
            });

            // Mostrar la ventana
            primaryStage.show();

            // Iniciar la música de fondo
            escenaNavidad.iniciarMusica();

            System.out.println("Aplicación iniciada correctamente");
            System.out.println("Controles:");
            System.out.println("  - W/A/S/D: Mover cámara");
            System.out.println("  - Mouse: Arrastrar para mirar alrededor");
            System.out.println("  - L: Cambiar patrón de luces navideñas");
            System.out.println("  - Click en piñata: ¡Romperla!");

        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("Deteniendo aplicación...");
        if (escenaNavidad != null) {
            escenaNavidad.cerrar();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
