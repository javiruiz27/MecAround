package com.javirumu.mecaround.controllers;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.javirumu.mecaround.R;
import com.javirumu.mecaround.adapters.AdaptadorPersonalizado;
import com.javirumu.mecaround.fragments.NuevaAveriaDialogo;
import com.javirumu.mecaround.interfaces.OnNuevaAveriaListener;
import com.javirumu.mecaround.model.AveriaDB;

import java.util.ArrayList;
import java.util.List;


public class IncidencesActivity extends AppCompatActivity implements OnNuevaAveriaListener {

    DialogFragment nuevaAveria;

    ListView lista;
    List<AveriaDB> averiaDBS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidences);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = findViewById(R.id.listViewAverias);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevaAveria = new NuevaAveriaDialogo();
                nuevaAveria.show(getSupportFragmentManager(), "NuevaAveriaDialogo");
            }
        });

        averiaDBS = new ArrayList<>();
        averiaDBS.add(new AveriaDB("Choque frontal", "Audi RS3", "https://est.zetaestaticos.com/aragon/img/noticias/1/221/1221451_1.jpg", 2));
        averiaDBS.add(new AveriaDB("Rotura de retrovisor", "Lamborguini Aventador Svj", "", 2));
        averiaDBS.add(new AveriaDB("Pérdida de batería", "Ford Fiesta", "", 2));
        averiaDBS.add(new AveriaDB("Pinchazo en rueda trasera", "Sin cojones", "", 2));

        AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(this, R.layout.averia_item, averiaDBS);

        lista.setAdapter(adapter);

    }

    @Override
    public void onAveriaGuardarClickListener() {
        Toast.makeText(this, "Se ha recibido la avería guardada", Toast.LENGTH_LONG).show();
    }
}
