package com.javirumu.mecaround;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.Toast;

public class Incidences extends AppCompatActivity implements OnNuevaAveriaListener {

    DialogFragment nuevaAveria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidences);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevaAveria = new NuevaAveriaDialogo();
                nuevaAveria.show(getSupportFragmentManager(), "NuevaAveriaDialogo");
            }
        });
    }

    @Override
    public void onAveriaGuardarClickListener() {
        Toast.makeText(this, "Se ha recibido la avería guardada", Toast.LENGTH_LONG).show();
    }
}
