package com.example.mari_.pymescontrol.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterCuentasBancarias;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.CuentaBancaria;
import com.example.mari_.pymescontrol.tools.Constant;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCuentasBancarias extends Fragment {
    RecyclerView recyclerView;
    ArrayList<CuentaBancaria> cuentaBancarias;
    AdapterCuentasBancarias adapterCuentasBancarias;
    private SwipeRefreshLayout swipeRefresh;
    public FragmentCuentasBancarias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cuentas_bancarias, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_cuenta_bancarias);
        swipeRefresh = rootView.findViewById(R.id.fragment_cuenta_bancaria_refresher);
        return  rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        cuentaBancarias = new ArrayList<>();
        adapterCuentasBancarias = new AdapterCuentasBancarias(cuentaBancarias, getActivity(), Constant.FRAGMENT_CUENTA_BANCARIA);
        recyclerView.setAdapter(adapterCuentasBancarias);
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

    private CuentaBancaria createCuentaBancaria(JSONObject jsonCuentas){
        CuentaBancaria cuentaBancaria = null;
        try{
            String nombre = jsonCuentas.getString("nombre");
            String nCuenta = jsonCuentas.getString("cuenta");
            String clabe = jsonCuentas.getString("clabe");
            cuentaBancaria = new CuentaBancaria(nombre, nCuenta, clabe);
        }catch(Exception e){
            //TODO something here
        }
        return cuentaBancaria;
    }

    private void loadData(){
        cuentaBancarias = new ArrayList<>();
        GetCalls.bancos(getActivity(), new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    for(int i = 0; i < jsonObject.length(); i++){
                        JSONObject jsonCuentas = jsonObject.getJSONObject(i);
                        cuentaBancarias.add(createCuentaBancaria(jsonCuentas));
                    }
                }catch (Exception e) {
                    //TODO something here
                }
                adapterCuentasBancarias = new AdapterCuentasBancarias(cuentaBancarias, getActivity(), Constant.FRAGMENT_CUENTA_BANCARIA);
                recyclerView.setAdapter(adapterCuentasBancarias);
                swipeRefresh.setRefreshing(false);
            }
        });
    }
}
