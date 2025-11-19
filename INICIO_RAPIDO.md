# 🚀 INICIO RÁPIDO - Piñata 3D

## ⚡ Ejecutar en 3 Pasos

### 1️⃣ Instalar dependencias
```bash
# macOS
brew install mpv

# Linux
sudo apt-get install mpv
```

### 2️⃣ Añadir archivos de audio (opcional)
Coloca estos archivos en `src/main/resources/audio/`:
- `golpe.wav` - Sonido de golpe
- `musica.mp3` - Música de fondo

### 3️⃣ Ejecutar
```bash
# Opción A: Script automático
chmod +x run_pinata.sh
./run_pinata.sh

# Opción B: Maven directo
mvn clean javafx:run
```

## 🎮 Controles

| Tecla | Acción |
|-------|--------|
| W/A/S/D | Mover cámara |
| Mouse (arrastrar) | Rotar vista |
| Clic en piñata | ¡Golpear! 💥 |
| ESC | Salir |

## 📋 Configuración del Modelo (Blender)

En Blender, nombra tus objetos:
- **Piñata**: `pinata_mesh` (REQUERIDO)
- **Luces**: `luz_1`, `luz_2`, `luz_3`, ... (OPCIONAL)

Exporta como OBJ a: `src/main/resources/assets/posada.obj`

## ❓ Problemas Comunes

**No funciona la música:**
- Instala MPV: `brew install mpv`

**No se ve el modelo:**
- Verifica que `posada.obj` esté en `/resources/assets/`
- La app creará una escena de prueba si no encuentra el modelo

**No suena el golpe:**
- Añade `golpe.wav` en `/resources/audio/`

## 📚 Documentación Completa

- `PIÑATA_README.md` - Documentación completa
- `BLENDER_SETUP.md` - Guía de configuración de Blender
- `setup_audio.sh` - Script para configurar audio

## 🎯 Características

✅ Cámara 3D con controles FPS
✅ Piñata rotando automáticamente
✅ Sistema de partículas (15 objetos coloridos)
✅ Luces navideñas parpadeando (rojo/verde)
✅ Música de fondo en loop
✅ Sonido de golpe al hacer clic
✅ Importador OBJ personalizado

---

**¡Listo para golpear la piñata!** 🎊

Para más detalles, consulta `PIÑATA_README.md`
