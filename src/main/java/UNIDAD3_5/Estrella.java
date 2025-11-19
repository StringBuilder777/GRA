package UNIDAD3_5;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Estrella {
    double x, y, z, magnitud;
    Sphere esfera;
    Sphere glow;
    Group nodo;

    public Estrella() {
        this(0, 0, 2.5);
    }

    public Estrella(double x, double y) {
        this(x, y, 2.5);
    }

    public Estrella(double x, double y, double magnitud) {
        this.x = x;
        this.y = y;
        this.magnitud = magnitud;

        // Radius based on magnitude
        double radio = Math.max(2, 8 - magnitud);

        // Depth: random Z coordinate
        this.z = 0;//(Math.random() - 0.5) * 300;

        // Color based on magnitude
        Color color = calcularColor(magnitud);

        // Main sphere
        this.esfera = new Sphere(radio);
        PhongMaterial material = new PhongMaterial(color);
        esfera.setMaterial(material);

        esfera.setTranslateX(x);
        esfera.setTranslateY(y);
        esfera.setTranslateZ(z);

        // Glow effect: larger, semi-transparent sphere
        this.glow = new Sphere(radio * 1.2);
        PhongMaterial glowMaterial = new PhongMaterial(color);
        glow.setMaterial(glowMaterial);

        glow.setTranslateX(x);
        glow.setTranslateY(y);
        glow.setTranslateZ(z);

        // Group both spheres
        this.nodo = new Group(glow, esfera);

        // Twinkle animation
        if (magnitud < 3.0) {
            ScaleTransition twinkle = new ScaleTransition(Duration.seconds(Math.random() + 5), nodo);
            twinkle.setFromX(0.8);
            twinkle.setToX(1.2);
            twinkle.setFromY(0.8);
            twinkle.setToY(1.2);
            twinkle.setFromZ(0.8);
            twinkle.setToZ(1.2);
            twinkle.setCycleCount(Animation.INDEFINITE);
            twinkle.setAutoReverse(true);
            twinkle.play();
        }
    }

    private Color calcularColor(double mag) {
        if (mag < 1.0)
            return Color.WHITE;
        else if (mag < 2.5)
            return Color.LIGHTYELLOW;
        else if (mag < 4.0)
            return Color.ORANGE;
        else
            return Color.DARKORANGE;
    }

    public Group getNodo() {
        return nodo;
    }

    public Point3D getPoint3D() {
        return new Point3D(x, y, z);
    }

    public void setColor(Color color) {
        ((PhongMaterial) esfera.getMaterial()).setDiffuseColor(color);
    }
}
