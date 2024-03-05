package com.example.czcionka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSeekBarValue;
    private TextView textViewQuote;
    private Button button;
    private String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSeekBarValue = findViewById(R.id.textViewSeekBarValue);
        textViewQuote = findViewById(R.id.textView3);
        button = findViewById(R.id.button);

        SeekBar seekBar = findViewById(R.id.seekBar);

        textViewQuote.setText(quotes[currentIndex]);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBarValue.setText(String.valueOf(progress));
                textViewQuote.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        button.setOnClickListener(view -> changeQuote());
    }

    private void changeQuote() {
        currentIndex = (currentIndex + 1) % quotes.length;
        textViewQuote.setText(quotes[currentIndex]);
    }
}
