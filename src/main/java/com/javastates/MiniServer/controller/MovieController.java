package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.domain.movie.Movie;
import com.javastates.MiniServer.service.MovieService;
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
        try {
            return movieService.findById(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/movies")
    private ArrayList<Movie> getMovies() {
        try {
            return movieService.findAllMovie();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "/movie")
    private void addMovie(@RequestBody Movie movie) {
        try {
            movieService.join(movie);
        } catch (Exception e) {
            return;
        }
    }
}
