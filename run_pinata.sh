#!/bin/bash

# Script de ejecución para la aplicación Piñata 3D
# Facilita la ejecución del proyecto con diferentes configuraciones

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}╔═══════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║     🎉 PIÑATA NAVIDEÑA 3D - JavaFX      ║${NC}"
echo -e "${BLUE}╚═══════════════════════════════════════════╝${NC}"
echo ""

# Verificar Java
echo -e "${YELLOW}Verificando instalación de Java...${NC}"
if ! command -v java &> /dev/null; then
    echo -e "${RED}❌ Java no está instalado${NC}"
    echo "Por favor instala Java 17 o superior"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | cut -d'.' -f1)
echo -e "${GREEN}✅ Java $JAVA_VERSION encontrado${NC}"

# Verificar Maven
echo -e "${YELLOW}Verificando instalación de Maven...${NC}"
if ! command -v mvn &> /dev/null; then
    echo -e "${RED}❌ Maven no está instalado${NC}"
    echo "Por favor instala Maven: brew install maven (macOS)"
    exit 1
fi
echo -e "${GREEN}✅ Maven encontrado${NC}"

# Verificar MPV (opcional pero recomendado)
echo -e "${YELLOW}Verificando instalación de MPV...${NC}"
if ! command -v mpv &> /dev/null; then
    echo -e "${YELLOW}⚠️  MPV no está instalado (música de fondo no funcionará)${NC}"
    echo "   Instalar: brew install mpv (macOS) o apt-get install mpv (Linux)"
else
    echo -e "${GREEN}✅ MPV encontrado${NC}"
fi

# Verificar archivos de audio
echo -e "${YELLOW}Verificando archivos de audio...${NC}"
AUDIO_DIR="src/main/resources/audio"

if [ -f "$AUDIO_DIR/golpe.wav" ]; then
    echo -e "${GREEN}✅ golpe.wav encontrado${NC}"
else
    echo -e "${YELLOW}⚠️  golpe.wav no encontrado${NC}"
    echo "   La aplicación funcionará, pero sin sonido de golpe"
fi

if [ -f "$AUDIO_DIR/musica.mp3" ]; then
    echo -e "${GREEN}✅ musica.mp3 encontrado${NC}"
else
    echo -e "${YELLOW}⚠️  musica.mp3 no encontrado${NC}"
    echo "   La aplicación funcionará, pero sin música de fondo"
fi

# Verificar modelo OBJ
echo -e "${YELLOW}Verificando modelo 3D...${NC}"
if [ -f "src/main/resources/assets/posada.obj" ]; then
    echo -e "${GREEN}✅ posada.obj encontrado${NC}"
else
    echo -e "${YELLOW}⚠️  posada.obj no encontrado${NC}"
    echo "   Se creará una escena de prueba automáticamente"
fi

echo ""
echo -e "${BLUE}═══════════════════════════════════════════${NC}"
echo ""

# Opciones de ejecución
echo "Selecciona una opción:"
echo "1) Ejecutar aplicación (mvn javafx:run)"
echo "2) Compilar proyecto (mvn clean compile)"
echo "3) Empaquetar JAR (mvn clean package)"
echo "4) Limpiar proyecto (mvn clean)"
echo "5) Salir"
echo ""
read -p "Opción [1-5]: " option

case $option in
    1)
        echo -e "${GREEN}🚀 Ejecutando aplicación...${NC}"
        echo ""
        mvn javafx:run
        ;;
    2)
        echo -e "${GREEN}🔨 Compilando proyecto...${NC}"
        echo ""
        mvn clean compile
        ;;
    3)
        echo -e "${GREEN}📦 Empaquetando JAR...${NC}"
        echo ""
        mvn clean package
        if [ $? -eq 0 ]; then
            echo ""
            echo -e "${GREEN}✅ JAR creado exitosamente${NC}"
            echo "Ubicación: target/StringBuilder-1.0-SNAPSHOT.jar"
        fi
        ;;
    4)
        echo -e "${GREEN}🧹 Limpiando proyecto...${NC}"
        echo ""
        mvn clean
        ;;
    5)
        echo -e "${BLUE}👋 ¡Hasta luego!${NC}"
        exit 0
        ;;
    *)
        echo -e "${RED}❌ Opción inválida${NC}"
        exit 1
        ;;
esac

echo ""
echo -e "${BLUE}═══════════════════════════════════════════${NC}"
echo -e "${GREEN}✅ Proceso completado${NC}"
echo -e "${BLUE}═══════════════════════════════════════════${NC}"
