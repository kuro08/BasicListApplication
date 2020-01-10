package com.example.mylistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Halaman Tentang");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
