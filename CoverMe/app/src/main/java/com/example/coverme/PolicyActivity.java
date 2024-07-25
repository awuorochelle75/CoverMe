package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PolicyActivity extends AppCompatActivity {

    private TextView textHeading, policyDetailTextView;
    private EditText editFullName, editDateOfBirth, editIdNumber, editPermanentAddress, editCode, editMobileNumber;
    private EditText editKraPin, editEmailAddress, editHeight, editWeight, editBeneficiaryName;
    private EditText editBeneficiaryRelationship, editBeneficiaryDateOfBirth, editBeneficiaryMobile;
    private EditText editNomineeName, editNomineeRelationship, editNomineeDateOfBirth, editNomineeMobileNumber;
    private EditText editBankName, editServiceNo, editBranchDepartment, editAccountNo;
    private EditText editPolicyDescription, editTerm, editAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        // Initialize TextView and EditText fields
        textHeading = findViewById(R.id.text_heading);
        policyDetailTextView = findViewById(R.id.policyDetailTextView);

        editFullName = findViewById(R.id.et_full_name);
        editDateOfBirth = findViewById(R.id.et_date_of_birth);
        editIdNumber = findViewById(R.id.et_id_number);
        editPermanentAddress = findViewById(R.id.et_permanent_address);
        editCode = findViewById(R.id.et_code);
        editMobileNumber = findViewById(R.id.et_mobile_number);
        editKraPin = findViewById(R.id.et_kra_pin);
        editEmailAddress = findViewById(R.id.et_email_address);
        editHeight = findViewById(R.id.et_height);
        editWeight = findViewById(R.id.edit_weight);
        editBeneficiaryName = findViewById(R.id.et_beneficiary_name);
        editBeneficiaryRelationship = findViewById(R.id.et_beneficiary_relationship);
        editBeneficiaryDateOfBirth = findViewById(R.id.edit_beneficiary_date_of_birth);
        editBeneficiaryMobile = findViewById(R.id.edit_beneficiary_mobile);
        editNomineeName = findViewById(R.id.et_nominee_name);
        editNomineeRelationship = findViewById(R.id.et_nominee_relationship);
        editNomineeDateOfBirth = findViewById(R.id.et_nominee_date_of_birth);
        editNomineeMobileNumber = findViewById(R.id.et_nominee_mobile_number);
        editBankName = findViewById(R.id.et_bank_name);
        editServiceNo = findViewById(R.id.et_service_no);
        editBranchDepartment = findViewById(R.id.et_branch_department);
        editAccountNo = findViewById(R.id.et_account_no);
        editPolicyDescription = findViewById(R.id.et_policy_description);
        editTerm = findViewById(R.id.et_term);
        editAmount = findViewById(R.id.et_amount);

        // Fetch and display policy details
        Intent intent = getIntent();
        if (intent != null) {
            // Optionally set the heading and policy details
            textHeading.setText("View Policy Details");
            policyDetailTextView.setText("Policy Details:");

            editFullName.setText(intent.getStringExtra("fullName"));
            editDateOfBirth.setText(intent.getStringExtra("dateOfBirth"));
            editIdNumber.setText(intent.getStringExtra("idNumber"));
            editPermanentAddress.setText(intent.getStringExtra("permanentAddress"));
            editCode.setText(intent.getStringExtra("code"));
            editMobileNumber.setText(intent.getStringExtra("mobileNumber"));
            editKraPin.setText(intent.getStringExtra("kraPin"));
            editEmailAddress.setText(intent.getStringExtra("emailAddress"));
            editHeight.setText(intent.getStringExtra("height"));
            editWeight.setText(intent.getStringExtra("weight"));
            editBeneficiaryName.setText(intent.getStringExtra("beneficiaryName"));
            editBeneficiaryRelationship.setText(intent.getStringExtra("beneficiaryRelationship"));
            editBeneficiaryDateOfBirth.setText(intent.getStringExtra("beneficiaryDateOfBirth"));
            editBeneficiaryMobile.setText(intent.getStringExtra("beneficiaryMobile"));
            editNomineeName.setText(intent.getStringExtra("nomineeName"));
            editNomineeRelationship.setText(intent.getStringExtra("nomineeRelationship"));
            editNomineeDateOfBirth.setText(intent.getStringExtra("nomineeDateOfBirth"));
            editNomineeMobileNumber.setText(intent.getStringExtra("nomineeMobileNumber"));
            editBankName.setText(intent.getStringExtra("bankName"));
            editServiceNo.setText(intent.getStringExtra("serviceNo"));
            editBranchDepartment.setText(intent.getStringExtra("branchDepartment"));
            editAccountNo.setText(intent.getStringExtra("accountNo"));
            editPolicyDescription.setText(intent.getStringExtra("policyDescription"));
            editTerm.setText(intent.getStringExtra("term"));
            editAmount.setText(intent.getStringExtra("amount"));
        }
    }
}
