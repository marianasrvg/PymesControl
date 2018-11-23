package com.example.mari_.pymescontrol;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mari_.pymescontrol.beans.ProductoServicio;

import java.util.ArrayList;

public class AdapterProductoServicio extends RecyclerView.Adapter<AdapterProductoServicio.ViewHolder>{
    private ArrayList<ProductoServicio> productoServiciosList;
    private Context context;
    private int fragment;

    public AdapterProductoServicio(int fragment, Context context, ArrayList<ProductoServicio> productoServicios){
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
        holder.psCodigo.setText(productoServiciosList.get(holder.getAdapterPosition()).getCodigo());
        holder.psDescripcion.setText(productoServiciosList.get(holder.getAdapterPosition()).getDescripcion());
        holder.psPrecio.setText("$"+productoServiciosList.get(holder.getAdapterPosition()).getPrecio().toString());
    }

    @Override
    public int getItemCount() {
        return productoServiciosList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView psCodigo;
        TextView psDescripcion;
        TextView psPrecio;

        ViewHolder(View v){
            super(v);
            psCodigo = v.findViewById(R.id.p_s_codigo);
            psDescripcion = v.findViewById(R.id.p_s_descripcion);
            psPrecio = v.findViewById(R.id.p_s_precio);
        }
    }
}
