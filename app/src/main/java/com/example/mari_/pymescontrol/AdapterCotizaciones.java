package com.example.mari_.pymescontrol;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.Cotizacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AdapterCotizaciones extends RecyclerView.Adapter<AdapterCotizaciones.ViewHolder> {
    private ArrayList<Cotizacion> cotizacionesArrayList;
    private Context context;
    private int fragment;

    public AdapterCotizaciones(int fragment, Context context, ArrayList<Cotizacion> cotizacionArrayList) {
        this.cotizacionesArrayList = cotizacionArrayList;
        this.context = context;
        this.fragment = fragment;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout myEventLayout;
        TextView cFolio;
        TextView cTitulo;
        TextView cNombre;
        TextView cFecha;

        ViewHolder(View v){
            super(v);
            cFolio = v.findViewById(R.id.cotizacion_folio);
            cTitulo = v.findViewById(R.id.cotizacion_titulo);
            cNombre = v.findViewById(R.id.cotizacion_nombre);
            cFecha = v.findViewById(R.id.cotizacion_fecha);
            myEventLayout = v.findViewById(R.id.cotizacion_item_layout);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cotizaciones, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.cFolio.setText(cotizacionesArrayList.get(position).getFolio());
        holder.cTitulo.setText(cotizacionesArrayList.get(position).getTitulo());
        holder.cNombre.setText(cotizacionesArrayList.get(position).getNombre());
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = dateFormat.format(cotizacionesArrayList.get(position).getFecha());
        holder.cFecha.setText(date);

        holder.myEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityPdf.class);
                intent.putExtra("tipo", 2);
                intent.putExtra("cotizacion", cotizacionesArrayList.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cotizacionesArrayList.size();
    }
}
