package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

        CheckBox checkbox3Question1 = (CheckBox) findViewById(R.id.checkbox3_question1);
        boolean hasCheckbox3Question1 = checkbox3Question1.isChecked();

        CheckBox checkbox4Question1 = (CheckBox) findViewById(R.id.checkbox4_question1);
        boolean hasCheckbox4Question1 = checkbox4Question1.isChecked();

        //Checks to see if the correct answer for questions with radio buttons is selected
        RadioButton radioButtonQuestion2 = (RadioButton) findViewById(R.id.radio_button_1);
        boolean hasRadioButtonQuestion2 = radioButtonQuestion2.isChecked();

        RadioButton radioButtonQuestion3 = (RadioButton) findViewById(R.id.radio_button_6);
        boolean hasRadioButtonQuestion3 = radioButtonQuestion3.isChecked();

        RadioButton radioButtonQuestion4 =  (RadioButton) findViewById(R.id.radio_button_8);
        boolean hasRadioButtonQuestion4 = radioButtonQuestion4.isChecked();

        // Gets the name entered in the best player field
        EditText playerField = (EditText) findViewById(R.id.nickname_player_field);
        String hasNicknamePlayer = playerField.getText().toString();

        calculateScore(hasCheckbox1Question1, hasCheckbox2Question1, hasCheckbox3Question1, hasCheckbox4Question1,
                        hasRadioButtonQuestion2, hasRadioButtonQuestion3, hasRadioButtonQuestion4, hasNicknamePlayer);

        String quizMessage = createQuizSummary(name, score, hasCheckbox1Question1, hasCheckbox2Question1, hasRadioButtonQuestion2,
         hasRadioButtonQuestion3, hasRadioButtonQuestion4, hasNicknamePlayer);

        Toast.makeText(this, "You scored " + score + " points!", Toast.LENGTH_SHORT).show();

        displayMessage(quizMessage);

        //Reset score to 0 to prevent score continuing to add when hitting Submit button
        score = 0;
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasCheckbox1Question1 is whether the user has selected the correct answer checkbox
     * @param hasCheckbox2Question1 is whether the user has selected the correct answer checkbox
     * @param hasCheckbox3Question1 is whether the user has selected an incorrect checkbox
     * @param hasCheckbox4Question1 is whether the user has selected and incorrect checkbox
     * @param hasRadioButtonQuestion2 is whether the user has selected the correct answer radio button for question 2
     * @param hasRadioButtonQuestion3 is whether the user has selected the correct answer radio button for question 3
     * @param hasRadioButtonQuestion4 is whether the user has selected the correct answer radio button for question 4
     * @param hasNicknamePlayer compares the input text with a value and scores if correct                                
     * @return total score
     */
    public int calculateScore(boolean hasCheckbox1Question1, boolean hasCheckbox2Question1, boolean hasCheckbox3Question1,
                              boolean hasCheckbox4Question1, boolean hasRadioButtonQuestion2,
                              boolean hasRadioButtonQuestion3, boolean hasRadioButtonQuestion4, String hasNicknamePlayer) {
        // Check to see if the correct answers are selected for question 1
        if(hasCheckbox1Question1 && hasCheckbox2Question1 && !hasCheckbox3Question1 && !hasCheckbox4Question1) {
            score = score + 10;
        } else if (hasCheckbox1Question1 || hasCheckbox2Question1 && hasCheckbox3Question1 || hasCheckbox4Question1){
            score = score + 5;
        }
        // Check to see if the correct answer was selected for question 2
        if(hasRadioButtonQuestion2) {
            score = score + 10;
        }
        // Check to see if the correct answer was selected for question 3
        if(hasRadioButtonQuestion3) {
            score = score + 10;
        }
        // Check to see if the correct answer was selected for question 4
        if(hasRadioButtonQuestion4) {
            score = score + 10;
        }
        if(hasNicknamePlayer.equalsIgnoreCase("George Gervin") || hasNicknamePlayer.equalsIgnoreCase("Gervin")) {
            score = score + 10;
        }
        // Returns the total score
        return score;
    }


    /**
     * This method resets the app when clicking the reset button.
     */
    public void resetQuiz(View v) {
        finish();
        startActivity(getIntent());
    }


    /**
     * Display results and message
     * @param message that will be displayed in the quiz_summary_text_view
     */
    public void displayMessage(String message) {
        TextView quizSummaryTextView  = (TextView) findViewById(R.id.quiz_summary_text_view);
        quizSummaryTextView.setText(message);
    }

    public String createQuizSummary(String name, int score, boolean hasCheckbox1Question1, boolean hasCheckbox2Question1, boolean hasRadioButtonQuestion2,
                                      boolean hasRadioButtonQuestion3, boolean hasRadioButtonQuestion4, String hasNicknamePlayer) {
        String quizMessage = "Good Job " + name + "!\n";
        //Will display message
        quizMessage += "\nYou scored " + score + " points!\n";
        if(hasCheckbox1Question1 && hasCheckbox2Question1) {
            quizMessage += "\nTony Parker and Manu Ginobili were the two players to win four championships with Tim Duncan. 10 points!";
        } else if(hasCheckbox1Question1) {
            quizMessage += "\nYou are half right Tony Parker was one of the players. 5 points!";
        } else if(hasCheckbox2Question1) {
            quizMessage += "\nYou are half right Manu Ginobili was one of the the players. 5 points!";
        } else {
            quizMessage += "\nSorry, you scored 0 points for question 1.";
        }
        //Will display message
        if(hasRadioButtonQuestion2) {
            quizMessage += "\nGregg Poppovich took over coaching the Spurs in 1996. 10 points!";
        } else {
            quizMessage += "\nSorry, you scored 0 points for question 2.";
        }
        //Will display message
        if(hasRadioButtonQuestion3) {
            quizMessage += "\nDavid Robinson played college basketball at the Naval Academy. 10 points!";
        } else {
            quizMessage += "\nSorry, you scored 0 points for question 3.";
        }
        //Will display message
        if(hasRadioButtonQuestion4) {
            quizMessage += "\nThe Spurs coyote was the first mascot ejected from a game in 2005. 10 points!";
        } else {
            quizMessage += "\nSorry, you scored 0 points for question 4.";
        }
        if(hasNicknamePlayer.equalsIgnoreCase("George Gervin")) {
            quizMessage += "\n" + hasNicknamePlayer + " was the Spur known as the Iceman. 10 points!\n";
        } else if (hasNicknamePlayer.equalsIgnoreCase("Gervin")) {
            quizMessage += "\n George Gervin was the Spur known as the Iceman. 10 points!";
        } else {
            quizMessage += "\n" + hasNicknamePlayer + " was not known as the Iceman. You scored 0 points for question 5";
        }

        quizMessage += "\nThanks for taking the Spurs quiz!";

        return quizMessage;
    }
}
