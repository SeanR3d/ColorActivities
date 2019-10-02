package edu.temple.coloractivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colors = {"Select a color", "Red", "Yellow", "Green", "Teal", "Cyan", "Blue",
                "Magenta", "Purple", "Maroon", "Black", "Gray"};

        // Create Adapter
        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        // Obtain spinner
        Spinner colorSpinner = findViewById(R.id.spinner);
        colorSpinner.setAdapter(colorAdapter);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Change textview to white
                view.setBackgroundColor(Color.WHITE);
                ((TextView) view).setTextColor(Color.BLACK);

                //set background to color
                ConstraintLayout layout = findViewById(R.id.layout);

                String colorValue = ((TextView) view).getText().toString();
                if (colorValue.equals("Select a color")) colorValue = "White";

                layout.setBackgroundColor(Color.parseColor(colorValue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


}
