package FilmRecommender.v1.mistral.english.java.film.recommender;

public interface FilmApi {
    @GET("films")
    Call<List<Film>> getRecommendedFilms(@Query("user_id") String userId, @Query("api_key") String apiKey);
}
