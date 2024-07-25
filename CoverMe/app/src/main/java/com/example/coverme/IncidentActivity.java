package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IncidentActivity extends AppCompatActivity {

    private ImageView ivBackIcon;
    private EditText etDateOfIncident, etLocationOfIncident, etDescriptionOfIncident;
    private EditText etWitnessStatements, etWitnessContact;
    private Button btnContinue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);

        // Initialize views
        ivBackIcon = findViewById(R.id.iv_back_icon);
        etDateOfIncident = findViewById(R.id.etDateOfIncident);
        etLocationOfIncident = findViewById(R.id.etLocationOfIncident);
        etDescriptionOfIncident = findViewById(R.id.etDescriptionOfIncident);
        etWitnessStatements = findViewById(R.id.etWitnessStatements);
        etWitnessContact = findViewById(R.id.etWitnessContact);
        btnContinue = findViewById(R.id.btn_continue);

        // Set back icon click listener
        ivBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Set continue button click listener
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContinueClicked();
            }
        });
    }

    public void onContinueClicked() {
        // Retrieve data from the EditText fields
        String dateOfIncident = etDateOfIncident.getText().toString().trim();
        String locationOfIncident = etLocationOfIncident.getText().toString().trim();
        String descriptionOfIncident = etDescriptionOfIncident.getText().toString().trim();
        String witnessStatements = etWitnessStatements.getText().toString().trim();
        String witnessContact = etWitnessContact.getText().toString().trim();

        // Perform validation or process the data
        if (dateOfIncident.isEmpty() || locationOfIncident.isEmpty() || descriptionOfIncident.isEmpty() ||
                witnessStatements.isEmpty() || witnessContact.isEmpty()) {
            // Show error message if any field is empty
            if (dateOfIncident.isEmpty()) {
                etDateOfIncident.setError("Please enter the date of incident");
            }
            if (locationOfIncident.isEmpty()) {
                etLocationOfIncident.setError("Please enter the location of incident");
            }
            if (descriptionOfIncident.isEmpty()) {
                etDescriptionOfIncident.setError("Please enter the description of incident");
            }
            if (witnessStatements.isEmpty()) {
                etWitnessStatements.setError("Please enter the witness statements");
            }
            if (witnessContact.isEmpty()) {
                etWitnessContact.setError("Please enter the witness contact information");
            }
        } else {
            // Proceed to the next activity
            Intent intent = new Intent(this, AuthorizationActivity.class);
            startActivity(intent);
        }
    }
}
