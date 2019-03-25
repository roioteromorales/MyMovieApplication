package com.codingnomads.mymovieapplication.data;

import com.codingnomads.mymovieapplication.logic.Movie;

import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

public class MovieRepository {

    private String url = "http://192.168.33.45:8080/movies";
    private RestTemplate restTemplate;

    public MovieRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getAllMovies() {
        Movie[] movieList = restTemplate.getForObject(url, Movie[].class);
        return asList(movieList);
    }
}
