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