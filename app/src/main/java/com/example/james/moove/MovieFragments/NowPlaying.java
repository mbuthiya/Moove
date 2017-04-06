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

import com.example.james.moove.Adapters.TvMoviePageAdapter;
import com.example.james.moove.HttpService.HttpService;
import com.example.james.moove.Model.Movie;
import com.example.james.moove.ProcessResults.ProcessResults;
import com.example.james.moove.R;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NowPlaying extends Fragment {
    @Bind(R.id.rv_nowPlaying)RecyclerView mNowPlayingRecycler;
    private TvMoviePageAdapter tvMoviePageAdapter;
    private GridLayoutManager gridLayoutManager;
    public static  final  String NOW_PLAYING="now_playing";
    private HttpService httpService;
    private ProcessResults processResults;
    ArrayList<Movie> movies;



    public NowPlaying() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpService=new HttpService();
        processResults=new ProcessResults();
        gridLayoutManager=new GridLayoutManager(getContext(),2);
        GetNowPlaying getNowPlaying=new GetNowPlaying();
        getNowPlaying.execute(NOW_PLAYING);
    }
    public  class GetNowPlaying extends AsyncTask<String,Void,String>{

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
            mNowPlayingRecycler.setAdapter(tvMoviePageAdapter);
            mNowPlayingRecycler.setLayoutManager(gridLayoutManager);


        }
    }
}
