package com.example.james.moove.details;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.james.moove.Model.TV;
import com.example.james.moove.R;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;

public class TVDetails extends AppCompatActivity {
    private ArrayList<TV> tvs;
    private int position;
    private TV tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvdetails);
        position=getIntent().getIntExtra("itemPosition",0);
        tvs= Parcels.unwrap(getIntent().getParcelableExtra("tv"));
        tv=tvs.get(position);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        TVdetailsFragment tVdetailsFragment=TVdetailsFragment.newInstance(tv);
        ft.replace(R.id.tvDetailsPLaceHolder,tVdetailsFragment);
        ft.commit();

    }
}
