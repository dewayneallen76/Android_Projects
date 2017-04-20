package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Set variable for score with initial value of 0.
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * User enters name, selects answers for questions, and provides input for the final question.
     * When the user clicks the submit button the results will display on the screen.
     * @param view displays to the quiz_summary_text view
     */
    public void submitQuiz(View view) {
        // Gets the name entered in the edit text view
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //Checks to see if the correct checkboxes are selected for question 1
        CheckBox checkbox1Question1 = (CheckBox) findViewById(R.id.checkbox1_question1);
        boolean hasCheckbox1Question1 = checkbox1Question1.isChecked();

        CheckBox checkbox2Question1 = (CheckBox) findViewById(R.id.checkbox2_question1);
        boolean hasCheckbox2Question1 = checkbox2Question1.isChecked();

        //Checks to see if the correct answer for questions with radio buttons is selected
        RadioButton radioButtonQuestion2 = (RadioButton) findViewById(R.id.radio_button_1);
        boolean hasRadioButtonQuestion2 = radioButtonQuestion2.isChecked();

        RadioButton radioButtonQuestion3 = (RadioButton) findViewById(R.id.radio_button_6);
        boolean hasRadioButtonQuestion3 = radioButtonQuestion3.isChecked();

        RadioButton radioButtonQuestion4 =  (RadioButton) findViewById(R.id.radio_button_8);
        boolean hasRadioButtonQuestion4 = radioButtonQuestion4.isChecked();

        // Gets the name entered in the best player field
        EditText playerField = (EditText) findViewById(R.id.best_player_field);
        String bestPlayer = playerField.getText().toString();

        calculateScore(hasCheckbox1Question1, hasCheckbox2Question1, hasRadioButtonQuestion2,
                        hasRadioButtonQuestion3, hasRadioButtonQuestion4);

        String quizMessage = createQuizSummary(name, score, hasCheckbox1Question1,hasCheckbox2Question1, hasRadioButtonQuestion2,
         hasRadioButtonQuestion3, hasRadioButtonQuestion4, bestPlayer);

        displayMessage(quizMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasCheckbox1Question1 is whether the user has selected the correct answer checkbox
     * @param hasCheckbox2Question1 is whether the user has selected the correct answer checkbox
     * @param hasRadioButtonQuestion2 is whether the user has selected the correct answer radio button for question 2
     * @param hasRadioButtonQuestion3 is whether the user has selected the correct answer radio button for question 3
     * @param hasRadioButtonQuestion4 is whether the user has selected the correct answer radio button for question 4
     * @return total score
     */
    public int calculateScore(boolean hasCheckbox1Question1, boolean hasCheckbox2Question1, boolean hasRadioButtonQuestion2,
                              boolean hasRadioButtonQuestion3, boolean hasRadioButtonQuestion4) {
        // Check to see if the correct answers are selected for question 1
        if(hasCheckbox1Question1 && hasCheckbox2Question1) {
            score = score + 5;
        }
        if(hasRadioButtonQuestion2) {
            score = score + 5;
        }
        if(hasRadioButtonQuestion3) {
            score = score + 5;
        }
        if(hasRadioButtonQuestion4) {
            score = score + 5;
        }
        return score;
    }


    /**
     * This method clears the results when clicking the reset button.
     */
    public void resetQuiz(View v) {
        displayMessage("");
    }

    /**
     *
     * @param message
     */
    public void displayMessage(String message) {
        TextView quizSummaryTextView  = (TextView) findViewById(R.id.quiz_summary_text_view);
        quizSummaryTextView.setText(message);
    }

    public String createQuizSummary(String name, int score, boolean hasCheckbox1Question1, boolean hasCheckbox2Question1, boolean hasRadioButtonQuestion2,
                                      boolean hasRadioButtonQuestion3, boolean hasRadioButtonQuestion4, String bestPlayer) {
        String quizMessage = "Good job " + name + "!";
        //Will display message
        quizMessage += "\nYou scored " + score + " points!";
        if(hasCheckbox1Question1 && hasCheckbox2Question1) {
            quizMessage += "\nTony Parker and Manu Ginobili were the two players to win four championships with Tim Duncan.";
        }
        //Will display message
        if(hasRadioButtonQuestion2) {
            quizMessage += "\nGregg Poppovich took over coaching the Spurs in 1996";
        }
        //Will display message
        if(hasRadioButtonQuestion3) {
            quizMessage += "\nDavid Robinson played college basketball at the Naval Aacademy.";
        }
        //Will display message
        if(hasRadioButtonQuestion4) {
            quizMessage += "\nThe Spurs coyote was the first mascot ejected from a game in 2005";

        }
        quizMessage += "\nYou chose " + bestPlayer + " as the best Spurs player ever. Good choice!";
        quizMessage += "\nThanks for taking the Spurs quiz";

        return quizMessage;
    }
}
