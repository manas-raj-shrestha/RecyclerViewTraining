package com.shilu.recyclerviews;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ShiluShrestha on 9/27/16.
 */
public class MoviesRvAdapter extends RecyclerView.Adapter<MoviesRvAdapter.ViewHolder> {
    private Context context;
    private String[] movieNames;
    private int[] movieIcons;

    public MoviesRvAdapter(MainActivity mainActivity, String[] movieNames, int[] movieIcons) {
        context = mainActivity;
        this.movieIcons = movieIcons;
        this.movieNames = movieNames;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("OnCreateViewHolder", "OnCreateViewHolder");

        View view = LayoutInflater.from(context).inflate(R.layout.rv_movie_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the itemView to reflect the item at the given position.
     * Called by recycler view when a view is about to enter the visible window
     * Only binding takes place here
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Log.e("OnBindViewHolder", String.valueOf(position));

        holder.tvMovieName.setText(movieNames[position]);
        holder.ivMoviePoster.setImageDrawable(ContextCompat.getDrawable(context, movieIcons[position]));

        /**
         * OnClickListener can be defined here of in the holder itself
         * For best practice use an interface to pass the click events to the activity and let activity handle the events
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, movieNames[position] + " clicked at position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieIcons.length;
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     * View holder is important because its is costly to do findViewById each time and for each item type
     * IMP: View holder will not holder your data. So don't define data variables here like "int position"
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMoviePoster;
        TextView tvMovieName;

        public ViewHolder(View itemView) {
            super(itemView);

            ivMoviePoster = (ImageView) itemView.findViewById(R.id.iv_poster);
            tvMovieName = (TextView) itemView.findViewById(R.id.tv_movie_name);
        }
    }
}
