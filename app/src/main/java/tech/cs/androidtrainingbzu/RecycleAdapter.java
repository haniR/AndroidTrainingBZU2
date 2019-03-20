package tech.cs.androidtrainingbzu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHoder> {
    private ArrayList<Movie> movieArrayList;

    public RecycleAdapter(ArrayList<Movie> movieList) {
        movieArrayList = movieList;
    }

    @NonNull
    @Override
    public RecycleViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
        RecycleViewHoder rvh = new RecycleViewHoder(v);
        return rvh;    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHoder recycleViewHoder, int i) {
        Movie movie = movieArrayList.get(i);

        recycleViewHoder.mImageView.setImageResource(movie.getImageResource());
        recycleViewHoder.mName.setText(movie.getText1());
        recycleViewHoder.mAddress.setText(movie.getText2());

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public static class RecycleViewHoder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mName;
        public TextView mAddress;

        public RecycleViewHoder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.imageViewRC);
            mName = (TextView)itemView.findViewById(R.id.nameRC);
            mAddress = (TextView)itemView.findViewById(R.id.addressRC);

        }
    }

}
