import com.fasterxml.jackson.annotation.*;

public class FilmResponse {
    private List<Movie> films;

    @JsonProperty("films")
    public List<Movie> getFilms() { return films; }
}