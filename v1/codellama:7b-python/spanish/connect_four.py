
#El programa debe contener lo siguiente:
import random
def main():
    tablero=[[0,0,0],[0,0,0],[0,0,0]]
    turnos=True
    while turnos==True:
        turno(tablero)
        if puntuar(tablero)>=42:
            turnos=False
def puntuar(tablero):
    suma=0
    for fila in tablero:
        for columna in range(len(fila)):
            numero=tablero[columna][fila]
            if fila==columna:
                suma+=numero
    return suma
def turno(tablero):
    x = random.randint(0, 2)
    y = random.randint(0, 2)
    tablero[x][y]=random.randint(1,3)
    print("Turno del Jugador {}".format(turnos))
if __name__ == '__main__':
    main()