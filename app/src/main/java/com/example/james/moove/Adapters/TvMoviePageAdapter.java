package com.example.james.moove.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.james.moove.Model.Movie;
import com.example.james.moove.R;
import com.example.james.moove.details.MovieDetails;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TvMoviePageAdapter extends RecyclerView.Adapter<TvMoviePageAdapter.TvMovie> {
    private Context context;
    private ArrayList<Movie> movies;
    public  TvMoviePageAdapter(Context context,ArrayList<Movie> movies){
        this.context=context;
        this.movies=movies;
    }

    @Override
    public TvMoviePageAdapter.TvMovie onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_tv_item,parent,false);
        TvMovie tvMovie=new TvMovie(v);
        return tvMovie;
    }

    @Override
    public void onBindViewHolder(TvMoviePageAdapter.TvMovie holder, int position) {
        holder.bind(movies.get(position));

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class TvMovie extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.iv_singleItemIv) ImageView mSingleItemIv;
        public TvMovie(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context=itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bind(Movie movie) {
            Picasso.with(context).load(movie.getmImageUrl()).into(mSingleItemIv);

        }

        @Override
        public void onClick(View v) {
            int itemPosition=getLayoutPosition();
            Intent intent=new Intent(context, MovieDetails.class);
            intent.putExtra("position",itemPosition);
            intent.putExtra("movies", Parcels.wrap(movies));
            context.startActivity(intent);


        }
    }
}
