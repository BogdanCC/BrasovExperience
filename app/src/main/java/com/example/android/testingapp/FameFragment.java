package com.example.android.testingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FameFragment extends Fragment {


    public FameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fameView = inflater.inflate(R.layout.fragment_fame, container, false);
        CardView userGallery = fameView.findViewById(R.id.user_gallery);
        CardView devGallery = fameView.findViewById(R.id.dev_gallery);
        userGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FameGalleryActivity.class);
                startActivity(i);
            }
        });
        devGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), FameDevGalleryActivity.class);
                startActivity(i);
            }
        });
        return fameView;
    }

}
