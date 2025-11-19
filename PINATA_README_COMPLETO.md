# 🎄 Piñata Navideña 3D - JavaFX 24

Una aplicación interactiva 3D desarrollada en JavaFX que simula una piñata navideña con efectos visuales, sonido y música de fondo.

## 📋 Características

### 🎮 Interactividad
- **Cámara FPS**: Controles de movimiento con W/A/S/D y rotación con mouse
- **Piñata Interactiva**: Click para golpear y generar sistema de partículas
- **Luces Navideñas**: Efecto parpadeante rojo/verde automático
- **Música de Fondo**: Reproducción continua usando MPV

### 🎨 Gráficos 3D
- Carga de modelos OBJ desde Blender
- Sistema de partículas con física
- Iluminación profesional (key, fill, rim lights)
- Antialiasing y renderizado suave
- Materiales con Phong shading

### 🔊 Audio
- Sonido de golpe con JavaFX AudioClip
- Música de fondo con MPV externo
- Control de volumen

## 🛠️ Requisitos

### Software
- **Java**: 17 o superior
- **JavaFX**: 24
- **Maven**: 3.8+ (para gestión de dependencias)
- **MPV**: Reproductor de medios (para música)
  - macOS: `brew install mpv`
  - Linux: `sudo apt-get install mpv`
  - Windows: Descargar de [mpv.io](https://mpv.io)

### Archivos de Recursos
```
src/main/resources/
├── assets/
│   ├── posada.obj      # Modelo 3D exportado desde Blender
│   └── posada.mtl      # Materiales del modelo (opcional)
└── audio/
    └── golpe.wav       # Sonido de golpe (WAV format)

audio/
└── musica.mp3          # Música de fondo (ruta relativa al ejecutable)
```

## 🚀 Instalación y Ejecución

### 1. Clonar/Descargar el Proyecto
```bash
cd /Users/Emiliano/Downloads/hola\ fx
```

### 2. Verificar Dependencias
Asegúrate de que `pom.xml` incluya JavaFX 24:
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>24</version>
</dependency>
```

### 3. Instalar MPV
```bash
# macOS
brew install mpv

# Linux (Debian/Ubuntu)
sudo apt-get install mpv

# Verificar instalación
mpv --version
```

### 4. Preparar Archivos de Audio
```bash
# Crear directorio de audio si no existe
mkdir -p audio

# Copiar tu música
cp tu_musica_navidena.mp3 audio/musica.mp3

# Verificar que existe el sonido de golpe
ls src/main/resources/audio/golpe.wav
```

### 5. Compilar y Ejecutar
```bash
# Compilar con Maven
mvn clean compile

# Ejecutar la aplicación
mvn javafx:run
```

O usando el script de ejecución:
```bash
chmod +x run_pinata.sh
./run_pinata.sh
```

## 🎮 Controles

| Tecla/Acción | Función |
|--------------|---------|
| **W** | Mover cámara hacia adelante |
| **S** | Mover cámara hacia atrás |
| **A** | Mover cámara a la izquierda |
| **D** | Mover cámara a la derecha |
| **Shift** | Movimiento rápido (2x velocidad) |
| **Mouse Drag** | Rotar vista (MouseLook) |
| **Click en Piñata** | Golpear piñata (genera partículas) |
| **Espacio** | Resetear posición de cámara |
| **ESC** | Salir de la aplicación |

## 🏗️ Estructura del Código

```
src/main/java/pinata3d/
├── PinataApp3D.java        # Aplicación principal
├── ObjImporter.java        # Importador de modelos OBJ
├── MusicController.java    # Control de música con MPV
└── SoundController.java    # Control de efectos de sonido
```

### Clases Principales

#### `PinataApp3D.java`
- **Propósito**: Aplicación principal de JavaFX
- **Responsabilidades**:
  - Configuración de escena 3D
  - Sistema de cámara con controles FPS
  - Gestión de eventos de usuario
  - Coordinación de animaciones y efectos

#### `ObjImporter.java`
- **Propósito**: Importador de modelos 3D en formato OBJ
- **Características**:
  - Parseo de vértices, texturas y normales
  - Triangulación automática de polígonos
  - Soporte de múltiples objetos
  - Manejo de errores robusto

#### `MusicController.java`
- **Propósito**: Control de música de fondo
- **Tecnología**: ProcessBuilder + MPV
- **Características**:
  - Reproducción en loop infinito
  - Control de proceso externo
  - Gestión de cierre limpio

#### `SoundController.java`
- **Propósito**: Efectos de sonido
- **Tecnología**: JavaFX AudioClip
- **Características**:
  - Reproducción inmediata sin lag
  - Control de volumen
  - Múltiples reproducciones simultáneas

## 📦 Exportación desde Blender

### Preparar el Modelo en Blender

1. **Nombrar Objetos Correctamente**:
   - Piñata: `pinata_mesh`
   - Luces: `luz_0`, `luz_1`, `luz_2`, etc.

2. **Exportar a OBJ**:
   ```
   File > Export > Wavefront (.obj)
   
   Opciones:
   ✅ Include Normals
   ✅ Include UVs
   ✅ Write Materials
   ✅ Triangulate Faces
   ✅ Objects as OBJ Objects
   ```

3. **Ubicar Archivo**:
   ```bash
   cp posada.obj src/main/resources/assets/
   ```

### Usar el Script de Conversión (Opcional)
Si tienes configurado el MCP de Blender:
```bash
# El archivo .blend debe estar en blender_src/
python automation/convert_blend.py posada.blend
```

## 🎯 Características Técnicas Destacadas

### Sistema de Partículas
- **Cantidad**: 15 partículas por golpe
- **Formas**: Box y Sphere aleatorios
- **Colores**: HSB aleatorio (Hue: 0-360°, Sat: 80-100%, Bright: 80-100%)
- **Física**: Caída con gravedad + rotación
- **Duración**: 3 segundos
- **Auto-destrucción**: Se eliminan automáticamente

### Sistema de Iluminación
- **Ambient Light**: Iluminación base (30% intensidad)
- **Key Light**: Luz principal frontal
- **Fill Light**: Luz de relleno lateral
- **Rim Light**: Luz trasera para contorno

### Animaciones
- **Piñata**: Rotación continua en eje Y (4 segundos/rotación)
- **Luces Navideñas**: Alternancia Rojo/Verde cada 1 segundo
- **Partículas**: TranslateTransition + RotateTransition + FadeTransition
- **Sacudida**: Efecto al golpear la piñata

## 🐛 Solución de Problemas

### Error: "MPV no encontrado"
```bash
# Verificar instalación
which mpv

# Instalar si falta
brew install mpv  # macOS
```

### Error: "Audio no disponible"
```bash
# Verificar que existe el archivo
ls src/main/resources/audio/golpe.wav

# Verificar formato (debe ser WAV)
file src/main/resources/audio/golpe.wav
```

### Error: "Modelo OBJ no se carga"
1. Verificar ruta: `src/main/resources/assets/posada.obj`
2. Verificar que el archivo no está corrupto
3. Re-exportar desde Blender con triangulación

### La piñata no responde al click
1. Verificar que el objeto se llama `pinata_mesh` en Blender
2. O modificar el código para buscar otro nombre:
   ```java
   pinataNode = findNodeById(sceneRoot, "tu_nombre_aqui");
   ```

### Rendimiento bajo
- Reducir antialiasing: Cambiar `SceneAntialiasing.BALANCED` a `DISABLED`
- Reducir número de partículas: Cambiar `PARTICLE_COUNT` a 8-10
- Simplificar modelo 3D en Blender

## 🎨 Personalización

### Cambiar Colores de Luces
```java
// En setupChristmasLights()
new KeyFrame(Duration.ZERO, e -> setLightsColor(Color.BLUE)),
new KeyFrame(Duration.seconds(1), e -> setLightsColor(Color.YELLOW))
```

### Ajustar Velocidad de Cámara
```java
private static final double CAMERA_SPEED = 5.0;        // Normal
private static final double CAMERA_SPEED_FAST = 10.0;  // Con Shift
```

### Modificar Cantidad de Partículas
```java
private static final int PARTICLE_COUNT = 20;  // Más partículas
```

### Cambiar Fondo
```java
scene.setFill(Color.BLACK);           // Negro
scene.setFill(Color.DARKSLATEBLUE);   // Azul oscuro
scene.setFill(Color.rgb(10, 10, 30)); // Azul muy oscuro
```

## 📝 Licencia

Este proyecto fue desarrollado como parte de un proyecto académico de Gráficos por Computadora.

## 👨‍💻 Autor

**StringBuilder**  
Proyecto de Animación 3D - JavaFX 24  
2025

## 🙏 Agradecimientos

- **JavaFX Team**: Por la excelente biblioteca 3D
- **MPV Project**: Por el reproductor de medios robusto
- **Blender Foundation**: Por el software de modelado 3D

---

## 📚 Referencias

- [JavaFX 3D Tutorial](https://docs.oracle.com/javase/8/javafx/graphics-tutorial/javafx-3d-graphics.htm)
- [JavaFX API Documentation](https://openjfx.io/javadoc/24/)
- [MPV Manual](https://mpv.io/manual/master/)
- [OBJ File Format](https://en.wikipedia.org/wiki/Wavefront_.obj_file)

---

**¡Disfruta tu Piñata Navideña 3D! 🎄🎉**
