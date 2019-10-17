package edu.temple.coloractivities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    OnColorSelectedListener callback;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public void setOnColorSelectedListener(OnColorSelectedListener callback){
        this.callback = callback;
    }

    public interface OnColorSelectedListener {
        public void OnColorSelected(String colorValue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_palette, container, false);

        String[] colors_array = getResources().getStringArray(R.array.colors_array);

        // Create Adapter
        final ColorAdapter colorAdapter = new ColorAdapter(this.getContext(), colors_array);

        // Obtain spinner
        Spinner colorSpinner = view.findViewById(R.id.spinner);
        colorSpinner.setAdapter(colorAdapter);
        colorSpinner.setSelection(0, false);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Change textview to white
                view.setBackgroundColor(Color.WHITE);
                ((TextView) view).setTextColor(Color.BLACK);

                if (position != 0) {
                    String colorValue = ColorAdapter.convertColorLanguage(position);

                    // Send the event to the host activity
                    callback.OnColorSelected(colorValue);

//                    Intent intent = new Intent(parent.getContext(), CanvasActivity.class);
//                    intent.putExtra("colorValue", colorValue);
//                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

}
