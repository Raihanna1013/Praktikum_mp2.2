package com.example.praktikummp2.Praktikum1.Implicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.praktikummp2.R;

import android.widget.Toast;

import com.example.praktikummp2.BuildConfig;

public class Implicit_Intent extends AppCompatActivity {

    Button maps, wa, telegram, instagram, facebook, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit__intent);


        if(BuildConfig.DEBUG) {

        }
        findViewById(R.id.btnCamera).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivity(i);
        });

        EditText et = findViewById(R.id.etNo);
        findViewById(R.id.btnGallery).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://media/external/images/media/"));
            startActivity(i);
        });

        findViewById(R.id.btnBrowser).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.google.com"));
            startActivity(i);
        });

        findViewById(R.id.btnContact).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://contacts/people"));
            startActivity(i);
        });

        findViewById(R.id.btnDial).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+et.getText()));
            startActivity(i);
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:" + et.getText()));
            startActivity(i);

            startActivity(new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:" + et.getText())));
        });
        maps = findViewById(R.id.btnMaps);
        wa = findViewById(R.id.btnWA);
        telegram = findViewById(R.id.btnTele);
        instagram = findViewById(R.id.btnIG);
        facebook = findViewById(R.id.btnFB);
        email = findViewById(R.id.btnEmail);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.google.com/maps/place/Jl.+Candi+Gebang,+Jetis,+Wedomartani,+Kec.+Ngemplak,+Kabupaten+Sleman,+Daerah+Istimewa+Yogyakarta+55584/@-7.7483631,110.4119603,56m/data=!3m1!1e3!4m8!1m2!2m1!1sRuko+2,+JL.+Candi+Gebang+1,+Sleman,+Yogyakarta,+DI+Yogyakarta,+Indonesia!3m4!1s0x2e7a59772460fa9b:0xc50c490c4256cc76!8m2!3d-7.7483231!4d110.4118834");
            }
        });
        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://api.whatsapp.com/send/?phone=%2B6287839953366&text&app_absent=0");
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://telegram.me/jitc_yk");
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/jitc_yk/");
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://web.facebook.com/infojitc");
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jitcyk.official@gmail.com"});
                intent.putExtra(Intent.EXTRA_CC, new String[] {""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                try {
                    startActivity(Intent.createChooser(intent, "Ingin Mengirim Email?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Implicit_Intent.this, "Tidak ada aplikasi yang mendukung", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void gotoUrl(String string) {
        Uri uri = Uri.parse(string);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}