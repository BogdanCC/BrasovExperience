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
 * Created by bogda on 1/17/2018.
 */

public class PlacesAdapter extends ArrayAdapter<Places> {
    public PlacesAdapter(Activity context, ArrayList<Places> places) {
        super(context, 0, places);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }
        /** Getting the current Places object to set its data to the views */
        final Places currentPlace = getItem(position);

        /** Getting the views that we want to populate with our data */
        ImageView placeImage = listItemView.findViewById(R.id.placeImage);
        TextView placeText = listItemView.findViewById(R.id.placeText);
        TextView placeDesc = listItemView.findViewById(R.id.placeDesc);
        RatingBar placeRating = listItemView.findViewById(R.id.ratingBarSmall);
        LinearLayout linearLayout = listItemView.findViewById(R.id.ratingBarLayout);
        LinearLayout welcomingFooter = listItemView.findViewById(R.id.welcoming_footer);
        LinearLayout cardGradientBg = listItemView.findViewById(R.id.card_gradient_background);
        TextView learnMore = listItemView.findViewById(R.id.learn_more);

        /** Populating the views with our data */
        // If the cardView is the welcoming card, do this
        if(currentPlace.getWelcomingBool()) {
            placeImage.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
            welcomingFooter.setVisibility(View.VISIBLE);
            placeText.setText(currentPlace.getWelcomeTitle());
            placeText.setTextSize(24);
            placeText.setTextColor(getContext().getResources().getColor(R.color.titleColor));
            placeDesc.setText(currentPlace.getWelcomeDesc());
            placeDesc.setTextColor(getContext().getResources().getColor(R.color.titleColor));
            placeDesc.setTextSize(16);
            placeDesc.setMaxLines(5);
            cardGradientBg.setBackgroundResource(R.drawable.gradient);

        }
        // If the cardView is NOT the welcoming card, do this
        else {
            placeImage.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            welcomingFooter.setVisibility(View.GONE);
            placeImage.setImageResource(currentPlace.getPlaceImageId());
            placeText.setText(currentPlace.getPlaceName());
            placeText.setTextSize(22);
            placeText.setTextColor(getContext().getResources().getColor(R.color.titleColor));
            placeDesc.setText(currentPlace.getPlaceDescription());
            placeDesc.setTextColor(getContext().getResources().getColor(R.color.titleColor));
            placeRating.setRating(currentPlace.getPlaceRating());
            placeDesc.setMaxLines(2);
            placeDesc.setTextSize(14);
            cardGradientBg.setBackgroundResource(currentPlace.getGradientId());
            learnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(currentPlace.getUrlLocation()));
                    getContext().startActivity(i);
                }
            });
        }

        return listItemView;
    }
}
