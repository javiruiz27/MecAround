package com.javirumu.mecaround.controllers;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.javirumu.mecaround.R;
import com.javirumu.mecaround.controllers.fragments.NuevaAveriaDialogo;
import com.javirumu.mecaround.controllers.interfaces.OnNuevaAveriaListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.Toast;

public class IncidencesActivity extends AppCompatActivity implements OnNuevaAveriaListener {

    DialogFragment dialogNuevaAveria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidences);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogNuevaAveria = new NuevaAveriaDialogo();
                dialogNuevaAveria.show(getSupportFragmentManager(), "Nueva Avería Diálogo");
            }
        });
    }


    @Override
    public void onNuevaAveriaClickListener() {
        Toast.makeText(this, "La avería ha sido guardada", Toast.LENGTH_SHORT).show();
    }
}
