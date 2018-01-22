package com.example.android.testingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bogda on 1/19/2018.
 */

public class FameGalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fame_gallery);

        // Make the app full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set a custom Toolbar to replace the ActionBar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Creating array list of Gallery objects
        ArrayList<Gallery> galleryInfo = new ArrayList<>();
        galleryInfo.add(new Gallery("Sent by : User 1", R.drawable.brasov, R.drawable.gradient_cc_opacity_red_yellow));
        galleryInfo.add(new Gallery("Sent by : User 2", R.drawable.bran, R.drawable.gradient_cc_opacity_blue_purple));
        galleryInfo.add(new Gallery("Sent by : User 3", R.drawable.poiana, R.drawable.gradient_cc_opacity_pruple_red));
        galleryInfo.add(new Gallery("Sent by : User 4", R.drawable.cetate, R.drawable.gradient_cc_opacity_red_yellow));
        galleryInfo.add(new Gallery("Sent by : User 5", R.drawable.bran, R.drawable.gradient_cc_opacity_blue_purple));
        galleryInfo.add(new Gallery("Sent by : User 6", R.drawable.poiana, R.drawable.gradient_cc_opacity_pruple_red));
        galleryInfo.add(new Gallery("Sent by : User 7", R.drawable.cetate, R.drawable.gradient_cc_opacity_red_yellow));
        galleryInfo.add(new Gallery("Sent by : User 8", R.drawable.bran, R.drawable.gradient_cc_opacity_blue_purple));

        // Find list view to set our custom adapter to it
        ListView listView = findViewById(R.id.user_gallery_list);

        // Create a GalleryAdapter object and set it to the list view
        GalleryAdapter customAdapter = new GalleryAdapter(this, galleryInfo);
        listView.setAdapter(customAdapter);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
