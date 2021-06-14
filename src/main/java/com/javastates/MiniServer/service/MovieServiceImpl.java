package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.movie.Movie;
import com.javastates.MiniServer.respository.MovieMemoryRespository;
import com.javastates.MiniServer.respository.MovieRespository;

import java.util.*;

public class MovieServiceImpl implements MovieService {

    // 스프링 컨테이너 Bean을 이용해야 됨 (자동등록)
    private MovieRespository movieRespository = new MovieMemoryRespository();

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
