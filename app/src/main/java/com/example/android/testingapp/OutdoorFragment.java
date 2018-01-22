package com.example.android.testingapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class OutdoorFragment extends Fragment {
    public OutdoorFragment() {
        // Required empty public constructor
    }
    private GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_outdoor, container, false);
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getText(R.string.welcome_outdoors_title), getText(R.string.welcome_outdoors_desc)));
        places.add(new Places(getString(R.string.name_tampa), getString(R.string.desc_tampa),
                R.drawable.tampa, 4.7f, R.drawable.gradient_cc_opacity_blue_green, "https://www.google.ro/maps/place/T%C3%A2mpa/@45.6340677,25.5753376,14z/data=!3m1!4b1!4m5!3m4!1s0x40b35b61e51e4dc7:0xa82ef9504a68e005!8m2!3d45.6340695!4d25.5928472!5m1!1e4"));
        places.add(new Places(getString(R.string.name_zoo), getString(R.string.desc_zoo),
                R.drawable.zoo, 4.4f, R.drawable.gradient_cc_opacity_blue_green, "https://www.google.ro/maps/place/Parcul+Zoologic/@45.613929,25.633153,15z/data=!4m5!3m4!1s0x0:0xac80b8e1fb4fd4bd!8m2!3d45.613929!4d25.633153"));
        places.add(new Places(getString(R.string.name_park_aventura), getString(R.string.desc_park_aventura),
                R.drawable.aventura, 4.7f, R.drawable.gradient_cc_opacity_blue_green, "https://www.google.ro/maps/place/Adventure+Park+Brasov/@45.614058,25.6353243,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35cd89169b7b5:0x32767f2cc427e4c5!8m2!3d45.614058!4d25.637513"));
        places.add(new Places(getString(R.string.name_poiana), getString(R.string.desc_poiana),
                R.drawable.poiana, 5f, R.drawable.gradient_cc_opacity_blue_green, "https://www.google.ro/maps/place/Poiana+Bra%C8%99ov,+Bra%C8%99ov/@45.5915365,25.525714,14z/data=!3m1!4b1!4m5!3m4!1s0x40b3449e0439a589:0xf790f8ae21edd7c8!8m2!3d45.5955044!4d25.5513291"));
        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places);
        gridView = rootView.findViewById(R.id.gridview);
        gridView.setAdapter(placesAdapter);

        return rootView;
    }

}
