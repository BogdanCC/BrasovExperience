package com.example.android.testingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResideFragment extends Fragment {


    public ResideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and save it in this variable
        // We will use the variable to access ids in this fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_reside, container, false);

        // Create an array list that holds Places objects
        ArrayList<Places> residePlaces = new ArrayList<>();


        // Add object instances to the array list
        residePlaces.add(new Places(getString(R.string.toscana),
                "https://www.tripadvisor.com/Hotel_Review-g295394-d5856995-Reviews-Pensiunea_Toscana-Brasov_Brasov_County_Central_Romania_Transylvania.html",
                "https://www.google.ro/maps/place/Toscana/@45.643685,25.57719,15.5z/data=!4m5!3m4!1s0x0:0xfd54653cd40855a0!8m2!3d45.643787!4d25.578249",
                4.8f, R.drawable.toscana, R.drawable.gradient_a6_opacity_blue_purple));
        residePlaces.add(new Places(getString(R.string.kronwell),
                "https://www.tripadvisor.com/Hotel_Review-g295394-d3971858-Reviews-Kronwell_Hotel-Brasov_Brasov_County_Central_Romania_Transylvania.html",
                "https://www.google.ro/maps/place/Kronwell/@45.660292,25.6125853,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b8bd1972f91:0x32f07490089673c8!8m2!3d45.660292!4d25.614774",
                4.5f, R.drawable.kronwell, R.drawable.gradient_a6_opacity_purple_red));
        residePlaces.add(new Places(getString(R.string.belfort),
                "https://www.tripadvisor.com/Hotel_Review-g295394-d12297377-Reviews-Hotel_Belfort-Brasov_Brasov_County_Central_Romania_Transylvania.html",
                "https://www.google.ro/maps/place/Belfort+Hotel+Brasov/@45.6429029,25.5971169,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7ddbfdaa05:0xfcd2aabd19e480a8!8m2!3d45.6429029!4d25.5993057",
                4.6f, R.drawable.belfort, R.drawable.gradient_a6_opacity_red_yellow));
        residePlaces.add(new Places(getString(R.string.bella_vista),
                "https://www.tripadvisor.com/Hotel_Review-g295394-d1056930-Reviews-Bella_Vista-Brasov_Brasov_County_Central_Romania_Transylvania.html",
                "https://www.google.ro/maps/place/Bella+Vista/@45.603446,25.6774104,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35d648bc30721:0xc31bcb1e098924d8!8m2!3d45.603446!4d25.6795992",
                5.0f, R.drawable.bellavista, R.drawable.gradient_a6_opacity_blue_purple));

        /**
         * Create an instance of the custom adapter (ResideAdapter) that we created
         * Our custom adapter will use the reside_list_item layout to inflate or display our residePlaces data
         * */
        ResideAdapter resideAdapter = new ResideAdapter(getActivity(), residePlaces);
        /**
         * Set the custom adapter to the ListView inside our fragment
         * Each list item in the ListView will contain the reside_list_item layout with the data from our array list
         * And the resideAdapter holds the instructions on how to display the data in the reside_list_item layout
         * */
        ListView lv = rootView.findViewById(R.id.listview);
        lv.setAdapter(resideAdapter);

        // return fragment_reside as inflated view
        return rootView;
    }

}
