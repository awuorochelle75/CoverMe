package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class homePageActivity extends AppCompatActivity {

    private CardView cardProfile, cardPolicy, cardClaims, cardBuyPolicy, cardProducts, cardSettings, cardPremiumPayment, cardTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize and set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize CardView elements
        cardProfile = findViewById(R.id.cardProfile);
        cardPolicy = findViewById(R.id.cardPolicy);
        cardClaims = findViewById(R.id.cardClaims);
        cardBuyPolicy = findViewById(R.id.cardBuyPolicy);
        cardProducts = findViewById(R.id.cardProducts);
        cardSettings = findViewById(R.id.cardSettings);
        cardPremiumPayment = findViewById(R.id.cardPremiumPayment);
        cardTransaction = findViewById(R.id.cardTransaction);

        // Set click listeners for each CardView
        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardProfile click
                Intent intent = new Intent(homePageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        cardPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardPolicy click
                Intent intent = new Intent(homePageActivity.this, PolicyActivity.class);
                startActivity(intent);
            }
        });

        cardClaims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardClaims click
                Intent intent = new Intent(homePageActivity.this, ClaimsActivity.class);
                startActivity(intent);
            }
        });

        cardBuyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardBuyPolicy click
                Intent intent = new Intent(homePageActivity.this, BuyPolicyActivity.class);
                startActivity(intent);
            }
        });

        cardProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardProducts click
                Intent intent = new Intent(homePageActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardSettings click
                Intent intent = new Intent(homePageActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        cardPremiumPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardPremiumPayment click
                Intent intent = new Intent(homePageActivity.this, PremiumPaymentActivity.class);
                startActivity(intent);
            }
        });

        cardTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle cardTransaction click
                Intent intent = new Intent(homePageActivity.this, TransactionActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.contact_info) {
            // Navigate to ContactActivity
            Intent intent = new Intent(homePageActivity.this, ContactInfo.class);
            startActivity(intent);
            return true;

        } else if (itemId == R.id.terms_privacy_policy) {
            // Navigate to TermsPrivacyPolicyActivity (Assuming you have one)
            Intent intent = new Intent(homePageActivity.this, TermsandPrivacy.class);
            startActivity(intent);
            return true;

        } else if (itemId == R.id.logout) {
            // Navigate back to login page and clear activity stack
            Intent intent = new Intent(homePageActivity.this, loginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            return true;
        }

        return false;
    }
}