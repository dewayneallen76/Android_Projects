package com.example.android.quakereport;

/**
 * Created by dewayneallen on 5/8/17.
 */


/**
 * An {@link Earthquake} object contains information about a single earthquake.
 */
public class Earthquake {

    /** Magnitude of the earthquake */
    private double mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Date of the earthquake */
    private String mDate;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude is the magnitude (size) of the earthquake.
     * @param location is the location of the earthquake.
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch)
     *                           when the earthquake occurred.
     * @param url is the website url to find more details about the earthquake.
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * Returns the magnitude of the earthquake
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /** Returns the location of the earthquake */
    public String getLocation() {
        return mLocation;
    }

    /** Returns the date of the earthquake */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /** Returns the website URL to get more information about the earthquake */
    public String getUrl() {
        return mUrl;
    }

}
