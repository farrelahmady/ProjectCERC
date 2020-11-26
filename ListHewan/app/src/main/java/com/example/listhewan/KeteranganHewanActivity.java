package com.example.listhewan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.listhewan.Data.Hewan;

import de.hdodenhof.circleimageview.CircleImageView;

public class KeteranganHewanActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextView tvNama;
    private TextView tvJenis;
    private TextView tvKeterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan_hewan);

        circleImageView = findViewById(R.id.img_item_photo);
        tvNama = findViewById(R.id.tvNama);
        tvJenis = findViewById(R.id.tvJenis);
        tvKeterangan = findViewById(R.id.tvKeterangan);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String jenis = intent.getStringExtra("jenis");
        String photo = intent.getStringExtra("photo");
        String keterangan = intent.getStringExtra("keterangan");
        Glide.with(getApplicationContext())
                .load(photo)
                .apply(new RequestOptions().override(350, 550))
                .into(circleImageView);

        tvNama.setText(name);
        tvJenis.setText(jenis);
        tvKeterangan.setText(keterangan);
    }
}