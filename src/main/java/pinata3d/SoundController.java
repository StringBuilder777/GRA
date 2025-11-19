package pinata3d;

import javafx.scene.media.AudioClip;

import java.net.URL;

/**
 * Controlador de efectos de sonido para la aplicación
 * 
 * Maneja la reproducción de sonidos usando JavaFX AudioClip.
 * AudioClip es ideal para efectos de sonido cortos y repetitivos.
 * 
 * CARACTERÍSTICAS:
 * - Carga de sonidos desde recursos
 * - Control de volumen
 * - Reproducción inmediata sin lag
 * - Múltiples reproducciones simultáneas
 * 
 * @author StringBuilder
 * @version 2.0
 */
public class SoundController {
    
    private static AudioClip hitSound;
    private static boolean initialized = false;
    
    // Configuración de volumen
    private static final double DEFAULT_VOLUME = 0.7; // 70%
    private static final double MAX_VOLUME = 1.0;
    private static final double MIN_VOLUME = 0.0;
    
    static {
        initialize();
    }
    
    /**
     * Inicializa el controlador de sonido
     */
    private static void initialize() {
        try {
            System.out.println("🔊 Inicializando sistema de sonido...");
            
            // Cargar sonido de golpe desde recursos
            URL soundUrl = SoundController.class.getResource("/audio/golpe.wav");
            
            if (soundUrl == null) {
                throw new IllegalArgumentException("Archivo no encontrado en /audio/golpe.wav");
            }
            
            hitSound = new AudioClip(soundUrl.toExternalForm());
            hitSound.setVolume(DEFAULT_VOLUME);
            
            initialized = true;
            System.out.println("✅ Sonido de golpe cargado exitosamente");
            System.out.println("   Archivo: /audio/golpe.wav");
            System.out.println("   Volumen: " + (int)(DEFAULT_VOLUME * 100) + "%");
            
        } catch (Exception e) {
            System.err.println("❌ Error al cargar sonido de golpe: " + e.getMessage());
            System.err.println("   Ruta esperada: src/main/resources/audio/golpe.wav");
            System.err.println("   La aplicación funcionará sin sonido de golpe");
            hitSound = null;
            initialized = false;
        }
    }
    
    /**
     * Reproduce el sonido de golpe
     * 
     * Si el sonido no se cargó correctamente, imprime un mensaje en consola.
     */
    public static void playHitSound() {
        if (hitSound != null) {
            // Detener reproducción anterior si está sonando
            // Esto evita que se solapen múltiples sonidos
            hitSound.stop();
            
            // Reproducir desde el inicio
            hitSound.play();
            
            System.out.println("💥 ¡Sonido de golpe reproducido!");
            
        } else {
            // Feedback visual en consola si no hay audio
            System.out.println("💥 *GOLPE* (audio no disponible)");
            playConsoleBell();
        }
    }
    
    /**
     * Reproduce el sonido sin detener la reproducción anterior
     * Útil para múltiples golpes rápidos
     */
    public static void playHitSoundOverlapping() {
        if (hitSound != null) {
            hitSound.play();
            System.out.println("💥 ¡Sonido de golpe reproducido (overlapping)!");
        } else {
            System.out.println("💥 *GOLPE* (audio no disponible)");
            playConsoleBell();
        }
    }
    
    /**
     * Ajusta el volumen del sonido de golpe
     * 
     * @param volume Volumen entre 0.0 (silencio) y 1.0 (máximo)
     */
    public static void setVolume(double volume) {
        // Clamp volume entre 0.0 y 1.0
        double clampedVolume = Math.max(MIN_VOLUME, Math.min(MAX_VOLUME, volume));
        
        if (hitSound != null) {
            hitSound.setVolume(clampedVolume);
            System.out.println("🔊 Volumen ajustado: " + (int)(clampedVolume * 100) + "%");
        }
    }
    
    /**
     * Obtiene el volumen actual
     * 
     * @return Volumen entre 0.0 y 1.0, o -1 si no hay sonido cargado
     */
    public static double getVolume() {
        if (hitSound != null) {
            return hitSound.getVolume();
        }
        return -1.0;
    }
    
    /**
     * Incrementa el volumen en un 10%
     */
    public static void volumeUp() {
        if (hitSound != null) {
            double newVolume = Math.min(MAX_VOLUME, hitSound.getVolume() + 0.1);
            setVolume(newVolume);
        }
    }
    
    /**
     * Decrementa el volumen en un 10%
     */
    public static void volumeDown() {
        if (hitSound != null) {
            double newVolume = Math.max(MIN_VOLUME, hitSound.getVolume() - 0.1);
            setVolume(newVolume);
        }
    }
    
    /**
     * Silencia el sonido
     */
    public static void mute() {
        setVolume(MIN_VOLUME);
    }
    
    /**
     * Restaura el volumen por defecto
     */
    public static void unmute() {
        setVolume(DEFAULT_VOLUME);
    }
    
    /**
     * Verifica si el sistema de sonido está inicializado correctamente
     * 
     * @return true si el sonido se cargó correctamente
     */
    public static boolean isInitialized() {
        return initialized && hitSound != null;
    }
    
    /**
     * Recarga el sonido (útil si hubo un error en la carga inicial)
     */
    public static void reload() {
        System.out.println("🔄 Recargando sistema de sonido...");
        initialized = false;
        hitSound = null;
        initialize();
    }
    
    /**
     * Reproduce un beep en la consola como fallback
     */
    private static void playConsoleBell() {
        try {
            // Beep del sistema (funciona en la mayoría de terminales)
            System.out.print("\u0007");
        } catch (Exception e) {
            // Ignorar si falla
        }
    }
    
    /**
     * Obtiene información sobre el estado del sistema de sonido
     * 
     * @return String con información de debug
     */
    public static String getDebugInfo() {
        StringBuilder info = new StringBuilder();
        info.append("🔊 Estado del Sistema de Sonido\n");
        info.append("================================\n");
        info.append("Inicializado: ").append(initialized ? "✅" : "❌").append("\n");
        info.append("Audio cargado: ").append(hitSound != null ? "✅" : "❌").append("\n");
        
        if (hitSound != null) {
            info.append("Volumen actual: ").append((int)(hitSound.getVolume() * 100)).append("%\n");
            info.append("Estado: ").append(hitSound.isPlaying() ? "🔊 Reproduciendo" : "🔇 Detenido").append("\n");
        }
        
        return info.toString();
    }
}
