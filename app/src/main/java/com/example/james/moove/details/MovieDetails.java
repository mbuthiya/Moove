package com.example.james.moove.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.james.moove.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetails extends AppCompatActivity {
    @Bind(R.id.iv_movieImageDetails)ImageView mMovieDetailsImageView;
    @Bind(R.id.tv_movieName)TextView mMovieName;
    @Bind(R.id.tv_overview)TextView mOverView;
    @Bind(R.id.tv_rating)TextView mRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
    }
}
