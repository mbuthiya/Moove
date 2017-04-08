package com.example.james.moove.details;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.james.moove.Model.Movie;
import com.example.james.moove.R;


import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MovieDetails extends AppCompatActivity {
    private Movie movie;
    private int position;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movies= Parcels.unwrap(getIntent().getParcelableExtra("movies"));
        position=getIntent().getIntExtra("position",0);

        movie=movies.get(position);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        MovieDetailsFragment detailsFragment=MovieDetailsFragment.newInstance(movie);
        ft.replace(R.id.movieDetailsPLaceHolder,detailsFragment);
        ft.commit();

    }
}
