package com.example.mari_.pymescontrol;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.Cliente;

import java.util.ArrayList;


public class AdapterCliente extends RecyclerView.Adapter<AdapterCliente.ViewHolder> {
    private ArrayList<Cliente> clienteArrayList;
    private Context context;
    private int fragment;

    public AdapterCliente(ArrayList<Cliente> clienteArrayList, Context context, int fragment) {
        this.clienteArrayList = clienteArrayList;
        this.context = context;
        this.fragment = fragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_clientes, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cNombre.setText(clienteArrayList.get(holder.getAdapterPosition()).getNombre());
        holder.cRfc.setText(clienteArrayList.get(holder.getAdapterPosition()).getRfc());
        holder.cRazonSocial.setText(clienteArrayList.get(holder.getAdapterPosition()).getRazonSocial());
    }

    @Override
    public int getItemCount() {
        return clienteArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cNombre;
        TextView cRfc;
        TextView cRazonSocial;

        ViewHolder(View v){
            super(v);
            cNombre = v.findViewById(R.id.clientes_name);
            cRfc = v.findViewById(R.id.clientes_rfc);
            cRazonSocial = v.findViewById(R.id.clientes_razon_social);
        }
    }
}
