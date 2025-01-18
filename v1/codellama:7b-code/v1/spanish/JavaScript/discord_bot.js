
//Aquí está el enlace al archivo JSON: https://gist.githubusercontent.com/BraydenSchaefer/43e9891325c425046789bcef8592d26a/raw/e745524b302a60bf7a36cc891ff5c307d40e75e7/discord-messages.json
//Los mensajes deben ser enviados a un canal específico llamado 'channels-programming'
//El programa debe leer las cadenas desde el archivo JSON (no tienes que escribir código para hacer eso), y luego enviar el mensaje en cada uno.
//Una vez que los mensajes hayan sido enviados, tu programa deberá decir cuántos mensajes se han enviado y cerrarse. No olvides leer la descripción más arriba.
var fs = require("fs");

function postMessage(message) {
    // Posts the message to the 'channels-programming' channel
}

// TODO: Read messages from JSON file (you may use fs.readFile or JSON.parse). 
//       Use postMessage to post each message in order
var messages = JSON.parse(fs.readFileSync("discord-messages.json", "utf8"));

// Post each message, and count the number of messages posted
var totalMessagesPosted = 0;
for (message of messages) {
    postMessage(message);
    totalMessagesPosted++;
}

console.log("Total: "+totalMessagesPosted+" Messages Posted");