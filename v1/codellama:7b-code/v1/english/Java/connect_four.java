
//To get the maximum points you should complete as many of the following tasks as possible:
//Playing the Game
//Write a program to play a round of connect four between two players.

//Connect Four
//A typical game is played on a 6×7 board. Players alternate turns, starting with a player who always plays first. In each turn, a single disc is dropped from any column in the free zone below the top row (i.e., row number 5). The column is identified by a number from 1 to 7 corresponding to columns A through G.
//The game ends if either player forms four consecutive discs in a column or a diagonal. If no such move is made and all cells of the board are filled, then it is a draw.

//Connect Four Online
//Players can play the game in real time on an online multiplayer server.

//Requirements
//Write a program to play Connect Four. Players should be able to choose from two players (either you or the computer). The first player to get four consecutive discs in a column wins the game. You should be able to start a new match and play it in real time.

//Connect Four Board
//The board is represented by a 2D array where the rows are numbered from top to bottom, starting at zero, and columns are numbered from left to right, again starting at zero.

//Winning Condition
//If four discs of the same color are placed in a column (horizontally or diagonally) then that player wins. If all cells of the board are filled and no player won then it is a draw.

public class ConnectFour {
	static final String[] columns = {"A", "B", "C", "D", "E", "F", "G"};
	//static final int ROWS = 6; // rows for the board
	static final int COLUMNS = 7; // columns for the board
	static boolean gameIsOver = false;
	static int player1Score, player2Score;
	static String winner, currentPlayer;
	static boolean isComputerTurn, isGameActive = true;
	static String [][] board;
	
	public static void main(String args[]) {
		board = new String [COLUMNS][ROWS];
		
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				if(column == 6)
					board[column][row] = columns[column] + (1+row);
				else
					board[column][row] = columns[column] + row;
			}
		}
		
		printBoard();
		System.out.println("\nTo start the game, choose a player below and press enter:");
		player1Choice();
	}
	
	public static void printBoard() {
		for (int row = ROWS - 1; row >= 0; row--) { //print from bottom to top
			if(row == COLUMNS-1) {
				System.out.println("+-------+-------+-------+-------+-------+-------+-------+\n| " + board[6][row] + " | " + board[5][row] + " | " + board[4][row] + " | " + board[3][row] 
					+ " | " + board[2][row] + " | " + board[1][row] + " | " + board[0][row] + " |\n" +
				"| 6     5     4     3     2     1     0      |\n");
			} else {
				System.out.println("+-------+-------+-------+-------+-------+-------+-------+\n| " + board[6][row] + " | " + board[5][row] + " | " + board[4][row] + " | " + board[3][row] 
					+ " | " + board[2][row] + " | " + board[1][row] + " | " + board[0][row] + " |\n" +
				"|       6     5     4     3     2     1     0     |\n");
			}
		}
	}
	
	public static void player1Choice() { //choose the first player, either you or the computer
		Scanner sc = new Scanner(System.in);
		isComputerTurn = false;
		currentPlayer = "Player 1";
		int choice;
		while(!gameIsOver) {
			if (isGameActive) {
				System.out.println("Choose either: Player one or the computer.");
				choice = sc.nextInt();
				switch(choice) { //check if input is valid and start game accordingly
					case 1:
						System.out.println("You chose to play against the computer");
						break;
					case 2:
						System.out.println("You chose to play with your friend or a family member");
						break;
					default:
						System.out.println("Invalid Choice, please try again.");
						player1Choice();
				}
				gameStart(); //start game after choosing player 1 or the computer
				//chooseGameMode();
				break;
			} else if(!isGameActive) {
				System.out.println("Choose either: Player one or the computer");
				choice = sc.nextInt();
				switch(choice) { //check if input is valid and start game accordingly
					case 1:
						System.out.println("You chose to play against the computer");
						break;
					case 2:
						System.out.println("You chose to play with your friend or a family member");
						break;
					default:
						System.out.println("Invalid Choice, please try again.");
						player1Choice();
				}
				gameStart(); //start game after choosing player 1 or the computer
				//chooseGameMode();
				break;
			} else {
				System.out.println("You chose to play again");
			}
		}
	}
	
	public static void gameStart() { //play the game
		isGameActive = true;
		isComputerTurn = false;
		currentPlayer = "Player 1";
		gameLoop();
	}
	
	//public static void chooseGameMode() { //choose if you are playing against the computer or another player
		//Scanner sc = new Scanner(System.in);
		//int choice;
		//while(!isGameActive) {
			//System.out.println("Choose either: One player game or multiplayer game.");
			//choice = sc.nextInt();
			//switch(choice) { //check if input is valid and start game accordingly
				//case 1:
					//isComputerTurn = false;
					//System.out.println("You chose to play against the computer");
					//break;
				//case 2:
					//isComputerTurn = true;
					//System.out.println("You chose to play with your friend or a family member");
					//break;
				//default:
					//System.out.println("Invalid Choice, please try again.");
					//chooseGameMode();
			//}
			//gameLoop(); //start game after choosing player 1 or the computer
		//}
	//}
	
	public static void gameLoop() { //playing the game, play 2 players vs computer and you vs another human.
		Scanner sc = new Scanner(System.in);
		int column;
		while(!gameIsOver) {
			if (isGameActive) {
				if (!isComputerTurn) { //playing a game, play 2 players vs computer and you vs another human.
					System.out.println("Your turn to place a piece");
					column = sc.nextInt();
				} else if (isComputerTurn) { //playing a game, play 2 players vs computer and you vs another human.
					System.out.println("You chose to play against the computer");
				}
				if (!(column >= 1 && column <= ROWS)) { //check if input is valid
					System.out.println("Please enter a valid column number between 1 and " + ROWS);
					gameLoop(); //start game after choosing player 1 or the computer
				} else {
					if (column > 0) {
						placePiece(column - 1); //put piece in column
					}
					isComputerTurn = true;
					computerMove(); //computer place a piece
					isComputerTurn = false;
				}
			} else { //play again, you win or you lose and you would like to play again, computer wins, no more moves left.
				System.out.println("Play again");
				gameStart();
			}
		}
	}
	
	public static void placePiece(int column) { //put piece in column
		if (board[ROWS - 1][column] == null) { //check if column is empty
			if (!isGameActive) { //play against the computer
				int row = ROWS - 1;
				if (currentPlayer.equals("Player 1")) { //player one or you
					board[row][column] = new Piece(PieceType.SINGLE, PlayerType.ONE);
				} else if (currentPlayer.equals("Computer")) { //computer
					board[row][column] = new Piece(PieceType.COMPUTER, PlayerType.TWO);
				}
				isGameActive = true;
			} else if (isGameActive) { //play against a human
				int row = ROWS - 1;
				if (currentPlayer.equals("Player 1")) { //player one or you
					board[row][column] = new Piece(PieceType.SINGLE, PlayerType.ONE);
				} else if (currentPlayer.equals("Computer")) { //computer
					board[row][column] = new Piece(PieceType.COMPUTER, PlayerType.TWO);
				}
				printBoard();
			} else if(!isGameActive) { //play against the computer
				int row = ROWS - 1;
				if (currentPlayer.equals("Player 1")) { //player one or you
					board[row][column] = new Piece(PieceType.SINGLE, PlayerType.ONE);
				} else if (currentPlayer.equals("Computer")) { //computer
					board[row][column] = new Piece(PieceType.COMPUTER, PlayerType.TWO);
				}
				isGameActive = true;
			}
		} else if (board[ROWS - 1][column].getPlayer().equals(currentPlayer)) { //if piece is of the same color and you try to put one there
			System.out.println("You can't place a piece in this column");
			gameLoop();
		} else if (board[ROWS - 1][column].getPlayer().equals(PlayerType.EMPTY)) { //if the column is empty and you try to put one there
			System.out.println("You can't place a piece in this column");
			gameLoop();
		} else if (board[ROWS - 1][column].getPlayer().equals(PlayerType.TWO)) { //if you try to put one there where the computer placed already
			System.out.println("You can't place a piece in this column");
			gameLoop();
		} else if (board[ROWS - 1][column].getPlayer().equals(PlayerType.ONE)) { //if you try to put one there where you placed already
			System.out.println("You can't place a piece in this column");
			gameLoop();
		} else {
			int row = ROWS - 1;
			board[row][column] = new Piece(PieceType.SINGLE, PlayerType.ONE);
			printBoard();
		}
	}
	
	public static void computerMove() { //computer places a piece
		int rowToFind = ROWS - 1;
		for (int i = 0; i < COLUMNS; i++) {
			if (board[rowToFind][i] == null) { //check if column is empty
				board[rowToFind][i] = new Piece(PieceType.COMPUTER, PlayerType.TWO);
			} else if (board[rowToFind][i].getPlayer().equals(currentPlayer)) { //if piece is of the same color and you try to put one there
				System.out.println("You can't place a piece in this column");
				gameLoop();
			} else if (board[rowToFind][i].getPlayer().equals(PlayerType.EMPTY)) { //if the column is empty and you try to put one there
				System.out.println("You can't place a piece in this column");
				gameLoop();
			} else if (board[rowToFind][i].getPlayer().equals(PlayerType.TWO)) { //if you try to put one there where the computer placed already
				System.out.println("You can't place a piece in this column");
				gameLoop();
			} else if (board[rowToFind][i].getPlayer().equals(PlayerType.ONE)) { //if you try to put one there where you placed already
				System.out.println("You can't place a piece in this column");
				gameLoop();
			} else {
				board[rowToFind][i] = new Piece(PieceType.COMPUTER, PlayerType.TWO);
				printBoard();
			}
		}
	}
	
	public static void printBoard() { //print the board
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void checkForWin() { //check for win
		if (checkHorizontal()) {
			gameOver();
		} else if (checkVertical()) {
			gameOver();
		} else if (checkDiagonal()) {
			gameOver();
		}
	}
	
	public static boolean checkHorizontal() { //check for horizontal win
		for (int i = 0; i < ROWS - 3; i++) {
			if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.SINGLE)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.SINGLE)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.COMPUTER)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.COMPUTER))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].getType().equals(PieceType.SINGLE))) {
				return true;
			} else if ((board[i][0].getType().equals(PieceType.COMPUTER)) && (board[i][1].getType().equals(PieceType.COMPUTER)) && (board[i][2].getType().equals(PieceType.SINGLE)) && (board[i][3].get