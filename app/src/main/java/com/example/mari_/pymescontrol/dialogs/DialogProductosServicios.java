package com.example.mari_.pymescontrol.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.ProductoServicio;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONObject;

public class DialogProductosServicios extends Dialog implements View.OnClickListener {
    private Activity activity;
    private Dialog d;
    private ImageView closeBtn;

    TextView codigo, descripcion, unidadMedida, sat, precioSI, impuestos, precioN;

    public DialogProductosServicios(Activity activity){
        super(activity);
        this.activity = activity;
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
        precioSI = findViewById(R.id.dps_preciosiT);
        impuestos = findViewById(R.id.dps_impuestosT);
        precioN = findViewById(R.id.dps_precioT);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    public void loadData(ProductoServicio productoServicio){
        GetCalls.producto(activity, new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    codigo.setText(jsonObject.getString("codigo"));
                    descripcion.setText(jsonObject.getString("descripcion"));
                    unidadMedida.setText(jsonObject.getString("unidad"));
                    sat.setText(jsonObject.getString("claveSAT"));
                    precioSI.setText(jsonObject.getString("total"));
                    impuestos.setText(jsonObject.getString("total"));
                    precioN.setText(jsonObject.getString("total"));
                }catch (Exception e){}
            }
        }, Integer.parseInt(productoServicio.getId()));
    }
}
