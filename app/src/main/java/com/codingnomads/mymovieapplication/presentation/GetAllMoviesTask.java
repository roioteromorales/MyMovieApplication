package com.codingnomads.mymovieapplication.presentation;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.codingnomads.mymovieapplication.logic.Movie;
import com.codingnomads.mymovieapplication.logic.MovieService;

import java.util.List;

public class GetAllMoviesTask extends AsyncTask<Void, Integer, List<Movie>> {

    private MovieService movieService;
    private List<Movie> movieList;
    private RecyclerView.Adapter movieAdapter;

    public GetAllMoviesTask(MovieService movieService, List<Movie> movieList, RecyclerView.Adapter movieAdapter) {
        this.movieService = movieService;
        this.movieList = movieList;
        this.movieAdapter = movieAdapter;
    }

    @Override
    protected List<Movie> doInBackground(Void... voids) {
        return movieService.getAllMovies();
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        movieList.clear();
        movieList.addAll(movies);
        movieAdapter.notifyDataSetChanged();
    }
}
