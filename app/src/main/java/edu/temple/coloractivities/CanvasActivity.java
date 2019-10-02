package edu.temple.coloractivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        Intent intent = getIntent();
        String colorValue = intent.getStringExtra("colorValue");

        //set background to color
        ConstraintLayout layout = findViewById(R.id.canvasLayout);
        layout.setBackgroundColor(Color.parseColor(colorValue));
    }
}
