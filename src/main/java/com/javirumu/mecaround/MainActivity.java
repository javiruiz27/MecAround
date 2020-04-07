package com.javirumu.mecaround;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    ImageView logotipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logotipo = (ImageView) this.findViewById(R.id.imageViewIcon);

        RequestOptions cropOptions = new RequestOptions().centerCrop();

        Glide.with(this)
                .load("http://www.miguelcamposrivera.com/logo_mecaround.png")
                .apply(cropOptions)
                .into(logotipo);


    }

    public void iniciarActivity(View view) {

        Intent intent = new Intent(this, Incidences.class);
        startActivity(intent);

    }
}
