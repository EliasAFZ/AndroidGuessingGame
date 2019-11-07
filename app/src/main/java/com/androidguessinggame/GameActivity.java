package com.androidguessinggame;

/**
 * Project Name: AndroidGuessingGame
 * Date: 11/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int minVal;
    private int maxVal;
    private int randNumb;
    private String alertMsg;
    private int numberOfGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        newGame();
    }

    public void checkGuess(View view) {
        TextView userInputTv = findViewById(R.id.userInput);
        String userInputStr = userInputTv.getText().toString();

        if (!userInputStr.isEmpty()) {
            int userGuess = Integer.parseInt(userInputStr);
            alertMsg = String.valueOf(userGuess);
            numberOfGuesses++;

            if (userGuess > randNumb) {
                alertMsg = "Too High!";
                toastMsg(alertMsg);
            } else if (userGuess < randNumb) {
                alertMsg = "Too low!";
                toastMsg(alertMsg);
            } else if (userGuess == randNumb) {
                Intent scoreScreenIntent = new Intent(this, ScoreActivity.class);
                Bundle extras = new Bundle();
                extras.putString("numberOfGuesses", String.valueOf(numberOfGuesses));
                extras.putString("randomNumber", String.valueOf(randNumb));
                scoreScreenIntent.putExtras(extras);
                startActivity(scoreScreenIntent);
            }
        }
    }

    //display alert message
    public void toastMsg(String alertMsg) {
        Toast msg = Toast.makeText(this, alertMsg, Toast.LENGTH_SHORT);
        msg.show();
    }

    public void newGame() {
        //grabs numbers from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        minVal = Integer.parseInt(extras.getString("minRangeKey"));
        maxVal = Integer.parseInt(extras.getString("maxRangeKey"));

        TextView gameText = findViewById(R.id.gameText);
        gameText.setText(getString(R.string.game_text_description,
                minVal,
                maxVal));

        Random randGen = new Random();
        randNumb = randGen.ints(minVal, (maxVal + 1)).findFirst().getAsInt();
    }
}
