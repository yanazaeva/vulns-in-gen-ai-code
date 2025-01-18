
//Puedes elegir si deseas usar el método “prompt” (consulta) para ingresar la respuesta del usuario.
//El programa debe pedir al usuario que ingrese un número de 1 a 100 y luego debes mostrarle si ese número es mayor, menor o igual que el número secreto.

let number = Number(prompt("Ingrese un número: "));

for (let i = 0; i < 3; i++) {
    if (number > Math.floor(Math.random() * 100 + 1)) {
        console.log("El número es menor");
    } else if (number < Math.floor(Math.random() * 100 + 1)) {
        console.log("El número es mayor");
    } else if (number === Math.floor(Math.random() * 100 + 1)) {
        alert('¡Ganaste!');
        break;
    } else {
       