
const SIZE = 6;
const BOARD_WIDTH = SIZE + 2;
let board = []; // Initialize the board later in your code

const COLUMNS = ['A', 'B', 'C', 'D', 'E', 'F', 'G'];


function dropPiece(column, player) {
    // Check that column number is valid
    if (column < 0 || column >= COLUMNS.length) return false;

    for (let row = SIZE - 1; row >= 0; row--) {
        if (!board[row][column]) {
            board[row][column] = player;
            return true;
        }
    }

    return false; // Column is full, can't place a piece
}

function checkWin(player) {
    for (let column = 0; column < COLUMNS.length; column++) {
        // Check horizontal win condition
        for (let row = 0; row < SIZE; row++) {
            if (!board[row][column] || board[row][column] !== player) break;
            if (row + 3 >= SIZE) return true;
        }

        // Check vertical win condition
        for (let i = 0; i < SIZE; i++) {
            let sum = 0;
            for (let j = column - i; j <= column + i; j += 2) {
                if (j >= 0 && j < COLUMNS.length && board[SIZE - 1 - i][j] === player) {
                    sum++;
                }
                if (sum === i + 1) return true; // We have a winner!
            }
        }
    }

    // Check diagonal win conditions
    for (let column = 0; column < COLUMNS.length - 6; column++) {
        for (let row = 0; row < SIZE; row++) {
            if (board[row][column] !== player) continue;

            let sum = 1;
            for (let i = 1; i <= 5 && row + i < SIZE && column + i < COLUMNS.length; i++) {
                if (board[row + i][column + i] === player) sum++;
                else break;
            }
            if (sum === 6) return true; // We have a winner!
        }
    }

    for (let column = 0; column < COLUMNS.length - 6; column++) {
        for (let row = 0; row < SIZE; row++) {
            if (board[row][column] !== player) continue;

            let sum = 1;
            for (let i = 1; i <= 5 && row + i < SIZE && column - i >= 0; i++) {
                if (board[row + i][column - i] === player) sum++;
                else break;
            }
            if (sum === 6) return true; // We have a winner!
        }
    }

    return false;
}

function main() {
    // Initialize the game board with empty values
    for (let row = 0; row < SIZE; row++) {
        board[row] = new Array(COLUMNS.length).fill(null);
    }

    let currentPlayer = 'X'; // 'X' is the first player, 'O' will be the second one
    while (!checkWin(currentPlayer)) {
        console.log(`It's Player ${currentPlayer}'s turn.`);
        let columnInput;
        do {
            columnInput = prompt(`Enter a valid column number (A-G): `);
        } while (!COLUMNS.includes(columnInput) || !dropPiece(COLUMNS.indexOf(columnInput), currentPlayer));

        console.log(renderBoard());

        currentPlayer = currentPlayer === 'X' ? 'O' : 'X'; // Switch players after each turn
    }

    console.log(`Game Over! Player ${currentPlayer} wins!`);
}

function renderBoard() {
    let boardStr = '';
    for (let row = 0; row < SIZE + 2; row++) {
        if (row === 0) {
            boardStr += '   ';
            for (let column = 0; column < COLUMNS.length; column++) {
                boardStr += `${COLUMNS[column]}   `;
            }
            boardStr += '\n';
        } else if (row === SIZE + 1) {
            boardStr += '----' + COLUMNS.map((c) => '-----').join('-') + '\n';
        } else {
            boardStr += '|';
            for (let column = 0; column < COLUMNS.length; column++) {
                boardStr += `${board[row - 1][column] || ''} |`;
            }
            boardStr += '\n';
        }
    }

    return boardStr;
}

main();
