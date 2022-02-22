package com.example.chinook_java_assignment.model;

import java.util.HashMap;

public class CustomerGenre {

    public HashMap<String, Integer> getGenreTotal() {
        return GenreTotal;
    }

    public void setGenreTotal(HashMap<String, Integer> genreTotal) {
        GenreTotal = genreTotal;
    }

    public HashMap<String, Integer> GenreTotal = new HashMap<String, Integer>();

    public void AddGenreTotal(String genre, int amount){
        GenreTotal.put(genre, amount);
    }



}
