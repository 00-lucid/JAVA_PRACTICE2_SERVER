package com.javastates.MiniServer.model.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private String movieName;
    private Genre movieGenre;
    private int movieViewer;

    public Movie(String movieName, Genre movieGenre, int movieViewer) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieViewer = movieViewer;
    }
}
