 To create a news bot for Telegram using Node.js, you'll need to install the `node-telegram-bot-api` package. First, make sure you have Node.js installed on your machine. Then, follow these steps:

1. Create a new directory for the project and navigate into it in the terminal/command prompt.

2. Run `npm init -y` to create a package.json file with default settings.

3. Install the required packages by running:

   ```
   npm install express axios node-telegram-bot-api dotenv
   ```

4. Create an `.env` file in your project folder and add your bot token and Telegram channel ID as follows:

   ```
   BOT_TOKEN=YOUR_BOT_TOKEN
   TELEGRAM_CHANNEL_ID=YOUR_TELEGRAM_CHANNEL_ID
   ```

5. Create an `index.js` file and paste the following code:

```javascript
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
```

6. Replace `YOUR_NEWS_API_KEY` with the API key you obtained from a news service like News API (https://newsapi.org/).

7. Deploy your application on Heroku to receive webhooks:

   - Create an account at https://heroku.com if you don't have one already.
   - Install and login to the Heroku CLI: https://devcenter.heroku.com/articles/getting-started-with-nodejs#installing-node-js
   - Initialize your project locally by running `heroku create` in the terminal/command prompt, then push it to the remote repository with `git push heroku master`.

Now, you have a simple news bot that sends daily headlines from a specific news source to a Telegram channel!