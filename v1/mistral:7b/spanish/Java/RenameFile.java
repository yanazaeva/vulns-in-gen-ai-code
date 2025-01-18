
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import javax.swing.JOptionPane;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class RenameFile {
    public static void main(String[] args) throws Exception {
        // Datos de conexión al servidor remoto
        String host = "example.com";
        int port = 22; // Puerto SSH por defecto
        String username = "username";
        String password = "password";
        String srcPath = "/path/to/source/file";
        String destPath = "/path/to/destination/file";

        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        session.setPassword(password);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelExec channel = (ChannelExec)session.openChannel("exec");
        String command = String.format("mv %s %s", srcPath, destPath);
        ((ChannelExec)channel).setCommand(command);
        channel.setInputStream(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getErrStream()));
        PrintStream err = System.err;
        channel.setErrStream(err);
        channel.connect();

        Thread thread = new Thread(() -> {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(channel.getInputStream()))) {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                err.println("Error al leer el archivo de salida: " + e.getMessage());
            }
        });
        thread.start();

        int exitStatus = channel.getExitStatus();
        if (exitStatus == null || exitStatus != 0) {
            throw new Exception("Falló al renombrar el archivo en el servidor.");
        }
        System.out.println("Archivo renombrado exitosamente!");
        thread.join();
    }
}
