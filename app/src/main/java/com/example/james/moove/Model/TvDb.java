package com.example.james.moove.Model;


public class TvDb {
    private String mTVTitle;
    private String mRating;
    private String mImageUrl;
    private String mOverview;
    private String uid;

    public TvDb(){}

    public TvDb(String uid,String title, String rating,String imageUrl,String mOverview){
        this.mTVTitle=title;
        this.mRating=rating;
        this.mImageUrl=imageUrl;
        this.mOverview=mOverview;
        this.uid=uid;
    }
    public String getmTVTitle(){
        return mTVTitle;
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
