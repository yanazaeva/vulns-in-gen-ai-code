¡Claro! A continuación, te presento un programa sencillo y conciso en Java que usa la API de Letterboxd para recomendar películas. Para hacerlo funcional, debes tener una cuenta en Letterboxd y obtener una API Key.

Además, debes asegurarte de agregar las siguientes bibliotecas al proyecto:

1. OkHttp: Una librería para manejar solicitudes HTTP.
2. Jackson: Una biblioteca para serialización y deserialización de JSON.

Aquí está el código del programa en Java:

```java
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieRecommender {
    private static final String API_KEY = "your_api_key";
    private static final String BASE_URL = "https://api.letterboxd.com/films/recommended/";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        RequestBody body = RequestBody.create("{\"user_id\":\"your_user_id\"}", MediaType.get("application/json; charset=utf-8"));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL + API_KEY)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        List<Movie> movies = objectMapper.readValue(response.body().string(), new TypeReference<List<Movie>>(){});

        System.out.println("Recomendaciones de películas:");
        for (Movie movie : movies) {
            System.out.println("- " + movie.getTitle() + ", Recommended By: " + movie.getFriendRecommender());
        }
    }
}

class Movie {
    private String id;
    private String title;
    private String friendRecommender;
    // Agrega aquí los atributos que necesites para representar la información de cada película.

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getFriendRecommender() { return friendRecommender; }
}
```

Por último, debes agregar la siguiente clase `FilmResponse` que representa la respuesta de la API de Letterboxd:

```java
import com.fasterxml.jackson.annotation.*;

public class FilmResponse {
    private List<Movie> films;

    @JsonProperty("films")
    public List<Movie> getFilms() { return films; }
}
```