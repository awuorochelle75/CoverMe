package com.example.coverme;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product); // Ensure your XML file is named activity_product.xml

        // Initialize the back button
        ImageButton backButton = findViewById(R.id.backButton);

        // Set up the back button functionality
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous activity
                onBackPressed();
            }
        });

        // Setting dynamic properties for TextViews
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setTypeface(null, Typeface.BOLD);
        titleTextView.setTextSize(30);

        TextView academiaTitleTextView = findViewById(R.id.academiaTitleTextView);
        academiaTitleTextView.setTypeface(null, Typeface.BOLD);
        academiaTitleTextView.setTextSize(20);

        TextView productDescTitleTextView = findViewById(R.id.productDescTitleTextView);
        productDescTitleTextView.setTypeface(null, Typeface.BOLD);
        productDescTitleTextView.setTextSize(20);

        TextView otherOptionsTitleTextView = findViewById(R.id.otherOptionsTitleTextView);
        otherOptionsTitleTextView.setTypeface(null, Typeface.BOLD);
        otherOptionsTitleTextView.setTextSize(20);
    }
}
