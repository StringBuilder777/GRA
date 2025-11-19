package navidad3d;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Controlador de efectos de sonido
 */
public class SoundController {

    /**
     * Reproduce el sonido de golpe cuando se rompe la piñata
     */
    public static void reproducirGolpe() {
        try {
            // Intentar cargar el archivo de sonido
            File archivoSonido = new File("src/main/resources/audio/golpe.wav");

            if (archivoSonido.exists()) {
                Media media = new Media(archivoSonido.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(0.5);
                mediaPlayer.play();

                System.out.println("Reproduciendo sonido de golpe");

                // Liberar recursos después de reproducir
                mediaPlayer.setOnEndOfMedia(() -> {
                    mediaPlayer.dispose();
                });

            } else {
                // Si no existe el archivo, usar beep del sistema
                System.out.println("Archivo de sonido no encontrado, usando beep del sistema");
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            // Si falla todo, usar beep del sistema como fallback
            System.out.println("Error al reproducir sonido: " + e.getMessage());
            try {
                java.awt.Toolkit.getDefaultToolkit().beep();
            } catch (Exception ex) {
                System.out.println("No se pudo reproducir ningún sonido");
            }
        }
    }
}
