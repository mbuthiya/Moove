package com.example.james.moove.MovieFragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.james.moove.Adapters.TvMoviePageAdapter;
import com.example.james.moove.HttpService.HttpService;
import com.example.james.moove.Model.Movie;
import com.example.james.moove.ProcessResults.ProcessResults;
import com.example.james.moove.R;
import com.example.james.moove.connection.Connection;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class Upcoming extends Fragment {
    @Bind(R.id.rv_upcoming)RecyclerView mUpcomingRecycler;
    private TvMoviePageAdapter tvMoviePageAdapter;
    private GridLayoutManager gridLayoutManager;
    public static  final  String UPCOMING="upcoming";
    private HttpService httpService;
    private ProcessResults processResults;
    ArrayList<Movie> movies;


    public Upcoming() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_upcoming, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpService=new HttpService();
        processResults=new ProcessResults();
        if(Connection.isConnected(getContext())){
            GetUpcoming upcoming=new GetUpcoming();
            upcoming.execute(UPCOMING);
        }else {
            Toast.makeText(getContext(), "NO INTERNET", Toast.LENGTH_SHORT).show();
        }

    }
    class GetUpcoming extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {
            String movie=params[0];
            String result=null;
            try{
                result=httpService.getMovieTypes(movie);
            }catch (IOException e){
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            movies=processResults.movieResults(s);
            tvMoviePageAdapter=new TvMoviePageAdapter(getContext(),movies);
            mUpcomingRecycler.setAdapter(tvMoviePageAdapter);
            gridLayoutManager=new GridLayoutManager(getContext(),2);
            mUpcomingRecycler.setLayoutManager(gridLayoutManager);
        }
    }
}
