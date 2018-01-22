package com.example.android.testingapp;

public class Places {
    /** Creating the Places variables for : Places to visit, Reside, Food */
    private String placeName;
    private String placeDescription;
    private int placeImageId;
    private float placeRating;
    private String url;
    private String urlLocation;
    private int gradientId;
    private String restaurantType;
    private String restaurantName;

    /** Creating variables for welcoming cardView */
    private CharSequence welcomeTitle;
    private CharSequence welcomeDesc;
    private boolean isWelcoming;

    /** Creating places constructor */
    public Places(String name, String description, int imgId, float rating, int gradientId, String location) {
        this.placeImageId = imgId;
        this.placeName = name;
        this.placeDescription = description;
        this.placeRating = rating;
        this.gradientId = gradientId;
        this.urlLocation = location;
        this.isWelcoming = false;
    }

    /** Creating constructor for welcoming info */
    public Places(CharSequence welcomeTitle, CharSequence welcomeDesc) {
        this.welcomeTitle = welcomeTitle;
        this.welcomeDesc = welcomeDesc;
        this.isWelcoming = true;
    }
    /** Creating constructor for hotels */
    public Places(String title, String url, String urlLoc, float rating, int imgId, int gradient) {
        this.placeName = title;
        this.placeRating = rating;
        this.placeImageId = imgId;
        this.url = url;
        this.gradientId = gradient;
        this.urlLocation = urlLoc;
    }

    /** Creating constructor for food */
    public Places(String rName, String rType, int gradientId, int imgId, String location, String url) {
        this.restaurantName = rName;
        this.restaurantType = rType;
        this.gradientId = gradientId;
        this.placeImageId = imgId;
        this.urlLocation = location;
        this.url = url;
    }

    /** Creating the getter methods to use the info in the adapter */
    public String getPlaceName() {
        return placeName;
    }
    public int getPlaceImageId() {
        return placeImageId;
    }
    public String getPlaceDescription(){
        return placeDescription;
    }
    public float getPlaceRating(){
        return placeRating;
    }
    public CharSequence getWelcomeTitle(){
        return welcomeTitle;
    }
    public CharSequence getWelcomeDesc(){
        return welcomeDesc;
    }
    public boolean getWelcomingBool() {
        return isWelcoming;
    }
    public String getUrl(){
        return url;
    }
    public int getGradientId(){
        return gradientId;
    }
    public String getUrlLocation(){
        return urlLocation;
    }
    public String getRestaurantName(){
        return restaurantName;
    }
    public String getRestaurantType(){
        return restaurantType;
    }
}
