package com.example.mari_.pymescontrol.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.Cliente;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class DialogClientes extends Dialog implements View.OnClickListener {
    private Activity activity;
    private Dialog d;
    private ImageView closeBtn;
    private Cliente cliente;
    TextView id, nombre, razon, rfc, estado, ciudad, telefono, estadoh, ciudadh, telefonoh;

    public DialogClientes(Activity activity, Cliente cliente){
        super(activity);
        this.activity = activity;
        this.cliente = cliente;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_clientes);
        d = this;
        setCancelable(false);

        closeBtn = findViewById(R.id.dclientes_close);
        id = findViewById(R.id.dclientes_idT);
        nombre = findViewById(R.id.dclientes_nombreT);
        razon = findViewById(R.id.dclientes_razonT);
        rfc = findViewById(R.id.dclientes_rfcT);
        estado = findViewById(R.id.dclientes_estadoT);
        ciudad = findViewById(R.id.dclientes_ciudadT);
        telefono = findViewById(R.id.dclientes_telefonoT);
        estadoh = findViewById(R.id.dclientes_estado);
        ciudadh = findViewById(R.id.dclientes_ciudad);
        telefonoh = findViewById(R.id.dclientes_telefono);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
        GetCalls.cliente(activity, new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONArray jsonObject = new JSONArray(response);
                    JSONObject jsonCliente = jsonObject.getJSONObject(0);
                    id.setText(jsonCliente.getString("id"));
                    nombre.setText(jsonCliente.getString("nombre"));
                    razon.setText(jsonCliente.getString("razon"));
                    rfc.setText(jsonCliente.getString("rfc"));
                    if(jsonCliente.getString("estado")=="null"){
                        estado.setVisibility(View.GONE);
                        estadoh.setVisibility(View.GONE);
                    }else{
                        estado.setText(jsonCliente.getString("estado"));
                    }
                    if(jsonCliente.getString("ciudad")=="null"){
                        ciudad.setVisibility(View.GONE);
                        ciudadh.setVisibility(View.GONE);
                    }else{
                        ciudad.setText(jsonCliente.getString("ciudad"));
                    }
                    if(jsonCliente.getString("telefono")=="null"){
                        telefono.setVisibility(View.GONE);
                        telefonoh.setVisibility(View.GONE);
                    }else{
                        telefono.setText(jsonCliente.getString("telefono"));
                    }
                }catch (Exception e){}
            }
        }, Integer.parseInt(cliente.getId()));
    }

    @Override
    public void onClick(View view) {

    }
}
