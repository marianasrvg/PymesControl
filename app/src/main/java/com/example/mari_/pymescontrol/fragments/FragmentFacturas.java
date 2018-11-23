package com.example.mari_.pymescontrol.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterFacturas;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.Factura;
import com.example.mari_.pymescontrol.tools.Constant;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
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

        facturas = new ArrayList<>();
        GetCalls.facturas(getActivity(), new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    for(int i = 0; i < jsonObject.length(); i++){
                        JSONObject jsonFactura = jsonObject.getJSONObject(i);
                        facturas.add(createFactura(jsonFactura));
                    }
                }catch(Exception e){
                    //TODO something e
                }
            }
        });

        adapterFacturas = new AdapterFacturas(Constant.FRAGMENT_FACTURAS, getActivity(), facturas);
        recyclerView.setAdapter(adapterFacturas);
    }

    private Factura createFactura(JSONObject jsonFactura){
        Factura factura = null;
        try{
            String nombre = jsonFactura.getString("nombre");
            String estado = jsonFactura.getString("estado");
            String status = estado == "1" ? "Timbrado":"No timbrado";
            String id = jsonFactura.getString("id");
            String num = jsonFactura.getString("rfc");
            String sDate = jsonFactura.getString("fechaTimbre");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            Date date = formatter.parse(sDate);
            factura = new Factura(nombre,status,id,num,date);
        }catch (Exception e){
            //TODO something e
        }
        return factura;
    }


}
