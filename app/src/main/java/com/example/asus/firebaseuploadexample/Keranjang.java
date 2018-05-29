package com.example.asus.firebaseuploadexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Keranjang extends AppCompatActivity {
    ListView lv;
    FirebaseListAdapter adapter;
    public double r = 0;
    public double hitung = 0;
    public double hasil = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_keranjang );

        lv = findViewById ( R.id.listVIew );
        Query query = FirebaseDatabase.getInstance ().getReference ().child ( "Pemesan" );
        FirebaseListOptions<Pemesan> options = new FirebaseListOptions.Builder<Pemesan> ()
                .setLayout ( R.layout.view_keranjang )
                .setQuery ( query,Pemesan.class )
                .build();
        adapter = new FirebaseListAdapter (options ) {
            @Override
            protected void populateView(View v, Object model, int position) {

                TextView name = v.findViewById ( R.id.viewName );
                TextView ktp = v.findViewById ( R.id.viewNoktp );
                TextView jumlah = v.findViewById ( R.id.viewJumlah );
                TextView hasil = v.findViewById ( R.id.viewHasil );
                TextView norek = v.findViewById ( R.id.viewNorek );

                Pemesan pemesan = (Pemesan) model;
                r = Double.parseDouble (pemesan.getJumlah ().toString());
                hitung = ( r * 0.1) + r ;
                String h = String.valueOf ( hitung );

                name.setText ( "Name: "+pemesan.getName ().toString ());
                ktp.setText ( "No KTP : "+pemesan.getNoktp ().toString () );
                jumlah.setText ( "Modal  : "+pemesan.getJumlah ().toString ());
                hasil.setText ( "Hasil : "+ h);
                norek.setText ( "Silahkan Melakukan Pembayaran ke Rekening : 101.00.98300.997 (Mandiri) " );
            }
        };
        lv.setAdapter(adapter);
    }
    protected void onStart() {
        super.onStart ( );
        adapter.startListening ();
    }

    @Override
    protected void onStop() {
        super.onStop ( );
        adapter.stopListening ();
    }

}
