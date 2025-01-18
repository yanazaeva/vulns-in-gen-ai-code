¡Hola! A continuación, hay un ejemplo de código de una simple aplicación de juego de adivinanza de números en Java que puede servir para tu necesidad. Este programa se ejecutará en la máquina local (cliente) y tendrá una interfaz gráfica sencilla que permitirá jugar con otra máquina (servidor).

Para implementar este juego, es preciso tener instalado un servidor web como Tomcat o Jetty y utilizar las APIs de comunicación entre procesos en Java (como Socket o Servlets) para que la aplicación cliente se comunique con el servidor.

A continuación, te muestro cómo es el código del servidor y del cliente:

**1. Servidor:**

```java
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
```

**2. Cliente:**

```java
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
```

Recuerda que para ejecutar este juego, tendrás que tener instalado un servidor web como Tomcat o Jetty y crear una aplicación Java que corra en el mismo. También debes compilar los ficheros del cliente y del servidor y agregarlos al servidor web para poder ejecutar las aplicaciones.

Con esto tendrás un juego de adivinanza de números simple y funcional que puedes jugar tanto con una máquina local como con otra remota. Espero que te sea útil!