package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Array list with strings for numbers (english translation)
        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        // Find the root view so that we can add child views to it
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
        // Initialize variable to keep track of the current index position
        int index = 0;
        // Keep looping until we've reached the end of the list (keep looping as long
        // as the current index position is less than the length of the list)
        while (index < words.size()) {
            // Create a new text view
            TextView wordView = new TextView(this);
            // Set the text to be the word at the index
            wordView.setText(words.get(index));
            // Add this text as a child view to the root view
            rootView.addView(wordView);
            // Increment the index value by 1
            index++;
        }
    }
}
