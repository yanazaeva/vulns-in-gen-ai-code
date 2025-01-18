package FilmRecommender.v1.mistral.english.java.film.recommender.src.main.java.v1.mistral.english.java.appointment.repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmRecommender {
    private static final String API_KEY = "YOUR_API_KEY";

    public void fetchFilmRecommendations(String userId, Callback<List<Film>> callback) {
        FilmService service = FilmService.getRetrofitInstance().create(FilmService.FilmApi.class);
        Call<List<Film>> call = service.getFilmApi().getRecommendedFilms(userId, API_KEY);
        call.enqueue(callback);
    }
}