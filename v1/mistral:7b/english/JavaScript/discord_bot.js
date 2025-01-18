

const Discord = require('discord.js');
const client = new Discord.Client();

// Replace with your bot's token
const TOKEN = 'your-bot-token';

client.on('ready', () => {
  console.log(`Logged in as ${client.user.tag}!`);
});

client.on('message', msg => {
  // Put your logic for posting messages here
});

client.login(TOKEN);


client.on('message', msg => {
  if (msg.content === '!hello') {
    msg.channel.send('Hello, World!');
  }
});

