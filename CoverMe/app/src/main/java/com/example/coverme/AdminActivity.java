package com.example.coverme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminActivity extends AppCompatActivity {

    private CardView cardProfile, cardPolicy, cardClaims, cardBuyPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Initialize toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize views
        cardProfile = findViewById(R.id.cardProfile);
        cardPolicy = findViewById(R.id.cardPolicy);
        cardClaims = findViewById(R.id.cardClaims);
        cardBuyPolicy = findViewById(R.id.cardBuyPolicy);

        // Set click listeners
        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToUserManagement();
            }
        });

        cardPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToContentManagement();
            }
        });

        cardClaims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToTransactions();
            }
        });

        cardBuyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToReports();
            }
        });
    }

    private void navigateToUserManagement() {
        Intent intent = new Intent(AdminActivity.this, UserManagementActivity.class);
        startActivity(intent);
    }

    private void navigateToContentManagement() {
        Intent intent = new Intent(AdminActivity.this, ContentManagementActivity.class);
        startActivity(intent);
    }

    private void navigateToTransactions() {
        Intent intent = new Intent(AdminActivity.this, TransactionActivity.class);
        startActivity(intent);
    }

    private void navigateToReports() {
        Intent intent = new Intent(AdminActivity.this, ReportsActivity.class);
        startActivity(intent);
    }
}
