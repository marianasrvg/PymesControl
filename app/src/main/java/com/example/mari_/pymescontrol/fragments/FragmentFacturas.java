package com.example.mari_.pymescontrol.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterFacturas;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.Factura;
import com.example.mari_.pymescontrol.tools.Constant;

import java.util.ArrayList;
import java.util.Date;

public class FragmentFacturas extends Fragment {
   RecyclerView recyclerView;
   ArrayList<Factura> facturas;
   AdapterFacturas adapterFacturas;

    public FragmentFacturas() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_facturas, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_factura_recycler);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        Date date = new Date();
        facturas = new ArrayList<>();
        facturas.add(new Factura("Mariana Sierra", "Timbrado", "A15","XA00AX",date));
        facturas.add(new Factura("Mariana Sierra", "Timbrado", "A15","XA00AX",date));
        facturas.add(new Factura("Mariana Sierra", "Timbrado", "A15","XA00AX",date));
        facturas.add(new Factura("Mariana Sierra", "Timbrado", "A15","XA00AX",date));

        adapterFacturas = new AdapterFacturas(Constant.FRAGMENT_FACTURAS, getActivity(), facturas);
        recyclerView.setAdapter(adapterFacturas);
    }


}
