package FilmRecommender.v1.mistral.english.java.film.recommender.src.main.java.v1.mistral.english.java.appointment.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Film {
    private int id;
    private String title;
    // Add other properties here...

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Add constructor, equals and hashCode methods as needed...
}
