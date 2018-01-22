package com.example.android.testingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView playButton;
    ImageView routesButton;
    Intent goToVideo;
    Intent mainAppActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.play);
        routesButton = findViewById(R.id.route);
        goToVideo = new Intent(this, VideoActivity.class);
        mainAppActivity = new Intent(this, MainAppActivity.class);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToVideo);
                MainActivity.this.onStop();
            }
        });
        routesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainAppActivity);
            }
        });

    }
}

