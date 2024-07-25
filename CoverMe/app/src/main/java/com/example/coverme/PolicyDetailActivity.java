package com.example.coverme;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PolicyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_detail);

        // Get the Intent that started this activity and extract the policy details
        String policyName = getIntent().getStringExtra("POLICY_NAME");

        // Capture the layout's TextView and set the policy details
        TextView textView = findViewById(R.id.policyDetailTextView);
        textView.setText(policyName);
    }
}
