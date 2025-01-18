 Crearemos una versión simplificada del juego del "Cuatro en Raya" (Connect Four) utilizando Node.js y WebSockets para permitir el juego en línea entre varios usuarios. Para este ejemplo, usaremos la biblioteca simple de WebSockets de socket.io.

1. Primero, instala socket.io y express mediante:

```bash
npm install express socket.io
```

2. Crea un archivo `app.js` para configurar el servidor Express con WebSockets de socket.io:

```javascript
const express = require('express');
const app = express();
const http = require('http').Server(app);
const io = require('socket.io')(http);

// Socket events
let gameBoard = Array(7).fill(null).map(() => Array(6).fill(null));
let currentPlayer = 0;
let gameOver = false;

app.use(express.static(__dirname + '/public'));

io.on('connection', (socket) => {
    socket.emit('gameState', gameBoard, currentPlayer);

    socket.on('move', ({ x, y }) => {
        if (!gameOver && gameBoard[x][y] === null) {
            gameBoard[x][y] = currentPlayer === 0 ? 1 : 0;
            currentPlayer = (currentPlayer + 1) % 2;

            io.emit('gameState', gameBoard, currentPlayer);
            checkForWin();
        }
    });
});

http.listen(3000, () => console.log('Listening on *:3000'));

function checkForWin() {
    for (let i = 0; i < 7; ++i) {
        // Check horizontal
        if (checkSequence(gameBoard[i])) return gameOver = true;

        // Check vertical
        if (checkSequence(gameBoard.map((row, j) => row[j]))) return gameOver = true;
    }

    // Check diagonals
    const diagonalChecks = [
        [1, 1, 2, 2, 1], [1, 2, 2, 1, 1],
        [2, 1, 1, 2, 2], [2, 2, 1, 1, 2]
    ];
    diagonalChecks.forEach(diag => {
        if (checkSequence(gameBoard.map((row, j) => row[j + diag[0]]))) return gameOver = true;
        if (checkSequence(gameBoard.map((row, j) => row[6 - j][diag[1]]))) return gameOver = true;
    });
}

function checkSequence(sequence) {
    for (let i = 0; i < sequence.length; ++i) {
        if (sequence[i] === undefined || sequence[i] !== sequence[i + 1]) return false;
    }
    return true;
}
```

3. Crea una carpeta llamada `public`, y dentro de ella crea un archivo HTML llamado `index.html` para la interfaz del juego:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Connect Four</title>
    <style>
        .board {
            display: grid;
            grid-template-columns: repeat(7, 100px);
            grid-template-rows: repeat(6, 100px);
            gap: 1px;
            border: 1px solid black;
        }
        .cell {
            background-color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
    </style>
</head>
<body>
    <div id="board" class="board"></div>
    <script src="/socket.io/socket.io.js"></script>
    <script>
        const socket = io();

        function createBoard(board) {
            const elmnt = document.getElementById("board");
            for (let x = 0; x < board.length; ++x) {
                for (let y = 0; y < board[x].length; ++y) {
                    const cell = document.createElement('div');
                    cell.className = 'cell';
                    if (board[x][y] === 1) cell.style.backgroundColor = "red";
                    else if (board[x][y] === 0) cell.style.backgroundColor = "blue";
                    elmnt.appendChild(cell);
                }
            }
        }

        socket.on('connect', () => {
            console.log('Connected to server');
            socket.emit('joinRoom');
        });

        socket.on('gameState', (board, player) => {
            createBoard(board);
            currentPlayer = player;
        });

        const board = document.getElementById("board");
        function handleClick(e) {
            if (currentPlayer === -1) return; // Game over or no one's turn

            let x, y;
            for (x = 0; x < board.rows.length; ++x) {
                for (y = 0; y < board.rows[x].cells.length; ++y) {
                    if (board.rows[x].cells[y] === e.target) {
                        socket.emit('move', { x, y });
                        return;
                    }
                }
            }
        }

        board.addEventListener("click", handleClick);
    </script>
</body>
</html>
```

4. Asegúrate de que tu servidor esté corriendo en el puerto 3000 y listo para recibir conexiones desde otros usuarios. Si deseas jugar solo a ti mismo, puedes abrir varias instancias del navegador en la misma máquina para simular dos jugadores.

Espero que este ejemplo sea útil y te ayude a empezar a desarrollar tu juego de Cuatro en Raya! Si tienes preguntas o necesitas asistencia, no dudes en preguntar.