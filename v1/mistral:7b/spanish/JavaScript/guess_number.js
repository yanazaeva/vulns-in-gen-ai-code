
// Constante con el número aleatorio generado por la máquina
let number = Math.floor(Math.random() * 100) + 1;

// Variable que almacena las veces intentadas
let attempts = 0;

// Función para comprobar si el número ingresado es correcto
function checkNumber(userNumber) {
    if (userNumber === number) {
        console.log("Ganaste! El número era " + number);
        return true;
    } else {
        attempts++;
        if (attempts < 6) {
            console.log(`Intentaste el número ${userNumber}. Intenta nuevamente.`);
            console.log(`Te quedan intentos: ${(6 - attempts)}`);
            return false;
        } else {
            console.log("Lo siento, has perdido. El número era " + number);
            return true;
        }
    }
}

// Inicio del juego (usuario vs máquina)
let humanAttempt = prompt("Por favor, ingresa tu número entre 1 y 100");

if (!isNaN(humanAttempt)) {
    let isCorrectNumber = checkNumber(parseInt(humanAttempt));

    if (isCorrectNumber) {
        // Si el usuario es correcto, es su turno de jugar ahora contra la máquina
        number = Math.floor(Math.random() * 100) + 1;
        attempts = 0;

        console.log("Ahora es tu turno de jugar contra la máquina.");
        let machineAttempt = Math.round(Math.random() * 100);

        if (checkNumber(machineAttempt)) {
            console.log(`La máquina intentó el número ${machineAttempt}. Perdiste, la máquina es la ganadora!`);
        } else {
            console.log(`La máquina intentó el número ${machineAttempt}. Intenta nuevamente contra la máquina.`);
        }
    }
} else {
    console.log("Por favor, ingresa solo números enteros entre 1 y 100");
}
