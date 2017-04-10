package com.example.james.moove.Constants;


import com.example.james.moove.BuildConfig;

public class Constants {
    public static final String API_KEY= BuildConfig.API_KEY;
    public static final String API_KEY_QUERY="api_key";
    public static final String MOVIE_QUERY="query";

    //https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    public static final String MOVIE_SEARCH_BASE_URL="https://api.themoviedb.org/3/search/movie";

    //now_playing
    public static final String PLAYING_BASE_URL="https://api.themoviedb.org/3/movie/";

    public static  final String MOVIE_POSTER_BASE_URL="https://image.tmdb.org/t/p/w500/";


    //on_the_air,popular,airing_today

    public static  final String TV_BASE_URL="https://api.themoviedb.org/3/tv/";
    public  static  final String TV_SEARCH_BASE_URL="https://api.themoviedb.org/3/search/tv";

    //firebase constants.
    public static  final String USERS="users";
    public static  final String WATCHLIST="watchlist";

}
