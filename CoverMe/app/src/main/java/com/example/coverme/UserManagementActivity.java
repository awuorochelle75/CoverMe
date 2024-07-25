package com.example.coverme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class UserManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);

        Button viewUsersButton = findViewById(R.id.btnViewUsers);
        viewUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Firebase Authentication Users URL
                String firebaseAuthURL = "https://console.firebase.google.com/u/0/project/YOUR_PROJECT_ID/authentication/users";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(firebaseAuthURL));
                startActivity(intent);
            }
        });
    }
}
