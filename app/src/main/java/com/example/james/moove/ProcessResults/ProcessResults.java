package com.example.james.moove.ProcessResults;


import com.example.james.moove.Constants.Constants;
import com.example.james.moove.Model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProcessResults {
    public ArrayList<Movie> movieResults(String jsonString){
        ArrayList<Movie> movies=new ArrayList<>();

        try{
            JSONObject moviesJson=new JSONObject(jsonString);
            JSONArray moviesJsonArray=moviesJson.getJSONArray("results");
            for(int i=0;i<moviesJsonArray.length();i++){
                JSONObject movieJson=moviesJsonArray.getJSONObject(i);
                String title=movieJson.getString("title");
                String ratings=movieJson.getString("vote_average");
                String imageUrl=movieJson.getString("poster_path");
                String overview=movieJson.getString("overview");
                if(title !=null && ratings  !=null && imageUrl !=null && overview !=null){
                    String imgurl= Constants.MOVIE_POSTER_BASE_URL+imageUrl;
                    Movie movie=new Movie(title,ratings,imgurl,overview);
                    movies.add(movie);
                }




            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        return movies;

    }
}
