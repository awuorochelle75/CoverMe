package com.example.coverme;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // Initialize views
        ImageView aboutUsImage = findViewById(R.id.about_us_image);
        TextView aboutUsText = findViewById(R.id.about_us_text);
        TextView aboutUsDescription1 = findViewById(R.id.about_us_description1);
        TextView aboutUsDescription2 = findViewById(R.id.about_us_description2);
        TextView aboutUsDescription3 = findViewById(R.id.about_us_description3);
        ImageView cichigh = findViewById(R.id.cichigh);

        // You can further modify or handle these views as needed in your activity
        aboutUsText.setText("About CIC Academia");

        // Set the descriptions
        aboutUsDescription1.setText("CIC Academia is dedicated to providing comprehensive insurance solutions for children aged 2 to 13 years. Our mission is to safeguard the well-being and future of every child by offering tailor-made insurance plans that meet the diverse needs of families.");
        aboutUsDescription2.setText("With a focus on education, CIC Academia ensures that children have access to quality education without financial constraints. Our innovative insurance products cover a range of benefits, including tuition fees coverage, medical expenses to the parent incase of accident, and more.");
        aboutUsDescription3.setText("As a trusted insurance provider, CIC Academia prioritizes transparency, reliability, and customer satisfaction. We believe in building lasting relationships with our clients and strive to exceed their expectations through personalized service and prompt claims settlement.");
    }
}