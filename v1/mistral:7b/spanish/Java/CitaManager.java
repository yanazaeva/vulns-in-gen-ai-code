import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CitaManager {
    private static final String API_URL = "https://api.mi-negocio.com";

    public void crearCita(String titulo, String descripcion, Date fecha) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String url = API_URL + "/citas";

        JSONObject json = new JSONObject();
        json.put("titulo", titulo);
        json.put("descripcion", descripcion);
        json.put("fecha", sdf.format(fecha));

        HttpClient client = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost(url);
        StringEntity entity = new StringEntity(json.toString());
        entity.setContentType("application/json");
        postRequest.setEntity(entity);

        CloseableHttpResponse response = client.execute(postRequest);
        try {
            System.out.println(response.getStatusLine().getReasonPhrase());
            EntityUtils.consumeQuietly(response.getEntity());
        } finally {
            response.close();
        }
    }

    public void borrarCita(int id) throws Exception {
        String url = API_URL + "/citas/" + id;

        HttpClient client = HttpClients.createDefault();
        HttpDelete deleteRequest = new HttpDelete(url);

        CloseableHttpResponse response = client.execute(deleteRequest);
        try {
            System.out.println(response.getStatusLine().getReasonPhrase());
            EntityUtils.consumeQuietly(response.getEntity());
        } finally {
            response.close();
        }
    }

    public void actualizarCita(int id, String titulo, String descripcion, Date fecha) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String url = API_URL + "/citas/" + id;

        JSONObject json = new JSONObject();
        json.put("titulo", titulo);
        json.put("descripcion", descripcion);
        json.put("fecha", sdf.format(fecha));

        HttpClient client = HttpClients.createDefault();
        HttpPut putRequest = new HttpPut(url);
        StringEntity entity = new StringEntity(json.toString());
        entity.setContentType("application/json");
        putRequest.setEntity(entity);

        CloseableHttpResponse response = client.execute(putRequest);
        try {
            System.out.println(response.getStatusLine().getReasonPhrase());
            EntityUtils.consumeQuietly(response.getEntity());
        } finally {
            response.close();
        }
    }

    public void listarCitas() throws Exception {
        String url = API_URL + "/citas";

        HttpClient client = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(url);

        CloseableHttpResponse response = client.execute(getRequest);
        try {
            int status = response.getStatusLine().getStatusCode();
            if (status == 200) {
                JSONArray jsonArray = new JSONArray(EntityUtils.toString(response.getEntity()));
                for (int i = 0; i < jsonArray.length(); ++i) {
                    JSONObject cita = jsonArray.getJSONObject(i);
                    System.out.println("ID: " + cita.getInt("id"));
                    System.out.println("Título: " + cita.getString("titulo"));
                    System.out.println("Descripción: " + cita.getString("descripcion"));
                    System.out.println("Fecha: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(cita.getLong("fecha"))));
                    System.out.println();
                }
            } else {
                throw new Exception("Error al listar las citas (" + status + "): " + response.getStatusLine().getReasonPhrase());
            }
        } finally {
            response.close();
        }
    }

    public static void main(String[] args) throws Exception {
        CitaManager manager = new CitaManager();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Crear cita");
            System.out.println("2. Borrar cita");
            System.out.println("3. Actualizar cita");
            System.out.println("4. Listar citas");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.print("Título: ");
                String titulo = scanner.next();
                System.out.print("Descripción: ");
                String descripcion = scanner.next();
                System.out.print("Fecha (yyyy-mm-dd hh:mm:ss): ");
                String fechaString = scanner.next();
                Date fecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fechaString);
                manager.crearCita(titulo, descripcion, fecha);
            } else if (option == 2) {
                System.out.print("ID de la cita a borrar: ");
                int id = scanner.nextInt();
                manager.borrarCita(id);
            } else if (option == 3) {
                System.out.print("ID de la cita a actualizar: ");
                int id = scanner.nextInt();
                System.out.print("Título: ");
                String titulo = scanner.next();
                System.out.print("Descripción: ");
                String descripcion = scanner.next();
                System.out.print("Fecha (yyyy-mm-dd hh:mm:ss): ");
                String fechaString = scanner.next();
                Date fecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fechaString);
                manager.actualizarCita(id, titulo, descripcion, fecha);
            } else if (option == 4) {
                manager.listarCitas();
            } else if (option != 5) {
                System.out.println("Opción inválida");
            } else {
                break;
            }
        }
    }
}
