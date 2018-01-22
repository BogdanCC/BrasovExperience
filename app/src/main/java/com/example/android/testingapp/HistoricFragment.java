package com.example.android.testingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricFragment extends Fragment {


    public HistoricFragment() {
        // Required empty public constructor
    }

    private GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_historic, container, false);
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getText(R.string.welcome_historic_title), getText(R.string.welcome_historic_desc)));
        places.add(new Places(getString(R.string.name_bran), getString(R.string.desc_bran),
                R.drawable.bran, 4.3f, R.drawable.gradient_cc_opacity_red_yellow, "https://www.google.ro/maps/place/Bran+Castle/@45.5149022,25.364975,17z/data=!3m1!4b1!4m5!3m4!1s0x40b347e5a415de31:0xcf922792d921ab7f!8m2!3d45.5149022!4d25.3671637"));
        places.add(new Places(getString(R.string.name_citadel), getString(R.string.desc_citadel),
                R.drawable.cetate, 4.4f, R.drawable.gradient_cc_opacity_red_yellow, "https://www.google.ro/maps/place/Cet%C4%83%C8%9Buia+de+pe+Straj%C4%83/@45.6493021,25.5918922,15z/data=!4m2!3m1!1s0x0:0x3a9b5328fa8d7e42?sa=X&ved=0ahUKEwiHs5Hkg-vYAhWMBsAKHWYXCycQ_BIIqAEwDg"));
        places.add(new Places(getString(R.string.name_biserica_neagra), getString(R.string.desc_biserica_neagra),
                R.drawable.biserica, 4.5f, R.drawable.gradient_cc_opacity_red_yellow, "https://www.google.ro/maps/place/Rat+Brasov+-+Black+Church/@45.6493021,25.5918922,15z/data=!4m5!3m4!1s0x40b35b6542e21635:0x9fdd3236835f8e6e!8m2!3d45.6404076!4d25.5856186"));
        places.add(new Places(getString(R.string.name_turn_alb), getString(R.string.desc_turn_alb),
                R.drawable.turn, 4.5f, R.drawable.gradient_cc_opacity_red_yellow, "https://www.google.ro/maps/place/Turnul+Alb/@45.6404076,25.5834299,17z/data=!4m5!3m4!1s0x40b35b70766e49b1:0x344fbeabe1083928!8m2!3d45.6428816!4d25.5865014"));
        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places);
        gridView = rootView.findViewById(R.id.gridview);
        gridView.setAdapter(placesAdapter);

        return rootView;
    }

}
