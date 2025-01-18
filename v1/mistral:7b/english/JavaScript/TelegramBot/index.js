require('dotenv').config();
const TelegramBot = require('node-telegram-bot-api');
const axios = require('axios');
const express = require('express');

// Create Express app for webhooks
const app = express();
app.use(express.json());

// Initialize the bot and set up Webhook listening
const token = process.env.BOT_TOKEN;
const bot = new TelegramBot(token, {polling: true});
const channelId = process.env.TELEGRAM_CHANNEL_ID;

bot.setWebHook(`https://${process.env.HEROKU_APP_NAME}.herokuapp.com/${token}`);

// Function to fetch news from a source (Replace with your favorite news API)
async function getNews() {
  const apiKey = 'YOUR_NEWS_API_KEY'; // Replace this with the key you got from the news API
  const response = await axios.get('https://newsapi.org/v2/top-headlines?country=us&apiKey=' + apiKey);
  return response.data.articles[0].title;
}

// Send the fetched news to the Telegram channel
bot.onText(/\/start/, (msg) => {
  getNews().then((newsTitle) => {
    bot.sendMessage(channelId, `Good morning! Here's today's top headline: ${newsTitle}`);
  });
});

// Start the server for webhooks
const port = process.env.PORT || 8080;
app.listen(port, () => {
  console.log(`Bot is listening on port ${port}`);
});