package pinata3d;

import java.io.IOException;

/**
 * Controlador de música usando MPV externo
 * 
 * Ejecuta mpv como proceso del sistema para reproducir audio en loop.
 * MPV es un reproductor de medios multiplataforma muy eficiente.
 * 
 * INSTALACIÓN:
 * - macOS: brew install mpv
 * - Linux: sudo apt-get install mpv
 * - Windows: Descargar de mpv.io
 * 
 * CARACTERÍSTICAS:
 * - Reproducción en loop infinito
 * - Sin ventana de video
 * - Bajo consumo de recursos
 * - Control de proceso (start/stop)
 * 
 * @author StringBuilder
 * @version 2.0
 */
public class MusicController {
    
    private Process mpvProcess;
    private static final String MUSIC_PATH = "audio/musica.mp3";
    private static final int SHUTDOWN_TIMEOUT_SECONDS = 2;
    
    /**
     * Inicia la reproducción de música en loop
     * 
     * @throws RuntimeException si MPV no está instalado
     */
    public void startMusic() {
        if (mpvProcess != null && mpvProcess.isAlive()) {
            System.out.println("⚠️  La música ya está reproduciéndose");
            return;
        }
        
        try {
            // Construir comando para MPV
            // --no-video: no mostrar ventana de video
            // --loop: reproducir en bucle infinito
            // --volume: volumen inicial (0-100)
            ProcessBuilder processBuilder = new ProcessBuilder(
                "mpv",
                "--no-video",
                "--loop=inf",
                "--volume=70",
                MUSIC_PATH
            );
            
            // Redirigir salida para evitar spam en consola
            processBuilder.redirectErrorStream(true);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
            
            // Iniciar proceso
            mpvProcess = processBuilder.start();
            
            System.out.println("✅ Música de fondo iniciada con MPV");
            System.out.println("   Archivo: " + MUSIC_PATH);
            System.out.println("   Modo: Loop infinito");
            
        } catch (IOException e) {
            String errorMsg = "Error al iniciar MPV: " + e.getMessage();
            System.err.println("❌ " + errorMsg);
            System.err.println("\n📦 MPV no está instalado o no está en el PATH.");
            System.err.println("   Para instalar MPV:");
            System.err.println("   - macOS:   brew install mpv");
            System.err.println("   - Linux:   sudo apt-get install mpv");
            System.err.println("   - Windows: Descargar de https://mpv.io\n");
            
            // No lanzar excepción, solo advertir
            mpvProcess = null;
        }
    }
    
    /**
     * Detiene la reproducción de música de forma limpia
     */
    public void stopMusic() {
        if (mpvProcess == null) {
            return;
        }
        
        if (!mpvProcess.isAlive()) {
            System.out.println("ℹ️  El proceso de música ya estaba detenido");
            mpvProcess = null;
            return;
        }
        
        try {
            // Intentar cerrar limpiamente
            mpvProcess.destroy();
            
            // Esperar a que se cierre
            boolean terminated = mpvProcess.waitFor(
                SHUTDOWN_TIMEOUT_SECONDS, 
                java.util.concurrent.TimeUnit.SECONDS
            );
            
            // Si no se cerró, forzar cierre
            if (!terminated) {
                System.out.println("⚠️  Forzando cierre de MPV...");
                mpvProcess.destroyForcibly();
                mpvProcess.waitFor(1, java.util.concurrent.TimeUnit.SECONDS);
            }
            
            System.out.println("🔇 Música detenida correctamente");
            mpvProcess = null;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("⚠️  Interrupción al detener música");
            
            // Forzar cierre inmediato
            if (mpvProcess != null && mpvProcess.isAlive()) {
                mpvProcess.destroyForcibly();
            }
            mpvProcess = null;
        }
    }
    
    /**
     * Verifica si la música está reproduciéndose
     * 
     * @return true si el proceso de MPV está activo
     */
    public boolean isPlaying() {
        return mpvProcess != null && mpvProcess.isAlive();
    }
    
    /**
     * Alterna entre reproducir y detener la música
     */
    public void togglePause() {
        if (isPlaying()) {
            System.out.println("⏸️  Pausando música...");
            stopMusic();
        } else {
            System.out.println("▶️  Reanudando música...");
            startMusic();
        }
    }
    
    /**
     * Reinicia la reproducción de música
     */
    public void restart() {
        System.out.println("🔄 Reiniciando música...");
        stopMusic();
        
        // Pequeña pausa para asegurar que el proceso se cerró
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        startMusic();
    }
    
    /**
     * Obtiene el código de salida del proceso (si ha terminado)
     * 
     * @return Código de salida, o -1 si aún está en ejecución
     */
    public int getExitCode() {
        if (mpvProcess == null) {
            return -1;
        }
        
        if (mpvProcess.isAlive()) {
            return -1;
        }
        
        return mpvProcess.exitValue();
    }
}
