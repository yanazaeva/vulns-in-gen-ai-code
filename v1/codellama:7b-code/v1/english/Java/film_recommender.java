//The movies in my Letterboxd list have been classified as action, comedy, romance or drama (this is how it works: if a movie has been classified as action, comedy and drama but not romance, then the genre of the movie will be action). Write a method recommendMovie() that receives one argument of type String and returns an array with the recommended films based on Letterboxd list.

//Write a method called recommendMovie() that takes in a string as an input (e.g., "Bryan") and returns 4 movies from your recommendation algorithm.

import java.util.ArrayList;

public class FilmRecommender {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Letterboxd: Bryan's Films");
        String name = "Bryan";
        recommendMovie(name);
    }

    
    private static void recommendMovie(String input) {
        // TODO code application logic here
        String[] films = {"Glass", "Titanic", "Harry Potter", "The Green Mile"};
        
        System.out.println("Bryan recommends:");
        
        if (input == null) {
            System.out.println("You are a stranger.");
            
        } else {
            for (String film : films) {
                System.out.println(film);
            }
        }
    }
    
}


/*
let userName = "Bryan"; //this is the input of the method recommendMovie()
let genreList = ["action", "comedy", "romance", "drama"]; //genres that can be recommended

function recommendMovie(userName) {
    var genres;
    
    if (userName == null) {
        return [];
        
    } else if (genreList.contains("action") && genreList.contains("comedy") && genreList.contains("romance")) {
        return ["The Green Mile", "Titanic"];
        
    } else if (genreList.contains("action") && genreList.contains("drama")) {
        return ["Glass", "Harry Potter"];
        
    } else if (genreList.contains("romance")) {
        return