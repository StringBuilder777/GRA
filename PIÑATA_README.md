# 🎉 Piñata Navideña 3D - JavaFX

Aplicación interactiva 3D de una piñata navideña con animaciones, sistema de partículas y música.

## ✨ Características

### 🎮 Controles de Cámara
- **W/A/S/D** - Mover cámara (adelante/izquierda/atrás/derecha)
- **Mouse (arrastrar)** - Rotar vista (look around)
- **ESC** - Salir de la aplicación

### 🪅 Piñata Interactiva
- **Animación automática**: La piñata rota constantemente en el eje Y
- **Clic en la piñata**: 
  - Reproduce sonido de golpe
  - Genera 15 partículas coloridas que caen al suelo
  - Las partículas desaparecen después de 3 segundos

### 💡 Luces Navideñas
- Busca automáticamente objetos con ID que empiecen con `luz_`
- Efecto de parpadeo alternando entre rojo y verde cada segundo
- Simula luces navideñas tradicionales

### 🎵 Música de Fondo
- Usa MPV externo para reproducir música en loop
- Se detiene automáticamente al cerrar la aplicación
- No interfiere con el rendimiento de JavaFX

## 📋 Requisitos

### Software
- **Java 17+** (compilado con Java 23)
- **JavaFX 24** (incluido en el pom.xml)
- **Maven** (para gestión de dependencias)
- **MPV** (para música de fondo)

### Instalación de MPV

#### macOS
```bash
brew install mpv
```

#### Linux (Ubuntu/Debian)
```bash
sudo apt-get install mpv
```

#### Windows
Descarga desde: https://mpv.io/installation/

## 🗂️ Estructura del Proyecto

```
src/main/
├── java/pinata3d/
│   ├── PinataApp3D.java       # Clase principal de la aplicación
│   ├── ObjImporter.java       # Importador de archivos .obj
│   ├── MusicController.java   # Control de música con MPV
│   └── SoundController.java   # Control de efectos de sonido
└── resources/
    ├── assets/
    │   ├── posada.obj          # Modelo 3D principal
    │   └── posada.mtl          # Material del modelo
    └── audio/
        ├── golpe.wav           # Sonido de golpe (REQUERIDO)
        └── musica.mp3          # Música de fondo (REQUERIDO)
```

## 🚀 Cómo Ejecutar

### Opción 1: Desde Maven
```bash
mvn clean javafx:run
```

### Opción 2: Desde IDE
1. Abre el proyecto en tu IDE (IntelliJ IDEA, Eclipse, etc.)
2. Ejecuta la clase `pinata3d.PinataApp3D`

### Opción 3: Compilar JAR
```bash
mvn clean package
java -jar target/StringBuilder-1.0-SNAPSHOT.jar
```

## 📦 Recursos Necesarios

### Archivos de Audio
Coloca estos archivos en `src/main/resources/audio/`:

1. **golpe.wav** - Sonido corto de golpe/impacto
   - Sitios recomendados: freesound.org, zapsplat.com
   - Búsqueda: "hit", "punch", "impact"

2. **musica.mp3** - Música navideña de fondo
   - Sitios recomendados: incompetech.com, bensound.com
   - Búsqueda: "christmas music", "holiday music"

### Modelo 3D
El archivo `posada.obj` debe incluir:
- Un objeto con ID `pinata_mesh` (la piñata)
- Objetos con IDs que empiecen con `luz_` (luces navideñas)

Si no se encuentra el modelo, se creará una escena de prueba automáticamente.

## 🎨 Personalización

### Modificar Colores de Luces
En `PinataApp3D.java`, línea ~315:
```java
new KeyFrame(Duration.ZERO, e -> setLightsColor(Color.RED)),
new KeyFrame(Duration.seconds(1), e -> setLightsColor(Color.GREEN))
```

### Cambiar Velocidad de Cámara
En `PinataApp3D.java`, línea ~28:
```java
private static final double CAMERA_SPEED = 5.0;
```

### Ajustar Cantidad de Partículas
En `PinataApp3D.java`, línea ~212:
```java
for (int i = 0; i < 15; i++) {
```

### Modificar Duración de Rotación de Piñata
En `PinataApp3D.java`, línea ~178:
```java
RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), pinataNode);
```

## 🔧 Solución de Problemas

### No se carga el modelo OBJ
- Verifica que `posada.obj` esté en `src/main/resources/assets/`
- Revisa la consola para mensajes de error
- La aplicación creará una escena de prueba si falla la carga

### No suena el audio
- Verifica que `golpe.wav` esté en `src/main/resources/audio/`
- Asegúrate de que MPV esté instalado para la música de fondo
- Revisa los permisos de audio del sistema

### La piñata no responde al clic
- Asegúrate de que el objeto tenga ID `pinata_mesh` en Blender
- Verifica que el mouse esté sobre el objeto 3D
- Revisa la consola para mensajes de depuración

### Las luces no parpadean
- Verifica que los objetos tengan IDs que empiecen con `luz_`
- Asegúrate de que tengan material PhongMaterial
- Revisa la consola para ver cuántas luces se encontraron

## 🎯 Características Técnicas

- **Motor de renderizado**: JavaFX 3D con anti-aliasing
- **Cámara**: Perspectiva con controles FPS-style
- **Iluminación**: Ambiental + 2 luces puntuales
- **Animaciones**: Timeline y TranslateTransition
- **Sistema de partículas**: 15 objetos con física simple
- **Importación 3D**: Parser OBJ personalizado
- **Audio**: JavaFX Media + MPV externo

## 📝 Notas de Desarrollo

- El importador OBJ es básico y soporta: vértices, caras, texturas
- Las normales se ignoran por ahora (se calculan automáticamente)
- La triangulación de polígonos con más de 3 vértices es simple
- El sistema de partículas es básico (sin colisiones reales)

## 🤝 Créditos

Desarrollado como proyecto de animación 3D con JavaFX.
- **Modelo 3D**: posada.obj (exportado desde Blender)
- **Framework**: JavaFX 24
- **Audio**: MPV Player

## 📄 Licencia

Proyecto educativo - Uso libre para aprendizaje.

---

¡Disfruta golpeando la piñata! 🎊
