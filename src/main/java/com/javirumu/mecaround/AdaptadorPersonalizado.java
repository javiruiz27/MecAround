package com.javirumu.mecaround;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

class AdaptadorPersonalizado extends ArrayAdapter<Averia> {

    Context ctx;
    int layoutTemplate;
    List<Averia> averiaList;

    public AdaptadorPersonalizado(@NonNull Context context, int resource, @NonNull List<Averia> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.averiaList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        //Obtener la información del elemento de la vista que estoy iterando en este momento.
        Averia elementActual = averiaList.get(position);

        //Rescatar los elementos de la IU de la template
        TextView textViewtitulo = v.findViewById(R.id.textViewTitulo);
        TextView textViewModelo = v.findViewById(R.id.textViewModeloCoche);
        TextView textViewPresupuesto= v.findViewById(R.id.textViewPresupuesto);
        ImageView imageViewModelo = v.findViewById(R.id.imageViewFoto);

        //Hacer un set de los elementos de la entidad actual en los elementos de la IU
        textViewtitulo.setText(elementActual.getTitulo());
        textViewModelo.setText(elementActual.getModeloCoche());
        textViewPresupuesto.setText(elementActual.getNumeroPresupuestos()+ " presupuestos");

        Glide.with(ctx).load(elementActual.getUrlImagen()).into(imageViewModelo);

        return v;
    }
}
