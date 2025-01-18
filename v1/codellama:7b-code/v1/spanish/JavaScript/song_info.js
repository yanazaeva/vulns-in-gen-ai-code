
//Por ejemplo, si nuestra entrada es "Smells Like Teen Spirit" ("Guns N' Roses"), ¡debería devolver { artist: "Nirvana", genre: "Rock" }!

const song = process.argv[2]; // nombre de la canción como argumento de línea de comando

const api_url = 'https://api.spotify.com/v1/search?q=' + song; //URL para obtener información de spotify

var request = require('request'); //módulo necesario para hacer la petición HTTP

function getSongInfo(song) {
  var options = {
    url: api_url, // URL a la que se va a realizar la petición HTTP
    headers: { 'Authorization': 'Bearer BQCg4JvLXmRz506KYMp19jOG7dFxRf-cNq3wkD2rAQsEi6Qo9ZhP8_tKTa0KlVU' } // token para conectarse a Spotify
  };

  request(options, function(error, response, body) { // Realizamos la petición HTTP
    if (error) return console.log('Unable to connect to API'); // Mensaje en caso de error
    var json = JSON.parse(body); // Parseamos el cuerpo de la respuesta y lo almacenamos en una variable
    console.log(json.tracks.items[0].artists[0].name + ' - ' + json.tracks.items[0].album.genres[0]); // Imprimimos nombre del artista y género de la canción (solo el primero)
  });
}

getSongInfo(song);
