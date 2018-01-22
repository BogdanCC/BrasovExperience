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
public class EntertainmentFragment extends Fragment {

    public EntertainmentFragment() {
        // Required empty public constructor
    }

    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_entertainment, container, false);
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getText(R.string.welcome_entertainment_title), getText(R.string.welcome_entertainment_desc)));
        places.add(new Places(getString(R.string.name_dramatic), getString(R.string.desc_dramatic), R.drawable.dramatic, 4.6f, R.drawable.gradient_cc_opacity_blue_purple,
                "https://www.google.ro/maps/place/Teatrul+Sic%C4%83+Alexandrescu/@45.6456851,25.5986904,15z/data=!4m2!3m1!1s0x0:0xdef9ce358e1b6570?sa=X&ved=0ahUKEwimx4Clg-vYAhUjDsAKHdbhD4gQ_BIIigEwDA"));
        places.add(new Places(getString(R.string.name_reduta), getString(R.string.desc_reduta), R.drawable.reduta, 4.5f, R.drawable.gradient_cc_opacity_blue_purple,
                "https://www.google.ro/maps/place/Reduta+Cultural+Center/@45.6409328,25.5873303,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7b2c04fd79:0xf58f61d79f978bee!8m2!3d45.6409328!4d25.589519"));
        places.add(new Places(getString(R.string.name_cinema), getString(R.string.desc_cinema), R.drawable.cinema, 4.3f, R.drawable.gradient_cc_opacity_blue_purple,
                "https://www.google.ro/maps/place/Cinema+One/@45.6729839,25.6119929,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35befd621aa15:0x5f8b4206654d7f14!8m2!3d45.6729839!4d25.6141815"));
        places.add(new Places(getString(R.string.name_escape_room), getString(R.string.desc_escape_room), R.drawable.escape, 5f, R.drawable.gradient_cc_opacity_blue_purple,
                "https://www.google.ro/maps/place/Obscuria+Escape+Rooms/@45.648983,25.6016093,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b81b115aaef:0x16461fa1b352c6a8!8m2!3d45.648983!4d25.603798"));
        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places);
        gridView = rootView.findViewById(R.id.gridview);
        gridView.setAdapter(placesAdapter);

        return rootView;
    }

}
