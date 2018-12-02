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

import org.json.JSONObject;

public class DialogClientes extends Dialog implements View.OnClickListener {
    private Activity activity;
    private Dialog d;
    private ImageView closeBtn;

    TextView id, nombre, razon, rfc, estado, ciudad, telefono;

    public DialogClientes(Activity activity){
        super(activity);
        this.activity = activity;
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
        estado = findViewById(R.id.dclientes_estado);
        ciudad = findViewById(R.id.dclientes_ciudadT);
        telefono = findViewById(R.id.dclientes_telefonoT);

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

    public void loadData(Cliente cliente){
        GetCalls.producto(activity, new HttpRequestResponse() {
            @Override
            public void onResponse(String response) {
                if(response == "false") return;
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    id.setText(jsonObject.getString("id"));
                    nombre.setText(jsonObject.getString("nombre"));
                    razon.setText(jsonObject.getString("razon"));
                    rfc.setText(jsonObject.getString("rfc"));
                    estado.setText(jsonObject.getString("estado"));
                    ciudad.setText(jsonObject.getString("ciudad"));
                    telefono.setText(jsonObject.getString("telefono"));
                }catch (Exception e){}
            }
        }, Integer.parseInt(cliente.getId()));
    }
}
