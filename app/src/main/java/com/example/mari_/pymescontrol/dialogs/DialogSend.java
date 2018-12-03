package com.example.mari_.pymescontrol.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mari_.pymescontrol.R;
import com.example.mari_.pymescontrol.beans.Cotizacion;
import com.example.mari_.pymescontrol.beans.Factura;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;
import com.example.mari_.pymescontrol.tools.PostCalls;

public class DialogSend extends Dialog implements View.OnClickListener {
    private Activity activity;
    private Dialog d;
    private ImageView closeBtn;
    private Button buttonSend;
    private EditText textCorreo;
    private EditText textMensaje;
    private int action = 0;
    private Factura factura;
    private  Cotizacion cotizacion;

    public DialogSend(Activity activity, Factura factura) {
        super(activity);
        this.activity = activity;
        this.factura = factura;
        this.action = 1;
    }
    public DialogSend(Activity activity, Cotizacion cotizacion) {
        super(activity);
        this.activity = activity;
        this.cotizacion = cotizacion;
        this.action = 2;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_send);
        d = this;
        setCancelable(false);
        textCorreo = findViewById(R.id.dialog_send_correo);
        textMensaje = findViewById(R.id.dialog_send_mensaje);
        closeBtn = findViewById(R.id.dialog_send_close);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
        buttonSend = findViewById(R.id.dialog_send_enviar_btn);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(action == 1) {
                    String facturaId = factura.getId();
                    String email = textCorreo.getText().toString();
                    String mensaje = textMensaje.getText().toString();
                    Log.e("http", facturaId+" "+email+" "+mensaje);
                    PostCalls.sendFactura(activity, facturaId, 1, 2, email, 0, mensaje,new HttpRequestResponse() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("http", response);
                            DialogSendResponse dialog = new DialogSendResponse(activity);
                            dialog.show();
                            dismiss();
                        }
                    });
                }else if(action == 2){
                    String cotizacionId = cotizacion.getId();
                    String email = textCorreo.getText().toString();
                    String mensaje = textMensaje.getText().toString();
                    Log.e("http", cotizacionId+" "+email+" "+mensaje);
                    PostCalls.sendFactura(activity, cotizacionId, 1, 2, email, 0, mensaje,new HttpRequestResponse() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("http", response);
                            DialogSendResponse dialog = new DialogSendResponse(activity);
                            dialog.show();
                            dismiss();
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
    }
}
