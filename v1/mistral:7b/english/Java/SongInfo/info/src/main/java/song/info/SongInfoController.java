package SongInfo.info.src.main.java.song.info;

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