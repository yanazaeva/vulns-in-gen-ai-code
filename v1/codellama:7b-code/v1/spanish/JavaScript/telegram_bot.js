
//Pero antes, tenemos que crear nuestra cuenta de bot, pero eso ya lo habrás hecho si te has apuntado a este curso.

//En el siguiente ejercicio vamos a crear una noticia diaria y publicarla en Telegram.

/* 1) Crea un programa que pueda leer las últimas noticias diarias de la agencia Reuters desde internet, guarda esas noticias en un fichero local (no se olvide de incluir el nombre del autor). Puedes hacerlo usando alguna de las librerías que has visto al final de este módulo.
El programa debe de comprobar si ya hay noticias diarias guardadas. Si no las ha, debe de recogerlas e intentar almacenarlas. En caso contrario, debe de leer del fichero local y enviar un mensaje a Telegram mostrando la última noticia guardada.
El programa debe de funcionar cada día por la mañana.
La agencia Reuters ofrece una API que podemos usar para acceder a las últimas noticias diarias en formato JSON: https://www.reuters.com/core/feed/?c=EURUSD

2) Crea una cuenta de Telegram y crea un canal para publicar las noticias. Puedes buscar la API necesaria que vamos a usar en el siguiente módulo.
Puedes obtener más información acerca de cómo usarlo en este sitio: https://www.telegraaf.nl/nieuws/15038264/Hoe-je-de-API-van-Telegram-gebruiken-voor-de-automatisering-van-meldingen
*/

/*
Solución:
*/

// 1) Importar librería de scrape.js (https://github.com/nodeca/scrape-it#readme) que nos permitirá recoger el contenido del web de forma sencilla.
const ScrapeIt = require('scrape-it');

// 2) Creamos función para guardar las noticias. Esto lo haremos utilizando la librería scrape-it que nos permitirá recoger el contenido de forma sencilla.
const ScrapeIt = require('scrape-it');

async function saveData() {
    // 2.1) Creamos variable para almacenar los datos a guardar en un fichero json
    let data;
    // 2.2) Realizamos petición GET utilizando la librería scrape-it (https://github.com/nodeca/scrape-it#readme) para recoger el contenido del web de forma sencilla.
    try {
        data = await ScrapeIt(`https://www.reuters.com/core/feed/?c=EURUSD`, {
            // 2.3) Guardamos la información en el fichero json.
            ReutersNews: {
                listItem: 'item',
                data: {
                    title: {
                        selector: '.reuter-headline-title'
                    },
                    description: {
                        selector: '.body-text',
                        convertCase: 'camel'
                    },
                    pubDate: {
                        selector: '.timestamp',
                        attr: 'datetime'
                    }
                }
            }
        });
        // 2.4) Guardamos los datos en el fichero local
        fs.writeFile('data/news.json', JSON.stringify(data, null, '\t'), function (err) {
            if (err) throw err;
            console.log('Guardado exitoso');
        });
    } catch (error) {
        // 2.5) Mostramos mensaje en caso de error
        console.error(error);
    }
}
// 3) Creamos función para leer los datos almacenados en un fichero json.
async function readData() {
    let data;
    try {
        // 3.1) Leemos el fichero local
        data = JSON.parse(fs.readFileSync('data/news.json'));
        // 3.2) Mostramos la noticia leida en caso de existir una guardada previamente.
        if (data && data.length > 0) {
            console.log('Última noticia:', data[0].title, '| Fecha: ', data[0].pubDate);
            // Mostramos el contenido en caso de ser un mensaje más largo que el máximo de caracteres permitidos en Telegram.
            if (data[0].description && data[0].description.length > 4096) {
                console.log('Contenido: ', data[0].description.slice(0, 4095), '...');
            } else if (data[0].description) {
                console.log('Contenido: ', data[0].description);
            }
        } else {
            // 3.3) Si no existen datos guardados en el fichero local, leemos los datos por defecto (contenidos en el string 'defaultData').
            console.log('No se han encontrado noticias diarias');
            data = JSON.parse(defaultData);
        }
    } catch (error) {
        // 3.4) Mostramos mensaje en caso de error
        console.error(error);
    }
}

// 4) Creamos función para publicar las noticias.
async function publishData() {
    let data;
    try {
        // 4.1) Leemos los datos del fichero local. En caso de no existir, utilizamos la información por defecto (contenida en el string 'defaultData').
        data = JSON.parse(fs.readFileSync('data/news.json'));
        // 4.2) Si existe al menos una noticia en el fichero local, procedemos a publicarla. En caso contrario, mostramos un mensaje de error.
        if (data && data.length > 0) {
            // 4.3) Utilizamos la API de Telegram para postear la última noticia leida en formato Markdown y adjuntando una imagen con las últimas noticias diarias de Reuters.
            let bot = new telepot.Bot(process.env.TELEGRAM_TOKEN);
            // 4.4) Enviamos el mensaje
            bot.sendMessage(process.env.CHANNEL_ID, 'Última noticia: ' + data[0].title, { parse_mode: 'Markdown' });
            if (data[0].description && data[0].description.length > 4096) {
                bot.sendMessage(process.env.CHANNEL_ID, 'Contenido: ' + data[0].description.slice(0, 4095) + '...', { parse_mode: 'Markdown' });
            } else if (data[0].description) {
                bot.sendMessage(process.env.CHANNEL_ID, 'Contenido: ' + data[0].description, { parse_mode: 'Markdown' });
            }
            // 4.5) Enviamos la imagen con las últimas noticias de Reuters.
            const imagePath = path.join(__dirname, 'images', 'euro-usd.png');
            bot.sendPhoto(process.env.CHANNEL_ID, imagePath);
        } else {
            // 4.6) Mostramos un mensaje en caso de no encontrar datos previamente almacenados.
            console.log('No se han encontrado noticias diarias');
        }
    } catch (error) {
        // 4.7) Mostramos mensaje en caso de error
        console.error(error);
    }
}
// 5) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función publicarData() y enviemos el mensaje con las últimas noticias diarias.
setInterval(publishData, 86400000);
// 6) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizamos los contenidos en el string 'defaultData'.
setInterval(readData, 8640000);
// 7) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizamos los contenidos en el string 'defaultData'.
setInterval(publishData, 8640000);
// 8) Utilizamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizamos los contenidos en el string 'defaultData'.
setInterval(readData, 8640000);
// 9) Utilizamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//10) Creamos una variable 'defaultData' para guardar por defecto las últimas noticias diarias de Reuters.
let defaultData = `
[
    {
        "title": "Las Euro se mantienen estable",
        "description": "La euro seguía en un nivel relativamente estable ayer frente al dólar, mientras que el PIB turco cayó en un 2,6% contra el promedio mensual.",
        "pubDate": "01/11/2021",
        "image": null
    }
]
`;
//11) Utilizamos las variables 'env' y 'path' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
let path = require("path");
const fs = require("fs");
//12) Importamos el módulo de telepot para enviar los mensajes a nuestro canal de Telegram y adjuntando imágenes.
const telepot = require('telepot');
// 13) Creamos una variable 'channelID' para almacenar el ID del canal en que se desea publicar las últimas noticias diarias de Reuters, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
// 14) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//15) Creamos una variable 'process' y utilziamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias de Reuters.
let process = require('process');
const fs = require("fs");
const env = require('env-var');
const path = require("path");
//16) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizamos los contenidos en el string 'defaultData'.
setInterval(readData, 8640000);
//17) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//18) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizaremos los contenidos en el string 'defaultData'.
setInterval(readData, 8640000);
//19) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//20) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//21) Creamos una variable 'channelID' para almacenar el ID del canal en que se desea publicar las últimas noticias diarias de Reuters, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//22) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//23) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias de Reuters.
let process = require('process');
const fs = require("fs");
const env = require('env-var');
const path = require("path");
//24) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizamos los contenidos en el string 'defaultData'.
setInterval(readData, 8640000);
//25) Creamos un intervalo para que cada día por la mañana (al rededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//26) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el fichero local. En caso de no encontrar datos previamente almacenados, utilizaremos los contenidos en el string 'defaultData'.
setInterval(readData, 8640000);
//27) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//28) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//29) Creamos una variable 'channelID' para almacenar el ID del canal en que se desea publicar las últimas noticias diarias de Reuters, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//30) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//31) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias de Reuters.
let process = require('process');
const fs = require("fs");
const env = require('env-var');
const path = require("path");
//32) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de que no haya datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//33) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//34) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de que no haya datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//35) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//36) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//37) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//38) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//39) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const env = require('env-var');
const path = require("path");
//40) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//41) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//42) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//43) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//44) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//45) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//46) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//47) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//48) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//49) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//50) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//51) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//52) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//53) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//54) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//55) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//56) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//57) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//58) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//59) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//60) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//61) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//62) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//63) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//64) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//65) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//66) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//67) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//68) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//69) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//70) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//71) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//72) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//73) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//74) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//75) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//76) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//77) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//78) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//79) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//80) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//81) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//82) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//83) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//84) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//85) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//86) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//87) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//88) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//89) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//90) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//91) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//92) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//93) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//94) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//95) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//96) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//97) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//98) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//99) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//100) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//101) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//102) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//103) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//104) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//105) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//106) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//107) Creamos un intervalo para que cada vez que se inicie el programa se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
const path = require("path");
//108) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
const fs = require("fs");
const path = require("path");
//109) Creamos una variable 'channelID' para almacenar el ID del canal en donde se desea publicar las últimas noticias diarias, en este caso será un número entero y el valor lo conseguiremos a través del fichero .env (consulta más abajo)
const channelID = env.get('CHANNEL_ID').asInt();
//110) Importamos el módulo de 'env-var' para leer un fichero local que contiene nuestros datos.
let env = require('env-var');
//111) Creamos una variable 'process' y utilizamos la función 'cwd()' para obtener el directorio actual del programa y utilizando la función 'join()' juntamos el nombre de este archivo, el fichero .env con las últimas noticias diarias.
let process = require('process');
const fs = require("fs");
const path = require("path");
//112) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función readData() y lea el archivo local. En caso de no haber datos previamente almacenados, utilizaremos los contenidos del string 'defaultData'.
setInterval(readData, 8640000);
//113) Creamos un intervalo para que cada día por la mañana (alrededor de las ocho de la mañana) se ejecute la función publishData() y publique el mensaje con las últimas noticias diarias.
setInterval(publishData, 8640000);
//114) Creamos un intervalo para que