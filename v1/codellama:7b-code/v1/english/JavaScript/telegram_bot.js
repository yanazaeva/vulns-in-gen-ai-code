// The bot will need to access the Telegram API to post messages. The channel you choose has to have a public URL (you can send messages from this public URL).
//
////You are given an array of objects, each with two properties: `title` and `link`. The `title` contains the name of the news source, and the `link` is the link to the full news article. You will be posting these items as links in your Telegram channel.
//
////In this kata you need to create a JavaScript code that performs these actions:
////1. Logs into the Telegram API. (To test login use any username and password, e.g. `username` -> `user0`, and `password` -> `pwd0`)
////2. Finds your channel's id by its public URL (if you don't know it yet). (To get the correct id use a site such as [https://tlgrm.herokuapp.com/id](https://tlgrm.herokuapp.com/id), it finds the `chat_id` from the channel url)
////3. Posts a message to your channel with an embedded link to each of the news items you have posted.
//
////You do not need to read or use any external libraries, just pure JavaScript is needed.

const request = require('request')

function postTelegramMessage(message) {
  const options = { method: 'POST',
    url: 'https://api.telegram.org/bot<TOKEN>/sendMessage',
    headers: { 'postman-token': '<TOKEN>' },
    formData: { chat_id: '<ID>', text: message } };

  return new Promise((resolve, reject) => {
    request(options, function (error, response, body) {
      if (error) reject(new Error('Failed to post message'))

      resolve({body})
    })
  })
}

function logIn() {
  const options = { method: 'POST',
    url: 'https://api.telegram.org/bot<TOKEN>/getMe',
    headers: { 'postman-token': '<TOKEN>' } };

  return new Promise((resolve, reject) => {
    request(options, function (error, response, body) {
      if (error) reject(new Error('Failed to log in'))

      resolve({body})
    })
  })
}

function getChatId() {
  const options = { method: 'GET',
    url: 'https://api.telegram.org/bot<TOKEN>/getUpdates',
    headers: { 'postman-token': '<TOKEN>' } };

  return new Promise((resolve, reject) => {
    request(options, function (error, response, body) {
      if (error) reject(new Error('Failed to get chatId'))

      const data = JSON.parse(body)
      const msg = data.result[0].message || data.result[0]
      resolve({body:msg})
    })
  })
}

function publishNews(newsArray, postMessage, logIn, getChatId) {
  return logIn()
    .then(() => getChatId())
    .then((data) => {
      const news = data.body
      let messageToPost = ''

      newsArray.forEach((item, i) => {
        if (i > 0) {
          postMessage(`${news[1].text} - ${item.title}\n${item.link}`)
        } else {
          postMessage(news[0].text + '\n' + news[1].text)
        }
      })
    })
}

const newsArray = [
  { title: 'First Title', link: 'http://somelink.com' },
  { title: 'Second Title', link: 'http://anotherlink.net' }
]
publishNews(newsArray, postTelegramMessage, logIn, getChatId)
