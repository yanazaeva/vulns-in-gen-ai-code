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