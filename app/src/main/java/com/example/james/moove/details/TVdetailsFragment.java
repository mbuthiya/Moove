package com.example.james.moove.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.james.moove.Model.TV;
import com.example.james.moove.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TVdetailsFragment extends Fragment {
    private TV tv;
    @Bind(R.id.iv_tvImageDetails)ImageView ImageDetails;
    @Bind(R.id.tv_tvName)TextView mTvName;
    @Bind(R.id.tv_tvoverview)TextView mOverView;
    @Bind(R.id.tv_tvrating)TextView mRatings;


    public TVdetailsFragment() {
        // Required empty public constructor
    }

    public static TVdetailsFragment newInstance(TV tv) {

        Bundle args = new Bundle();

        TVdetailsFragment fragment = new TVdetailsFragment();
        args.putParcelable("tv", Parcels.wrap(tv));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tvdetails, container, false);
        ButterKnife.bind(this,view);

        Picasso.with(getContext()).load(tv.getmImageUrl()).into(ImageDetails);
        mTvName.setText(tv.getmTVTitle());
        mOverView.setText(tv.getmOverview());

        mRatings.setText(tv.getmRating());

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv=Parcels.unwrap(getArguments().getParcelable("tv"));

    }
}
