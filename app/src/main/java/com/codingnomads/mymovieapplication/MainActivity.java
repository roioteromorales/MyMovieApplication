package com.codingnomads.mymovieapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingnomads.mymovieapplication.data.MovieRepository;
import com.codingnomads.mymovieapplication.logic.Movie;
import com.codingnomads.mymovieapplication.logic.MovieService;
import com.codingnomads.mymovieapplication.presentation.GetAllMoviesTask;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MovieService movieService;
    private List<Movie> movieList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)

        movieService = new MovieService(new MovieRepository(new RestTemplate()));

        mAdapter = new MoviesAdapter(movieList);
        recyclerView.setAdapter(mAdapter);
        GetAllMoviesTask getAllMoviesTask = new GetAllMoviesTask(movieService, movieList, mAdapter);

        getAllMoviesTask.execute();
    }
}