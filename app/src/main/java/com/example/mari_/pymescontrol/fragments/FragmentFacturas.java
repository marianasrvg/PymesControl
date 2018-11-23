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
    private RecyclerView recyclerView;
    private ArrayList<Factura> facturas;
    private AdapterFacturas adapterFacturas;
    private SwipeRefreshLayout swipeRefresh;
    public FragmentFacturas() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_facturas, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_factura_recycler);
        swipeRefresh = rootView.findViewById(R.id.fragment_factura_refresher);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        facturas = new ArrayList<>();
        adapterFacturas = new AdapterFacturas(Constant.FRAGMENT_FACTURAS, getActivity(), facturas);
        recyclerView.setAdapter(adapterFacturas);
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

    private Factura createFactura(JSONObject jsonFactura){
        try{
            String id = jsonFactura.getString("id");
            String serie = jsonFactura.getString("serie");
            String folio = jsonFactura.getString("folio");
            String nombre = jsonFactura.getString("nombre");
            String estado = jsonFactura.getString("estado");
            String rfc = jsonFactura.getString("rfc");
            String sDate = jsonFactura.getString("fechaTimbre");
            Date date = null;
            if(sDate != "null") {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = formatter.parse(sDate);
            }
            return new Factura(id, serie, folio, nombre, estado, rfc ,date);
        }catch (Exception e){
            return null;
        }
    }

    private void loadData(){
        facturas = new ArrayList<>();
        GetCalls.facturas(getActivity(), new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    for(int i = 0; i < jsonObject.length(); i++){
                        JSONObject jsonFactura = jsonObject.getJSONObject(i);
                        Factura f = createFactura(jsonFactura);
                        facturas.add(f);
                    }
                }catch(Exception e){ }
                adapterFacturas = new AdapterFacturas(Constant.FRAGMENT_FACTURAS, getActivity(), facturas);
                recyclerView.setAdapter(adapterFacturas);
                swipeRefresh.setRefreshing(false);
            }
        });
    }


}
