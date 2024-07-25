package com.example.coverme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {

    private EditText etSurname, etFirstMiddleName, etEmail, etPhoneNumber, etDateOfBirth, etBankAccountDetails;
    private Button btnUpdateProfile;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        // Initialize UI elements
        etSurname = findViewById(R.id.et_surname);
        etFirstMiddleName = findViewById(R.id.et_first_middle_name);
        etEmail = findViewById(R.id.et_email);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        etDateOfBirth = findViewById(R.id.et_date_of_birth);
        etBankAccountDetails = findViewById(R.id.et_bank_account_details);
        btnUpdateProfile = findViewById(R.id.btn_update_profile);
        progressBar = findViewById(R.id.progress_bar);

        // Load user profile information
        loadUserProfile();

        // Set up the Update button click listener
        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserProfile();
            }
        });
    }

    private void loadUserProfile() {
        progressBar.setVisibility(View.VISIBLE);
        if (currentUser != null) {
            DocumentReference docRef = db.collection("users").document(currentUser.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            etSurname.setText(document.getString("surname"));
                            etFirstMiddleName.setText(document.getString("firstMiddleName"));
                            etEmail.setText(document.getString("email"));
                            etPhoneNumber.setText(document.getString("phoneNumber"));
                            etDateOfBirth.setText(document.getString("dateOfBirth"));
                            etBankAccountDetails.setText(document.getString("bankAccountDetails"));
                        } else {
                            Toast.makeText(ProfileActivity.this, "No profile found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ProfileActivity.this, "Error loading profile", Toast.LENGTH_SHORT).show();
                    }
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
    }

    private void updateUserProfile() {
        String surname = etSurname.getText().toString().trim();
        String firstMiddleName = etFirstMiddleName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String dateOfBirth = etDateOfBirth.getText().toString().trim();
        String bankAccountDetails = etBankAccountDetails.getText().toString().trim();

        if (surname.isEmpty() || firstMiddleName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || dateOfBirth.isEmpty() || bankAccountDetails.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(firstMiddleName + " " + surname)
                .build();

        currentUser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    currentUser.updateEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                DocumentReference docRef = db.collection("users").document(currentUser.getUid());
                                docRef.update(
                                        "surname", surname,
                                        "firstMiddleName", firstMiddleName,
                                        "email", email,
                                        "phoneNumber", phoneNumber,
                                        "dateOfBirth", dateOfBirth,
                                        "bankAccountDetails", bankAccountDetails
                                ).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(ProfileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(ProfileActivity.this, "Error updating profile", Toast.LENGTH_SHORT).show();
                                        }
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                            } else {
                                Toast.makeText(ProfileActivity.this, "Error updating email", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                } else {
                    Toast.makeText(ProfileActivity.this, "Error updating profile", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
