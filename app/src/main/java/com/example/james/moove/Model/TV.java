package com.example.james.moove.Model;


import org.parceler.Parcel;

@Parcel
public class TV {
    private String mTVTitle;
    private String mRating;
    private String mImageUrl;
    private String mOverview;

    public TV(){}

    public TV(String title, String rating,String imageUrl,String mOverview){
        this.mTVTitle=title;
        this.mRating=rating;
        this.mImageUrl=imageUrl;
        this.mOverview=mOverview;
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
}
