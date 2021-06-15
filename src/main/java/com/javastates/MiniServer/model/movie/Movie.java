package com.javastates.MiniServer.model.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private String movieName;
    private Genre movieGenre;
    private int movieViewer;
    private String moviePhoto;
    private String movieInfo;

    public Movie(String movieName, Genre movieGenre, int movieViewer, String moviePhoto, String movieInfo) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieViewer = movieViewer;
        this.moviePhoto = moviePhoto;
        this.movieInfo = movieInfo;
    }
}
