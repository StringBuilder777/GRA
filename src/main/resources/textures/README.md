# Texturas para la Escena Navideña 3D

Coloca aquí tus imágenes de texturas para dar vida a la escena.

## Texturas Soportadas

### 1. Piso/Calle (Calle_Adoquin)
**Archivos buscados:**
- `piso.jpg` (preferido)
- `piso.png` (alternativo)

**Sugerencias:**
- Textura de adoquines, piedra, o pavimento
- Tamaño recomendado: 1024x1024 o 2048x2048
- Debe ser tileable (repetible sin costuras)

**Ejemplos de búsqueda:**
- "cobblestone texture"
- "stone pavement texture"
- "brick street texture seamless"

### 2. Piñata (pinata_mesh)
**Archivos buscados:**
- `pinata.jpg` (preferido)
- `pinata.png` (alternativo)

**Sugerencias:**
- Textura colorida y festiva
- Puede incluir colores brillantes: rojo, amarillo, azul, verde
- Tamaño recomendado: 512x512 o 1024x1024
- Puede ser papel picado, rayas de colores, o patrones festivos

**Ejemplos de búsqueda:**
- "colorful paper texture"
- "mexican paper craft texture"
- "striped colorful texture"

## Cómo Agregar Texturas

1. Descarga o crea las imágenes en formato JPG o PNG
2. Renómbralas según los nombres listados arriba
3. Colócalas en esta carpeta: `src/main/resources/textures/`
4. Compila y ejecuta la aplicación

## Comportamiento

- Si la textura existe, se cargará automáticamente
- Si la textura no existe, se usará un color sólido por defecto:
  - **Piso**: Gris oscuro (DARKGRAY)
  - **Piñata**: Rosa fuerte (HOTPINK)

## Fuentes Gratuitas de Texturas

- [Poly Haven](https://polyhaven.com/textures)
- [Textures.com](https://www.textures.com/) (requiere registro gratuito)
- [OpenGameArt](https://opengameart.org/)
- [FreePBR](https://freepbr.com/)

## Ejemplo de Uso en Blender

Si estás creando las texturas en Blender:
1. Exporta las texturas desde el editor UV
2. Guárdalas en formato JPG con calidad 90%
3. Asegúrate de que sean cuadradas (potencia de 2: 512, 1024, 2048)
