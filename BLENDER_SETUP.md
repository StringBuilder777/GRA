# 📐 Guía de Configuración del Modelo 3D en Blender

## Requisitos del Modelo OBJ

Para que la aplicación funcione correctamente, el archivo `posada.obj` debe tener:

### 1. Piñata (REQUERIDO)
Un objeto con el nombre `pinata_mesh`

**Cómo configurarlo en Blender:**
1. Selecciona el objeto que será la piñata
2. En el panel de propiedades (derecha), busca la sección de Object Properties (ícono de cubo naranja)
3. En el campo de nombre (arriba), escribe: `pinata_mesh`
4. Este objeto será el que rote y responda a clics

### 2. Luces Navideñas (OPCIONAL)
Objetos cuyos nombres comiencen con `luz_`

**Cómo configurarlo en Blender:**
1. Selecciona cada objeto que quieras que sea una luz navideña
2. Renombra cada uno con el prefijo `luz_`:
   - `luz_1`
   - `luz_2`
   - `luz_3`
   - etc.
3. Estos objetos parpadearán alternando entre rojo y verde

**Recomendaciones para las luces:**
- Usa esferas pequeñas (`Sphere` con escala 0.1-0.3)
- Colócalas alrededor de la escena
- Asigna un material para que sea visible
- Las luces no necesitan emisión en Blender, la aplicación controla el color

### 3. Otros Objetos (OPCIONAL)
Puedes tener cualquier otro objeto en la escena:
- Fondo/escenario
- Decoraciones
- Suelo
- Paredes
- etc.

Estos se renderizarán normalmente sin interactividad especial.

## 🔧 Exportación desde Blender

### Pasos para exportar correctamente:

1. **Seleccionar objetos**
   - Selecciona todos los objetos que quieras exportar
   - Verifica que los nombres sean correctos (`pinata_mesh`, `luz_1`, etc.)

2. **Exportar a OBJ**
   - Menú: `File > Export > Wavefront (.obj)`
   - Nombre: `posada.obj`
   - **Configuración importante:**
     - ✅ Selection Only (si solo quieres exportar lo seleccionado)
     - ✅ Apply Modifiers
     - ✅ Write Materials
     - ✅ Triangulate Faces (recomendado)
     - ✅ Include UVs
     - ✅ Include Normals
     - ⚠️  **IMPORTANTE:** Asegúrate de que "Objects as OBJ Objects" esté marcado

3. **Guardar en el proyecto**
   - Guarda `posada.obj` en: `src/main/resources/assets/`
   - También se exportará `posada.mtl` (materiales)

## 📏 Escala y Posicionamiento

### Recomendaciones de escala:
- **Piñata:** Radio aproximado de 10-20 unidades
- **Luces:** Radio de 1-3 unidades
- **Escena completa:** Dentro de un cubo de 500x500x500 unidades

### Posicionamiento:
- Centra la piñata en el origen (0, 0, 0) o cerca
- Las luces pueden estar distribuidas alrededor
- La cámara inicia en Z=-300, Y=-50

## 🎨 Materiales

Los materiales de Blender se pueden exportar, pero la aplicación JavaFX:
- Convierte todo a `PhongMaterial`
- Respeta colores difusos (Diffuse Color)
- Las luces navideñas sobrescribirán su color automáticamente
- La piñata mantiene su color original

## ✅ Checklist de Verificación

Antes de exportar, verifica:

- [ ] Hay un objeto llamado exactamente `pinata_mesh`
- [ ] Las luces tienen nombres que empiezan con `luz_` (si las usas)
- [ ] Todos los objetos tienen materiales asignados
- [ ] La escala es apropiada
- [ ] Los objetos están posicionados correctamente
- [ ] Se exporta en formato OBJ con configuración correcta
- [ ] Los archivos se guardan en `src/main/resources/assets/`

## 🔍 Ejemplo de Estructura en Blender

```
Escena "Posada Navideña"
├── pinata_mesh (Esfera, Radio: 15)
├── luz_1 (Esfera pequeña, Posición: -50, 10, 0)
├── luz_2 (Esfera pequeña, Posición: -25, 10, 0)
├── luz_3 (Esfera pequeña, Posición: 0, 10, 0)
├── luz_4 (Esfera pequeña, Posición: 25, 10, 0)
├── luz_5 (Esfera pequeña, Posición: 50, 10, 0)
├── suelo (Plano, Escala: 50x50)
├── pared_fondo (Plano vertical)
└── decoracion_extra (Opcional)
```

## 🚨 Problemas Comunes

### La piñata no responde al clic
- **Causa:** El nombre no es exactamente `pinata_mesh`
- **Solución:** Revisa mayúsculas/minúsculas y guiones bajos

### Las luces no parpadean
- **Causa:** Los nombres no empiezan con `luz_`
- **Solución:** Renombra: `luz_1`, `luz_2`, etc.

### El modelo no se ve
- **Causa:** Escala muy grande o muy pequeña
- **Solución:** Ajusta la escala en Blender antes de exportar

### Colores incorrectos
- **Causa:** Materiales no exportados
- **Solución:** Marca "Write Materials" al exportar

## 🎯 Consejos Avanzados

### Para mejor rendimiento:
- Mantén el conteo de polígonos bajo (< 50,000 por objeto)
- Usa texturas en resolución moderada (1024x1024)
- Combina objetos estáticos cuando sea posible

### Para mejor apariencia:
- Usa iluminación en tres puntos en Blender para previsualizar
- Aplica smooth shading a objetos redondos
- Ajusta normales si es necesario

### Para debugging:
- Exporta una versión simple primero (solo piñata y suelo)
- Añade complejidad gradualmente
- Revisa la consola de JavaFX para mensajes de carga

---

¿Necesitas ayuda? Revisa el archivo `PIÑATA_README.md` para más información.
