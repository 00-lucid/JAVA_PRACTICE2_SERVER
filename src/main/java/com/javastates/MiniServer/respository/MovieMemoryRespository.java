package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.movie.Genre;
import com.javastates.MiniServer.model.movie.Movie;

import java.util.*;

public class MovieMemoryRespository implements MovieRespository{

    // immutable한 더미 데이터
    Map<UUID, Movie> uuidMovieMap = new HashMap<>(){{
        // 아주 사소한 것도 중복되면 자동화 권장 -갓재현님-
        // 모델 패키지는 안씀, 도메인(DTO) + 폼 패키지를 쓰는 경우는 있음
        for(int i = 0; i < 5; i++) {
            put(UUID.randomUUID(), new Movie("movie" + i, Genre.Action, i * 100));
        }
    }};

    @Override
    public void save(Movie movie) {
        uuidMovieMap.put(UUID.randomUUID(), movie);
    }

    @Override
    public Movie findMovieById(UUID uuid) {
        return uuidMovieMap.get(uuid);
    }

    @Override
    public ArrayList<Movie> findAllMovie() {
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        for (UUID key : uuidMovieMap.keySet()) {
            // key를 바탕으로 값을 받아와서 새로운 ArrayList에 넣는다.
            movieArrayList.add(uuidMovieMap.get(key));
        }

        return movieArrayList;
    }
}
