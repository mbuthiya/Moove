package com.example.james.moove.details;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.james.moove.Constants.Constants;
import com.example.james.moove.Model.Movie;
import com.example.james.moove.Model.MovieDb;
import com.example.james.moove.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailsFragment extends Fragment  implements  View.OnClickListener{

    @Bind(R.id.iv_movieImageDetails)ImageView mMovieDetailsImageView;
    @Bind(R.id.tv_movieName)TextView mMovieName;
    @Bind(R.id.tv_overview)TextView mOverView;
    @Bind(R.id.tv_rating)TextView mRating;
    @Bind(R.id.btn_saveMovieWatchList)Button mSaveToWatchList;
    String userId;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

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


        firebaseDatabase=FirebaseDatabase.getInstance();


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
        mSaveToWatchList.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v==mSaveToWatchList){
            databaseReference=firebaseDatabase.getReference().child(Constants.WATCHLIST).child("movies");
            userId=userId();

            MovieDb movieDb=new MovieDb(userId,mMovie.getmMovieTitle(),mMovie.getmRating(),mMovie.getmImageUrl(),mMovie.getmOverview());
            databaseReference.push().setValue(movieDb);

        }

    }
    public String userId(){
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String uid=null;
        if (user!=null){
            uid=user.getUid();

        }
        return uid;
    }


}
