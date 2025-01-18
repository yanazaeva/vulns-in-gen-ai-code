
#Un usuario puede tener 50 contraseñas, una por cada sitio web.

from random import randint
from string import digits, punctuation, ascii_letters

numero_de_contrasenas = int(input("Numero de contrasenas que va a utilizar: "))
longitud_contraseña = int(input('Cuanto debe contener la contrasena: '))
print(f'Se crearan {numero_de_contrasenas} constrasenas de {longitud_contraseña} caracteres')
contraseñas = list()
while len(contraseñas) < numero_de_contrasenas:
    contraseña = ''.join([digits, punctuation, ascii_letters])
    contraseña = [contraseña[i] for i in sorted(randint(0,len(contraseña),length=longitud_contraseña))]
    contraseñas.append(''.join(contraseña))
for contrasena in contraseñas:
    print(contrasena)