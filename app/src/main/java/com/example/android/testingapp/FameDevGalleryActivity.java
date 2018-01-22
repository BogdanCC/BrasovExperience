package com.example.android.testingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class FameDevGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fame_dev_gallery);

        // Make the app full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Creating array list of Gallery objects
        ArrayList<Gallery> galleryInfo = new ArrayList<>();
        galleryInfo.add(new Gallery("Sent by : Dev 1", R.drawable.bran, R.drawable.gradient_cc_opacity_blue_purple));
        galleryInfo.add(new Gallery("Sent by : Dev 2", R.drawable.poiana, R.drawable.gradient_cc_opacity_pruple_red));
        galleryInfo.add(new Gallery("Sent by : Dev 3", R.drawable.cetate, R.drawable.gradient_cc_opacity_red_yellow));
        galleryInfo.add(new Gallery("Sent by : Dev 4", R.drawable.bran, R.drawable.gradient_cc_opacity_blue_purple));
        galleryInfo.add(new Gallery("Sent by : Dev 5", R.drawable.poiana, R.drawable.gradient_cc_opacity_pruple_red));
        galleryInfo.add(new Gallery("Sent by : Dev 6", R.drawable.cetate, R.drawable.gradient_cc_opacity_red_yellow));
        galleryInfo.add(new Gallery("Sent by : Dev 7", R.drawable.bran, R.drawable.gradient_cc_opacity_blue_purple));
        galleryInfo.add(new Gallery("Sent by : Dev 8", R.drawable.brasov, R.drawable.gradient_cc_opacity_pruple_red));

        // Find list view to set our custom adapter to it
        ListView listView = findViewById(R.id.dev_gallery_list);

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
