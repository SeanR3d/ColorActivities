package edu.temple.coloractivities;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements PaletteFragment.OnColorSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.palette_fragment, new PaletteFragment()).addToBackStack(null);
        fragmentTransaction.add(R.id.canvas_fragment, new CanvasFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof PaletteFragment) {
            PaletteFragment paletteFragment = (PaletteFragment) fragment;
            paletteFragment.setOnColorSelectedListener(this);
        }

    }

    @Override
    public void OnColorSelected(String colorValue) {
        //  Send color to canvas fragment

        CanvasFragment canvasFragment = (CanvasFragment) getSupportFragmentManager()
                .findFragmentById(R.id.canvas_fragment);

        if (canvasFragment != null) {
            canvasFragment.updateCanvasView(colorValue);
        } else {
            CanvasFragment newFragment = CanvasFragment.newInstance(colorValue);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.canvas_fragment, newFragment)
                    .commit();

        }

    }
}
