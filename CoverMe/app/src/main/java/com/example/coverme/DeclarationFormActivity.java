package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class DeclarationFormActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText editHeightFeet, editHeightInches, editWeight;
    private RadioGroup radioGroupDisorder, radioGroupAlcoholSmoking, radioGroupIllnessAccident, radioGroupFamilyHistory, radioGroupHazardousActivities, radioGroupPregnant;
    private EditText editName, editIdPassport, editCell, editEmail, editDate;
    private Button btnSubmit, btnClaim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declaration_form); // Change this to your actual layout file name

        // Initialize UI elements
        editHeightFeet = findViewById(R.id.edit_height_feet);
        editHeightInches = findViewById(R.id.edit_height_inches);
        editWeight = findViewById(R.id.edit_weight);

        radioGroupDisorder = findViewById(R.id.radio_group_disorder);
        radioGroupAlcoholSmoking = findViewById(R.id.radio_group_alcohol_smoking);
        radioGroupIllnessAccident = findViewById(R.id.radio_group_illness_accident);
        radioGroupFamilyHistory = findViewById(R.id.radio_group_family_history);
        radioGroupHazardousActivities = findViewById(R.id.radio_group_hazardous_activities);
        radioGroupPregnant = findViewById(R.id.radio_group_pregnant);

        editName = findViewById(R.id.edit_name);
        editIdPassport = findViewById(R.id.edit_id_passport);
        editCell = findViewById(R.id.edit_cell);
        editEmail = findViewById(R.id.edit_email);
        editDate = findViewById(R.id.edit_date);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnClaim = findViewById(R.id.btnClaim);

        // Set listeners for buttons
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        btnClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadPolicyForm();
            }
        });
    }

    // Method to handle form submission
    private void submitForm() {
        // Get the values from EditTexts
        String heightFeet = editHeightFeet.getText().toString();
        String heightInches = editHeightInches.getText().toString();
        String weight = editWeight.getText().toString();
        String name = editName.getText().toString();
        String idPassport = editIdPassport.getText().toString();
        String cell = editCell.getText().toString();
        String email = editEmail.getText().toString();
        String date = editDate.getText().toString();

        // Get the selected RadioButton for each RadioGroup
        String disorder = getSelectedRadioValue(radioGroupDisorder, R.id.radio_disorder_yes);
        String alcoholSmoking = getSelectedRadioValue(radioGroupAlcoholSmoking, R.id.radio_alcohol_smoking_yes);
        String illnessAccident = getSelectedRadioValue(radioGroupIllnessAccident, R.id.radio_illness_accident_yes);
        String familyHistory = getSelectedRadioValue(radioGroupFamilyHistory, R.id.radio_family_history_yes);
        String hazardousActivities = getSelectedRadioValue(radioGroupHazardousActivities, R.id.radio_hazardous_activities_yes);
        String pregnant = getSelectedRadioValue(radioGroupPregnant, R.id.radio_pregnant_yes);

        // Create an Intent to pass data to ViewPolicyActivity
        Intent intent = new Intent(this, PolicyActivity.class);
        intent.putExtra("heightFeet", heightFeet);
        intent.putExtra("heightInches", heightInches);
        intent.putExtra("weight", weight);
        intent.putExtra("name", name);
        intent.putExtra("idPassport", idPassport);
        intent.putExtra("cell", cell);
        intent.putExtra("email", email);
        intent.putExtra("date", date);
        intent.putExtra("disorder", disorder);
        intent.putExtra("alcoholSmoking", alcoholSmoking);
        intent.putExtra("illnessAccident", illnessAccident);
        intent.putExtra("familyHistory", familyHistory);
        intent.putExtra("hazardousActivities", hazardousActivities);
        intent.putExtra("pregnant", pregnant);

        // Start ViewPolicyActivity
        startActivity(intent);
    }

    // Helper method to get selected RadioButton value
    private String getSelectedRadioValue(RadioGroup radioGroup, int yesId) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        return selectedId == yesId ? "Yes" : "No";
    }

    // Method to handle downloading the policy form
    private void downloadPolicyForm() {
        // Implement your download policy form logic here
    }
}