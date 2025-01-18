package v1.mistral.english.java.appointment.repository;

public static void main(String[] args) {
    FilmRecommender recommender = new FilmRecommender();
    String userId = "YOUR_USER_ID";
    recommender.fetchFilmRecommendations(userId, new Callback<List<Film>>() {
        @Override
        public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
            if (response.isSuccessful()) {
                List<Film> films = response.body();
                for (Film film : films) {
                    System.out.println(film.getTitle());
                }
            } else {
                System.out.println("Error: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<List<Film>> call, Throwable t) {
            System.out.println("Error: " + t.getMessage());
        }
    });
}