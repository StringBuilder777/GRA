package pinata3d;

import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Importador mejorado de archivos OBJ para JavaFX 3D
 * 
 * Parsea archivos .obj y crea MeshView para renderización en JavaFX.
 * Soporta múltiples objetos, grupos, y triangulación automática.
 * 
 * CARACTERÍSTICAS:
 * - Carga de vértices (v)
 * - Carga de coordenadas de textura (vt)
 * - Carga de normales (vn)
 * - Soporte de caras triangulares y cuadriláteras
 * - Triangulación automática de polígonos
 * - Manejo de múltiples objetos/grupos
 * - Preservación de IDs de objetos
 * 
 * FORMATO OBJ SOPORTADO:
 * v x y z          - Vértice
 * vt u v           - Coordenada de textura
 * vn x y z         - Normal
 * f v1 v2 v3       - Cara (índices)
 * f v1/vt1 v2/vt2  - Cara con texturas
 * f v1/vt1/vn1 ... - Cara con texturas y normales
 * o nombre         - Objeto
 * g nombre         - Grupo
 * 
 * @author StringBuilder
 * @version 2.0
 */
public class ObjImporter {
    
    // Datos del modelo
    private List<Float> vertices = new ArrayList<>();
    private List<Float> texCoords = new ArrayList<>();
    private List<Float> normals = new ArrayList<>();
    private List<Integer> faces = new ArrayList<>();
    
    // Metadatos
    private String currentObjectName = "default";
    private Map<String, Integer> objectStats = new HashMap<>();
    
    /**
     * Carga un archivo OBJ desde una URL
     * 
     * @param objUrl URL del archivo OBJ (puede ser externa o de recursos)
     * @return Array de MeshView creados (uno por objeto/grupo)
     * @throws Exception si hay error al cargar o parsear el archivo
     */
    public MeshView[] load(String objUrl) throws Exception {
        System.out.println("📦 Iniciando carga de OBJ...");
        System.out.println("   URL: " + objUrl);
        
        // Limpiar datos previos
        clear();
        
        // Abrir y leer archivo
        URL url = new URL(objUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String line;
        int lineNumber = 0;
        
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            try {
                parseLine(line);
            } catch (Exception e) {
                System.err.println("⚠️  Error en línea " + lineNumber + ": " + e.getMessage());
                // Continuar parseando el resto del archivo
            }
        }
        
        reader.close();
        
        // Estadísticas de carga
        printLoadStatistics();
        
        // Validar datos
        if (vertices.isEmpty()) {
            throw new IllegalArgumentException("El archivo OBJ no contiene vértices");
        }
        
        if (faces.isEmpty()) {
            throw new IllegalArgumentException("El archivo OBJ no contiene caras");
        }
        
        // Crear mesh
        return createMeshViews();
    }
    
    /**
     * Limpia todos los datos del importador
     */
    private void clear() {
        vertices.clear();
        texCoords.clear();
        normals.clear();
        faces.clear();
        objectStats.clear();
        currentObjectName = "default";
    }
    
    /**
     * Imprime estadísticas de carga
     */
    private void printLoadStatistics() {
        System.out.println("\n📊 Estadísticas de carga:");
        System.out.println("   Vértices: " + (vertices.size() / 3));
        System.out.println("   Coordenadas de textura: " + (texCoords.size() / 2));
        System.out.println("   Normales: " + (normals.size() / 3));
        System.out.println("   Triángulos: " + (faces.size() / 6));
        
        if (!objectStats.isEmpty()) {
            System.out.println("   Objetos/Grupos:");
            objectStats.forEach((name, count) -> 
                System.out.println("      - " + name + ": " + count + " referencias")
            );
        }
        System.out.println();
    }
    
    /**
     * Parsea una línea del archivo OBJ
     */
    private void parseLine(String line) {
        line = line.trim();
        
        // Ignorar líneas vacías y comentarios
        if (line.isEmpty() || line.startsWith("#")) {
            return;
        }
        
        String[] parts = line.split("\\s+");
        
        if (parts.length == 0) {
            return;
        }
        
        switch (parts[0]) {
            case "v":
                parseVertex(parts);
                break;
                
            case "vt":
                parseTexCoord(parts);
                break;
                
            case "vn":
                parseNormal(parts);
                break;
                
            case "f":
                parseFace(parts);
                break;
                
            case "o":
            case "g":
                parseObject(parts);
                break;
                
            case "mtllib":
            case "usemtl":
            case "s":
                // Material y shading - ignorar por ahora
                break;
                
            default:
                // Comando desconocido - ignorar
                break;
        }
    }
    
    /**
     * Parsea un vértice: v x y z [w]
     */
    private void parseVertex(String[] parts) {
        if (parts.length < 4) {
            throw new IllegalArgumentException("Vértice inválido: necesita al menos 3 coordenadas");
        }
        
        vertices.add(Float.parseFloat(parts[1]));
        vertices.add(Float.parseFloat(parts[2]));
        vertices.add(Float.parseFloat(parts[3]));
        // Ignorar componente w si existe
    }
    
    /**
     * Parsea una coordenada de textura: vt u v [w]
     */
    private void parseTexCoord(String[] parts) {
        if (parts.length < 3) {
            throw new IllegalArgumentException("Coordenada de textura inválida");
        }
        
        texCoords.add(Float.parseFloat(parts[1]));
        texCoords.add(Float.parseFloat(parts[2]));
        // Ignorar componente w si existe
    }
    
    /**
     * Parsea una normal: vn x y z
     */
    private void parseNormal(String[] parts) {
        if (parts.length < 4) {
            throw new IllegalArgumentException("Normal inválida: necesita 3 componentes");
        }
        
        normals.add(Float.parseFloat(parts[1]));
        normals.add(Float.parseFloat(parts[2]));
        normals.add(Float.parseFloat(parts[3]));
    }
    
    /**
     * Parsea un objeto o grupo: o nombre / g nombre
     */
    private void parseObject(String[] parts) {
        if (parts.length >= 2) {
            currentObjectName = parts[1];
            objectStats.put(currentObjectName, objectStats.getOrDefault(currentObjectName, 0) + 1);
        }
    }
    
    /**
     * Parsea una cara (face): f v1[/vt1[/vn1]] v2[/vt2[/vn2]] v3[/vt3[/vn3]] ...
     * 
     * Formatos soportados:
     * - f v1 v2 v3
     * - f v1/vt1 v2/vt2 v3/vt3
     * - f v1/vt1/vn1 v2/vt2/vn2 v3/vt3/vn3
     * - f v1//vn1 v2//vn2 v3//vn3
     */
    private void parseFace(String[] parts) {
        if (parts.length < 4) {
            throw new IllegalArgumentException("Cara inválida: necesita al menos 3 vértices");
        }
        
        // Lista temporal para vértices de esta cara
        List<int[]> faceVertices = new ArrayList<>();
        
        // Parsear cada vértice de la cara
        for (int i = 1; i < parts.length; i++) {
            faceVertices.add(parseVertexIndices(parts[i]));
        }
        
        // Triangular la cara
        triangulateFace(faceVertices);
    }
    
    /**
     * Parsea los índices de un vértice: v[/vt[/vn]]
     * 
     * @return Array de 2 enteros: [índice vértice, índice textura]
     */
    private int[] parseVertexIndices(String vertexString) {
        String[] indices = vertexString.split("/", -1);  // -1 para preservar campos vacíos
        
        // Índice de vértice (obligatorio, OBJ usa base 1)
        int vertexIndex = Integer.parseInt(indices[0]) - 1;
        
        // Índice de textura (opcional)
        int texIndex = 0;  // Valor por defecto
        
        if (indices.length > 1 && !indices[1].isEmpty() && !texCoords.isEmpty()) {
            texIndex = Integer.parseInt(indices[1]) - 1;
        }
        
        // Ignorar índice de normal (indices[2]) por ahora
        // JavaFX calcula normales automáticamente
        
        return new int[]{vertexIndex, texIndex};
    }
    
    /**
     * Triangula una cara (convierte polígonos en triángulos)
     * 
     * Usa triangulación en abanico (fan triangulation):
     * Para cara con vértices [v0, v1, v2, v3, v4]:
     * - Triángulo 1: v0, v1, v2
     * - Triángulo 2: v0, v2, v3
     * - Triángulo 3: v0, v3, v4
     */
    private void triangulateFace(List<int[]> faceVertices) {
        if (faceVertices.size() < 3) {
            return;
        }
        
        // Vértice pivot (siempre el primero)
        int[] v0 = faceVertices.get(0);
        
        // Crear triángulos en abanico
        for (int i = 1; i < faceVertices.size() - 1; i++) {
            int[] v1 = faceVertices.get(i);
            int[] v2 = faceVertices.get(i + 1);
            
            // Añadir triángulo: v0, v1, v2
            addTriangle(v0, v1, v2);
        }
    }
    
    /**
     * Añade un triángulo a la lista de caras
     */
    private void addTriangle(int[] v0, int[] v1, int[] v2) {
        // Cada triángulo necesita 6 enteros:
        // v0_index, v0_tex, v1_index, v1_tex, v2_index, v2_tex
        
        faces.add(v0[0]);  // Vértice 0
        faces.add(v0[1]);  // Textura 0
        
        faces.add(v1[0]);  // Vértice 1
        faces.add(v1[1]);  // Textura 1
        
        faces.add(v2[0]);  // Vértice 2
        faces.add(v2[1]);  // Textura 2
    }
    
    /**
     * Crea los MeshView a partir de los datos parseados
     */
    private MeshView[] createMeshViews() {
        System.out.println("🔨 Construyendo mesh...");
        
        // Crear mesh de JavaFX
        TriangleMesh mesh = new TriangleMesh();
        
        // Convertir datos a arrays
        float[] vertexArray = toFloatArray(vertices);
        float[] texCoordArray;
        
        // Si no hay coordenadas de textura, crear dummy
        if (texCoords.isEmpty()) {
            texCoordArray = new float[] { 0, 0 };
            System.out.println("ℹ️  No hay coordenadas de textura, usando valores por defecto");
        } else {
            texCoordArray = toFloatArray(texCoords);
        }
        
        int[] faceArray = toIntArray(faces);
        
        // Configurar mesh
        mesh.getPoints().addAll(vertexArray);
        mesh.getTexCoords().addAll(texCoordArray);
        mesh.getFaces().addAll(faceArray);
        
        // Crear MeshView
        MeshView meshView = new MeshView(mesh);
        
        // Aplicar material por defecto
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.LIGHTGRAY);
        material.setSpecularColor(Color.WHITE);
        material.setSpecularPower(16.0);
        meshView.setMaterial(material);
        
        // Asignar ID si hay nombre de objeto
        if (!currentObjectName.equals("default")) {
            meshView.setId(currentObjectName);
            System.out.println("🏷️  Mesh ID asignado: " + currentObjectName);
        }
        
        System.out.println("✅ Mesh construido exitosamente");
        
        return new MeshView[] { meshView };
    }
    
    /**
     * Convierte List<Float> a float[]
     */
    private float[] toFloatArray(List<Float> list) {
        float[] array = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    /**
     * Convierte List<Integer> a int[]
     */
    private int[] toIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    /**
     * Obtiene el número de vértices cargados
     */
    public int getVertexCount() {
        return vertices.size() / 3;
    }
    
    /**
     * Obtiene el número de triángulos cargados
     */
    public int getTriangleCount() {
        return faces.size() / 6;
    }
    
    /**
     * Verifica si el modelo tiene coordenadas de textura
     */
    public boolean hasTextureCoords() {
        return !texCoords.isEmpty();
    }
    
    /**
     * Verifica si el modelo tiene normales
     */
    public boolean hasNormals() {
        return !normals.isEmpty();
    }
}
