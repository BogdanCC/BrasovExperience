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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);

        ArrayList<Places> foods = new ArrayList<>();
        foods.add(new Places("The Hockey Pub", "Cosy, Casual, Groups", R.drawable.gradient_a6_opacity_blue_purple, R.drawable.hockeypub,
                "https://www.google.ro/maps/place/The+Hockey+Pub/@45.64134,25.5900323,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7b6f4e4071:0x2c5a81b9f06dcf48!8m2!3d45.64134!4d25.592221",
                "https://www.google.ro/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwi5nMKOhuvYAhXIIMAKHWQFDf4QFggoMAA&url=https%3A%2F%2Fwww.facebook.com%2FTheHockeyPubBrasov%2F&usg=AOvVaw2yWKqczMbrF5vc4lGTprNK"));
        foods.add(new Places("Four Roses", "Breakfast, Cosy, Casual", R.drawable.gradient_a6_opacity_purple_red, R.drawable.fourroses,
                "https://www.google.ro/maps/place/Four+Roses/@45.6651459,25.6010993,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b687ea3167d:0xaf08b281422b1c21!8m2!3d45.6651459!4d25.603288",
                "https://restaurant-four-roses.ro/"));
        foods.add(new Places("Bistro de l'Arte", "Late night food", R.drawable.gradient_a6_opacity_red_yellow, R.drawable.bistro,
                "https://www.google.ro/maps/place/Bistro+de+l'Arte/@45.6432268,25.5886066,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7a53754ef7:0x6730f2384d79f4f2!8m2!3d45.6432268!4d25.5907953",
                "http://www.bistrodelarte.ro/"));
        foods.add(new Places("Dei Frati", "Great cocktails", R.drawable.gradient_a6_opacity_blue_purple, R.drawable.deifrati,
                "https://www.google.ro/maps/place/Dei+Frati/@45.6428676,25.5876668,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7af8390a11:0x7ef532547adcaeac!8m2!3d45.6428676!4d25.5898555",
                "https://www.google.ro/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwilgOrqhuvYAhVoLMAKHSYNBe4QFggoMAA&url=https%3A%2F%2Fwww.facebook.com%2FDeifrati%2F&usg=AOvVaw1VVqSnAUJWzn9RD2FG0kZE"));
        foods.add(new Places("Prato", "Great cocktails", R.drawable.gradient_a6_opacity_purple_red, R.drawable.prato,
                "https://www.google.ro/maps/place/Prato/@45.643776,25.5885229,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7a48b1a89b:0x572ff245c56c730!8m2!3d45.643776!4d25.5907116",
                "http://www.prato.ro/lang/en.html"));
        foods.add(new Places("Keller Steak House", "Cosy, Good for kids", R.drawable.gradient_a6_opacity_red_yellow, R.drawable.keller,
                "https://www.google.ro/maps/place/Keller+Steak+House/@45.6413646,25.5870902,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b7ad8ebf5f1:0xda2dc80925c13e25!8m2!3d45.6413646!4d25.5892789",
                "http://www.kellersteakhouse.ro/en/"));
        foods.add(new Places("Vanilla The Lounge", "Happy hour food", R.drawable.gradient_a6_opacity_blue_purple, R.drawable.vanilla,
                "https://www.google.ro/maps/place/Vanilla+Lounge+%26+Games/@45.6608859,25.6084352,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b8c1e998dd7:0x76429087f139d377!8m2!3d45.6608859!4d25.6106239",
                "http://www.vanillanight.ro/vanilla-lounge-games"));
        foods.add(new Places("Pizzeria della Nonna", "Cosy, Casual", R.drawable.gradient_a6_opacity_purple_red, R.drawable.pizzeria,
                "https://www.google.ro/maps/place/Pizzeria+della+Nonna/@45.6496646,25.5977319,17z/data=!3m1!4b1!4m5!3m4!1s0x40b35b823c6b656f:0x4860aa72094a2d74!8m2!3d45.6496646!4d25.5999206",
                "http://www.pizzanonna.ro/"));

        FoodAdapter placesAdapter = new FoodAdapter(getActivity(), foods);

        ListView lv = rootView.findViewById(R.id.food_list_view);
        lv.setAdapter(placesAdapter);

        return rootView;
    }
}