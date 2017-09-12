package com.example.james.moove.watchlistFragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.james.moove.Adapters.MovieWatchlistAdapter;
import com.example.james.moove.Constants.Constants;
import com.example.james.moove.Model.MovieDb;
import com.example.james.moove.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MovieFragment extends Fragment {

    DatabaseReference databaseReference;
    ArrayList<MovieDb>movieDbs;
    @Bind(R.id.movieRvWatchlist)RecyclerView rvMovie;
    MovieWatchlistAdapter adapter;
    public static String TAG=MovieFragment.class.getSimpleName();


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this,view);
        connectToAdapter();
        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference=FirebaseDatabase.getInstance().getReference().child(Constants.WATCHLIST).child("movies");
     connectToData();

    }
    public void connectToData(){

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    MovieDb movieDb=snapshot.getValue(MovieDb.class);
                    movieDbs.add(movieDb);


                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void connectToAdapter(){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        adapter=new MovieWatchlistAdapter(getContext(),movieDbs);
        rvMovie.setLayoutManager(gridLayoutManager);
        rvMovie.setAdapter(adapter);
        rvMovie.setHasFixedSize(true);

    }

}
