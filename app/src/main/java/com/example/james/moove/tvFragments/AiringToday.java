package com.example.james.moove.tvFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.james.moove.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AiringToday extends Fragment {


    public AiringToday() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_airing_today, container, false);
    }

}
