package com.example.james.moove;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.james.moove.Adapters.FragmentsStateAdapter;
import com.example.james.moove.MovieFragments.NowPlaying;
import com.example.james.moove.MovieFragments.Popular;
import com.example.james.moove.MovieFragments.Upcoming;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

@Bind(R.id.vp_movies_tabs)ViewPager mViewPager;
    @Bind(R.id.iv_TvButton)ImageView mTvButton;
    @Bind(R.id.iv_movieButton)ImageView mMovieButton;
    @Bind(R.id.iv_watchListButton)ImageView mWatchlistButton;
    @Bind(R.id.iv_profileButton)ImageView mProfileButton;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        connectFragments();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mTvButton.setOnClickListener(this);
        mMovieButton.setOnClickListener(this);
        mWatchlistButton.setOnClickListener(this);
        mProfileButton.setOnClickListener(this);


    }
    //method to connect tab fragments with the viewPager
    public void connectFragments(){
        //instanciating new arrayLists
        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        ArrayList<String> titles=new ArrayList<>();
        //populating arrayLists...............
        fragmentArrayList.add(new NowPlaying());
        fragmentArrayList.add(new Popular());
        fragmentArrayList.add(new Upcoming());

        //...............................
        titles.add("NOW PLAYING");
        titles.add("POPULAR");
        titles.add("UP COMING");

        //connecting the viewpager to adapter

        FragmentsStateAdapter fragmentsStateAdapter=new FragmentsStateAdapter(getSupportFragmentManager(),fragmentArrayList,titles);
        mViewPager.setAdapter(fragmentsStateAdapter);
    }


    @Override
    public void onClick(View v) {
        if (v==mTvButton){
            intent=new Intent(MainActivity.this,TvActivity.class);
            startActivity(intent);
        }else if (v==mWatchlistButton){
            intent=new Intent(MainActivity.this,Watchlist.class);
            startActivity(intent);
        }
    }
}
