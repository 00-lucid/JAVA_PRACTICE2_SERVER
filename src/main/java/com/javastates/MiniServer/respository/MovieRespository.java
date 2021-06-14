package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.movie.Movie;

import java.util.*;


public interface MovieRespository {

    void save(Movie movie);

    Movie findMovieById(UUID uuid);

    ArrayList<Movie> findAllMovie();
}
