package com.mameen.getmumm.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mameen.getmumm.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GalleryAdapter extends ParentRecyclerAdapter<File> {

    static final String TAG = GalleryAdapter.class.getSimpleName();

    public GalleryAdapter(Context context, List<File> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public ParentRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        holder.setOnItemClickListener(itemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ParentRecyclerViewHolder holder, int position) {
        ViewHolder viewholder = (ViewHolder) holder;

            try {
                Picasso.get()
                        .load(data.get(position))
                        .resize(150, 150)
                        .placeholder(R.color.overlay)
                        .error(R.color.overlay)
                        .into(viewholder.img);
            } catch (Exception e) {
                Log.e(TAG, "Error: " + e.getMessage());
            }


    }

    private class ViewHolder extends ParentRecyclerViewHolder {

        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);

            setClickableRootView(itemView);
        }
    }
}
