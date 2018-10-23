package com.nuturetech.safelybuy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nuturetech.safelybuy.R;

public class SliderWelcome4 extends Fragment {
    private static ImageView imageViewSafety;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slider_4, container, false);
        imageViewSafety = view.findViewById(R.id.products_image);
        return view;
    }
}
