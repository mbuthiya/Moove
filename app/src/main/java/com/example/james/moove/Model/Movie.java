package com.example.james.moove.Model;



public class Movie {
    private String mMovieTitle;
    private String mRating;
    private String mImageUrl;
    private String mOverview;
    public Movie(){}

    public Movie(String title, String rating,String imageUrl,String mOverview){
        this.mMovieTitle=title;
        this.mRating=rating;
        this.mImageUrl=imageUrl;
        this.mOverview=mOverview;
    }
    public String getmMovieTitle(){
        return mMovieTitle;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmRating() {
        return mRating;
    }
    public String getmOverview(){return  mOverview;}
}
