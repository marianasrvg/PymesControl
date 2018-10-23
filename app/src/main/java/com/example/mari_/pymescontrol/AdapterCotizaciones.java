package com.example.mari_.pymescontrol;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.Cotizacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AdapterCotizaciones extends RecyclerView.Adapter<AdapterCotizaciones.ViewHolder> {
    private ArrayList<Cotizacion> cotizacionArrayList;
    private Context context;
    private int fragment;

    public AdapterCotizaciones(int fragment, Context context, ArrayList<Cotizacion> cotizacionArrayList) {
        this.cotizacionArrayList = cotizacionArrayList;
        this.context = context;
        this.fragment = fragment;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView cId;
        TextView cTitulo;
        TextView cNombre;
        TextView cFecha;

        ViewHolder(View v){
            super(v);
            cId = v.findViewById(R.id.cotizacion_num);
            cTitulo = v.findViewById(R.id.cotizacion_titulo);
            cNombre = v.findViewById(R.id.cotizacion_nombre);
            cFecha = v.findViewById(R.id.cotizacion_fecha);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cotizaciones, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int id = cotizacionArrayList.get(holder.getAdapterPosition()).getId();
        holder.cId.setText(String.valueOf(id));
        holder.cTitulo.setText(cotizacionArrayList.get(holder.getAdapterPosition()).getTitulo());
        holder.cNombre.setText(cotizacionArrayList.get(holder.getAdapterPosition()).getNombre());
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = dateFormat.format(cotizacionArrayList.get(holder.getAdapterPosition()).getFecha());
        holder.cFecha.setText(date);
    }

    @Override
    public int getItemCount() {
        return cotizacionArrayList.size();
    }





}
