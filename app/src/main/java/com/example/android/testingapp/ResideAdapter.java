package com.example.android.testingapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bogda on 1/19/2018.
 */

public class ResideAdapter extends ArrayAdapter<Places> {
    public ResideAdapter(Activity context, ArrayList<Places> places) {
        super(context, 0, places);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.reside_list_item, parent, false);
        }

        /** Getting the current Places object to set its data to the views */
        final Places currentPlace = getItem(position);

        /** Find the list item views so we can manipulate them */
        ImageView hotelImage = listItemView.findViewById(R.id.hotel_image);
        TextView hotelName = listItemView.findViewById(R.id.hotel_title);
        LinearLayout hotelUrl = listItemView.findViewById(R.id.hotel_website);
        RatingBar rb = listItemView.findViewById(R.id.ratingBarSmall);
        View gradient = listItemView.findViewById(R.id.gradient);
        LinearLayout hotelLocUrl = listItemView.findViewById(R.id.hotel_location);

        /** Manipulate views */
        gradient.setBackgroundResource(currentPlace.getGradientId());
        hotelImage.setImageResource(currentPlace.getPlaceImageId());
        hotelName.setText(currentPlace.getPlaceName());
        rb.setRating(currentPlace.getPlaceRating());

        // Create a new Intent instance
        final Intent i = new Intent(Intent.ACTION_VIEW);
        // Set a click listener to open correct website for each item
        hotelUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set the URL by accessing the current Places object's 'getUrl()' method
                i.setData(Uri.parse(currentPlace.getUrl()));
                // Open the browser
                getContext().startActivity(i);
            }
        });
        // Set a click listener to open correct website for each item
        hotelLocUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set the URL by accessing the current Places object's 'getUrlLocation()' method
                i.setData(Uri.parse(currentPlace.getUrlLocation()));
                // Open the browser
                getContext().startActivity(i);
            }
        });
        return listItemView;
    }
}
