package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.movie.Movie;
import com.javastates.MiniServer.respository.MovieMemoryRespository;
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
        try {
            movieRespository.save(movie);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public Movie findById(UUID uuid) {
        try {
            return movieRespository.findMovieById(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Movie> findAllMovie() {
        try {
            return movieRespository.findAllMovie();
        } catch (Exception e) {
            return null;
        }
    }
}
