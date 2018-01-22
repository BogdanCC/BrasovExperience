package com.example.android.testingapp;

/**
 * Created by bogda on 1/21/2018.
 */

public class Gallery {

    private String sender;
    private int imageId;
    private int gradientId;

    public Gallery(String sender, int imageId, int gradientId){
        this.sender = sender;
        this.gradientId = gradientId;
        this.imageId = imageId;
    }

    public String getSender() {
        return sender;
    }
    public int getImageId() {
        return imageId;
    }
    public int getGradientId(){
        return gradientId;
    }
}
