package com.example.mari_.pymescontrol.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterCotizaciones;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.Cotizacion;
import com.example.mari_.pymescontrol.tools.Constant;

import java.util.ArrayList;
import java.util.Date;


public class FragmentCotizaciones extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Cotizacion> cotizaciones;
    AdapterCotizaciones adapterCotizaciones;

    public FragmentCotizaciones() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_cotizaciones, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_cotizaciones_recycler);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        Date date = new Date();
        cotizaciones = new ArrayList<>();
        cotizaciones.add(new Cotizacion(1, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(2, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(3, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(5, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(6, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(7, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(8, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(9, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(10, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(11, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(12, "Cotizacion prueba", "Mariana Sierra", date));
        cotizaciones.add(new Cotizacion(13, "Cotizacion prueba", "Mariana Sierra", date));

        adapterCotizaciones = new AdapterCotizaciones(Constant.FRAGMENT_COTIZACIONES, getActivity(), cotizaciones);
        recyclerView.setAdapter(adapterCotizaciones);
    }


}
