package com.example.james.moove.HttpService;


import com.example.james.moove.Constants.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpService {
    public  String getMovie(String movie) throws IOException {
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder builder=HttpUrl.parse(Constants.MOVIE_SEARCH_BASE_URL).newBuilder();
        builder.addQueryParameter(Constants.API_KEY_QUERY,Constants.API_KEY);
        builder.addQueryParameter(Constants.MOVIE_QUERY,movie);

        String url=builder.build().toString();

        Request request=new Request.Builder()
                .url(url)
                .build();
        Call call=client.newCall(request);
        Response response=call.execute();

        String responseJson=response.body().string();
        return  responseJson;


    }
    public String getMovieTypes(String type) throws IOException{
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder builder=HttpUrl.parse(Constants.PLAYING_BASE_URL+type).newBuilder();
        builder.addQueryParameter(Constants.API_KEY_QUERY,Constants.API_KEY);


        String url=builder.build().toString();

        Request request=new Request.Builder()
                .url(url)
                .build();
        Call call=client.newCall(request);
        Response response=call.execute();

        String responseJson=response.body().string();

        return  responseJson;

    }
}
