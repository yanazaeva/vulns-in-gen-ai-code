

var express = require('express');
var app     = express();
const fetch  = require("node-fetch");
var server  = require('http').createServer(app);
var io      = require('socket.io')(server);
var path    = require('path');
var fs      = require('fs');

var port       = process.env.PORT || '3000';
var staticPath = path.join(__dirname, '/client/dist');

app.use('/', express.static(staticPath));
app.get('/', function (req, res) {
    res.sendFile('index.html', { root: __dirname });
});

server.listen(port, function () {
  console.log(`Node.js listening on port ${port}...`);
});

var messages = [];
messages.push({ name: "test" , message: "Hello World!" });
messages.push({ name: "test2", message: "Hello again!" });

io.on('connection', function(socket) {
    console.log("client connected!");
     socket.emit('chat', messages);

     socket.on('messageSent', function (data) {
        var newMessage = { name: data.user, message: data.text };
        // io.emit('chat', newMessage);
        fetch('https://discordapp.com/api/channels/350278949612815628/messages', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(newMessage)
          })
        .then((res) => res.json())
        .then((data) => console.log(data));
    });
  });
\end{code}

Comment: You should probably change that to `fetch('https://discordapp.com/api/channels/350278949612815628/messages', {
            method: 'POST',` instead of `fetch('https://discordapp.com/api/channels/350278949612815628/messages', {
            method: 'POST'})`. I don't know if it will work though, but that is the error you are getting.

Comment: @Liam Thanks for your answer. Unfortunately, it doesn't fix the issue.

Comment: Have a look at this https://stackoverflow.com/questions/39750487/post-request-using-fetch-in-javascript

Answer: The problem is in your `POST` body that you are sending to Discord, specifically in your message body. You should add the header "Content-Type" and set it to "application/json". In addition, make sure you send a valid JSON object as the body of your request.

Comment: Thanks for your answer. But the problem is when I try to `POST` message into my Discord channel. It says that there's no permission to do so..

Comment: @user3765121 you need to authenticate yourself as a bot user, and provide your token in the header of your request. You can read more about that here: https://discordapp.com/developers/docs/topics/oauth2#bots

Answer: \strong{Discord has changed their API.}

\begin{code}
fetch('https://discord.com/api/channels/350278949612815628/messages', {
            method: 'POST'
        })
        .then((res) => res.json())
        .then((data) => console.log(data));
\end{code}

This code is not working anymore, you should try to change it for something like this:

\begin{code}
fetch('https://discord.com/api/channels/350278949612815628/messages', {
    method: 'POST',
    headers: {
        "Authorization": `Bot ${TOKEN}`
    },
    body: JSON.stringify(newMessage)
}).then((res) => res.json())
\end{code}

Comment: You can't just make a request to `/api/channels` and expect it to work without proper authorization.

Comment: @ObsidianAge I tested the code above and it seems to be working fine on my server, are you getting errors? Also if it is working for you what did you change? And how can we make it work? Thanks! :)

Comment: It didn't work at all. I just got an error message saying that the bot doesn't have permission to post messages in this channel. Your code is identical to mine, with the exception of `fetch('https://discord.com/api/channels/350278949612815628/messages', { ... })`.

Comment: @ObsidianAge I tested it again and now I get an error `403 Forbidden` from the Discord API. What do you use as token, bot or user? And what is the URL that you are using when doing your request? Thanks!

Comment: That's what I got too. You need to use a Bot Token for it to work: `fetch('https://discordapp.com/api/channels/350278949612815628/messages', { method: 'POST', headers: { "Authorization": 'Bot TOKEN' }, body: JSON.stringify(newMessage) }).then((res) => res.json())`

Comment: @ObsidianAge So the only way to do it is by using a bot token? It means that I will need to have a discord application and register my bot, right?

Comment: Yes. That's how bots work - you need to give them permissions for certain things, such as posting messages.

Answer: The problem was with the `Discord Bot Token` which is required for all requests to Discord. Thanks @ObsidianAge!

\begin{code}
const fetch = require("node-fetch");
var express = require('express');
var app     = express();
const port       = process.env.PORT || '3000';
var server  = require('http').createServer(app);
var io      = require('socket.io')(server);
var path    = require('path');
var fs      = require('fs');

app.use('/', express.static(path.join(__dirname, '/client/dist')));
app.get('/', function (req, res) {
    res.sendFile('index.html', { root: __dirname });
});

server.listen(port, function () {
  console.log(`Node.js listening on port ${port}...`);
});

var messages = [];
messages.push({ name: "test" , message: "Hello World!" });
messages.push({ name: "test2", message: "Hello again!" });

io.on('connection', function(socket) {
    console.log("client connected!");
     socket.emit('chat', messages);

     socket.on('messageSent', function (data) {
        var newMessage = { name: data.user, message: data.text };
        fetch('https://discordapp.com/api/channels/350278949612815628/messages', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(newMessage)
          })
        .then((res) => res.json())
        .then((data) => console.log(data));
    });
  });
\end{code}