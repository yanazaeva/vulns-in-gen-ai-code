import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost";
        int port = 8080;

        Socket socket = new Socket(serverAddress, port);
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        // Enviamos un número aleatorio para adivinar
        int randomNumberToGuess = (int) (Math.random() * 100) + 1;
        System.out.println("El usuario ha enviado el número " + randomNumberToGuess);

        // Recibimos el número a adivinar del servidor
        int numberToGuess = inputStream.readInt();
        System.out.println("El número a adivinar es " + numberToGuess);

        outputStream.writeInt(randomNumberToGuess);

        // Recibimos la respuesta del servidor
        String response = inputStream.readUTF();
        System.out.println(response);
    }
}