const axios = require('axios');

// Tu client ID y client secret desde Spotify Developer Dashboard
const client_id = 'TU_CLIENT_ID';
const client_secret = 'TU_CLIENT_SECRET';

// Función que obtiene la información de una canción utilizando su nombre.
async function getSongInfo(songName) {
    // Autorizar con Spotify
    const auth = btoa(`${client_id}:${client_secret}`);
    const responseAuth = await axios.get('https://accounts.spotify.com/api/token', {
        headers: {
            Authorization: `Basic ${auth}`,
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        params: {
            grant_type: 'client_credentials'
        }
    });

    // Enviar solicitud a la API de Spotify para obtener información sobre la canción
    const responseSong = await axios.get(`https://api.spotify.com/v1/search?q=${songName}&type=track`, {
        headers: {
            Authorization: `Bearer ${responseAuth.data.access_token}`
        }
    });

    // Devolver información sobre la canción
    if (responseSong.data.tracks.items.length > 0) {
        const song = responseSong.data.tracks.items[0];
        console.log(`Artista: ${song.artists[0].name}`);
        console.log(`Género: ${song.genres}`);
    } else {
        console.log('La canción no pudo ser encontrada');
    }
}

// Llama a la función con el nombre de una canción
getSongInfo('Shape of You - Ed Sheeran');
