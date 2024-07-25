package com.example.coverme;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactInfo extends AppCompatActivity {

    private TextView tvDisplayText;
    private ImageView ivDisplayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        // Initialize UI elements
        tvDisplayText = findViewById(R.id.tv_display_text);
        ivDisplayImage = findViewById(R.id.iv_display_image);

        // Set default text and image (this is optional since it's already set in XML)
        tvDisplayText.setText("Contact Us");
        ivDisplayImage.setImageResource(R.drawable.contact);
    }
}
