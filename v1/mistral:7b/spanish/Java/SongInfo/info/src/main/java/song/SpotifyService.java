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