

//La interfaz debería permitirle a los jugadores indicar el nombre del oponente y luego empezar la partida. La partida tendrá una configuración inicial, en la que podremos modificar el número de columnas (50) o de filas (5).

//La primera vez que un jugador hace clic, se le asignará la posición 1 y el resto del tablero será rellenado automáticamente. El turno se alterna entre los dos jugadores. Los jugadores pueden intercambiar su turno si quieren, pero es lo suficientemente difícil como para que no sea necesario.

//El objetivo del juego es colocar cuatro casillas consecutivas en fila, horizontal, vertical o diagonalmente. Los jugadores deben tener la opción de cambiar las figuras que juegan. Por ejemplo, si un jugador quiere usar un rombo ajedrezado, podría hacerlo.

//El juego se almacena en el localStorage para evitar que se pierda la partida si cierra sesión.

//El juego tiene un tablero de 20 casillas por 15 casillas y el número de filas por defecto es 3.

//Puntos totales del juego: 100 pts.

//Requisitos iniciales (no hay nada malo en tenerlos a la mano, aunque no son necesarios para la calificación final):

//Usar HTML5 localStorage y hacer que el juego se guarde con cada movimiento.

//Usar algún framework de JavaScript o librería.

//Usar algún sistema de control de versiones (Git, GitHub).


"use strict";
/*
const board = {
	width: 20,
	height: 15,
	cells: [],
};
*/
class Board {
	constructor(w, h) {
		this.w = w;
		this.h = h;
		this.cells = [];
	}
	toString() {
		let out = "";
		for (let y = 0; y < this.h; ++y) {
			out += "|";
			for (let x = 0; x < this.w; ++x) {
				out += this.cells[y * this.w + x] + "|";
			}
			out += "\n";
		}
		return out;
	}
	save() {
		let str = "";
		for (let y = 0; y < this.h; ++y) {
			str += "|";
			for (let x = 0; x < this.w; ++x) {
				str += this.cells[y * this.w + x] + "|";
			}
			str += "\n";
		}
		localStorage.setItem(this.toString(), str);
	}
	load() {
		for (let y = 0; y < this.h; ++y) {
			for (let x = 0; x < this.w; ++x) {
				let cell = localStorage.getItem(this.toString());
				if (!cell || cell == "|") {
					continue;
				}
				this.cells[y * this.w + x] = cell;
			}
		}
	}
	setCell(x, y, c) {
		if (0 <= x && x < this.w && 0 <= y && y < this.h) {
			this.cells[y * this.w + x] = c;
		}
	}
	isFull() {
		for (let i = 0; i < this.cells.length; ++i) {
			if (!this.cells[i]) return false;
		}
		return true;
	}
	getWinner(x, y) {
		const cell = this.cells[y * this.w + x];
		for (let yy = y - 1; yy <= y + 1; ++yy) {
			if (!this.isValid(x, yy)) {
				break;
			}
			if (this.cells[yy * this.w + x] != cell) {
				continue;
			}
			for (let xx = x - 1; xx <= x + 1; ++xx) {
				if (!this.isValid(xx, yy)) {
					break;
				}
				if (this.cells[yy * this.w + xx] != cell) {
					continue;
				}
				return cell == "X" ? 1 : -1;
			}
		}
		return 0;
	}
	isValid(x, y) {
		if (0 <= x && x < this.w && 0 <= y && y < this.h) {
			return true;
		}
		return false;
	}
}
/*
function getCellChar(y, x) {
	return "|" + board.cells[y * board.w + x] + "|";
}
*/
class Cell {
	constructor(x, y, c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
	toString() {
		return this.getChar();
	}
	getChar() {
		const cell = board.cells[this.y * board.w + this.x];
		if (cell == "X" || cell == "O") {
			return cell;
		}
		return "-";
	}
}
/*
function getBoardWidth() {
	return 50;
}
*/
class GameState {
	constructor(board) {
		this.board = board;
	}
	toString() {
		let out = "";
		for (let y = 0; y < this.board.h; ++y) {
			out += "|";
			for (let x = 0; x < this.board.w; ++x) {
				out += this.getChar(new Cell(x, y));
			}
			out += "\n";
		}
		return out;
	}
	getChar(cell) {
		const cellChar = board.cells[cell.y * board.w + cell.x];
		if (cellChar == "X" || cellChar == "O") {
			return cellChar;
		}
		return "-";
	}
	isFull() {
		for (let y = 0; y < this.board.h; ++y) {
			for (let x = 0; x < this.board.w; ++x) {
				if (!this.getChar(new Cell(x, y))) return false;
			}
		}
		return true;
	}
	getWinner(cell) {
		const cellChar = this.getChar(cell);
		for (let yy = cell.y - 1; yy <= cell.y + 1; ++yy) {
			if (!this.isValid(cell, new Cell(cell.x, yy))) {
				break;
			}
			if (this.getChar(new Cell(cell.x, yy)) != cellChar) {
				continue;
			}
			for (let xx = cell.x - 1; xx <= cell.x + 1; ++xx) {
				if (!this.isValid(cell, new Cell(xx, yy))) {
					break;
				}
				if (this.getChar(new Cell(xx, yy)) != cellChar) {
				continue;
			}
			return cellChar == "X" ? 1 : -1;
			break;
		}
	}
	return 0;
}
isValid(cell, otherCell) {
	if (otherCell.y < 0 || otherCell.x < 0 || board.w <= otherCell.x || board.h <= otherCell.y) {
		return false;
	}
	return true;
}
}
const games = new Map();
window.onload = () => {
	for (let i = 1; ; ++i) {
		if (!games.has(i)) {
			games.set(i, new GameState(new Board(i)));
			break;
		}
	}
};
class CellClicker extends EventTarget {
	constructor(x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		if (gameState == null) {
			throw new Error("No board with id " + this.boardId + " exists.");
		}
		this.x = x;
		this.y = y;
		this.c = gameState.getChar(new Cell(x, y));
	}
	addEventListener(type, listener) {
		super.addEventListener(type, listener);
		if (type == "change") {
			const gameState = games.get(this.boardId);
			gameState.cells[this.y * gameState.w + this.x] = this.c;
		}
	}
	click() {
		if (this.c != "-") {
			return;
		}
		const event = new CustomEvent("change");
		this.dispatchEvent(event);
	}
}
/*
function getCellClickerChar(y, x) {
	return "|" + board.cells[y * board.w + x] + "|";
}
*/
class GameStateView extends EventTarget {
	constructor() {
		super();
		this.boardId = 0;
	}
	addEventListener(type, listener) {
		super.addEventListener(type, listener);
		if (type == "change") {
			const gameState = games.get(this.boardId);
			if (gameState != null) {
				for (let y = 0; y < gameState.h; ++y) {
					for (let x = 0; x < gameState.w; ++x) {
						const char = getCellChar(y, x);
					}
				}
			}
		}
	}
	click() {
		if (this.c != "-") {
			return;
		}
		const event = new CustomEvent("change");
		this.dispatchEvent(event);
	}
}
function getCellChar(y, x) {
	return "|" + board.cells[y * board.w + x] + "|";
}
/*
function GameStateView() {
	const gameState = games.get(this.boardId);
	if (gameState != null) {
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
}
*/
/*
class GameStateView {
	constructor() {
		this.boardId = 0;
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
//class GameStateView extends EventTarget {
//	constructor() {
//		super();
//		this.boardId = 0;
//	}
//	addEventListener(type, listener) {
//		if (type == "change") {
//			const gameState = games.get(this.boardId);
//			for (let y = 0; y < gameState.h; ++y) {
//				for (let x = 0; x < gameState.w; ++x) {
//					const char = getCellChar(y, x);
//				}
//			}
//		}
//	}
//}
class GameState extends EventTarget {
	constructor() {
		super();
		this.w = 0;
		this.h = 0;
		this.cells = null;
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
/*
function GameState() {
	this.boardId = 0;
}
GameState.prototype.addEventListener = function (type, listener) {
	if (type == "change") {
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
};
*/
/*
class GameStateView extends EventTarget {
	constructor() {
		super();
		this.boardId = 0;
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
class GameStateView extends EventTarget {
	constructor() {
		super();
		this.boardId = 0;
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
/*
class GameStateView extends EventTarget {
	constructor() {
		super();
		this.boardId = 0;
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
//Eres un obrero, y el capitalismo está en guerra contra ti. ¡Acción! ¡Defiende la clase trabajadora! ¡Sin salario mínimo, sin desempleo, con trabajo para todos los hombres y mujeres!
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const gameState = games.get(this.boardId);
			for (let y = 0; y < gameState.h; ++y) {
				for (let x = 0; x < gameState.w; ++x) {
					const char = getCellChar(y, x);
				}
			}
		}
	}
}
*/
/*
class CellClicker extends EventTarget {
	constructor(boardId, x, y) {
		super();
		this.boardId = 0;
		const gameState = games.get(this.boardId);
		for (let y = 0; y < gameState.h; ++y) {
			for (let x = 0; x < gameState.w; ++x) {
				const char = getCellChar(y, x);
			}
		}
	}
	addEventListener(type, listener) {
		if (type == "change") {
			const