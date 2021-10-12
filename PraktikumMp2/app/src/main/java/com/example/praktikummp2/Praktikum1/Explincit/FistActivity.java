package com.example.praktikummp2.Praktikum1.Explincit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.praktikummp2.R;

public class FistActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViewById(R.id.btnExplicit).setOnClickListener(v -> {
            Intent i = new Intent(FistActivity.this, SecondActivity.class);
            startActivity(i);
        });
    }

}
