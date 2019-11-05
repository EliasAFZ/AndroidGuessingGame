package com.androidguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar();
    }

    public void setRange(View view) {
        // Grab textviews
        TextView currentMinText = findViewById(R.id.minTextVal);
        TextView currentMaxText = findViewById(R.id.maxTextVal);

        // grab values of text views
        final String minRange = currentMinText.getText().toString();
        final String maxRange = currentMaxText.getText().toString();

        // create our new intent to pass bundle of values onto new activity
        Intent gameScreenIntent = new Intent(this, GameActivity.class);
        Bundle extras = new Bundle();
        extras.putString("minRangeKey", minRange);
        extras.putString("maxRangeKey", maxRange);
        gameScreenIntent.putExtras(extras);
        startActivity(gameScreenIntent);
    }

    public void seekbar() {
        // get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = findViewById(R.id.rangeSeekbar);

        // get min and max text view
        final TextView currentMinText = findViewById(R.id.minTextVal);
        final TextView currentMaxText = findViewById(R.id.maxTextVal);

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                currentMinText.setText(String.valueOf(minValue));
                currentMaxText.setText(String.valueOf(maxValue));
            }
        });

        // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }

}
