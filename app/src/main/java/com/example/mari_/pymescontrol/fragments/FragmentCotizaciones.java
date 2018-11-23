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
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
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

        cotizaciones = new ArrayList<>();

        GetCalls.facturas(getActivity(), new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    for (int i = 0; i < jsonObject.length(); i++){
                        JSONObject jsonCotizacion = jsonObject.getJSONObject(i);
                        cotizaciones.add(createCotizacion(jsonCotizacion));
                    }
                }catch (Exception e){

                }
            }
        });

        adapterCotizaciones = new AdapterCotizaciones(Constant.FRAGMENT_COTIZACIONES, getActivity(), cotizaciones);
        recyclerView.setAdapter(adapterCotizaciones);
    }

    private Cotizacion createCotizacion(JSONObject jsonCotizacion){
        Cotizacion cotizacion = null;
        try{
            int id = Integer.parseInt(jsonCotizacion.getString("id"));
            String titulo = jsonCotizacion.getString("titulo");
            String nombre = jsonCotizacion.getString("cliente");
            String sDate = jsonCotizacion.getString("fecha");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            Date date = formatter.parse(sDate);
            cotizacion = new Cotizacion(id, titulo, nombre, date);
        }catch(Exception e){
            //TODO something with exception
        }
        return cotizacion;
    }
}
