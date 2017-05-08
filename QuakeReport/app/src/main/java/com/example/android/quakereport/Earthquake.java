package com.example.android.quakereport;

/**
 * Created by dewayneallen on 5/8/17.
 */


/**
 * An {@link Earthquake} object contains information about a single earthquake.
 */
public class Earthquake {

    /** Magnitude of the earthquake */
    private String mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Date of the earthquake */
    private String mDate;

    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude is the magnitude (size) of the earthquake.
     * @param location is the location of the earthquake.
     * @param date is the date that the earthquake occurred.
     *
     */
    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /** Returns the magnitude of the earthquake */
    public String getMagnitude() {
        return mMagnitude;
    }

    /** Returns the location of the earthquake */
    public String getLocation() {
        return mLocation;
    }

    /** Returns the date of the earthquake */
    public String getmDate() {
        return mDate;
    }


}
