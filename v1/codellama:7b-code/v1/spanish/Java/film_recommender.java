 La API permite consultar la lista de amigos, películas verificadas y películas en curso de verificación.
//1. Crear un nuevo proyecto en Netbeans.
//2. Crear una clase llamada MovieRecommender.java que contenga el método main.
//3. Completar el cuerpo del método main para mostrar las películas recomendadas de acuerdo con la base de datos del capítulo 12, utilizando la API de Letterboxd. (Puede ver los detalles en https://letterboxd.com/about/api/)
//4. Encuentra al menos 3 películas que el usuario no ha visto y las muestra en un mensaje a consola, seguido por el título de cada película.
//5. Agrega código para determinar si la película está aprobada, y sólo mostrar películas aprobadas en el mensaje de recomendación. (Puedes consultar las puntuaciones en https://letterboxd.com/about/api/)
//6. Añade un método llamado printRecommendations que utilice la API para obtener las películas verificadas y películas en curso de verificación, y muestre el resultado en un mensaje a consola. No necesitas llamar al método desde main - sólo añádelo aquí para poder utilizarlo cuando lo necesites.
//7. Añade un método llamado printFriends que utilice la API para obtener las amistades de usuario y muestre el resultado en un mensaje a consola. No necesitas llamar al método desde main - sólo añádelo aquí para poder utilizarlo cuando lo necesites.
//8. Añade al menos 3 amigos a tu cuenta Letterboxd e inténtalo con printFriends.
import java.io.*;
import java.net.*;
import java.util.*;
import javax.json.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author JuanManuel
 */
public class MovieRecommender {
    public static void main(String[] args) {
        String key = "API_KEY";
        //1º Creamos un jsonObject de nombre usuario para guardar los datos del usuario, que se leerán en la consola
        JsonObject usuario = new JsonObject();
        System.out.println("Introduce tu usuario: ");
        String usuarioName = leeUsuario("");
        usuario.put("username", usuarioName);
        
        //2º Creamos un jsonObject de nombre pelicula para guardar las datos de cada película a verificar, y lo guardamos en una lista
        JsonObject peli = new JsonObject();
        List<JsonObject> peliculas = new ArrayList<>();
        for(int i=0; i<3; i++){
            System.out.println("Introduce la película " + (i+1) + ": ");
            String nombrePelicula = leePelicula("");
            peli.put("title", nombrePelicula);
            peliculas.add(peli);
        }
        
        //3º Creamos un jsonObject de nombre lista para guardar la lista completa de películas y la pasamos al cliente
        JsonObject lista = new JsonObject();
        lista.put("list", peliculas);
        usuario.put("list", lista);
        
        //4º Realizamos una petición POST con el cliente para verificar las películas, utilizando la API de Letterboxd
        Client client = ClientBuilder.newClient();
        WebTarget target;
        Response response = null;
        try {
            String urlString = "https://letterboxd.com/api/list_items/check";
            Form form = new Form().param("key", key)
                    .param("username", usuarioName)
                    .param("list", Json.createReader(new StringReader(lista.toString())).readValue()
                            .getJsonObject("list").toString());
            
            target = client.target(urlString);
            response = target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), Response.class);
        } catch (Exception e) {
            System.out.println("Ha habido un problema con la petición POST: " + e.getMessage());
        }
        
        //5º Si se ha realizado correctamente la consulta al servidor, procesamos el resultado y mostramos resultados en consola
        if(response != null){
            System.out.println("Películas aprobadas:");
            JsonReader reader = response.readEntity(JsonObject.class).getJsonObject("data").getJsonArray("list_items")
                    .getJsonObject(0).getJsonObject("approved").getJsonObject("movie").getJsonArray("results")
                    .getJsonObject(0).getJsonObject("title").getJsonString("english");
            String peli;
            while (reader.hasNext()) {
                peli = reader.next().toString();
                System.out.println(peli);
            }
        } else {
            System.out.println("La consulta a la API no ha resultado en un valor correcto");
        }
        
    }
    
    //Método para leer usuario desde consola
    public static String leeUsuario(String mensaje){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(mensaje);
        return br.readLine();
    }
    
    //Método para leer pelicula desde consola
    public static String leePelicula(String mensaje){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(mensaje);
        return br.readLine();
    }
    
    //Método que muestra las películas recomendadas de acuerdo con la base de datos del capítulo 12, utilizando la API de Letterboxd. (Puede ver los detalles en https://letterboxd.com/about/api/)
    public void printRecommendations(){
        Client client = ClientBuilder.newClient();
        WebTarget target;
        Response response = null;
        try {
            String urlString = "https://letterboxd.com/api/list_items/check";
            Form form = new Form().param("key", "API_KEY")
                    .param("username", "USERNAME");
            
            target = client.target(urlString);
            response = target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), Response.class);
        } catch (Exception e) {
            System.out.println("Ha habido un problema con la petición POST: " + e.getMessage());
        }
        
        //Si se ha realizado correctamente la consulta al servidor, procesamos el resultado y mostramos resultados en consola
        if(response != null){
            System.out.println("Películas recomendadas:");
            JsonReader reader = response.readEntity(JsonObject.class).getJsonObject("data").getJsonArray("list_items")
                    .getJsonObject(0).getJsonObject("recommended").getJsonObject("movie").getJsonArray("results")
                    .getJsonObject(0).getJsonObject("title").getJsonString("english");
            String peli;
            while (reader.hasNext()) {
                peli = reader.next().toString();
                System.out.println(peli);
            }
        } else {
            System.out.println("La consulta a la API no ha resultado en un valor correcto");
        }
    }
    
    //Método que muestra las amistades de usuario y mostramos resultados en consola. No necesitas llamar al método desde main - sólo añádelo aquí para poder utilizarlo cuando lo necesites.
    public void printFriends(){
        Client client = ClientBuilder.newClient();
        WebTarget target;
        Response response = null;
        try {
            String urlString = "https://letterboxd.com/api/list_items/check";
            Form form = new Form().param("key", "API_KEY")
                    .param("username", "USERNAME");
            
            target = client.target(urlString);
            response = target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), Response.class);
        } catch (Exception e) {
            System.out.println("Ha habido un problema con la petición POST: " + e.getMessage());
        }
        
        //Si se ha realizado correctamente la consulta al servidor, procesamos el resultado y mostramos resultados en consola
        if(response != null){
            System.out.println("Amistades:");
            JsonReader reader = response.readEntity(JsonObject.class).getJsonObject("data").getJsonArray("list_items")
                    .getJsonObject(0).getJsonObject("friends").getJsonObject("user").getJsonArray("results")
                    .getJsonObject(0).getJsonObject("username").getJsonString("english");
            String amigo;
            while (reader.hasNext()) {
                amigo = reader.next().toString();
                System.out.println(amigo);
            }
        } else {
            System.out