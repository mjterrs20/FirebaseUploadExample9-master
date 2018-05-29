package com.example.asus.firebaseuploadexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Pesan extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ProgressDialog mProgresDialog;
    //private DatabaseReference databaseReference;
    private EditText pesanNama,pesanNoktp,pesanJumlah,pesanNorek;
    private Button buttonsPesan;
    Pemesan pemesan;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_pesan );

        database = FirebaseDatabase.getInstance ();
        ref = database.getReference ("Pemesan");
        pesanNama = (EditText) findViewById ( R.id.pesanNama );
        pesanNoktp = (EditText) findViewById ( R.id.pesanKtp );
        pesanJumlah = (EditText) findViewById ( R.id.pesanJumlah );
        pesanNorek = (EditText) findViewById ( R.id.pesanNorek );
        buttonsPesan = (Button) findViewById ( R.id.buttonPesan );


        buttonsPesan.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                uploadData();
                Intent i = new Intent(Pesan.this, Depan.class);
                startActivity(i);
            }
        } );

    }


    private void uploadData(){
        mProgresDialog = new ProgressDialog ( Pesan.this );
        mProgresDialog.setMessage ( "Memesan Pilihan ...." );
        mProgresDialog.show();

        ref.addValueEventListener ( new ValueEventListener ( ) {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child ( pesanNama.getText ().toString ()).exists ()){
                    mProgresDialog.dismiss ();
                    Toast.makeText ( Pesan.this,"Anda Telah Memesan", Toast.LENGTH_LONG ).show ();
                }
                else{
                    mProgresDialog.dismiss ();
                    Pemesan pemesan = new Pemesan(pesanNama.getText ().toString (),pesanNoktp.getText ().toString (),
                            pesanJumlah.getText ().toString (),pesanNorek.getText ().toString () );
                    ref.child ( pesanNama.getText ().toString () ).setValue ( pemesan );
                    Toast.makeText ( Pesan.this,"Berbasil pesan",Toast.LENGTH_SHORT ).show ();
                    Intent i = new Intent (Pesan.this,Depan.class);
                    startActivity ( i );
                    finish ();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );
    }

}
