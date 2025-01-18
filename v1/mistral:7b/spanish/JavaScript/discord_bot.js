
const Discord = require('discord.js');
const client = new Discord.Client();

// Reemplaza estos tokens por tus propios tokens de bot y servidor
const botToken = 'TU_TOKEN_DE_BOT';
const guildId = 'TU_ID_DE_SERVER';

client.once('ready', () => {
  console.log(`Estoy listo!`);
});

client.on('message', message => {
  // Verifica que el mensaje provenga de un canal específico y no sea nuestro propio bot
  if (message.channel.id === guildId && message.author.id !== client.user.id) {
    // Enviar respuesta con el texto "¡Hola, soy tu asistente de conversación! ¿Cómo puedo ayudarte hoy?"
    message.channel.send(`¡Hola, soy tu asistente de conversación! ¿Cómo puedo ayudarte hoy?`);
  }
});

client.login(botToken);
