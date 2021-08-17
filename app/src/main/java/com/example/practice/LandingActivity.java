package com.example.practice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    Button btnLetsLearn, btnAdminPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        addListenerOnButton();
    }

    private void addListenerOnButton() {

        final Context context = this;
        btnLetsLearn = (Button) findViewById(R.id.btnLearn);
        btnLetsLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MainActivity.class);
            
                startActivity(intent);

            }

        });

        btnAdminPage = (Button) findViewById(R.id.btnLaunchAdmin);
        btnAdminPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent intent = new Intent(context, MainActivity.class);
                Intent intent = new Intent(context, AdminPageActivity.class);
                startActivity(intent);

            }

        });
    }
}
