#!/bin/bash

# Script para crear archivos de audio dummy para pruebas
# Los archivos reales deben ser reemplazados por sonidos reales

AUDIO_DIR="src/main/resources/audio"

echo "Creando archivos de audio dummy..."

# Crear directorio si no existe
mkdir -p "$AUDIO_DIR"

# Información sobre dónde obtener archivos reales
cat > "$AUDIO_DIR/INSTRUCCIONES.txt" << EOF
===========================================
ARCHIVOS DE AUDIO NECESARIOS
===========================================

Este proyecto requiere los siguientes archivos de audio:

1. golpe.wav - Sonido de golpe/impacto
   - Formato: WAV
   - Duración recomendada: 0.5-1 segundo
   - Sitios para descargar:
     * https://freesound.org/ (busca: "punch", "hit", "impact")
     * https://www.zapsplat.com/ (sección: impacts)

2. musica.mp3 - Música de fondo navideña
   - Formato: MP3
   - Duración: 2-5 minutos (se reproduce en loop)
   - Sitios para descargar:
     * https://incompetech.com/ (Música libre de Kevin MacLeod)
     * https://www.bensound.com/ (busca: christmas, holiday)
     * https://freemusicarchive.org/ (busca: christmas instrumental)

===========================================
INSTALACIÓN DE MPV (para música de fondo)
===========================================

macOS:
  brew install mpv

Linux (Ubuntu/Debian):
  sudo apt-get install mpv

Windows:
  Descarga desde https://mpv.io/installation/

===========================================
NOTAS LEGALES
===========================================

Asegúrate de que los archivos de audio que uses:
- Sean de dominio público, o
- Tengan licencia Creative Commons, o  
- Tengas permiso para usarlos

Siempre da crédito al autor original si es requerido.
EOF

echo "✅ Instrucciones creadas en $AUDIO_DIR/INSTRUCCIONES.txt"
echo ""
echo "⚠️  IMPORTANTE:"
echo "   - Descarga 'golpe.wav' y 'musica.mp3'"
echo "   - Colócalos en $AUDIO_DIR/"
echo "   - Lee las instrucciones en INSTRUCCIONES.txt"
echo ""
echo "🎵 La aplicación funcionará sin audio, pero no sonará"
