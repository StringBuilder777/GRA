package UNIDAD3_5;

import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import java.util.ArrayList;

public class Constelacion {
    ArrayList<Estrella> estrellas;
    ArrayList<Cylinder> lineas;
    Group lienzo;
    double[] dims;

    public Constelacion(Group lienzo){
        estrellas = new ArrayList<Estrella>();
        lineas = new ArrayList<Cylinder>();
        this.lienzo = lienzo;
    }

    public Constelacion(Group lienzo, double[] dims, double[][] data, int[][] conexiones){
        this.lienzo = lienzo;
        this.dims = dims;

        importarEstrellas(data);
        importarlineas(conexiones);
    }

    public Constelacion(Group lienzo, double[] dims, DatosConstelaciones data) {
        this(lienzo, dims, data.getStarData(), data.getConnections());
    }

    public void importarEstrellas(double[][] data){
        estrellas = new ArrayList<Estrella>();

        for(int i=0; i<data.length; i++) {
            estrellas.add(new Estrella(data[i][0] * dims[1], data[i][1] * dims[1], data[i][2]));
        }
    }

    public void importarlineas(int[][] conexiones){
        lineas = new ArrayList<Cylinder>();

        if(!estrellas.isEmpty()){
            for (int i = 0; i < conexiones.length; i++) {
                Cylinder linea = connectStars(estrellas.get(conexiones[i][0]).getPoint3D(), estrellas.get(conexiones[i][1]).getPoint3D(), 1, Color.WHITE);
                lineas.add(linea);
            }
        }
    }

    public void limpiarLienzo(){
        for (Estrella estrella : estrellas) {
            lienzo.getChildren().remove(estrella.getNodo());
        }
        lienzo.getChildren().removeAll(lineas);
    }

    public void trazar(){
        trazarEstrellas();
        trazarlineas();
    }

    public void trazarEstrellas(){
        for (Estrella estrella : estrellas) {
            lienzo.getChildren().add(estrella.getNodo());
        }
    }

    public void trazarlineas(){
        lienzo.getChildren().addAll(lineas);
    }

    public static Cylinder connectStars(Point3D a, Point3D b, double radius, Color color) {
        Point3D diff = b.subtract(a);
        double height = diff.magnitude();
        Point3D mid = a.midpoint(b);

        Cylinder cylinder = new Cylinder(radius, height);

        // Move cylinder to midpoint
        cylinder.setTranslateX(mid.getX());
        cylinder.setTranslateY(mid.getY());
        cylinder.setTranslateZ(mid.getZ());

        // Rotate the cylinder to align with the direction from A to B
        Point3D yAxis = new Point3D(0, 1, 0);
        Point3D axisOfRotation = yAxis.crossProduct(diff);

        double angle = Math.acos(yAxis.normalize().dotProduct(diff.normalize()));
        angle = Math.toDegrees(angle);

        if (!axisOfRotation.equals(Point3D.ZERO)) {
            cylinder.getTransforms().add(new Rotate(angle, axisOfRotation));
        }

        // Set material
        PhongMaterial material = new PhongMaterial(color);
        cylinder.setMaterial(material);

        return cylinder;
    }
}