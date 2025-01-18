
const TelegramBot = require('node-telegram-bot-api');
const axios = require('axios');

// Reemplaza tu token aquí
const token = 'tu_token_de_bot';

// Obtener las noticias
async function getNews() {
  try {
    const response = await axios.get('https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=API_KEY');
    return response.data.articles;
  } catch (error) {
    console.error(error);
  }
}

// Configurar el bot de Telegram
const bot = new TelegramBot(token, {polling: true});

bot.onText(/!noticias/, async (msg) => {
  const news = await getNews();
  if (!news || !news.length) {
    return msg.reply('No se encontraron noticias.');
  }

  // Mostrar las primeras 3 noticias
  let message = 'Noticias del día:\n';
  for (let i = 0; i < 3; i++) {
    message += `${i + 1}. ${news[i].title}\n`;
  }
  msg.reply(message);
});

// Inicio del bot
console.log('El bot de noticias está listo.');
