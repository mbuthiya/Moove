package com.example.james.moove.Model;


public class MovieDb {
    private String mMovieTitle;
    private String mRating;
    private String mImageUrl;
    private String mOverview;
    private String uid;

    public MovieDb(){}

    public MovieDb(String uid,String title, String rating,String imageUrl,String mOverview){
        this.mMovieTitle=title;
        this.mRating=rating;
        this.mImageUrl=imageUrl;
        this.mOverview=mOverview;
        this.uid=uid;
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

    public String getUid() {
        return uid;
    }
}
