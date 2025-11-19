package navidad3d;

import java.io.IOException;

/**
 * Controlador de música de fondo usando MPV externo
 */
public class MusicController {

    private Process procesoMPV;

    /**
     * Inicia la reproducción de música de fondo en loop
     */
    public void iniciar() {
        try {
            System.out.println("Intentando iniciar música de fondo...");

            // Intentar con ruta relativa primero
            ProcessBuilder pb = new ProcessBuilder(
                "mpv",
                "--no-video",
                "--loop",
                "src/main/resources/audio/musica.mp3"
            );

            pb.redirectErrorStream(true);
            procesoMPV = pb.start();

            System.out.println("Música iniciada correctamente con MPV");

        } catch (IOException e) {
            System.out.println("No se pudo iniciar MPV con ruta relativa, intentando ruta absoluta...");

            try {
                // Intentar con ruta absoluta
                String rutaAbsoluta = System.getProperty("user.dir") + "/src/main/resources/audio/musica.mp3";

                ProcessBuilder pb = new ProcessBuilder(
                    "mpv",
                    "--no-video",
                    "--loop",
                    rutaAbsoluta
                );

                pb.redirectErrorStream(true);
                procesoMPV = pb.start();

                System.out.println("Música iniciada con ruta absoluta: " + rutaAbsoluta);

            } catch (IOException ex) {
                System.out.println("No se pudo iniciar la música. Asegúrate de tener MPV instalado.");
                System.out.println("Error: " + ex.getMessage());
                System.out.println("La aplicación continuará sin música de fondo.");
            }
        }
    }

    /**
     * Detiene la reproducción de música
     */
    public void detener() {
        if (procesoMPV != null && procesoMPV.isAlive()) {
            System.out.println("Deteniendo música...");
            procesoMPV.destroy();
            procesoMPV = null;
            System.out.println("Música detenida");
        }
    }
}
