package Imagenes;
import javafx.scene.Group;
import javafx.scene.transform.Shear;

public class TransformacionesUtil {

    /**
     * Método para trasladar un grupo de dibujo
     * @param dibujo El grupo que contiene el dibujo a trasladar
     * @param x Desplazamiento en el eje X (puede ser positivo o negativo)
     * @param y Desplazamiento en el eje Y (puede ser positivo o negativo)
     */
    public static void trasladarDibujo(Group dibujo, double x, double y) {
        dibujo.setTranslateX(dibujo.getTranslateX() + x);
        dibujo.setTranslateY(dibujo.getTranslateY() + y);
    }

    /**
     * Método para rotar un grupo de dibujo
     * @param dibujo El grupo que contiene el dibujo a rotar
     * @param anguloGrados Ángulo de rotación en grados (positivo = antihorario, negativo = horario)
     */
    public static void rotarDibujo(Group dibujo, double anguloGrados) {
        dibujo.setRotate(dibujo.getRotate() + anguloGrados);
    }

    /**
     * Método para escalar un grupo de dibujo
     * @param dibujo El grupo que contiene el dibujo a escalar
     * @param factorX Factor de escala en el eje X (1.0 = tamaño original)
     * @param factorY Factor de escala en el eje Y (1.0 = tamaño original)
     */
    public static void escalarDibujo(Group dibujo, double factorX, double factorY) {
        dibujo.setScaleX(dibujo.getScaleX() * factorX);
        dibujo.setScaleY(dibujo.getScaleY() * factorY);
    }

    /**
     * Método alternativo para escalar proporcionalmente
     * @param dibujo El grupo que contiene el dibujo a escalar
     * @param factor Factor de escala para ambos ejes
     */
    public static void escalarDibujoProporcional(Group dibujo, double factor) {
        escalarDibujo(dibujo, factor, factor);
    }

    /**
     * Método para sesgar (shear) un grupo de dibujo
     * @param dibujo El grupo que contiene el dibujo a sesgar
     * @param x Factor de sesgado en el eje X
     * @param y Factor de sesgado en el eje Y
     */
    public static void sesgarDibujo(Group dibujo, double x, double y) {
        Shear shear = new Shear();
        shear.setX(x);
        shear.setY(y);
        dibujo.getTransforms().add(shear);
    }

    /**
     * Método para resetear todas las transformaciones
     * @param dibujo El grupo que contiene el dibujo a resetear
     */
    public static void resetearTransformaciones(Group dibujo) {
        dibujo.setTranslateX(0);
        dibujo.setTranslateY(0);
        dibujo.setRotate(0);
        dibujo.setScaleX(1.0);
        dibujo.setScaleY(1.0);
        dibujo.getTransforms().clear();
    }
}