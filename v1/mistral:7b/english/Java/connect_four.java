 To create a Connect Four game in Java and make it accessible online, I'll break down the problem into two parts: offline (Java console application) and online (web-based).

First, let me provide you with a simple console version of Connect Four written using Java. Later, I'll guide you on how to adapt this code for an online platform like WebSocket server + HTML/JS client.

**Offline Console Version:**

Here's the basic structure of a simple Connect Four game in Java:

```java
import java.util.*;

public class ConnectFour {
    final int SIZE = 7;
    int[] board;

    public ConnectFour() {
        this.board = new int[SIZE * SIZE];
        this.resetBoard();
    }

    // Rest of the code to implement the game logic...
}
```

Now, let's implement some of the essential methods:

1. `public void resetBoard()` - Resets the board to its initial state with all spaces empty.
2. `public boolean isFull()` - Checks if the board is full or not (game over).
3. `public int getWinner()` - Determines the winner of the game, return -1 if it's a draw.
4. `public void dropPiece(int column)` - Drops a piece into the specified column.
5. `private boolean isValidMove(int column)` - Checks if the specified column has an available space to make a move.
6. `public void printBoard()` - Prints the current state of the board in a readable format.
7. Add other methods as needed, like human player's turn or computer player's AI for making moves.

The online version will require additional work to create a server that handles multiple clients (players), manage turns, and handle communication between the server and each client.

**Online Version:**

You can use WebSocket technology to build an interactive online game where users can play against each other in real-time:

1. Choose a suitable WebSocket library for your project (e.g., `javax.websocket` or more modern libraries like `websocket++`).
2. Create a server that accepts multiple client connections and handles game management, including game state synchronization between connected clients.
3. Develop an HTML/JS frontend for the game interface and handle user input (clicks on columns) to send messages to the server with the desired moves.
4. Implement a system on the server side to process these messages, make moves accordingly, and update all connected clients with the latest game state.
5. Continue refining the UI and adding additional features like chat functionality or leaderboards.

This online version will require more effort and knowledge in web development (HTML/CSS/JS), but it'll provide a more engaging user experience for players to enjoy Connect Four together over the internet.