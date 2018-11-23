package com.example.mari_.pymescontrol;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
        private RelativeLayout myEventLayout;
        TextView fSerieFolio;
        TextView fStatus;
        TextView fNombre;
        TextView fRfc;
        TextView fFecha;
        ImageView fStatusIcon;

        ViewHolder(View v){
            super(v);
            fSerieFolio = v.findViewById(R.id.factura_seriefolio);
            fStatus = v.findViewById(R.id.factura_status);
            fNombre = v.findViewById(R.id.factura_nombre);
            fRfc = v.findViewById(R.id.factura_rfc);
            fFecha = v.findViewById(R.id.factura_fecha);
            fStatusIcon = v.findViewById(R.id.factura_status_icon);
            myEventLayout = v.findViewById(R.id.factura_item_layout);
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
        holder.fSerieFolio.setText(facturaArrayList.get(holder.getAdapterPosition()).getSerie()+" "
                +facturaArrayList.get(holder.getAdapterPosition()).getFolio());
        if(facturaArrayList.get(holder.getAdapterPosition()).getStatus().equals("1")){
            holder.fStatus.setText(R.string.factura_card_timbrada);
            holder.fStatusIcon.setImageResource(R.drawable.ic_check_circle_green_24dp);
            holder.fStatus.setTextColor(ContextCompat.getColor(context, R.color.colorGreen));
        }else{
            holder.fStatus.setText(R.string.factura_card_notimbrada);
            holder.fStatusIcon.setImageResource(R.drawable.ic_cancel_red_24dp);
            holder.fStatus.setTextColor(ContextCompat.getColor(context, R.color.colorRed));
        }
        holder.myEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityPdf.class);
                context.startActivity(intent);
            }
        });

        holder.fNombre.setText(facturaArrayList.get(holder.getAdapterPosition()).getNombre());
        holder.fRfc.setText(facturaArrayList.get(holder.getAdapterPosition()).getRfc());
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = "-";
        if(facturaArrayList.get(holder.getAdapterPosition()).getFecha()!= null){
            date = dateFormat.format(facturaArrayList.get(holder.getAdapterPosition()).getFecha());
        }
        holder.fFecha.setText(date);
    }

    @Override
    public int getItemCount() {
        return facturaArrayList.size();
    }

}
