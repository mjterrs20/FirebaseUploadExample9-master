package com.example.asus.firebaseuploadexample.kontak;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.asus.firebaseuploadexample.R;

public class Kontak extends AppCompatActivity {

    ImageButton fb1;
    ImageButton in1;
    ImageButton gm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView ( R.layout.activity_kontak );

        fb1 = findViewById(R.id.fb1);
        in1 = findViewById(R.id.in1);
        gm1 = findViewById(R.id.gm1);

        //Inten ke facebook
        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100001786966711"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rizki.aditia.5851")));
                }
            }
        });



        //Intent ke email
        gm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","aditia20.riz@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kritik & Saran");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Saran saya adalah :  ");
                startActivity(Intent.createChooser(emailIntent, "Send email"));
            }
        });




        //Intent ke Instagram
        in1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/pearl_maknun");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/mj_uhuy")));
                }
            }
        });



    }
}
