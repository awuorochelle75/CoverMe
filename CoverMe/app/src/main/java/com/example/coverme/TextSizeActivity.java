package com.example.coverme;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextSizeActivity extends AppCompatActivity {

    // Define keys for SharedPreferences
    private static final String PREFS_NAME = "TextSizePrefs";
    private static final String TEXT_SIZE_KEY = "textSize";

    // Define text sizes
    private static final int SMALL_TEXT_SIZE = 14;
    private static final int MEDIUM_TEXT_SIZE = 18;
    private static final int LARGE_TEXT_SIZE = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_size);

        // Find TextViews
        TextView smallTextView = findViewById(R.id.smallText);
        TextView mediumTextView = findViewById(R.id.mediumText);
        TextView largeTextView = findViewById(R.id.largeText);

        // Set click listeners
        smallTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for small text
                saveTextSize(SMALL_TEXT_SIZE);
            }
        });

        mediumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for medium text
                saveTextSize(MEDIUM_TEXT_SIZE);
            }
        });

        largeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for large text
                saveTextSize(LARGE_TEXT_SIZE);
            }
        });
    }

    // Save selected text size in SharedPreferences
    private void saveTextSize(int textSize) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt(TEXT_SIZE_KEY, textSize);
        editor.apply();
    }
}