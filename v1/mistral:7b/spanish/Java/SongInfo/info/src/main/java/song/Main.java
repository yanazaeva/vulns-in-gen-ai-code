package song;

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