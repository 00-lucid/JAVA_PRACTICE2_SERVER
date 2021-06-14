package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.movie.Movie;

import java.util.*;


public interface MovieService {

    void join(Movie movie);

    Movie findById(UUID uuid);

    ArrayList<Movie> findAllMovie();
}
