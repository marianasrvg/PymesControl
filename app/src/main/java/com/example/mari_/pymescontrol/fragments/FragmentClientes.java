package com.example.mari_.pymescontrol.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterCliente;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.Cliente;
import com.example.mari_.pymescontrol.tools.Constant;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClientes extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Cliente> clienteArrayList;
    AdapterCliente adapterCliente;

    public FragmentClientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_clientes, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_cliente);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        clienteArrayList = new ArrayList<>();

        GetCalls.clientes(getActivity(), new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try {
                    JSONArray jsonObject = new JSONArray(response);
                    for(int i = 0; i < jsonObject.length(); i++){
                        JSONObject jsonClient = jsonObject.getJSONObject(i);
                        clienteArrayList.add(createCliente(jsonClient));
                    }
                }catch(Exception e){
                    //TODO something e
                }
            }
        });

        adapterCliente = new AdapterCliente(clienteArrayList, getActivity(), Constant.FRAGMENT_CLIENTE);
        recyclerView.setAdapter(adapterCliente);
    }

    private Cliente createCliente(JSONObject jsonClient){
        Cliente cliente = null;
        try{
            String nombre = jsonClient.getString("nombre");
            String rfc = jsonClient.getString("rfc");
            String razonSocial = jsonClient.getString("nombre");
            cliente = new Cliente(nombre, rfc, razonSocial);
        }catch(Exception e){
            //TODO something e
        }
        return cliente;
    }
}
