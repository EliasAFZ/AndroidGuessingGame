package com.androidguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        displayScore();
    }

    public void displayScore() {
        // grab previous activity values
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int numberOfGuesses = Integer.parseInt(extras.getString("numberOfGuesses"));
        int randNumb = Integer.parseInt(extras.getString("randomNumber"));

        TextView scoreText = findViewById(R.id.scoreText);
        scoreText.setText(getString(R.string.score_text_description,
                randNumb,
                numberOfGuesses));
    }

    public void resetGame(View view) {
        Intent resetIntent = new Intent(this, MainActivity.class);
        // clears previous activities except for the activity that is already running being called.
        resetIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(resetIntent);
    }

}
