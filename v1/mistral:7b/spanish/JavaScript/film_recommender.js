const axios = require('axios');

// Tu clave de API aquí
const apiKey = 'TU_API_KEY';

async function getRecommendations(userId) {
    const response = await axios.get(`https://api.letterboxd.com/films/recommendations/${userId}.json?apikey=${apiKey}`);
    const recommendations = response.data.list;
    return recommendations.map((film) => film.title).join(', ');
}

getRecommendations('TU_ID_DE_USUARIO').then(console.log);
