package com.example.praktikummp2.Praktikum1.Passing;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktikummp2.R;

public class Out extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);

        TextView Nama = (TextView) findViewById(R.id.tv_Nama);
        TextView NIM = (TextView) findViewById(R.id.tv_NIM);
        TextView Prodi = (TextView) findViewById(R.id.tv_Prodi);

        if(getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            Nama.setText(bundle.getString("Nama"));
            NIM.setText(bundle.getString("NIM"));
            Prodi.setText(bundle.getString("Prodi"));
        }else{
            Nama.setText(getIntent().getStringExtra("Nama"));
            NIM.setText(getIntent().getStringExtra("NIM"));
            Prodi.setText(getIntent().getStringExtra("Prodi"));
        }
    }
}