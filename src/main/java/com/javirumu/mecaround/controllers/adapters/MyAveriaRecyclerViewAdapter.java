package com.javirumu.mecaround.controllers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javirumu.mecaround.R;
import com.javirumu.mecaround.controllers.interfaces.OnAveriaInteractionListener;
import com.javirumu.mecaround.controllers.models.AveriaDB;

import java.util.List;

public class MyAveriaRecyclerViewAdapter extends RecyclerView.Adapter<MyAveriaRecyclerViewAdapter.ViewHolder> {

    private final List<AveriaDB> aValues;
    private final OnAveriaInteractionListener mListener;
    private Context ctx;

    public MyAveriaRecyclerViewAdapter(List<AveriaDB> aValues, OnAveriaInteractionListener mListener, Context ctx) {
        this.aValues = aValues;
        this.mListener = mListener;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyAveriaRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_listado_averias_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAveriaRecyclerViewAdapter.ViewHolder holder, int position) {

        holder.mItem = aValues.get(position);

        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewModeloCoche.setText(holder.mItem.getModeloCoche());
        holder.textViewNumPresupuestos.setText(holder.mItem.getPresupuestos());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onAveriaClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return aValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AveriaDB mItem;
        public final TextView textViewTitulo;
        public final TextView textViewModeloCoche;
        public final TextView textViewNumPresupuestos;
        public final ImageView imageViewFotoAveria;
        public final View mView;



        public ViewHolder(@NonNull View view) {
            super(view);
            mView = view;
            textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
            textViewModeloCoche = (TextView) view.findViewById(R.id.textViewModeloCoche);
            textViewNumPresupuestos = (TextView) view.findViewById(R.id.textViewPresupuesto);
            imageViewFotoAveria = (ImageView) view.findViewById(R.id.imageViewFoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }
}
