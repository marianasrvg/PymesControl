package com.example.mari_.pymescontrol;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.ProductoServicio;

import java.util.ArrayList;

public class AdapterProdcutoServicio extends RecyclerView.Adapter<AdapterProdcutoServicio.ViewHolder> {
    private ArrayList<ProductoServicio> productoServiciosList;
    private Context context;
    private int fragment;

    public AdapterProdcutoServicio(int fragment, Context context, ArrayList<ProductoServicio> productoServicios){
        this.context = context;
        this.fragment = fragment;
        this.productoServiciosList = productoServicios;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_productos_servicios, parent, false);
         return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.psTitle.setText(productoServiciosList.get(holder.getAdapterPosition()).getTitle());
        holder.psDescription.setText(productoServiciosList.get(holder.getAdapterPosition()).getDescrption());
        holder.psPrice.setText(productoServiciosList.get(holder.getAdapterPosition()).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return productoServiciosList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView psTitle;
        TextView psDescription;
        TextView psPrice;

        ViewHolder(View v){
            super(v);
            psTitle = v.findViewById(R.id.p_s_title);
            psDescription = v.findViewById(R.id.p_s_description);
            psPrice = v.findViewById(R.id.p_s_price);
        }
    }
}
