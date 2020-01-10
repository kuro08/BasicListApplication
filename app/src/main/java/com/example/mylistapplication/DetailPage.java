package com.example.mylistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailPage extends AppCompatActivity {

    public static final String NAMA = "NAMA";
    public static final String DESKRIPSI = "DESKRIPSI";
    public static final String PHOTO = "GAMBAR";
    public static final String COORDINATES = "KOORDINAT";
    public static final String POPULATION = "POPULASI";
    public static final String CITY = "KOTA TERBESAR";


    TextView tvDesc;
    TextView tvCoor;
    TextView tvPopul;
    TextView tvCity;
    ImageView tvImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String nama = getIntent().getStringExtra(NAMA);
        getSupportActionBar().setTitle("Pulau " +nama);
        tvDesc=findViewById(R.id.tv_item_desc);
        String deskripsi = getIntent().getStringExtra(DESKRIPSI);
        tvDesc.setText(deskripsi);
        tvImage=findViewById(R.id.img_item_photo);
        String gambar = getIntent().getStringExtra(PHOTO);
        Glide.with(this).load(gambar).into(tvImage);

        tvCoor=findViewById(R.id.tv_koordinat);
        String koordinat = getIntent().getStringExtra(COORDINATES);
        tvCoor.setText(koordinat);
        tvPopul=findViewById(R.id.tv_total_penduduk);
        String populasi = getIntent().getStringExtra(POPULATION);
        tvPopul.setText(populasi);
        tvCity=findViewById(R.id.tv_kota_terbesar);
        String kota = getIntent().getStringExtra(CITY);
        tvCity.setText(kota);


    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
