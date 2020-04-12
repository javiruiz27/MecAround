package com.javirumu.mecaround.controllers.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javirumu.mecaround.R;
import com.javirumu.mecaround.controllers.adapters.MyAveriaRecyclerViewAdapter;
import com.javirumu.mecaround.controllers.interfaces.OnAveriaInteractionListener;
import com.javirumu.mecaround.controllers.models.AveriaDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

public class ListadoAveriasFragment extends Fragment {

    SharedPreferences sharedPrefs;
    RecyclerView recyclerView;
    List<AveriaDB> averiaList;
    OnAveriaInteractionListener mListener;
    Context ctx;

    public ListadoAveriasFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPrefs = getActivity().getSharedPreferences(getString(R.string.preferencias_mecaround_file),
                Context.MODE_PRIVATE);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.activity_incidences, container, false);

        //Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Lista de averias
            averiaList = new ArrayList<>();
            averiaList.addAll(añadeAverias());
            ctx = getActivity();

            recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(averiaList, mListener, ctx));

        }

        return view;
    }

    private Collection<AveriaDB> añadeAverias() {
        Collection<AveriaDB> res = new ArrayList<>();
        res.add(new AveriaDB("Rotura de paragolpes delantero", "Seat Ibiza",
                "Rotura de paragolpes delantero por colisión", 2,
                "https://cdn.euroncap.com/media/29269/seat_ibiza_2017_odb1.jpg?mode=crop&width=359&height=235"));
        return res;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnAveriaInteractionListener) {
            mListener = (OnAveriaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAveriaInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
