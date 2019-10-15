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
    public final static String BLACK_COLOR_STR = "Black";
    public final static String LTGRAY_COLOR_STR = "lightgrey";

    public ColorAdapter(Context context, String[] colors) {
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
            colorValue = LTGRAY_COLOR_STR;
        else
            colorValue = convertColorLanguage(position);

        // Change the black view's text to light grey for visibility
        if (colorValue.equals(BLACK_COLOR_STR))
            textView.setTextColor(Color.LTGRAY);
        else
            textView.setTextColor(Color.BLACK);

        // Set view configs
        textView.setText(this.colors[position]);
        textView.setBackgroundColor(Color.parseColor(colorValue));
        textView.setTextSize(25);
        textView.setPadding(5, 5, 0, 5);

        return textView;
    }

    /**
     * Takes the index of the color string array and returns the English text value
     * that is parsable by Color.parseColor()
     *
     * @param pos index of color array
     * @return string of English color value
     */
    public static String convertColorLanguage(int pos) {

        switch (pos) {
            case 0:
                return "White";
            case 1:
                return "Red";
            case 2:
                return "Yellow";
            case 3:
                return "Green";
            case 4:
                return "Teal";
            case 5:
                return "Cyan";
            case 6:
                return "Blue";
            case 7:
                return "Magenta";
            case 8:
                return "Purple";
            case 9:
                return "Maroon";
            case 10:
                return "Black";
            case 11:
                return "Gray";
            default:
                return "White";
        }
    }
}
