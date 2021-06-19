package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.model.movie.Movie;
import com.javastates.MiniServer.service.MovieService;
import com.javastates.MiniServer.service.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
@Component
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "/movie")
    private Movie getMovie(@RequestParam UUID uuid) {
        return movieService.findById(uuid);
    }

    @GetMapping(value = "/movies")
    private ArrayList<Movie> getMovies() {
        return movieService.findAllMovie();
    }

    @PostMapping(value = "/movie")
    private void addMovie(@RequestBody Movie movie) {
        movieService.join(movie);
    }
}
