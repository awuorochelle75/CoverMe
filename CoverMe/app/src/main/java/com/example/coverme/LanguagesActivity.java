package com.example.coverme;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class LanguagesActivity extends AppCompatActivity {

    private RadioButton englishRadioButton;
    private RadioButton swahiliRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        // Initialize views
        englishRadioButton = findViewById(R.id.englishRadioButton);
        swahiliRadioButton = findViewById(R.id.swahiliRadioButton);

        // Set English RadioButton as checked by default
        englishRadioButton.setChecked(true);

        // Set click listener for English RadioButton
        englishRadioButton.setOnClickListener(v -> {
            // Handle English language selection
            swahiliRadioButton.setChecked(false);
            // Your logic for setting the app language to English
        });

        // Set click listener for Swahili RadioButton
        swahiliRadioButton.setOnClickListener(v -> {
            // Handle Swahili language selection
            englishRadioButton.setChecked(false);
            // Your logic for setting the app language to Swahili
        });
    }
}