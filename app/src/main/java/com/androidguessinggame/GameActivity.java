package com.androidguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setGameText();
    }

    public void setGameText(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int minVal = Integer.parseInt(extras.getString("minRangeKey"));
        int maxVal = Integer.parseInt(extras.getString("maxRangeKey"));

        TextView gameText = findViewById(R.id.gameText);
        gameText.setText(getString(R.string.game_text_description,minVal,maxVal));

    }

    public void startGame(){

    }

}
