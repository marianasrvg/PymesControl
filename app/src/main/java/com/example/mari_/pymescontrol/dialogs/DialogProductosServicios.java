package com.example.mari_.pymescontrol.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.ProductoServicio;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class DialogProductosServicios extends Dialog implements View.OnClickListener {
    private Activity activity;
    private Dialog d;
    private ImageView closeBtn;
    private ProductoServicio productoServicio;

    TextView codigo, descripcion, unidadMedida, sat, precioN;

    public DialogProductosServicios(Activity activity, ProductoServicio productoServicio){
        super(activity);
        this.activity = activity;
        this.productoServicio = productoServicio;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_productos_servicios);
        d = this;
        setCancelable(false);

        closeBtn = findViewById(R.id.dps_close);
        codigo = findViewById(R.id.dps_codigoT);
        descripcion = findViewById(R.id.dps_descripcionT);
        unidadMedida = findViewById(R.id.dps_unidadmedidaT);
        sat = findViewById(R.id.dps_clavesatT);
        precioN = findViewById(R.id.dps_precioT);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
        GetCalls.producto(activity, new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    JSONObject jsonProducto = jsonObject.getJSONObject(0);
                    codigo.setText(jsonProducto.getString("codigo"));
                    descripcion.setText(jsonProducto.getString("descripcion"));
                    unidadMedida.setText(jsonProducto.getString("unidad"));
                    sat.setText(jsonProducto.getString("claveSAT"));
                    precioN.setText(Float.parseFloat(jsonProducto.getString("total"))+"");
                }catch (Exception e){}
            }
        }, Integer.parseInt(productoServicio.getId()));
    }

    @Override
    public void onClick(View view) {

    }

}
