package com.example.chinook_java_assignment.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerGenre {

    public ArrayList<GenreTotals> getGenreTotal() {
        return GenreTotal;
    }

    public void setGenreTotal(ArrayList<GenreTotals> genreTotal) {
        GenreTotal = genreTotal;
    }

    ArrayList<GenreTotals> GenreTotal = new ArrayList<GenreTotals>();

    public void AddGenreTotal(String genre, int amount){
        GenreTotals genreTotals = new GenreTotals(genre, amount);
        GenreTotal.add(genreTotals);
    }


    public static class GenreTotals {
        public String genre;
        public int amount;

        GenreTotals(String g, int a) {
            genre = g;
            amount = a;
        }
    }
}
