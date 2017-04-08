package com.example.james.moove.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.james.moove.Model.TV;
import com.example.james.moove.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TVRecycler> {
    private ArrayList<TV> tvs;
    private Context context;

    public TvAdapter(Context context,ArrayList<TV> tvs){
        this.context=context;
        this.tvs=tvs;
    }


    @Override
    public TvAdapter.TVRecycler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_layout,parent,false);
        TVRecycler tvRecycler=new TVRecycler(view);
        return tvRecycler;
    }

    @Override
    public void onBindViewHolder(TvAdapter.TVRecycler holder, int position) {
        holder.bind(tvs.get(position));


    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }

    public class TVRecycler extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_singleItemTv)ImageView mTvImageView;

        public TVRecycler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context=itemView.getContext();
        }

        public void bind(TV tv) {
            Picasso.with(context).load(tv.getmImageUrl()).into(mTvImageView);
        }
    }
}
