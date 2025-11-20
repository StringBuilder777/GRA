package pinata3d;

public class TestSound {
    public static void main(String[] args) {
        System.out.println("=== TEST DE SOUNDCONTROLLER ===\n");

        // Intentar inicializar y reproducir sonido
        System.out.println("Estado inicial:");
        System.out.println(SoundController.getDebugInfo());

        System.out.println("\nIntentando reproducir sonido...");
        SoundController.playHitSound();

        System.out.println("\nEstado después de reproducir:");
        System.out.println(SoundController.getDebugInfo());

        // Esperar un poco para que se reproduzca
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== FIN DEL TEST ===");
    }
}
