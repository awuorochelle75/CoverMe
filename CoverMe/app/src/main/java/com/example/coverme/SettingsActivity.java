package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Handle back button click
        ImageView backButton = findViewById(R.id.iv_back_icon);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the activity and go back
            }
        });

        // Handle Security & Privacy click


        ImageView backArrowSecurity = findViewById(R.id.back_arrow);
        backArrowSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, SecurityPrivacyActivity.class);
                startActivity(intent);
            }
        });

        // Handle Text Size click


        ImageView backArrowTextSize = findViewById(R.id.back_);
        backArrowTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, TextSizeActivity.class);
                startActivity(intent);
            }
        });

        // Handle Languages click


        ImageView forwardArrowLanguages = findViewById(R.id.forward_arrow);
        forwardArrowLanguages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, LanguagesActivity.class);
                startActivity(intent);
            }
        });

        // Handle About Us click


        ImageView moveAboutUs = findViewById(R.id.move);
        moveAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });

        // Handle FAQs click


        ImageView forwardArrowFAQs = findViewById(R.id.foooont);
        forwardArrowFAQs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, FAQsActivity.class);
                startActivity(intent);
            }
        });
    }
}
