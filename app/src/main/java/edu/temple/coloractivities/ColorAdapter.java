package edu.temple.coloractivities;

import android.widget.BaseAdapter;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class ColorAdapter extends BaseAdapter {

    Context context;
    String[] colors;

    public ColorAdapter(Context context, String[] colors){
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        String colorValue;

        // Check for recycle view
        if (convertView != null && convertView instanceof TextView)
            textView = (TextView) convertView;
        else
            textView = new TextView(this.context);

        // Change the default, "Select a color", color value to white
        if (position == 0)
            colorValue = "lightgrey";
        else
            colorValue = this.colors[position];
        // Change the black view's text to light grey for visibility

        if (colorValue.equals("Black"))
            textView.setTextColor(Color.LTGRAY);
        else
            textView.setTextColor(Color.BLACK);

        // Set view configs
        textView.setText(this.colors[position]);
        textView.setBackgroundColor(Color.parseColor(colorValue));
        textView.setTextSize(25);
        textView.setPadding(5,5,0,5);

        return textView;
    }
}
