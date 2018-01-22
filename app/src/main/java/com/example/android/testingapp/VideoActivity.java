package com.example.android.testingapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by bogda on 11/30/2017.
 */

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        videoView = findViewById(R.id.video_view);
        mediaController = new MediaController(this);
        String videoPath = "android.resource://com.example.android.testingapp/" + R.raw.video;
        Uri videoData = Uri.parse(videoPath);
        videoView.setVideoURI(videoData);
        videoView.setVisibility(View.VISIBLE);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Intent goBack = new Intent(VideoActivity.this, MainActivity.class);
                startActivity(goBack);
            }
        });
    }


}
