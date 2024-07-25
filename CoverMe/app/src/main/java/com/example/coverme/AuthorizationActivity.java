package com.example.coverme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthorizationActivity extends AppCompatActivity {

    private static final int PICK_BIRTH_CERTIFICATE_REQUEST = 1;
    private static final int PICK_DEATH_CERTIFICATE_REQUEST = 2;
    private static final int PICK_ACCIDENT_PROOF_REQUEST = 3;
    private static final int PICK_DISABILITY_PROOF_REQUEST = 4;

    private ImageView ivBackIcon;
    private TextView tvBirthCertificate, tvDeathCertificate, tvAccidentProof, tvDisabilityProof;
    private CheckBox cbAuthorization;
    private EditText etDateOfCertification;
    private Button btnSubmit, btnClaim, btnUploadBirthCertificate, btnUploadDeathCertificate, btnUploadAccidentProof, btnUploadDisabilityProof;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        // Initialize views
        ivBackIcon = findViewById(R.id.iv_back_icon);
        tvBirthCertificate = findViewById(R.id.tvBirthCertificate);
        tvDeathCertificate = findViewById(R.id.tvDeathCertificate);
        tvAccidentProof = findViewById(R.id.tvAccidentProof);
        tvDisabilityProof = findViewById(R.id.tvDisabilityProof);
        cbAuthorization = findViewById(R.id.cbAuthorization);
        etDateOfCertification = findViewById(R.id.etDateOfCertification);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClaim = findViewById(R.id.btnClaim);
        btnUploadBirthCertificate = findViewById(R.id.btnUploadBirthCertificate);
        btnUploadDeathCertificate = findViewById(R.id.btnUploadDeathCertificate);
        btnUploadAccidentProof = findViewById(R.id.btnUploadAccidentProof);
        btnUploadDisabilityProof = findViewById(R.id.btnUploadDisabilityProof);

        // Set back icon click listener
        ivBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Set upload buttons click listeners
        btnUploadBirthCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(PICK_BIRTH_CERTIFICATE_REQUEST);
            }
        });

        btnUploadDeathCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(PICK_DEATH_CERTIFICATE_REQUEST);
            }
        });

        btnUploadAccidentProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(PICK_ACCIDENT_PROOF_REQUEST);
            }
        });

        btnUploadDisabilityProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(PICK_DISABILITY_PROOF_REQUEST);
            }
        });

        // Set submit button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        // Set claim button click listener
        btnClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadClaimForm();
            }
        });
    }

    private void openFilePicker(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            Uri selectedFileUri = data.getData();
            if (selectedFileUri != null) {
                String filePath = selectedFileUri.getPath();
                switch (requestCode) {
                    case PICK_BIRTH_CERTIFICATE_REQUEST:
                        tvBirthCertificate.setText(filePath);
                        break;
                    case PICK_DEATH_CERTIFICATE_REQUEST:
                        tvDeathCertificate.setText(filePath);
                        break;
                    case PICK_ACCIDENT_PROOF_REQUEST:
                        tvAccidentProof.setText(filePath);
                        break;
                    case PICK_DISABILITY_PROOF_REQUEST:
                        tvDisabilityProof.setText(filePath);
                        break;
                }
            }
        }
    }

    private void submitForm() {
        String dateOfCertification = etDateOfCertification.getText().toString().trim();

        if (!cbAuthorization.isChecked() || tvBirthCertificate.getText().toString().equals("No file selected")
                || tvDeathCertificate.getText().toString().equals("No file selected")
                || tvAccidentProof.getText().toString().equals("No file selected")
                || tvDisabilityProof.getText().toString().equals("No file selected")) {
            showIncompleteFormDialog();
            return;
        }

        if (dateOfCertification.isEmpty()) {
            etDateOfCertification.setError("Please enter the date of certification");
            return;
        }

        // Perform form submission process
        Toast.makeText(this, "Form Submitted", Toast.LENGTH_SHORT).show();

        // Example: Save the data to a database or send it to a server
        // saveClaimData(dateOfCertification);

        // Example: Start a new activity
        // Intent intent = new Intent(this, NextActivity.class);
        // startActivity(intent);
    }

    private void downloadClaimForm() {
        // Check if all fields are filled
        if (!cbAuthorization.isChecked() || tvBirthCertificate.getText().toString().equals("No file selected")
                || tvDeathCertificate.getText().toString().equals("No file selected")
                || tvAccidentProof.getText().toString().equals("No file selected")
                || tvDisabilityProof.getText().toString().equals("No file selected")
                || etDateOfCertification.getText().toString().trim().isEmpty()) {
            showIncompleteFormDialog();
            return;
        }

        // Notify the user that the document is downloading
        Toast.makeText(this, "Downloading Claim Form...", Toast.LENGTH_SHORT).show();

        // Simulate downloading a file
        new Thread(new Runnable() {
            public void run() {
                try {
                    String fileUrl = "https://www.example.com/claimform.pdf"; // URL to your PDF file
                    String fileName = "claimform.pdf";

                    File pdfFile = downloadFile(fileUrl, fileName);

                    // Notify the user that the document is downloaded
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(AuthorizationActivity.this, "Claim Form Downloaded", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // You can open the PDF file using an Intent
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(pdfFile), "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private File downloadFile(String fileUrl, String fileName) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
        FileOutputStream fileOutput = new FileOutputStream(file);
        InputStream inputStream = urlConnection.getInputStream();

        byte[] buffer = new byte[1024];
        int bufferLength;

        while ((bufferLength = inputStream.read(buffer)) > 0) {
            fileOutput.write(buffer, 0, bufferLength);
        }

        fileOutput.close();

        return file;
    }

    private void showIncompleteFormDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Incomplete Form")
                .setMessage("Please fill in all the required documents and authorize the information provided.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    // Example method to save data (implement as needed)
    private void saveClaimData(String dateOfCertification) {
        // Code to save the data
    }
}
