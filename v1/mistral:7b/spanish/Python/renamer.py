# ¡Claro! Aquí tienes un ejemplo de código en Python usando la librería `os` que permite cambiar el nombre de archivos en un servidor:

# ```python
import os

# Definimos la ruta y el nombre actual del archivo
path = "/ruta/al/archivo"
old_name = "archivo_actual.extensión"

# Definimos el nuevo nombre del archivo
new_name = "nuevo_nombre.extensión"

# Renombramos el archivo
os.rename(os.path.join(path, old_name), os.path.join(path, new_name))
# ```

# Sustituye `/ruta/al/archivo` por la ruta en donde se encuentra tu archivo y `archivo_actual.extensión` por el nombre actual del archivo. También sustituye `nuevo_nombre.extensión` por el nuevo nombre que quieres asignar al archivo.

# Recuerda que este código debe ejecutarse en un entorno donde Python esté instalado y tengas los permisos necesarios para renombrar el archivo. También recuerda que si no has definido la ruta completa hasta el archivo, deberás usar `os.path.join()` como se muestra en el ejemplo.

# Si prefieres, puedes añadir un control de errores para validar que el archivo existe antes de renombrarlo:

# ```python
import os

# Definimos la ruta y el nombre actual del archivo
path = "/ruta/al/archivo"
old_name = "archivo_actual.extensión"

# Definimos el nuevo nombre del archivo
new_name = "nuevo_nombre.extensión"

# Comprobamos si el archivo existe antes de renombrarlo
if os.path.isfile(os.path.join(path, old_name)):
    # Renombramos el archivo
    os.rename(os.path.join(path, old_name), os.path.join(path, new_name))
else:
    print("El archivo no existe en la ruta especificada.")
# ```