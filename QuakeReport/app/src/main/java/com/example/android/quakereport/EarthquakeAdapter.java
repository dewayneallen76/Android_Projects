package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dewayneallen on 5/8/17.
 */


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * The part of the location string from USGS service that we use to determine whether or not
     * there is a location offset present ("5km N of Cairo, Egypt)
     */
    private static final String LOCATION_SEPERATOR = "of";

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
        // Format the magnitude to show a 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        // Display the magnitude for the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);


        // Get the original location string from the Earthquake object,
        // which could be in the format "5km N of Cairo, Egypt" or "Pacific Antartic Ridge"
        String originalLocation = currentEarthquake.getLocation();

        // If the original location string (i.e. "5km N of Cairo, Egypt") contains a primary
        // location (Cairo, Egypt) and a location offset (5km N of) then store the primary location
        // seperately from the location_offset in 2 strings, so they can be displayed in 2 text views
        String primaryLocation;
        String locationOffset;

        // Check whether the originalLocation string contains the "of" text
        if (originalLocation.contains(LOCATION_SEPERATOR)) {
            // Split the string into different parts (as an array of Strings) based on the "of" text.
            // We expect an array of 2 Strings, where the first string will be "5km N" and the second
            // string will be "Cairo, Egypt".
            String[] parts = originalLocation.split(LOCATION_SEPERATOR);
            // Location offset should be "5km N" + "of" ---> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPERATOR;
            // Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        } else {
            // Otherwise, there is not "of" text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = getContext().getString(R.string.near_the);
            // The primary location will be the full location string "Pacific-Antartic Range"
            primaryLocation = originalLocation;
        }

        // Find the TextView with the view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Display the location for the current earthquake in that TextView
        primaryLocationView.setText(primaryLocation);

        // Find the TextView with the view ID location offset
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Display the location for the current earthquake in that TextView
        locationOffsetView.setText(locationOffset);

        // Set a new date object from the time in milliseconds of the earthquake.
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with the view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date for the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with the view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string
        String formattedTime = formatTime(dateObject);
        // Display the time for the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return  listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted time string (i.e. "4:30pm") from a Date object
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing a 1 decimal place (i.e. 3.2) from a
     * decimal magnitude
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return  magnitudeFormat.format(magnitude);
    }
}
