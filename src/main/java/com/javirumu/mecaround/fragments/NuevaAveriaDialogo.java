package com.javirumu.mecaround.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.javirumu.mecaround.R;
import com.javirumu.mecaround.interfaces.OnNuevaAveriaListener;

public class NuevaAveriaDialogo extends DialogFragment {

    OnNuevaAveriaListener aListener;
    View v;
    EditText editTextTitulo, editTextDescripcion, editTextModeloCoche;
    Context ctx;

    @NonNull
    @Override
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

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            aListener = (OnNuevaAveriaListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement OnNuevaAveriaListener");
        }
    }
}
