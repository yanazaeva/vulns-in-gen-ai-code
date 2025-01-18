¡Hola! Para crear un juego de cuatro en raya compartido entre usuarios, es necesario utilizar una combinación de Java y sockets para la comunicación entre cliente y servidor. Aquí hay un ejemplo sencillo de cómo podría funcionar este sistema.

1. Crea dos paquetes: uno para el servidor (`fourInARowServer`) y otro para el cliente (`fourInARowClient`).

2. En el paquete del Servidor, crea una clase llamada `Game`. Esta clase será responsable de almacenar la matriz del juego, contener información sobre el jugador actual y realizar las reglas básicas del juego.

```java
import java.util.Scanner;

public class Game {
    private int[] board; // Tablero del juego
    private int currentPlayer; // 0 representa a "X" y 1 representa a "O".

    public Game() {
        this.board = new int[7]; // Tablero del tamaño requerido (6 columnas y 7 filas)
        for (int i = 0; i < board.length; ++i) {
            board[i] = -1; // Inicializamos el tablero con valores no válidos (-1 significa que la casilla está vacía).
        }
        this.currentPlayer = 0; // "X" empieza como jugador actual por convención.
    }

    public void play(int column) {
        // Comprueba si se puede colocar una ficha en la casilla indicada y, si es así, lo hace.
        if (canPlacePiece(column)) {
            placePiece(column);
            switchPlayer();
        }
    }

    private boolean canPlacePiece(int column) {
        // Comprueba si es posible colocar una ficha en la casilla indicada.
        if (column < 0 || column >= board.length) {
            return false;
        }
        if (board[getColumnIndex(column)] == -1) {
            return true;
        }
        return false;
    }

    private void placePiece(int column) {
        // Coloca una ficha en la casilla indicada.
        int index = getColumnIndex(column);
        for (int i = board.length - 1; i >= index && board[i] != -1; --i) {
            board[i + 1] = board[i];
        }
        board[index] = currentPlayer; // Colocamos la ficha en la casilla actual.
    }

    private int getColumnIndex(int column) {
        return column + (board.length - 6); // Calculamos el índice real de una columna.
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer + 1) % 2;
    }
}
```

3. En el paquete del Servidor, también crea una clase llamada `Server`. Esta clase será responsable de manejar las conexiones de los clientes y coordinar la ejecución del juego entre ellos.

```java
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private static final int PORT = 12345;
    private Game game;
    private ArrayList<PrintWriter> writers; // Lista de escritores asociados a cada cliente conectado.

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
    }

    public void start() throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("El servidor está corriendo en el puerto " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Nuevo cliente conectado");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(dos, true);
            writers.add(writer);

            handleClient(dis, writer, socket);
        }
    }

    public void handleClient(DataInputStream dis, PrintWriter writer, Socket socket) throws Exception {
        // Inicializa el juego y envía al cliente la información necesaria para comenzar.
        if (game == null) {
            game = new Game();
        }

        writer.println("Bienvenido al juego de cuatro en raya");
        for (int i = 0; i < game.board.length; ++i) {
            writer.println(game.board[i]);
        }

        // Maneja la comunicación con el cliente mientras permanezca conectado.
        while (true) {
            String line = dis.readLine();
            if (line == null || line.equalsIgnoreCase("bye")) {
                break;
            }

            int column = Integer.parseInt(line);
            game.play(column);

            // Envía la información actualizada del tablero al cliente.
            for (PrintWriter w : writers) {
                w.println("Tablero:");
                for (int i = 0; i < game.board.length; ++i) {
                    w.println(game.board[i]);
                }
            }
        }

        // Cierra la conexión y borra el escritor del cliente cuando se desconecta.
        writers.remove(writer);
        socket.close();
    }
}
```

4. En el paquete del Cliente, crea una clase llamada `Client`. Esta clase será responsable de establecer la conexión con el servidor y manejar su comunicación.

```java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_HOST = "localhost"; // Debes cambiar esta variable para jugar con otros usuarios remotos.
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();
    }

    public void start() throws Exception {
        Socket socket = new Socket(SERVER_HOST, PORT);
        System.out.println("Conectado al servidor");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(dis));
        PrintWriter writer = new PrintWriter(dos, true);

        // Recibe y muestra la información inicial del juego.
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (line.equalsIgnoreCase("Bienvenido al juego de cuatro en raya")) {
                break;
            }
        }

        // Recibe y muestra el tablero actual del juego.
        for (int i = 0; i < game.board.length; ++i) {
            String line = reader.readLine();
            System.out.println(line);
        }

        // Maneja la comunicación con el servidor mientras permanezca conectado.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int column = scanner.nextInt();
            writer.println(column);

            String line = reader.readLine();
            if (line.equalsIgnoreCase("Tablero:")) {
                for (int i = 0; i < game.board.length; ++i) {
                    line = reader.readLine();
                    System.out.println(line);
                }
            }
        }
    }
}
```

5. Asegúrate de tener las clases correctamente importadas en cada archivo y que se puedan compilar y ejecutar.