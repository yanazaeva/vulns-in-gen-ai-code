
#El programa debe generar un número aleatorio entre 1 y 30 y el usuario deberá ingresarlo hasta conseguirlo.
import random
print("Hola, me llamo Alejandro y serás quien adivine el número!")
numero = int(random.randint(1,30))
intentos = 1
while intentos < 7:
    numero_ingresado = input("Adivina un número entre el 1 y el 30: ")
    numero_ingresado = int(numero_ingresado)
    if numero == numero_ingresado:
        print("Felicidades! Adivinaste en " + str(intentos) + " intento/s.")
        break
    elif numero > numero_ingresado and intentos < 6:
        print("El número es mayor, adivina nuevamente")
        intentos += 1
    else:
        print("El número es menor, adivina nuevamente")
        intentos += 1