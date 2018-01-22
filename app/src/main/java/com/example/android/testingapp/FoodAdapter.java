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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bogda on 1/20/2018.
 */

public class FoodAdapter extends ArrayAdapter<Places> {
    public FoodAdapter(Activity context, ArrayList<Places> foods) {

        super(context, 0, foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.food_list_item, parent, false);
        }
        final Places currentPlace = getItem(position);

        // Method to expand and collapse info layout
        ImageView expand = listItemView.findViewById(R.id.collapse_button);
        LinearLayout goBack = listItemView.findViewById(R.id.food_back);
        final FrameLayout expandedFood = listItemView.findViewById(R.id.expanded_food);
        final LinearLayout infoLayout= listItemView.findViewById(R.id.collapsed_layout);

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    infoLayout.setVisibility(View.VISIBLE);
                    expandedFood.setVisibility(View.GONE);
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    infoLayout.setVisibility(View.GONE);
                    expandedFood.setVisibility(View.VISIBLE);
            }
        });
        TextView rTitle = listItemView.findViewById(R.id.restaurant_title);
        TextView rType = listItemView.findViewById(R.id.restaurant_type);
        LinearLayout bGradient = listItemView.findViewById(R.id.food_gradient_bg);
        ImageView rImage = listItemView.findViewById(R.id.restaurant_image);
        ImageView circleR = listItemView.findViewById(R.id.circle_r_image);
        LinearLayout location = listItemView.findViewById(R.id.location);
        LinearLayout website = listItemView.findViewById(R.id.website);

        circleR.setImageResource(currentPlace.getPlaceImageId());
        rTitle.setText(currentPlace.getRestaurantName());
        rType.setText(currentPlace.getRestaurantType());
        bGradient.setBackgroundResource(currentPlace.getGradientId());
        rImage.setImageResource(currentPlace.getPlaceImageId());
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(currentPlace.getUrlLocation()));
                getContext().startActivity(i);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(currentPlace.getUrl()));
                getContext().startActivity(i);
            }
        });

        return listItemView;
    }
}
