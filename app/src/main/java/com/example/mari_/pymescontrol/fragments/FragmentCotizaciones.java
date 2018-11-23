package com.example.mari_.pymescontrol.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
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
    private SwipeRefreshLayout swipeRefresh;
    public FragmentCotizaciones() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_cotizaciones, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_cotizaciones_recycler);
        swipeRefresh = rootView.findViewById(R.id.fragment_cotizacion_refresher);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        cotizaciones = new ArrayList<>();
        adapterCotizaciones = new AdapterCotizaciones(Constant.FRAGMENT_COTIZACIONES, getActivity(), cotizaciones);
        recyclerView.setAdapter(adapterCotizaciones);
        swipeRefresh.setColorSchemeColors(ContextCompat.getColor(getContext(),R.color.colorLightBlue));
        swipeRefresh.setRefreshing(true);
        loadData();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    private Cotizacion createCotizacion(JSONObject jsonCotizacion){
        try{
            String id = jsonCotizacion.getString("id");
            String folio = jsonCotizacion.getString("numero");
            String titulo = jsonCotizacion.getString("titulo");
            String nombre = jsonCotizacion.getString("cliente");
            String sDate = jsonCotizacion.getString("fecha");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(sDate);
            return new Cotizacion(id, folio, titulo, nombre, date);
        }catch(Exception e){
           return null;
        }
    }

    private void loadData(){
        cotizaciones = new ArrayList<>();
        GetCalls.cotizaciones(getActivity(), new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    for (int i = 0; i < jsonObject.length(); i++){
                        JSONObject jsonCotizacion = jsonObject.getJSONObject(i);
                        cotizaciones.add(createCotizacion(jsonCotizacion));
                    }
                }catch (Exception e){}
                adapterCotizaciones = new AdapterCotizaciones(Constant.FRAGMENT_COTIZACIONES, getActivity(), cotizaciones);
                recyclerView.setAdapter(adapterCotizaciones);
                swipeRefresh.setRefreshing(false);
            }
        });
    }
}
