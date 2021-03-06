package com.example.james.moove.tvFragments;


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

import com.example.james.moove.Adapters.TvAdapter;
import com.example.james.moove.HttpService.HttpService;
import com.example.james.moove.Model.TV;
import com.example.james.moove.ProcessResults.ProcessResults;
import com.example.james.moove.R;
import com.example.james.moove.connection.Connection;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnAir extends Fragment {
    @Bind(R.id.rv_onAir)RecyclerView monAirRecycler;
    private TvAdapter tvMoviePageAdapter;
    private GridLayoutManager gridLayoutManager;
    public static  final  String ON_AIR="on_the_air";
    private HttpService httpService;
    private ProcessResults processResults;
    ArrayList<TV> tvs;


    public OnAir() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_on_air, container, false);
        ButterKnife.bind(this,view);
        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpService=new HttpService();
        processResults=new ProcessResults();

            GetOnAir  onAir =new  GetOnAir ();
            onAir.execute(ON_AIR);


    }
    public class GetOnAir extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {
            String tv=params[0];
            String result=null;
            try{
                result=httpService.getTVTypes(tv);
            }catch (IOException e){
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            tvs=processResults.tvResults(s);
            tvMoviePageAdapter=new TvAdapter(getContext(),tvs);
            monAirRecycler.setAdapter(tvMoviePageAdapter);
            gridLayoutManager=new GridLayoutManager(getContext(),2);
            monAirRecycler.setLayoutManager(gridLayoutManager);
        }
    }
}
