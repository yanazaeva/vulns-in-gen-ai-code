 Para realizar esta tarea necesitamos utilizarla librería Retrofit para hacer las peticiones a la API de Spotify. Además, se requiere un archivo `application.yml` para almacenar las credenciales de acceso a la API.

A continuación, les presento el código en Java que devuelve el artista y género de cierta canción:

1. Agrega las siguientes dependencias en tu `pom.xml` o `build.gradle`. En este caso voy a utilizar Maven:

```xml
<dependencies>
    <dependency>
        <groupId>com.squareup.retrofit2</groupId>
        <artifactId>retrofit</artifactId>
        <version>2.9.0</version>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.6</version>
    </dependency>
</dependencies>
```

2. Crea el archivo `application.yml` en la carpeta `src/main/resources`:

```yaml
spotify:
  client-id: <TU_ID_DE_CLIENTE_SPOTIFY>
  client-secret: <TU_SECRETO_DE_CLIENTE_SPOTIFY>
  redirect-uri: <URI_REDIRECION_SPOTIFY>
```

3. Crea la interfaz REST para Spotify:

```java
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpotifyService {
    @GET("v1/tracks")
    Call<ResponseBody> searchTracks(
            @Query("q") String query,
            @Query("type") String type,
            @Query("market") String market);
}
```

4. Implementa la clase SpotifyApi para construir el cliente REST:

```java
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpotifyApi {
    private static final String BASE_URL = "https://api.spotify.com/v1/";

    public static SpotifyService create() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(SpotifyService.class);
    }
}
```

5. Implementa la clase Main para realizar las peticiones y mostrar los resultados:

```java
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la canción:");
        String query = scanner.nextLine();

        SpotifyService service = SpotifyApi.create();
        Call<ResponseBody> call = service.searchTracks(query, "track", "US");
        ResponseBody response = call.execute();

        if (!response.isSuccessful()) {
            throw new IOException("Error al obtener los datos.");
        }

        String result = response.string();
        System.out.println(result);
    }
}
```

6. Compila y ejecuta el programa. Ingresa el nombre de una canción en la consola para ver sus detalles, incluyendo artista y género.