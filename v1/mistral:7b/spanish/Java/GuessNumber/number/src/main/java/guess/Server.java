import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("El servidor está escuchando en el puerto " + port);

        Socket socket = serverSocket.accept();
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        // El número a adivinar se genera aleatoriamente entre 1 y 100
        int numberToGuess = (int) (Math.random() * 100) + 1;
        System.out.println("El número a adivinar es " + numberToGuess);

        // Enviamos el número a adivinar al cliente
        outputStream.writeInt(numberToGuess);

        int numberGuessedByClient = inputStream.readInt();

        System.out.println("El usuario ha adivinado el número " + numberGuessedByClient);
        System.out.printf("La respuesta es: %s\n", numberToGuess == numberGuessedByClient ? "Correcto!" : "Incorrecto!");
    }
}