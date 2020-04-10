package com.javirumu.mecaround.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.javirumu.mecaround.R;
import com.javirumu.mecaround.interfaces.OnNuevaAveriaListener;
import com.javirumu.mecaround.model.AveriaDB;


public class EditTextAveriaDialog extends DialogFragment {

    private long idAveria;

    OnNuevaAveriaListener aListener;
    View v;
    EditText editTextTitulo, editTextDescripcion, editTextModeloCoche;
    Context ctx;

    public EditTextAveriaDialog() {
        // Required empty public constructor
    }

    public static EditTextAveriaDialog newInstance(long idAveria) {
        EditTextAveriaDialog fragment = new EditTextAveriaDialog();
        Bundle args = new Bundle();
        args.putLong(AveriaDB.AVERIADB_ID, idAveria);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           idAveria = getArguments().getLong(AveriaDB.AVERIADB_ID);
        }
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        ctx = getActivity();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        v = inflater.inflate(R.layout.dialogo_nueva_averia, null);
        editTextTitulo = v.findViewById(R.id.textViewTitulo);
        editTextDescripcion = v.findViewById(R.id.textDescription);
        editTextModeloCoche = v.findViewById(R.id.textViewModeloCoche);

        builder.setView(v);

        builder.setTitle("Nueva Avería")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String titulo = editTextTitulo.getText().toString();
                        String modeloCoche = editTextModeloCoche.getText().toString();
                        String descripcion = editTextDescripcion.getText().toString();

                        //Si los datos que le estamos pasando a traves del dialogo no son vacios, los mandamos
                        //al metodo del activity que nos permitirá guardar los datos en la BD
                        if(!titulo.isEmpty() && !modeloCoche.isEmpty() && !descripcion.isEmpty()){
                            aListener.onAveriaGuardarClickListener(titulo, modeloCoche, descripcion);

                            dialog.dismiss();
                        }else{
                            Toast.makeText(ctx, "Introduzca todos los datos", Toast.LENGTH_LONG);
                        }


                        aListener.onAveriaGuardarClickListener();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancelar --> Cerrar el cuadro de diálogo
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


}
