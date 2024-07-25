package com.example.coverme;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PremiumPaymentActivity extends AppCompatActivity {

    private RadioGroup paymentTypeRadioGroup;
    private LinearLayout firstPremiumDetailsLayout;
    private RadioGroup paymentFrequencyRadioGroup;
    private EditText premiumAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_payment);

        paymentTypeRadioGroup = findViewById(R.id.radio_group_payment_type);
        firstPremiumDetailsLayout = findViewById(R.id.layout_first_premium_details);
        paymentFrequencyRadioGroup = findViewById(R.id.radio_group_payment_frequency);
        premiumAmountEditText = findViewById(R.id.edit_premium_amount);

        // Set listener for payment type radio group
        paymentTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_first_premium) {
                    // Show details for First Premium
                    firstPremiumDetailsLayout.setVisibility(View.VISIBLE);
                } else {
                    // Show details for Continuing Premium
                    firstPremiumDetailsLayout.setVisibility(View.GONE);
                    // You may add more logic here based on selection of continuing premium options
                }
            }
        });

        // Set listener for make payment button
        findViewById(R.id.btn_make_payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePayment();
            }
        });
    }

    private void makePayment() {
        // Get selected payment type (First Premium or Continuing Premium)
        int selectedPaymentTypeId = paymentTypeRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedPaymentTypeRadioButton = findViewById(selectedPaymentTypeId);
        String paymentType = selectedPaymentTypeRadioButton.getText().toString();

        // Get selected payment frequency
        int selectedFrequencyId = paymentFrequencyRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedFrequencyRadioButton = findViewById(selectedFrequencyId);
        String paymentFrequency = selectedFrequencyRadioButton.getText().toString();

        // Get premium amount entered by user
        String premiumAmount = premiumAmountEditText.getText().toString().trim();

        // Perform validation if needed
        if (premiumAmount.isEmpty()) {
            Toast.makeText(this, "Please enter premium amount", Toast.LENGTH_SHORT).show();
            return;
        }

        // Example: Display payment details (You can modify this as per your actual payment logic)
        String paymentDetails = "Payment Type: " + paymentType + "\n" +
                "Payment Frequency: " + paymentFrequency + "\n" +
                "Premium Amount: Ksh " + premiumAmount;

        Toast.makeText(this, paymentDetails, Toast.LENGTH_LONG).show();

        // Here you can proceed with actual payment processing logic
        // For simplicity, we are just displaying a Toast with payment details
    }
}