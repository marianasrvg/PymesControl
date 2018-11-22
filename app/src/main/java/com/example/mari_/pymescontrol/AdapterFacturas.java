package com.example.mari_.pymescontrol;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.Factura;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdapterFacturas extends RecyclerView.Adapter<AdapterFacturas.ViewHolder> {

    private ArrayList<Factura> facturaArrayList;
    private Context context;
    private int fragment;

    public AdapterFacturas(int fragment, Context context, ArrayList<Factura> facturas){
        this.facturaArrayList = facturas;
        this.context = context;
        this.fragment = fragment;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView fId;
        TextView fStatus;
        TextView fNombre;
        TextView fFolio;
        TextView fFecha;

        ViewHolder(View v){
            super(v);
            fId = v.findViewById(R.id.factura_id);
            fStatus = v.findViewById(R.id.factura_status);
            fNombre = v.findViewById(R.id.factura_nombre);
            fFolio = v.findViewById(R.id.factura_rfc);
            fFecha = v.findViewById(R.id.factura_fecha);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_facturas, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterFacturas.ViewHolder holder, int position) {
        holder.fId.setText(facturaArrayList.get(holder.getAdapterPosition()).getId());
        holder.fStatus.setText(facturaArrayList.get(holder.getAdapterPosition()).getStatus());
        holder.fNombre.setText(facturaArrayList.get(holder.getAdapterPosition()).getNombre());
        holder.fFolio.setText(facturaArrayList.get(holder.getAdapterPosition()).getNum());
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = dateFormat.format(facturaArrayList.get(holder.getAdapterPosition()).getFecha());
        holder.fFecha.setText(date);
    }

    @Override
    public int getItemCount() {
        return facturaArrayList.size();
    }
}
