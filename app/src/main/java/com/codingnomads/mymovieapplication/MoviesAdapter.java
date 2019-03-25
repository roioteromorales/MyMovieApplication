package com.codingnomads.mymovieapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingnomads.mymovieapplication.logic.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movieList;

    public MoviesAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView movieTitleTextView = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        MovieViewHolder vh = new MovieViewHolder(movieTitleTextView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.movieTitleTextView.setText(movieList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView movieTitleTextView;

        public MovieViewHolder(TextView movieTitleTextView) {
            super(movieTitleTextView);
            this.movieTitleTextView = movieTitleTextView;
        }
    }

}
