package edu.temple.coloractivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        setTitle(R.string.palette_activity_title);

//        {"Select a color", "Red", "Yellow", "Green", "Teal", "Cyan", "Blue",
//                "Magenta", "Purple", "Maroon", "Black", "Gray"};
        String[] colors_array = getResources().getStringArray(R.array.colors_array);

        // Create Adapter
        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors_array);

        // Obtain spinner
        Spinner colorSpinner = findViewById(R.id.spinner);
        colorSpinner.setAdapter(colorAdapter);
        colorSpinner.setSelection(0, false);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Change textview to white
                view.setBackgroundColor(Color.WHITE);
                ((TextView) view).setTextColor(Color.BLACK);

                String colorValue = ((TextView) view).getText().toString();
                if (colorValue.equals("Select a color"))
                    colorValue = "White";
                else {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("colorValue", colorValue);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


}
