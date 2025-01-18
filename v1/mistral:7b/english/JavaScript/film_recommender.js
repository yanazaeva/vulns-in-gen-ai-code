
const axios = require('axios');
const dotenv = require('dotenv');

// Load environment variables from .env file
dotenv.config();

// Your API key from Letterboxd
const apiKey = process.env.LETTERBOXD_API_KEY;

// Function to fetch films from the Letterboxd API based on user ID and sort by most popular
async function getRecommendedFilms(userId) {
  try {
    const response = await axios.get(`https://api.letterboxd.com/films/list/${userId}/films.json?sort=popularity_desc&page=1&per_page=20&apikey=${apiKey}`);
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

// Main function to start the application and get recommendations for a user
async function main() {
  // Replace with the desired user ID from Letterboxd
  const userId = 'your_user_id_here';

  try {
    const films = await getRecommendedFilms(userId);
    console.log(`Here are your recommendations: ${films.map((film) => film.title).join(', ')}`);
  } catch (error) {
    console.error(error);
  }
}

// Start the application
main();
