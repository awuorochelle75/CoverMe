package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContinueActivity extends AppCompatActivity {

    private TextView tvContinueAs;
    private RadioGroup radioGroup;
    private RadioButton rbGuest, rbAdmin;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        // Initialize views
        tvContinueAs = findViewById(R.id.tvContinueAs);
        radioGroup = findViewById(R.id.radioGroup);
        rbGuest = findViewById(R.id.rbGuest);
        rbAdmin = findViewById(R.id.rbAdmin);
        btnContinue = findViewById(R.id.btn_continue);

        // Set click listener for the button
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContinueClicked(v);
            }
        });
    }

    public void onContinueClicked(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            // No radio buttons are checked
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        } else {
            // Find which radio button is selected
            if (selectedId == R.id.rbGuest) {
                // User selected "User"
                Intent intent = new Intent(ContinueActivity.this, homePageActivity.class);
                startActivity(intent);
            } else if (selectedId == R.id.rbAdmin) {
                // User selected "Admin"
                Intent intent = new Intent(ContinueActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        }
    }
}
