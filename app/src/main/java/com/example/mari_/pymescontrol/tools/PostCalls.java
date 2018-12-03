package com.example.mari_.pymescontrol.tools;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class PostCalls {
    public static void login(Context context, String usuario, String password, HttpRequestResponse requestResponse){
        Map<String, String> params = new HashMap<String, String>();
        params.put("usuario", usuario);
        params.put("password", password);
        HttpRequest.postNoAuto(context, "http://api.pymescontrol.com/login", params, requestResponse);
    }
    public static void sendFactura(Context context, String facturaId, int tipo, int accion, String email, int guardarCorreo, String mensaje, HttpRequestResponse requestResponse){
        Map<String, String> params = new HashMap<String, String>();
        params.put("type", tipo+"");
        params.put("action", accion+"");
        params.put("email", email);
        params.put("saveEmail", guardarCorreo+"");
        params.put("mensaje", mensaje);
        HttpRequest.postNoAuto(context, "http://api.pymescontrol.com/facturas/"+facturaId+"/enviar", params, requestResponse);
    }
}