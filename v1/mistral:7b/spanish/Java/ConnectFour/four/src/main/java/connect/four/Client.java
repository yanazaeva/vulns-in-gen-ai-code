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