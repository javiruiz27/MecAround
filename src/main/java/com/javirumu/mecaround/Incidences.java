package com.javirumu.mecaround;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Incidences extends AppCompatActivity implements OnNuevaAveriaListener {

    DialogFragment nuevaAveria;

    ListView lista;
    List<Averia> averias;



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

        averias = new ArrayList<>();
        averias.add(new Averia("Choque frontal", "Audi RS3", "https://est.zetaestaticos.com/aragon/img/noticias/1/221/1221451_1.jpg", 2));
        averias.add(new Averia("Rotura de retrovisor", "Lamborguini Aventador Svj", "", 2));
        averias.add(new Averia("Pérdida de batería", "Ford Fiesta", "", 2));
        averias.add(new Averia("Pinchazo en rueda trasera", "Sin cojones", "", 2));

        AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(this, R.layout.averia_item, averias);

        lista.setAdapter(adapter);

    }

    @Override
    public void onAveriaGuardarClickListener() {
        Toast.makeText(this, "Se ha recibido la avería guardada", Toast.LENGTH_LONG).show();
    }
}
