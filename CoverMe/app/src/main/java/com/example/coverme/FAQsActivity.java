package com.example.coverme;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FAQsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        // Initialize views
        TextView faqsText = findViewById(R.id.faqs_text);
        TextView question1 = findViewById(R.id.question1);
        TextView answer1 = findViewById(R.id.answer1);
        TextView question2 = findViewById(R.id.question2);
        TextView answer2 = findViewById(R.id.answer2);
        TextView question3 = findViewById(R.id.question3);
        TextView answer3 = findViewById(R.id.answer3);
        TextView question4 = findViewById(R.id.question4);
        TextView answer4 = findViewById(R.id.answer4);
        TextView question5 = findViewById(R.id.question5);
        TextView answer5 = findViewById(R.id.answer5);
        TextView question6 = findViewById(R.id.question6);
        TextView answer6 = findViewById(R.id.answer6);
        TextView question7 = findViewById(R.id.question7);
        TextView answer7 = findViewById(R.id.answer7);
        TextView question8 = findViewById(R.id.question8);
        TextView answer8 = findViewById(R.id.answer8);
        TextView question9 = findViewById(R.id.question9);
        TextView answer9 = findViewById(R.id.answer9);
        TextView question10 = findViewById(R.id.question10);
        TextView answer10 = findViewById(R.id.answer10);

        // Set the text for each question and answer
        question1.setText("Q: What types of insurance policies do you offer?");
        answer1.setText("A: We offer a range of insurance policies including life insurance, health insurance, auto insurance, home insurance, and more. Each policy is designed to meet specific needs and provide coverage in different areas.");

        question2.setText("Q: How can I file a claim?");
        answer2.setText("A: You can file a claim by contacting our customer service department or through our online portal. We will guide you through the process and assist you with any documentation required to complete your claim.");

        question3.setText("Q: What factors affect insurance premiums?");
        answer3.setText("A: Insurance premiums are influenced by various factors such as age, gender, location, driving record (for auto insurance), health status (for health insurance), coverage limits, deductibles, and the type of insurance policy.");

        question4.setText("Q: Can I cancel my insurance policy?");
        answer4.setText("A: Yes, you can cancel your insurance policy at any time. However, there may be penalties or fees associated with early cancellation, and you may lose coverage benefits. It's important to review the terms and conditions of your policy before canceling.");

        question5.setText("Q: What does my insurance policy cover?");
        answer5.setText("A: The coverage provided by your insurance policy depends on the type of policy you have and the specific terms outlined in your policy documents. Common coverage includes property damage, bodily injury liability, medical expenses, and personal property protection.");

        question6.setText("Q: How are insurance claims processed?");
        answer6.setText("A: Insurance claims are processed by submitting a claim form along with any supporting documentation (such as police reports, medical bills, or repair estimates) to your insurance provider. The provider will review the claim and determine coverage eligibility based on the terms of your policy.");

        question7.setText("Q: Can I change my coverage limits?");
        answer7.setText("A: Yes, you can change your coverage limits. However, any changes to your coverage may affect your insurance premiums. It's important to consult with your insurance provider to understand how adjusting your coverage limits will impact your policy.");

        question8.setText("Q: What is a deductible?");
        answer8.setText("A: A deductible is the amount of money you are required to pay out-of-pocket before your insurance coverage kicks in. For example, if you have a $500 deductible on your auto insurance policy and you file a claim for $2,000 in damages, you would pay $500 and your insurance company would cover the remaining $1,500.");

        question9.setText("Q: How can I lower my insurance premiums?");
        answer9.setText("A: You can lower your insurance premiums by maintaining a clean driving record (for auto insurance), improving your credit score (for all types of insurance), bundling multiple policies with the same provider, increasing your deductibles, and taking advantage of discounts offered by your insurance company.");

        question10.setText("Q: What happens if I miss a premium payment?");
        answer10.setText("A: If you miss a premium payment, your insurance policy may lapse, meaning you will lose coverage. However, many insurance companies offer a grace period during which you can still make a payment to keep your policy active. It's important to contact your insurance provider as soon as possible if you are unable to make a payment to discuss your options.");
    }
}