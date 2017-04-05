package com.example.james.moove.Constants;


import com.example.james.moove.BuildConfig;

public class Constants {
    public static final String API_KEY= BuildConfig.API_KEY;
    public static final String API_KEY_QUERY="api_key";
    public static final String MOVIE_QUERY="query";

    //https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    public static final String MOVIE_SEARCH_BASE_URL="https://api.themoviedb.org/3/search/movie";

    //add the movie id then the api key ie.https://api.themoviedb.org/3/movie/343611?api_key={api_key}
    public static final String MOVIE_DETAILS_BASE_URL="https://api.themoviedb.org/3/movie/";
    //now_playing
    public static final String PLAYING_BASE_URL="https://api.themoviedb.org/3/movie/";

    public static  final String MOVIE_POSTER_BASE_URL="https://image.tmdb.org/t/p/w500/";
}
