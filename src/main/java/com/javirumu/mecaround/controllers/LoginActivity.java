package com.javirumu.mecaround.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.javirumu.mecaround.R;

public class LoginActivity extends AppCompatActivity {

    ImageView logotipo;
    EditText editTextEmail, editTextPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide toolbar
        getSupportActionBar().hide();

        ///Cargamos el logotipo con glide
        logotipo = (ImageView) this.findViewById(R.id.imageViewIcon);

        RequestOptions cropOptions = new RequestOptions().centerCrop();

        Glide.with(this)
                .load("http://www.miguelcamposrivera.com/logo_mecaround.png")
                .apply(cropOptions)
                .into(logotipo);
        /************************************/

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        //Aqui basicamente lo que hacemos es coger y ver si las credenciales están almacenadas en el fichero isLogin

        //Obtener las preferencias
        sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);

        //Averiguo si las variables de preferencias isLogin es true para saber si
        // el usuario está logueado. En ese caso redirigo a la pestaña de incidencias
        boolean isLogin = sharedPref.getBoolean(getString(R.string.preferencias_isLogin), false);
        if(isLogin){
            Intent i = new Intent(this, IncidencesActivity.class);
            startActivity(i);
        }

    }

    public void doLogin(View v){
        final String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(!email.isEmpty() && !password.isEmpty()){
            //Aqui meteremos lo de la API

            /***************************/

            //Guardamos los datos del login en Preferencias, a modo de variables de sesión
            sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.preferencias_email), email);
            editor.putBoolean(getString(R.string.preferencias_isLogin), true);
            editor.commit();

            //Nos movemos al intent
            Intent i = new Intent(this, IncidencesActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(this, "Los datos introducidos no son correctos", Toast.LENGTH_SHORT).show();
        }
    }
}
