package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuyPolicyActivity extends AppCompatActivity {

    private EditText etFullName, etDateOfBirth, etIdNumber, etPermanentAddress, etCode, etMobileNumber;
    private EditText etKraPin, etEmailAddress, etHeight, etWeight, etBeneficiaryName;
    private EditText etBeneficiaryRelationship, etBeneficiaryDateOfBirth, etBeneficiaryMobile;
    private EditText etNomineeName, etNomineeRelationship, etNomineeDateOfBirth, etNomineeMobileNumber;
    private EditText etBankName, etServiceNo, etBranchDepartment, etAccountNo, etPolicyDescription;
    private EditText etTerm, etAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_policy);

        // Initialize EditTexts
        etFullName = findViewById(R.id.et_full_name);
        etDateOfBirth = findViewById(R.id.et_date_of_birth);
        etIdNumber = findViewById(R.id.et_id_number);
        etPermanentAddress = findViewById(R.id.et_permanent_address);
        etCode = findViewById(R.id.et_code);
        etMobileNumber = findViewById(R.id.et_mobile_number);
        etKraPin = findViewById(R.id.et_kra_pin);
        etEmailAddress = findViewById(R.id.et_email_address);
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_weight);
        etBeneficiaryName = findViewById(R.id.et_beneficiary_name);
        etBeneficiaryRelationship = findViewById(R.id.et_beneficiary_relationship);
        etBeneficiaryDateOfBirth = findViewById(R.id.et_beneficiary_date_of_birth);
        etBeneficiaryMobile = findViewById(R.id.et_beneficiary_mobile);
        etNomineeName = findViewById(R.id.et_nominee_name);
        etNomineeRelationship = findViewById(R.id.et_nominee_relationship);
        etNomineeDateOfBirth = findViewById(R.id.et_nominee_date_of_birth);
        etNomineeMobileNumber = findViewById(R.id.et_nominee_mobile_number);
        etBankName = findViewById(R.id.et_bank_name);
        etServiceNo = findViewById(R.id.et_service_no);
        etBranchDepartment = findViewById(R.id.et_branch_department);
        etAccountNo = findViewById(R.id.et_account_no);
        etPolicyDescription = findViewById(R.id.et_policy_description);
        etTerm = findViewById(R.id.et_term);
        etAmount = findViewById(R.id.et_amount);
    }

    public void onContinueClicked(View view) {
        // Collect data
        String fullName = etFullName.getText().toString();
        String dateOfBirth = etDateOfBirth.getText().toString();
        String idNumber = etIdNumber.getText().toString();
        String permanentAddress = etPermanentAddress.getText().toString();
        String code = etCode.getText().toString();
        String mobileNumber = etMobileNumber.getText().toString();
        String kraPin = etKraPin.getText().toString();
        String emailAddress = etEmailAddress.getText().toString();
        String height = etHeight.getText().toString();
        String weight = etWeight.getText().toString();
        String beneficiaryName = etBeneficiaryName.getText().toString();
        String beneficiaryRelationship = etBeneficiaryRelationship.getText().toString();
        String beneficiaryDateOfBirth = etBeneficiaryDateOfBirth.getText().toString();
        String beneficiaryMobile = etBeneficiaryMobile.getText().toString();
        String nomineeName = etNomineeName.getText().toString();
        String nomineeRelationship = etNomineeRelationship.getText().toString();
        String nomineeDateOfBirth = etNomineeDateOfBirth.getText().toString();
        String nomineeMobileNumber = etNomineeMobileNumber.getText().toString();
        String bankName = etBankName.getText().toString();
        String serviceNo = etServiceNo.getText().toString();
        String branchDepartment = etBranchDepartment.getText().toString();
        String accountNo = etAccountNo.getText().toString();
        String policyDescription = etPolicyDescription.getText().toString();
        String term = etTerm.getText().toString();
        String amount = etAmount.getText().toString();

        // Validate inputs
        if (fullName.isEmpty() || dateOfBirth.isEmpty() || idNumber.isEmpty() ||
                permanentAddress.isEmpty() || code.isEmpty() || mobileNumber.isEmpty() ||
                kraPin.isEmpty() || emailAddress.isEmpty() || height.isEmpty() || weight.isEmpty() ||
                beneficiaryName.isEmpty() || beneficiaryRelationship.isEmpty() ||
                beneficiaryDateOfBirth.isEmpty() || beneficiaryMobile.isEmpty() ||
                nomineeName.isEmpty() || nomineeRelationship.isEmpty() ||
                nomineeDateOfBirth.isEmpty() || nomineeMobileNumber.isEmpty() ||
                bankName.isEmpty() || serviceNo.isEmpty() || branchDepartment.isEmpty() ||
                accountNo.isEmpty() || policyDescription.isEmpty() || term.isEmpty() ||
                amount.isEmpty()) {

            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save data to file
        File directory = getFilesDir();
        File file = new File(directory, "proposal_data.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(("Full Name: " + fullName + "\n").getBytes());
            fos.write(("Date of Birth: " + dateOfBirth + "\n").getBytes());
            fos.write(("ID Number: " + idNumber + "\n").getBytes());
            fos.write(("Permanent Address: " + permanentAddress + "\n").getBytes());
            fos.write(("Code: " + code + "\n").getBytes());
            fos.write(("Mobile Number: " + mobileNumber + "\n").getBytes());
            fos.write(("KRA PIN: " + kraPin + "\n").getBytes());
            fos.write(("Email Address: " + emailAddress + "\n").getBytes());
            fos.write(("Height: " + height + "\n").getBytes());
            fos.write(("Weight: " + weight + "\n").getBytes());
            fos.write(("Beneficiary Name: " + beneficiaryName + "\n").getBytes());
            fos.write(("Beneficiary Relationship: " + beneficiaryRelationship + "\n").getBytes());
            fos.write(("Beneficiary Date of Birth: " + beneficiaryDateOfBirth + "\n").getBytes());
            fos.write(("Beneficiary Mobile: " + beneficiaryMobile + "\n").getBytes());
            fos.write(("Nominee Name: " + nomineeName + "\n").getBytes());
            fos.write(("Nominee Relationship: " + nomineeRelationship + "\n").getBytes());
            fos.write(("Nominee Date of Birth: " + nomineeDateOfBirth + "\n").getBytes());
            fos.write(("Nominee Mobile Number: " + nomineeMobileNumber + "\n").getBytes());
            fos.write(("Bank Name: " + bankName + "\n").getBytes());
            fos.write(("Service No./Payroll No.: " + serviceNo + "\n").getBytes());
            fos.write(("Branch/Department: " + branchDepartment + "\n").getBytes());
            fos.write(("Account No: " + accountNo + "\n").getBytes());
            fos.write(("Policy Description: " + policyDescription + "\n").getBytes());
            fos.write(("Term: " + term + "\n").getBytes());
            fos.write(("Amount: " + amount + "\n").getBytes());

            // Navigate to DeclarationFormActivity
            Intent intent = new Intent(this, DeclarationFormActivity.class);
            startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();
        }
    }
}