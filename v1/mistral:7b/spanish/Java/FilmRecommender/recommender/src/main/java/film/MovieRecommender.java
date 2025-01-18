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