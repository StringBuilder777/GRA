from mcp.server.fastmcp import FastMCP
import subprocess
import os
import shutil

# --- CONFIGURACIÓN ---
# Ajusta esta ruta si tu Blender está en otro lado
BLENDER_EXEC = "/Applications/Blender.app/Contents/MacOS/Blender"

# Rutas relativas (asumiendo que el script corre desde la carpeta 'automation')
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
BLENDER_SRC_DIR = os.path.join(BASE_DIR, "blender_src")
JAVAFX_ASSETS_DIR = os.path.join(BASE_DIR, "src", "main", "resources", "assets")

# Crear el servidor MCP
mcp = FastMCP("BlenderAutomation")

@mcp.tool()
def convertir_blend_a_obj(nombre_archivo: str) -> str:
    """
    Convierte un archivo .blend (ubicado en blender_src) a .obj
    y lo coloca en la carpeta de recursos de JavaFX.

    Args:
        nombre_archivo: El nombre del archivo sin ruta (ej: "posada.blend")
    """

    input_path = os.path.join(BLENDER_SRC_DIR, nombre_archivo)
    nombre_base = os.path.splitext(nombre_archivo)[0]
    output_obj = os.path.join(JAVAFX_ASSETS_DIR, f"{nombre_base}.obj")

    # Verificar que existe el archivo fuente
    if not os.path.exists(input_path):
        return f"Error: No encuentro el archivo {input_path}"

    # Verificar que existe el directorio destino
    os.makedirs(JAVAFX_ASSETS_DIR, exist_ok=True)

    # Creamos un script temporal de Python para Blender
    # Esto le dice a Blender qué hacer internamente
    script_exportacion = f"""
import bpy
import sys

# Limpiar selección y seleccionar todo
bpy.ops.object.select_all(action='DESELECT')
bpy.ops.object.select_all(action='SELECT')

# Exportar a OBJ
bpy.ops.export_scene.obj(
    filepath='{output_obj}',
    use_selection=True,
    use_triangles=True,  # JavaFX prefiere triángulos
    use_materials=True,
    path_mode='COPY'     # Copia las texturas si es necesario
)
"""

    script_path = os.path.join(BASE_DIR, "automation", "temp_export.py")

    try:
        # 1. Escribir el script temporal
        with open(script_path, "w") as f:
            f.write(script_exportacion)

        # 2. Ejecutar Blender en modo background (-b)
        # Sintaxis: blender -b archivo.blend -P script.py
        cmd = [
            BLENDER_EXEC,
            "-b", input_path,
            "-P", script_path
        ]

        print(f"Ejecutando Blender para: {nombre_archivo}...")
        result = subprocess.run(cmd, capture_output=True, text=True)

        if result.returncode != 0:
            return f"Error en Blender:\n{result.stderr}"

        return f"¡Éxito! Modelo exportado a: {output_obj}"

    except Exception as e:
        return f"Error crítico: {str(e)}"
    finally:
        # Limpieza: borrar el script temporal
        if os.path.exists(script_path):
            os.remove(script_path)

if __name__ == "__main__":
    mcp.run()