package com.example.mari_.pymescontrol.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterProdcutoServicio;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.ProductoServicio;
import com.example.mari_.pymescontrol.tools.Constant;

import java.util.ArrayList;


public class FragmentProductoServicio extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ProductoServicio> productoServicios;
    AdapterProdcutoServicio adapterProdcutoServicio;

    public FragmentProductoServicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_producto_servicio, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_producto_servicio);
        return  rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        productoServicios = new ArrayList<>();
        productoServicios.add(new ProductoServicio("Nike", "Descripcion", 11.98));
        productoServicios.add(new ProductoServicio("Nike", "Descripcion", 11.98));
        productoServicios.add(new ProductoServicio("Nike", "Descripcion", 11.98));
        adapterProdcutoServicio = new AdapterProdcutoServicio(Constant.FRAGMENT_PRODUCTOS_SERVICIOS, getActivity(), productoServicios);
        recyclerView.setAdapter(adapterProdcutoServicio);
    }

    


}
