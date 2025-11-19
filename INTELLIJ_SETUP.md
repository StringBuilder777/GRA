# Configuración de IntelliJ IDEA para Piñata 3D

## 🔧 Configuración del Proyecto

### 1. Abrir el Proyecto
1. `File > Open...`
2. Selecciona la carpeta del proyecto
3. IntelliJ detectará el `pom.xml` automáticamente

### 2. Configurar SDK
1. `File > Project Structure` (Cmd+; en Mac)
2. `Project > Project SDK`: Selecciona Java 17 o superior
3. `Project > Project language level`: 17 o superior
4. Click `Apply` y `OK`

### 3. Sincronizar Maven
1. Panel derecho: Click en "Maven" 
2. Click en el ícono de refrescar (↻)
3. Espera a que descargue todas las dependencias

### 4. Marcar Carpetas de Recursos
1. `File > Project Structure > Modules`
2. Asegúrate de que esté marcado:
   - `src/main/java` como **Sources**
   - `src/main/resources` como **Resources**
   - `src/test/java` como **Test Sources**

## ▶️ Configuraciones de Ejecución

### Opción 1: Ejecutar Clase Principal

1. **Crear Nueva Configuración:**
   - `Run > Edit Configurations...`
   - Click `+` > `Application`
   
2. **Configurar:**
   - **Name:** `Piñata 3D`
   - **Module:** `StringBuilder`
   - **Main class:** `pinata3d.PinataApp3D`
   - **VM options:** 
     ```
     --module-path /ruta/a/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml,javafx.media,javafx.graphics
     ```
   - **Working directory:** `$MODULE_WORKING_DIR$`

3. **Aplicar y Ejecutar**

### Opción 2: Ejecutar con Maven (Recomendado)

1. **Crear Nueva Configuración:**
   - `Run > Edit Configurations...`
   - Click `+` > `Maven`

2. **Configurar:**
   - **Name:** `Piñata 3D (Maven)`
   - **Command line:** `javafx:run`
   - **Working directory:** Raíz del proyecto

3. **Aplicar y Ejecutar**

## 🐛 Configuración de Debug

Para depurar la aplicación:

1. Usa cualquiera de las configuraciones anteriores
2. Click en el ícono de bug (🐛) en lugar del play (▶️)
3. Coloca breakpoints en el código (clic en el margen izquierdo)

**Puntos de interés para debugging:**
- `PinataApp3D.loadObjModel()` - Carga del modelo
- `PinataApp3D.onPinataClicked()` - Evento de clic
- `PinataApp3D.generateParticles()` - Sistema de partículas
- `ObjImporter.load()` - Parsing de OBJ

## 📦 Plugins Recomendados

Instala estos plugins para mejor experiencia:

1. **Maven Helper**
   - Facilita trabajo con dependencias Maven
   - `File > Settings > Plugins > Marketplace > buscar "Maven Helper"`

2. **JavaFX Runtime for Plugins**
   - Mejor soporte para JavaFX
   - `File > Settings > Plugins > Marketplace > buscar "JavaFX"`

3. **Blender Integration** (opcional)
   - Si trabajas con Blender
   - Permite abrir archivos .blend desde IntelliJ

## ⚙️ Ajustes Adicionales

### Aumentar Memoria de la JVM
Si el proyecto es grande, aumenta la memoria:

1. `Help > Edit Custom VM Options...`
2. Añade/modifica:
   ```
   -Xmx2048m
   -Xms512m
   ```

### Formato de Código
Configurar formato automático:

1. `File > Settings > Editor > Code Style > Java`
2. `Scheme > Import Scheme > IntelliJ IDEA code style XML`
3. O usa el estilo por defecto de IntelliJ

### Live Templates
Crear snippet para JavaFX:

1. `File > Settings > Editor > Live Templates`
2. Añade templates personalizados para JavaFX 3D

## 🔍 Resolución de Problemas

### "Cannot resolve symbol javafx"
**Solución:**
1. Maven panel → Click derecho en proyecto → Reimport
2. `File > Invalidate Caches / Restart`
3. Verifica que las dependencias de JavaFX estén descargadas

### "Class not found: pinata3d.PinataApp3D"
**Solución:**
1. `Build > Rebuild Project`
2. Verifica que `src/main/java` esté marcado como Sources
3. Verifica la configuración del classpath

### Error al ejecutar con JavaFX
**Solución:**
1. Usa la configuración de Maven (`mvn javafx:run`)
2. O añade las VM options correctas (ver Opción 1 arriba)

### Proyecto lento
**Solución:**
1. Excluye carpetas no necesarias:
   - Click derecho en `target` → Mark Directory as → Excluded
   - Click derecho en `.idea` → Mark Directory as → Excluded
2. Aumenta memoria de IntelliJ (ver arriba)

## 📝 Shortcuts Útiles

| Acción | Mac | Windows/Linux |
|--------|-----|---------------|
| Ejecutar | Ctrl+R | Shift+F10 |
| Debug | Ctrl+D | Shift+F9 |
| Buscar clase | Cmd+O | Ctrl+N |
| Buscar archivo | Cmd+Shift+O | Ctrl+Shift+N |
| Buscar en archivos | Cmd+Shift+F | Ctrl+Shift+F |
| Refactorizar | Cmd+T | Ctrl+Alt+Shift+T |
| Completar código | Cmd+Space | Ctrl+Space |

## 🎨 Temas Recomendados

Para trabajar con gráficos 3D, estos temas son cómodos:

- **Darcula** (oscuro, por defecto)
- **IntelliJ Light** (claro)
- **One Dark** (plugin)
- **Material Theme UI** (plugin)

## 📚 Recursos Adicionales

- [IntelliJ IDEA Docs](https://www.jetbrains.com/help/idea/)
- [JavaFX Documentation](https://openjfx.io/)
- [Maven in IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html)

---

¡Listo para desarrollar! 🚀

Si tienes problemas, revisa `PIÑATA_README.md` para más información.
