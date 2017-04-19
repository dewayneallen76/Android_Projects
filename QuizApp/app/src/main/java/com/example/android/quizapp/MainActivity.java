package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        // Gets the name entered in the edit text view
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Checks to see if the correct checkboxes are selected for question 1
        CheckBox checkbox1Question1 = (CheckBox) findViewById(R.id.checkbox1_question1);
        boolean hasCheckbox1Question1 = checkbox1Question1.isChecked();

        CheckBox checkbox2Question1 = (CheckBox) findViewById(R.id.checkbox2_question1);
        boolean hasCheckbox2Question1 = checkbox2Question1.isChecked();

        // Gets the name entered in the best player field
        EditText playerField = (EditText) findViewById(R.id.best_player_field);
        String bestPlayer = nameField.getText().toString();

        calculateScore(hasCheckbox1Question1, hasCheckbox2Question1);
        displayScore(score);
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasCheckbox1Question1 is whether the user has selected the correct answer checkbox
     * @param hasCheckbox2Question1 is whether the user has selected the correct answer checkbox
     * @return total score
     */
    public int calculateScore(boolean hasCheckbox1Question1, boolean hasCheckbox2Question1) {
        int totalScore;
        // Check to see if the correct answers are selected for question 1
        if(hasCheckbox1Question1 && hasCheckbox2Question1) {
            score = score + 5;
        }
        return score;
    }

    /**
     * This method displays the total score on the screen.
     */
    public void displayScore(int totalScore) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText("" + totalScore);
    }
}
