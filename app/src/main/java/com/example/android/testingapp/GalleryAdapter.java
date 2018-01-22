package com.example.android.testingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bogda on 1/21/2018.
 */

public class GalleryAdapter extends ArrayAdapter<Gallery> {
    public GalleryAdapter(Context context, ArrayList<Gallery> galleryInfo) {
        super(context, 0, galleryInfo);
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.gallery_list_item, parent, false);
        }
        /** Get the current Gallery object */
        Gallery currentGalleryObject = getItem(position);

        /** Get the views that we want to populate with our data */
        ImageView imageView = listItemView.findViewById(R.id.list_item_image);
        TextView imageSender = listItemView.findViewById(R.id.list_item_sender);
        RelativeLayout gradientLayout = listItemView.findViewById(R.id.photo_info_gradient);

        /** Populate views with our data from our current Gallery object */
        imageSender.setText(currentGalleryObject.getSender());
        imageView.setImageResource(currentGalleryObject.getImageId());
        gradientLayout.setBackgroundResource(currentGalleryObject.getGradientId());

        return listItemView;
    }
}
