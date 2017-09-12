package com.example.james.moove.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.james.moove.Model.MovieDb;
import com.example.james.moove.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieWatchlistAdapter extends RecyclerView.Adapter<MovieWatchlistAdapter.MovieWatchAdapter> {

    private Context mcontext;
    private ArrayList<MovieDb> movieDbs;

    public MovieWatchlistAdapter(Context context, ArrayList<MovieDb> movieDbs) {
        this.mcontext = context;
        this.movieDbs = movieDbs;
    }

    @Override
    public MovieWatchAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_watchlist, parent, false);
        MovieWatchAdapter movieWatchAdapter = new MovieWatchAdapter(view);
        return movieWatchAdapter;
    }

    @Override
    public void onBindViewHolder(MovieWatchAdapter holder, int position) {
        holder.bind(movieDbs.get(position));

    }

    @Override
    public int getItemCount() {
        return movieDbs.size();
    }

    public class MovieWatchAdapter extends RecyclerView.ViewHolder {
        @Bind(R.id.singleLayoutWatchList)
        LinearLayout mlayout;
        @Bind(R.id.singleImageWatchList)
        ImageView mImages;
        @Bind(R.id.singleTextWatchList)
        TextView mText;

        public MovieWatchAdapter(View itemView) {
            super(itemView);
            mcontext = itemView.getContext();
            ButterKnife.bind(this, itemView);

        }

        public void bind(MovieDb movieDb) {
            Picasso.with(mcontext).load(movieDb.getmImageUrl()).into(mImages);
            mText.setText(movieDb.getmMovieTitle());

        }
    }
}
