package edu.temple.coloractivities;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    public final static String colorKey = "colorKey";
    private View view;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String colorValue) {
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(colorKey, colorValue);
        canvasFragment.setArguments(args);
        return canvasFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_canvas, container, false);
        return view;
    }

    public void updateCanvasView(String colorValue) {
        // Set background to color
        view.setBackgroundColor(Color.parseColor(colorValue));
    }

}
