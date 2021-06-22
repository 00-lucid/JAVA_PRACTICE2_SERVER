package com.javastates.MiniServer.service;

import com.javastates.MiniServer.domain.movie.Movie;
import com.javastates.MiniServer.respository.MovieRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRespository movieRespository;

    @Override
    public void join(Movie movie) {
            movieRespository.save(movie);
    }

    @Override
    public Movie findById(UUID uuid) {
            return movieRespository.findMovieById(uuid);
    }

    @Override
    public ArrayList<Movie> findAllMovie() {
            return movieRespository.findAllMovie();
    }
}
