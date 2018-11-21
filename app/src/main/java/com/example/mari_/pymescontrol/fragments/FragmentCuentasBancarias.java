package com.example.mari_.pymescontrol.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.AdapterCuentasBancarias;
import com.example.mari_.pymescontrol.AdapterProdcutoServicio;
import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.CuentaBancaria;
import com.example.mari_.pymescontrol.beans.ProductoServicio;
import com.example.mari_.pymescontrol.tools.Constant;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCuentasBancarias extends Fragment {
    RecyclerView recyclerView;
    ArrayList<CuentaBancaria> cuentaBancarias;
    AdapterCuentasBancarias adapterCuentasBancarias;

    public FragmentCuentasBancarias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cuentas_bancarias, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_cuenta_bancarias);
        return  rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        cuentaBancarias = new ArrayList<>();
        cuentaBancarias.add(new CuentaBancaria("Banamex", "xxxxxxxxx", "11.98"));
        cuentaBancarias.add(new CuentaBancaria("Bancomer", "xxxxxxxxxxx", "11.98"));
        cuentaBancarias.add(new CuentaBancaria("Santander", "xxxxxxxxx", "11.98"));
        adapterCuentasBancarias = new AdapterCuentasBancarias(cuentaBancarias, getActivity(), Constant.FRAGMENT_CUENTA_BANCARIA);
        recyclerView.setAdapter(adapterCuentasBancarias);
    }
}
