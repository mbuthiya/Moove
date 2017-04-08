package com.example.james.moove.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.james.moove.Model.Movie;
import com.example.james.moove.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailsFragment extends Fragment {

    @Bind(R.id.iv_movieImageDetails)ImageView mMovieDetailsImageView;
    @Bind(R.id.tv_movieName)TextView mMovieName;
    @Bind(R.id.tv_overview)TextView mOverView;
    @Bind(R.id.tv_rating)TextView mRating;

    Movie mMovie;
    public MovieDetailsFragment() {
        // Required empty public constructor
    }

    //new instance to replace constructor

    public static MovieDetailsFragment newInstance(Movie movie) {

        Bundle args = new Bundle();
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        args.putParcelable("Movie", Parcels.wrap(movie));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie=Parcels.unwrap(getArguments().getParcelable("Movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this,view);
        Picasso.with(view.getContext()).load(mMovie.getmImageUrl()).into(mMovieDetailsImageView);
        mMovieName.setText(mMovie.getmMovieTitle());
        mOverView.setText(mMovie.getmOverview());
        mRating.setText(mMovie.getmRating());
        return view;
    }

}
