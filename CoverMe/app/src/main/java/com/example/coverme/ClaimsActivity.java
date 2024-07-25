package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ClaimsActivity extends AppCompatActivity {

    private EditText etFullName, etPolicyNumber, etPhoneNumber, etEmailAddress, etPostalAddress, etClaimType, etClaimNumber, etDateOfClaim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claims);

        // Initialize the views
        etFullName = findViewById(R.id.etFullName);
        etPolicyNumber = findViewById(R.id.etPolicyNumber);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etPostalAddress = findViewById(R.id.etPostalAddress);
        etClaimType = findViewById(R.id.etClaimType);
        etClaimNumber = findViewById(R.id.etClaimNumber);
        etDateOfClaim = findViewById(R.id.etDateOfClaim);

        ImageView ivBackIcon = findViewById(R.id.iv_back_icon);
        ivBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back icon click
                onBackPressed();
            }
        });

        Button continueButton = findViewById(R.id.btn_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect data from form
                String fullName = etFullName.getText().toString();
                String policyNumber = etPolicyNumber.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                String emailAddress = etEmailAddress.getText().toString();
                String postalAddress = etPostalAddress.getText().toString();
                String claimType = etClaimType.getText().toString();
                String claimNumber = etClaimNumber.getText().toString();
                String dateOfClaim = etDateOfClaim.getText().toString();

                // Pass data to the next activity
                Intent intent = new Intent(ClaimsActivity.this, IncidentActivity.class);
                intent.putExtra("fullName", fullName);
                intent.putExtra("policyNumber", policyNumber);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("emailAddress", emailAddress);
                intent.putExtra("postalAddress", postalAddress);
                intent.putExtra("claimType", claimType);
                intent.putExtra("claimNumber", claimNumber);
                intent.putExtra("dateOfClaim", dateOfClaim);
               startActivity(intent);
            }
        });
    }
}
