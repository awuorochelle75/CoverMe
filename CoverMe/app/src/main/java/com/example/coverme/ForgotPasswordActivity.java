package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coverme.R;
import com.example.coverme.loginActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ImageView backIcon;
    private EditText newPasswordEditText;
    private EditText confirmNewPasswordEditText;
    private Button resetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Initialize views
        backIcon = findViewById(R.id.iv_back_icon);
        newPasswordEditText = findViewById(R.id.et_new_password);
        confirmNewPasswordEditText = findViewById(R.id.et_confirm_new_password);
        resetPasswordButton = findViewById(R.id.btn_reset_password);

        // Set click listener for back icon
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous screen
                onBackPressed();
            }
        });

        // Set click listener for reset password button
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle password reset logic
                String newPassword = newPasswordEditText.getText().toString();
                String confirmNewPassword = confirmNewPasswordEditText.getText().toString();

                if (newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!newPassword.equals(confirmNewPassword)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform password reset operation
                    resetPassword(newPassword);
                }
            }
        });
    }

    private void resetPassword(String newPassword) {
        // Implement the password reset logic here
        // This could involve calling an API or updating a local database

        // For demonstration purposes, we'll just show a toast message
        Toast.makeText(ForgotPasswordActivity.this, "Password reset successfully", Toast.LENGTH_SHORT).show();

        // Optionally, navigate to the login screen after resetting the password
        Intent intent = new Intent(ForgotPasswordActivity.this, loginActivity.class);
        startActivity(intent);
        finish();
    }
}