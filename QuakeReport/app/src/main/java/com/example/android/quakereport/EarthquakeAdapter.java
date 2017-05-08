package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dewayneallen on 5/8/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Constructs a new {@link EarthquakeAdapter}
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data from the adapter
     */

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0 , earthquakes);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the current position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView with the view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Display the magnitude for the current earthquake in that TextView
        magnitudeView.setText(currentEarthquake.getMagnitude());

        // Find the TextView with the view ID location
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        // Display the location for the current earthquake in that TextView
        locationView.setText(currentEarthquake.getLocation());

        // Find the TextView with the view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date for the current earthquake in that TextView
        dateView.setText(currentEarthquake.getDate());

        // Return the list item view that is now showing the appropriate data
        return  listItemView;
    }
}
