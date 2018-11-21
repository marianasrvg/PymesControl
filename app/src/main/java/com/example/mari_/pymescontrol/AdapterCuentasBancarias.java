package com.example.mari_.pymescontrol;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.CuentaBancaria;

import java.util.ArrayList;


public class AdapterCuentasBancarias extends RecyclerView.Adapter<AdapterCuentasBancarias.ViewHolder>{
    private ArrayList<CuentaBancaria> cuentasBancariasArrayList;
    private Context context;
    private int fragment;

    public AdapterCuentasBancarias(ArrayList<CuentaBancaria> cuentasBancariasArrayList, Context context, int fragment) {
        this.cuentasBancariasArrayList = cuentasBancariasArrayList;
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_cuentas_bancarias, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cbBanco.setText(cuentasBancariasArrayList.get(holder.getAdapterPosition()).getBanco());
        holder.cbNumeroCuenta.setText(cuentasBancariasArrayList.get(holder.getAdapterPosition()).getnCuenta());
        holder.cbClabe.setText(cuentasBancariasArrayList.get(holder.getAdapterPosition()).getClabe());
    }

    @Override
    public int getItemCount() {
        return cuentasBancariasArrayList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cbBanco;
        TextView cbNumeroCuenta;
        TextView cbClabe;

        public ViewHolder(View itemView) {
            super(itemView);
            cbBanco = itemView.findViewById(R.id.c_b_banco);
            cbNumeroCuenta = itemView.findViewById(R.id.c_d_numerocuenta);
            cbClabe = itemView.findViewById(R.id.c_d_clabe);
        }
    }
}
