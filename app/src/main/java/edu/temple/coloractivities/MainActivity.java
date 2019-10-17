package edu.temple.coloractivities;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements PaletteFragment.OnColorSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.palette_activity_title);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.palette_fragment, new PaletteFragment());
        fragmentTransaction.commit();


//        {"Select a color", "Red", "Yellow", "Green", "Teal", "Cyan", "Blue",
//                "Magenta", "Purple", "Maroon", "Black", "Gray"};
//        String[] colors_array = getResources().getStringArray(R.array.colors_array);

//        // Create Adapter
//        final ColorAdapter colorAdapter = new ColorAdapter(MainActivity.this, colors_array);
//
//        // Obtain spinner
//        Spinner colorSpinner = findViewById(R.id.spinner);
//        colorSpinner.setAdapter(colorAdapter);
//        colorSpinner.setSelection(0, false);
//
//        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                //Change textview to white
//                view.setBackgroundColor(Color.WHITE);
//                ((TextView) view).setTextColor(Color.BLACK);
//
//                if (position != 0) {
//                    String colorValue = colorAdapter.convertColorLanguage(position);
//                    Intent intent = new Intent(MainActivity.this, CanvasActivity.class);
//                    intent.putExtra("colorValue", colorValue);
//                    startActivity(intent);
//                }
//
//            }

//        });

    }

    @Override
    public void onAttachFragment(Fragment fragment){
        if (fragment instanceof  PaletteFragment){
            PaletteFragment paletteFragment = (PaletteFragment) fragment;
            paletteFragment.setOnColorSelectedListener(this);
        }
    }

    @Override
    public void OnColorSelected(String colorValue) {
        //  Send color to canvas fragment
        ;
    }
}
