package com.example.james.moove;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.james.moove.Adapters.FragmentsStateAdapter;
import com.example.james.moove.watchlistFragment.MovieFragment;
import com.example.james.moove.watchlistFragment.TvFragment;

import java.util.ArrayList;

public class Watchlist extends AppCompatActivity {

    private FragmentStatePagerAdapter fragmentStatePagerAdapter;



    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        connectFragments();


    }
        public  void connectFragments(){
            ArrayList<Fragment> fragments=new ArrayList<>();
            ArrayList<String> strings=new ArrayList<>();
            //populate lists

            fragments.add(new MovieFragment());
            fragments.add(new TvFragment());

            strings.add("Movies");
            strings.add("Tv Shows");

            fragmentStatePagerAdapter=new FragmentsStateAdapter(getSupportFragmentManager(),fragments,strings);
            mViewPager.setAdapter(fragmentStatePagerAdapter);

        }



}
