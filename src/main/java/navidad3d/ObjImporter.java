package navidad3d;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

import java.io.*;
import java.util.*;

/**
 * Importador avanzado de archivos OBJ con soporte para materiales
 */
public class ObjImporter {

    private List<Float> vertices = new ArrayList<>();
    private List<Float> texturas = new ArrayList<>();
    private List<Float> normales = new ArrayList<>();
    private Map<String, Material> materiales = new HashMap<>();
    private String archivoMtl = null;
    private String objetoActual = "default";
    private String materialActual = "default";

    // Grupos de caras por objeto y material
    private Map<String, List<Face>> gruposCaras = new HashMap<>();

    public Group cargarModelo(InputStream objStream) throws IOException {
        leerArchivo(objStream);

        Group grupo = new Group();

        // Crear un MeshView para cada grupo objeto+material
        for (Map.Entry<String, List<Face>> entry : gruposCaras.entrySet()) {
            String clave = entry.getKey();
            List<Face> caras = entry.getValue();

            if (caras.isEmpty()) continue;

            MeshView meshView = crearMeshView(caras, clave);
            grupo.getChildren().add(meshView);
        }

        System.out.println("Modelo importado: " + gruposCaras.size() + " grupos creados");
        return grupo;
    }

    private void leerArchivo(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String linea;

        while ((linea = reader.readLine()) != null) {
            linea = linea.trim();

            if (linea.isEmpty() || linea.startsWith("#")) {
                continue;
            }

            String[] partes = linea.split("\\s+");

            switch (partes[0]) {
                case "mtllib":
                    archivoMtl = partes[1];
                    cargarMateriales();
                    break;

                case "v": // Vértice
                    vertices.add(Float.parseFloat(partes[1]));
                    vertices.add(Float.parseFloat(partes[2]));
                    vertices.add(Float.parseFloat(partes[3]));
                    break;

                case "vt": // Coordenada de textura
                    texturas.add(Float.parseFloat(partes[1]));
                    texturas.add(partes.length > 2 ? Float.parseFloat(partes[2]) : 0f);
                    break;

                case "vn": // Normal
                    normales.add(Float.parseFloat(partes[1]));
                    normales.add(Float.parseFloat(partes[2]));
                    normales.add(Float.parseFloat(partes[3]));
                    break;

                case "o": // Objeto
                    objetoActual = partes.length > 1 ? partes[1] : "default";
                    break;

                case "usemtl": // Usar material
                    materialActual = partes.length > 1 ? partes[1] : "default";
                    break;

                case "f": // Cara
                    procesarCara(partes);
                    break;
            }
        }

        reader.close();
    }

    private void cargarMateriales() {
        if (archivoMtl == null) return;

        try {
            InputStream mtlStream = getClass().getResourceAsStream("/assets/" + archivoMtl);
            if (mtlStream == null) {
                System.out.println("No se encontró el archivo .mtl: " + archivoMtl);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(mtlStream));
            String linea;
            Material materialActual = null;

            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty() || linea.startsWith("#")) continue;

                String[] partes = linea.split("\\s+");

                switch (partes[0]) {
                    case "newmtl":
                        materialActual = new Material();
                        materialActual.nombre = partes[1];
                        materiales.put(partes[1], materialActual);
                        break;

                    case "Kd": // Color difuso
                        if (materialActual != null && partes.length >= 4) {
                            materialActual.colorDifuso = Color.color(
                                Double.parseDouble(partes[1]),
                                Double.parseDouble(partes[2]),
                                Double.parseDouble(partes[3])
                            );
                        }
                        break;

                    case "Ks": // Color especular
                        if (materialActual != null && partes.length >= 4) {
                            materialActual.colorEspecular = Color.color(
                                Double.parseDouble(partes[1]),
                                Double.parseDouble(partes[2]),
                                Double.parseDouble(partes[3])
                            );
                        }
                        break;

                    case "map_Kd": // Textura difusa
                        if (materialActual != null) {
                            materialActual.texturaDifusa = partes[1];
                        }
                        break;
                }
            }

            reader.close();
            System.out.println("Materiales cargados: " + materiales.size());

        } catch (IOException e) {
            System.err.println("Error al cargar materiales: " + e.getMessage());
        }
    }

    private void procesarCara(String[] partes) {
        Face cara = new Face();

        for (int i = 1; i < partes.length; i++) {
            String[] indices = partes[i].split("/");

            int v = Integer.parseInt(indices[0]) - 1;
            int vt = indices.length > 1 && !indices[1].isEmpty() ? Integer.parseInt(indices[1]) - 1 : -1;
            int vn = indices.length > 2 && !indices[2].isEmpty() ? Integer.parseInt(indices[2]) - 1 : -1;

            cara.vertices.add(v);
            cara.texturas.add(vt);
            cara.normales.add(vn);
        }

        String clave = objetoActual + "___MAT___" + materialActual;
        gruposCaras.computeIfAbsent(clave, k -> new ArrayList<>()).add(cara);
    }

    private MeshView crearMeshView(List<Face> caras, String clave) {
        TriangleMesh mesh = new TriangleMesh();

        // Mapeos separados para vértices y coordenadas de textura
        Map<Integer, Integer> verticesIndices = new HashMap<>();
        Map<Integer, Integer> texturasIndices = new HashMap<>();
        int indiceVertice = 0;
        int indiceTextura = 0;

        for (Face cara : caras) {
            // Convertir cara a triángulos (triangulación simple para n-gons)
            for (int i = 1; i < cara.vertices.size() - 1; i++) {
                int[] indices = {0, i, i + 1};

                // Procesar los 3 vértices del triángulo
                for (int j : indices) {
                    int v = cara.vertices.get(j);
                    int vt = cara.texturas.get(j);

                    // Añadir vértice si no existe
                    if (!verticesIndices.containsKey(v)) {
                        mesh.getPoints().addAll(
                            vertices.get(v * 3),
                            vertices.get(v * 3 + 1),
                            vertices.get(v * 3 + 2)
                        );
                        verticesIndices.put(v, indiceVertice++);
                    }

                    // Añadir coordenada de textura si no existe
                    if (!texturasIndices.containsKey(vt)) {
                        if (vt >= 0 && vt * 2 + 1 < texturas.size()) {
                            mesh.getTexCoords().addAll(
                                texturas.get(vt * 2),
                                texturas.get(vt * 2 + 1)
                            );
                        } else {
                            mesh.getTexCoords().addAll(0f, 0f);
                        }
                        texturasIndices.put(vt, indiceTextura++);
                    }
                }

                // Agregar la cara (triángulo) como pares [índice_vértice, índice_textura]
                for (int j : indices) {
                    int v = cara.vertices.get(j);
                    int vt = cara.texturas.get(j);
                    int idxVertice = verticesIndices.get(v);
                    int idxTextura = texturasIndices.get(vt);
                    mesh.getFaces().addAll(idxVertice, idxTextura);
                }
            }
        }

        // Debug: Mostrar estadísticas del mesh
        String[] partesClave = clave.split("___MAT___");
        String nombreObjeto = partesClave[0];
        if (nombreObjeto.toLowerCase().contains("calle") || nombreObjeto.toLowerCase().contains("piso")) {
            System.out.println("=== DEBUG MESH: " + nombreObjeto + " ===");
            System.out.println("  Puntos (vertices): " + mesh.getPoints().size() / 3);
            System.out.println("  TexCoords (UV): " + mesh.getTexCoords().size() / 2);
            System.out.println("  Faces (triangles): " + mesh.getFaces().size() / 6);
            if (mesh.getTexCoords().size() > 0) {
                System.out.println("  Primeros UV coords: [" +
                    mesh.getTexCoords().get(0) + ", " +
                    mesh.getTexCoords().get(1) + "]");
            }
        }

        // Crear MeshView
        MeshView meshView = new MeshView(mesh);
        meshView.setDrawMode(DrawMode.FILL);
        // Para el piso, desactivar culling para que sea visible desde ambos lados
        if (nombreObjeto.toLowerCase().contains("calle") || nombreObjeto.toLowerCase().contains("piso")) {
            meshView.setCullFace(CullFace.NONE);
            System.out.println("  CullFace establecido a NONE para el piso");
        } else {
            meshView.setCullFace(CullFace.BACK);
        }

        // Asignar material
        String nombreMaterial = partesClave.length > 1 ? partesClave[1] : "default";

        PhongMaterial material = crearMaterial(nombreObjeto, nombreMaterial);
        meshView.setMaterial(material);

        // Debug: Verificar que el material tiene textura
        if (nombreObjeto.toLowerCase().contains("calle") || nombreObjeto.toLowerCase().contains("piso")) {
            System.out.println("  Material aplicado. Tiene textura: " + (material.getDiffuseMap() != null));
            if (material.getDiffuseMap() != null) {
                System.out.println("  Textura tamaño: " + material.getDiffuseMap().getWidth() + "x" +
                                   material.getDiffuseMap().getHeight());
            }
            System.out.println("  Color difuso: " + material.getDiffuseColor());
        }

        // Asignar ID si es necesario
        if (nombreObjeto.toLowerCase().contains("pinata")) {
            meshView.setId("pinata_mesh");
            System.out.println("Asignado ID 'pinata_mesh' a: " + nombreObjeto);
        } else if (nombreObjeto.toLowerCase().startsWith("luz_")) {
            meshView.setId(nombreObjeto);
            System.out.println("Asignado ID '" + nombreObjeto + "'");
        }

        return meshView;
    }

    private PhongMaterial crearMaterial(String nombreObjeto, String nombreMaterial) {
        PhongMaterial material = new PhongMaterial();
        String nombreLower = nombreObjeto.toLowerCase();
        boolean texturaAplicada = false;

        // Intentar cargar texturas personalizadas según el nombre del objeto PRIMERO
        if (nombreLower.contains("calle") || nombreLower.contains("piso") || nombreLower.contains("adoquin")) {
            System.out.println("Detectado objeto de piso: " + nombreObjeto);
            if (cargarTextura(material, "/textures/piso.jpg") ||
                cargarTextura(material, "/textures/piso.png")) {
                texturaAplicada = true;
            }
        } else if (nombreLower.contains("pinata")) {
            System.out.println("Detectado objeto piñata: " + nombreObjeto);
            if (cargarTextura(material, "/textures/pinata.jpg") ||
                cargarTextura(material, "/textures/pinata.png")) {
                texturaAplicada = true;
            }
        }

        // Intentar obtener material del archivo .mtl
        Material mtlMaterial = materiales.get(nombreMaterial);

        if (mtlMaterial != null) {
            // IMPORTANTE: Solo aplicar color difuso si NO hay textura
            // En JavaFX, setDiffuseColor puede interferir con setDiffuseMap
            if (!texturaAplicada && mtlMaterial.colorDifuso != null) {
                material.setDiffuseColor(mtlMaterial.colorDifuso);
                System.out.println("  - Aplicado color difuso del .mtl");
            } else if (texturaAplicada) {
                // Si hay textura, asegurar que el color sea blanco para no interferir
                material.setDiffuseColor(Color.WHITE);
                System.out.println("  - Color difuso establecido a WHITE para no interferir con textura");
            }

            // Para texturas, reducir el brillo especular
            if (texturaAplicada) {
                material.setSpecularColor(Color.gray(0.1));  // Muy poco brillo especular
                material.setSpecularPower(2);  // Brillo muy difuso
                System.out.println("  - Reducido brillo especular para textura");
            } else if (mtlMaterial.colorEspecular != null) {
                material.setSpecularColor(mtlMaterial.colorEspecular);
            }
            if (mtlMaterial.texturaDifusa != null && !texturaAplicada) {
                try {
                    InputStream texStream = getClass().getResourceAsStream("/assets/" + mtlMaterial.texturaDifusa);
                    if (texStream != null) {
                        Image texture = new Image(texStream);
                        material.setDiffuseMap(texture);
                    }
                } catch (Exception e) {
                    System.err.println("Error al cargar textura: " + mtlMaterial.texturaDifusa);
                }
            }
        } else {
            // Materiales inteligentes basados en nombre (cuando no hay .mtl)
            System.out.println("Sin material .mtl para: '" + nombreObjeto + "'");

            if (nombreLower.contains("calle") || nombreLower.contains("piso") || nombreLower.contains("adoquin")) {
                // Intentar cargar textura de piso/calle
                if (!cargarTextura(material, "/textures/piso.jpg") &&
                    !cargarTextura(material, "/textures/piso.png")) {
                    // Si no hay textura, usar color
                    material.setDiffuseColor(Color.DARKGRAY);
                }
                material.setSpecularColor(Color.LIGHTGRAY);
                material.setSpecularPower(8);

            } else if (nombreLower.contains("pared") || nombreLower.contains("muro")) {
                material.setDiffuseColor(Color.SANDYBROWN);
                material.setSpecularColor(Color.WHITE);
                material.setSpecularPower(10);

            } else if (nombreLower.contains("ventana")) {
                material.setDiffuseColor(Color.LIGHTBLUE.deriveColor(0, 1, 1, 0.6));
                material.setSpecularColor(Color.WHITE);
                material.setSpecularPower(64);

            } else if (nombreLower.contains("puerta")) {
                material.setDiffuseColor(Color.SADDLEBROWN);
                material.setSpecularColor(Color.BURLYWOOD);
                material.setSpecularPower(12);

            } else if (nombreLower.contains("techo")) {
                material.setDiffuseColor(Color.DARKRED);
                material.setSpecularColor(Color.RED);
                material.setSpecularPower(20);

            } else if (nombreLower.startsWith("luz_")) {
                material.setDiffuseColor(Color.RED);
                material.setSpecularColor(Color.YELLOW);
                material.setSpecularPower(32);

            } else if (nombreLower.contains("pinata")) {
                // Intentar cargar textura de piñata
                if (!cargarTextura(material, "/textures/pinata.jpg") &&
                    !cargarTextura(material, "/textures/pinata.png")) {
                    // Si no hay textura, usar color
                    material.setDiffuseColor(Color.HOTPINK);
                }
                material.setSpecularColor(Color.WHITE);
                material.setSpecularPower(16);

            } else {
                // Color aleatorio para otros objetos
                Random rand = new Random(nombreObjeto.hashCode());
                double h = rand.nextDouble() * 360;
                double s = 0.5 + rand.nextDouble() * 0.3;
                double b = 0.6 + rand.nextDouble() * 0.3;
                material.setDiffuseColor(Color.hsb(h, s, b));
                material.setSpecularColor(Color.WHITE);
                material.setSpecularPower(16);
            }
        }

        return material;
    }

    /**
     * Intenta cargar una textura desde una ruta. Retorna true si se cargó exitosamente.
     */
    private boolean cargarTextura(PhongMaterial material, String ruta) {
        try {
            System.out.println("Intentando cargar textura: " + ruta);

            Image texture = null;

            // Método 1: Intentar cargar como recurso
            InputStream texStream = getClass().getResourceAsStream(ruta);
            if (texStream != null) {
                System.out.println("  - Cargando desde recursos (InputStream)");
                texture = new Image(texStream);
            } else {
                // Método 2: Intentar cargar desde sistema de archivos
                String basePath = System.getProperty("user.dir");
                String[] posiblesPaths = {
                    basePath + "/src/main/resources" + ruta,
                    basePath + "/target/classes" + ruta,
                    "file:" + basePath + "/src/main/resources" + ruta
                };

                for (String path : posiblesPaths) {
                    try {
                        System.out.println("  - Intentando desde: " + path);
                        if (path.startsWith("file:")) {
                            texture = new Image(path);
                        } else {
                            File file = new File(path);
                            if (file.exists()) {
                                texture = new Image(new FileInputStream(file));
                                System.out.println("  - Archivo encontrado!");
                                break;
                            }
                        }
                    } catch (Exception ex) {
                        // Continuar con siguiente ruta
                    }
                }
            }

            if (texture != null) {
                System.out.println("  - Image creada, tamaño: " + texture.getWidth() + "x" + texture.getHeight());
                if (!texture.isError()) {
                    material.setDiffuseMap(texture);
                    System.out.println("  ✓ Textura cargada exitosamente: " + ruta);
                    return true;
                } else {
                    System.out.println("  ✗ Error en la imagen: " + texture.getException());
                }
            } else {
                System.out.println("  ✗ No se pudo cargar la textura desde ninguna ruta");
            }
        } catch (Exception e) {
            System.out.println("  ✗ Excepción al cargar textura: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Clases internas
    private static class Face {
        List<Integer> vertices = new ArrayList<>();
        List<Integer> texturas = new ArrayList<>();
        List<Integer> normales = new ArrayList<>();
    }

    private static class Material {
        String nombre;
        Color colorDifuso;
        Color colorEspecular;
        String texturaDifusa;
    }
}
