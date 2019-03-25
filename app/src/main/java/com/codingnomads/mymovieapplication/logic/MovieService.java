package com.codingnomads.mymovieapplication.logic;

import com.codingnomads.mymovieapplication.data.MovieRepository;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }
}
