package com.example.coverme;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private EditText etSurname, etFirstMiddleName, etEmail, etPhoneNumber, etPassword, etConfirmPassword, etDateOfBirth, etBankAccountDetails;
    private RadioGroup radioGroupGender;
    private Spinner spinnerMaritalStatus, spinnerEmploymentStatus;
    private CheckBox checkboxAgreeToTerms;
    private Button btnUploadID, btnUploadPassportPhoto, btnUploadKraPin, btnUploadATMCard, btnCreateAccount;
    private ProgressBar progressBar;

    private String idDocumentPath = "";
    private String passportPhotoPath = "";
    private String kraPinPath = "";
    private String atmCardPath = "";

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etSurname = findViewById(R.id.et_surname);
        etFirstMiddleName = findViewById(R.id.et_first_middle_name);
        etEmail = findViewById(R.id.et_email);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        etDateOfBirth = findViewById(R.id.et_date_of_birth);
        etBankAccountDetails = findViewById(R.id.et_bank_account_details);
        radioGroupGender = findViewById(R.id.radio_group_gender);
        spinnerMaritalStatus = findViewById(R.id.spinner_marital_status);
        spinnerEmploymentStatus = findViewById(R.id.spinner_employment_status);
        checkboxAgreeToTerms = findViewById(R.id.checkbox_agree_to_terms);
        btnUploadID = findViewById(R.id.btn_upload_id);
        btnUploadPassportPhoto = findViewById(R.id.btn_upload_passport_photo);
        btnUploadKraPin = findViewById(R.id.btn_upload_kra_pin);
        btnUploadATMCard = findViewById(R.id.btn_upload_atm_card);
        btnCreateAccount = findViewById(R.id.btn_create_account);
        progressBar = findViewById(R.id.progress_bar);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        setupSpinners();
        setupUploadButtons();
        setupDatePicker();
        setupTextWatchers();

        btnCreateAccount.setOnClickListener(v -> validateFields());
        TextView tvAlreadyHaveAccount = findViewById(R.id.tv_already_have_account);
        tvAlreadyHaveAccount.setOnClickListener(v -> openLoginActivity());
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> maritalStatusAdapter = ArrayAdapter.createFromResource(this,
                R.array.marital_status_array, android.R.layout.simple_spinner_item);
        maritalStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaritalStatus.setAdapter(maritalStatusAdapter);

        ArrayAdapter<CharSequence> employmentStatusAdapter = ArrayAdapter.createFromResource(this,
                R.array.employment_status_array, android.R.layout.simple_spinner_item);
        employmentStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEmploymentStatus.setAdapter(employmentStatusAdapter);
    }

    private void setupUploadButtons() {
        btnUploadID.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("application/pdf");
            startActivityForResult(Intent.createChooser(intent, "Select ID Document"), 1);
        });

        btnUploadPassportPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Passport Photo"), 2);
        });

        btnUploadKraPin.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("application/pdf");
            startActivityForResult(Intent.createChooser(intent, "Select KRA PIN Document"), 3);
        });

        btnUploadATMCard.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("application/pdf");
            startActivityForResult(Intent.createChooser(intent, "Select ATM Card Document"), 4);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (data != null && data.getData() != null) {
                Uri uri = data.getData();
                switch (requestCode) {
                    case 1:
                        idDocumentPath = uri.toString();
                        Toast.makeText(this, "ID Document selected: " + uri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        passportPhotoPath = uri.toString();
                        Toast.makeText(this, "Passport Photo selected: " + uri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        kraPinPath = uri.toString();
                        Toast.makeText(this, "KRA PIN Document selected: " + uri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        atmCardPath = uri.toString();
                        Toast.makeText(this, "ATM Card Document selected: " + uri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }

    private void setupDatePicker() {
        etDateOfBirth.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        month1 += 1; // Month is zero-based
                        String dateOfBirth = dayOfMonth + "/" + month1 + "/" + year1;
                        etDateOfBirth.setText(dateOfBirth);
                    }, year, month, day);
            datePickerDialog.show();
        });
    }

    private void setupTextWatchers() {
        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0 && !s.toString().startsWith("07")) {
                    etPhoneNumber.setError("Phone number must start with 07");
                } else if (s.length() != 10) {
                    etPhoneNumber.setError("Phone number must be 10 digits");
                } else {
                    etPhoneNumber.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No action needed
            }
        });
    }

    private void validateFields() {
        String surname = etSurname.getText().toString().trim();
        String firstMiddleName = etFirstMiddleName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String dateOfBirth = etDateOfBirth.getText().toString().trim();
        String bankAccountDetails = etBankAccountDetails.getText().toString().trim();
        String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        String maritalStatus = spinnerMaritalStatus.getSelectedItem().toString();
        String employmentStatus = spinnerEmploymentStatus.getSelectedItem().toString();

        if (surname.isEmpty() || firstMiddleName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty() || dateOfBirth.isEmpty() ||
                bankAccountDetails.isEmpty() || !checkboxAgreeToTerms.isChecked()) {
            Toast.makeText(this, "Please fill all fields and agree to the terms", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email address");
            return;
        }

        if (!phoneNumber.startsWith("07") || phoneNumber.length() != 10) {
            etPhoneNumber.setError("Phone number must start with 07 and be 10 digits");
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters long");
            return;
        }

        createFirebaseUser(surname, firstMiddleName, email, phoneNumber, password, dateOfBirth, bankAccountDetails, gender, maritalStatus, employmentStatus);
    }

    private void createFirebaseUser(String surname, String firstMiddleName, String email, String phoneNumber, String password, String dateOfBirth, String bankAccountDetails, String gender, String maritalStatus, String employmentStatus) {
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            String userId = user.getUid();
                            saveUserDataToFirestore(userId, surname, firstMiddleName, email, phoneNumber, dateOfBirth, bankAccountDetails, gender, maritalStatus, employmentStatus);
                        }
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(SignUpActivity.this, "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveUserDataToFirestore(String userId, String surname, String firstMiddleName, String email, String phoneNumber, String dateOfBirth, String bankAccountDetails, String gender, String maritalStatus, String employmentStatus) {
        Map<String, Object> user = new HashMap<>();
        user.put("surname", surname);
        user.put("firstMiddleName", firstMiddleName);
        user.put("email", email);
        user.put("phoneNumber", phoneNumber);
        user.put("dateOfBirth", dateOfBirth);
        user.put("bankAccountDetails", bankAccountDetails);
        user.put("gender", gender);
        user.put("maritalStatus", maritalStatus);
        user.put("employmentStatus", employmentStatus);
        user.put("idDocumentPath", idDocumentPath);
        user.put("passportPhotoPath", passportPhotoPath);
        user.put("kraPinPath", kraPinPath);
        user.put("atmCardPath", atmCardPath);

        db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener(aVoid -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SignUpActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                    openProfileActivity();
                })
                .addOnFailureListener(e -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SignUpActivity.this, "Error saving user data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void openProfileActivity() {
        Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    private void openLoginActivity() {
        Intent intent = new Intent(SignUpActivity.this, loginActivity.class);
        startActivity(intent);
        finish();
    }}
