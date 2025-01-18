 To achieve this task, you will need to use Spotify's Web API, which requires user authentication before accessing any resources. I will provide an example using Spring Boot, but you can adapt it to a simple Java project as well.

Firstly, add Spotify's dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.spotify</groupId>
    <artifactId>web-api</artifactId>
    <version>6.18.0</version>
</dependency>
```

Now, create a simple Spring Boot project structure:

```
SongInfoApp/
  src/
    main/
      java/
        com/
          example/
            songinfoapp/
              SongInfoController.java
              Main.java
      resources/
        application.properties
```

Add the `application.properties` file with your Spotify API credentials:

```properties
spotify.client-id=YOUR_CLIENT_ID
spotify.client-secret=YOUR_CLIENT_SECRET
```

Create a `SongInfoController` class with the following content:

```java
import com.spotify.api.spotify.SpotifyApi;
import com.spotify.api.spotify.model_objects.specification.Track;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongInfoController {

    private final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId("YOUR_CLIENT_ID")
            .setClientSecret("YOUR_CLIENT_SECRET")
            .build();

    @GetMapping("/songinfo")
    public Track getSongInfo(@RequestParam String songName) {
        try {
            Track track = spotifyApi.searchTracks(songName).tracks.stream().findFirst().get();
            return track;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching song info", e);
        }
    }
}
```

Now, create a `Main` class with the following content:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
```

Once you have your project setup and built, run it with `mvn spring-boot:run`. Then access the API at `http://localhost:8080/songinfo?songName=YOUR_SONG_NAME`, replacing YOUR_SONG_NAME with the name of the song you want to fetch.

This example will return a JSON object containing the artist, genre, and other song information, such as album and preview URLs:

```json
{
    "name": "Viva la vida",
    "artists": [
        {
            "id": "24zvCkX6fYZ1tWJ0Sr7pGy",
            "href": "https://api.spotify.com/v1/artists/24zvCkX6fYZ1tWJ0Sr7pGy",
            "uri": "spotify:artist:24zvCkX6fYZ1tWJ0Sr7pGy",
            "name": "Coldplay",
            "type": "artist"
        }
    ],
    "genres": [
        "Alternative rock",
        "Rock"
    ],
    //... other song information
}
```