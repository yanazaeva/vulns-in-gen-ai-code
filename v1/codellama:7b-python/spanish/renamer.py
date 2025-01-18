
#El usuario debe introducir dos líneas: el nombre del fichero a buscar y el nuevo nombre de dicho fichero, respectivamente.
#El programa debe buscar el archivo especificado en el directorio actual y renombrarlo si existe. El proceso se repite hasta que el usuario escriba un nombre del archivo "0".
#Después del último cambio se deben mostrar los nombres del fichero original y del nuevo, respectivamente, uno por línea.
#Para hacerlo, utilice la función os.rename() que devuelve el estado de ejecución (ver en la consola).
#El usuario debe poder detener el programa escribiendo el nombre "0" para salir del bucle indefinido.
import os  #funciones especificas de los sistemas operativos

print("Dame un nombre de fichero.")

nombre_fichero = input()  #Le pedimos al usuario que introduzca el nombre del fichero en la terminal, y lo guardamos en una variable.
while (nombre_fichero != "0"): #Mientras el usuario no escriba '0' seguirá ejecutandose el bucle, es decir, seguirán siendo renombrados los archivos. 
    if (os.path.exists(nombre_fichero)): #Si el fichero existe...
        print("Dame otro nombre para renombrar al",nombre_fichero) #Mostramos el mensaje por pantalla indicando que se va a renombrar un archivo.
        nuevo_nombre = input()  #Le pedimos al usuario que introduzca el nuevo nombre del fichero en la terminal, y lo guardamos en una variable.
        # os.rename(nombre_fichero, nuevo_nombre) #Mandamos a llamar a la función "os.rename()" para renombrar los archivos. 
    else: #Si el fichero no existe...
        print("No se encuentra este fichero.")   #Mostramos el mensaje por pantalla indicando que ese fichero no existe.
        
    nombre_fichero = input() #Volvemos a pedirle al usuario que introduzca el nombre del fichero en la terminal, y lo guardamos en una variable. 
