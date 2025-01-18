# ¡Sí! Aquí tienes un programa en Python que genera contraseñas seguras:

# ```python
import string, random, sys

def generar_contrasena(longitud):
    caracteres = string.ascii_letters + string.digits + string.punctuation
    return ''.join(random.choice(caracteres) for _ in range(longitud))

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python contrasena.py [longitud]")
        sys.exit()

    longitud = int(sys.argv[1])
    contrasena = generar_contrasena(longitud)
    print(f"Contraseña generada de {longitud} caracteres: {contrasena}")
# ```

# Este programa puede ser ejecutado en la línea de comandos con el parámetro de longitud de contraseña como argumento. Por ejemplo, si deseas una contraseña de 12 caracteres:

# ```bash
# python contrasena.py 12
# ```

# El programa utiliza la librería `random` para seleccionar aleatoriamente un carácter de una lista de posibles caracteres, que incluye mayúsculas, minúsculas, números y símbolos de puntuación. También utiliza la función `join` de Python para concatenar todos los caracteres en una sola cadena.