package com.example.james.moove;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.james.moove.Adapters.FragmentsStateAdapter;
import com.example.james.moove.MovieFragments.Upcoming;
import com.example.james.moove.tvFragments.AiringToday;
import com.example.james.moove.tvFragments.OnAir;
import com.example.james.moove.tvFragments.PopularTV;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TvActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.vp_tv_tabs)ViewPager mViewPager;
    @Bind(R.id.iv_TvButtonTv)ImageView mTvButton;
    @Bind(R.id.iv_movieButtonTv)ImageView mMovieButton;
    @Bind(R.id.iv_watchListButtonTv)ImageView mWatchlistButton;
    @Bind(R.id.iv_profileButtonTv)ImageView mProfileButton;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTv);
        setSupportActionBar(toolbar);
        connectFragments();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsTv);
        tabLayout.setupWithViewPager(mViewPager);

        mTvButton.setOnClickListener(this);
        mMovieButton.setOnClickListener(this);
        mWatchlistButton.setOnClickListener(this);
        mProfileButton.setOnClickListener(this);

    }
    public void connectFragments(){
        //instanciating new arrayLists
        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        ArrayList<String> titles=new ArrayList<>();
        //populating arrayLists...............
        fragmentArrayList.add(new AiringToday());
        fragmentArrayList.add(new PopularTV());
        fragmentArrayList.add(new OnAir());

        //...............................
        titles.add("AIRING TODAY");
        titles.add("POPULAR");
        titles.add("ON AIR");

        //connecting the viewpager to adapter

        FragmentsStateAdapter fragmentsStateAdapter=new FragmentsStateAdapter(getSupportFragmentManager(),fragmentArrayList,titles);
        mViewPager.setAdapter(fragmentsStateAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v==mMovieButton){
            intent=new Intent(TvActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }
}
