package com.javirumu.mecaround.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.javirumu.mecaround.R;

public class LoginActivity extends AppCompatActivity {

    ImageView logotipo;

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logotipo = (ImageView) this.findViewById(R.id.imageViewIcon);
        editTextEmail = (EditText) this.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) this.findViewById(R.id.editTextPassword);

        RequestOptions cropOptions = new RequestOptions().centerCrop();

        Glide.with(this)
                .load("http://www.miguelcamposrivera.com/logo_mecaround.png")
                .apply(cropOptions)
                .into(logotipo);


        //Si a la hora de crear el activity el usuario ya está iniciado sesión se inicia del tirón
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);

        boolean isLogin = sharedPref.getBoolean(getString(R.string.preferencias_isLogin), false);
        if(isLogin){
            Intent intent = new Intent(this, IncidencesActivity.class);
            startActivity(intent);

        }
    }

    public void doLogin(View view) {
        String email = this.editTextEmail.getText().toString();
        String password = this.editTextPassword.getText().toString();

        if(email.equals("javi@gmail.com") && password.equals("1234")){
            //Login conrrecto

            //Guardar los datos del login
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.preferencias_email), email);
            editor.putBoolean(getString(R.string.preferencias_isLogin), true);
            editor.commit();

            Intent intent = new Intent(this, IncidencesActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Email y/o contraseña incorrecta", Toast.LENGTH_LONG);
        }

    }
}
