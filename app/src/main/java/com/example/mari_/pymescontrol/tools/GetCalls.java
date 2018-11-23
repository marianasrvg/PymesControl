package com.example.mari_.pymescontrol.tools;

import android.content.Context;

public class GetCalls {
    public static void facturas(Context context, HttpRequestResponse requestResponse){
        HttpRequest.get(context, "http://api.pymescontrol.com/facturas", requestResponse);
    }

    public static void  factura(Context context, HttpRequestResponse requestResponse, int facturaId){
        HttpRequest.get(context, "http://api.pymescontrol.com/facturas/"+facturaId, requestResponse);
    }

    public static void cotizaciones(Context context, HttpRequestResponse requestResponse){
        HttpRequest.get(context, "http://api.pymescontrol.com/cotizaciones", requestResponse);
    }

    public static void cotizacion(Context context, HttpRequestResponse requestResponse, int cotizacionId){
        HttpRequest.get(context, "http://api.pymescontrol.com/cotizaciones/"+cotizacionId, requestResponse);
    }

    public static void clientes(Context context, HttpRequestResponse requestResponse){
        HttpRequest.get(context, "http://api.pymescontrol.com/clientes", requestResponse);
    }

    public static void cliente(Context context, HttpRequestResponse requestResponse, int clienteId){
        HttpRequest.get(context, "http://api.pymescontrol.com/clientes/"+clienteId, requestResponse);
    }

    public static void productos(Context context, HttpRequestResponse requestResponse){
        HttpRequest.get(context, "http://api.pymescontrol.com/productos", requestResponse);
    }

    public static void producto(Context context, HttpRequestResponse requestResponse, int  productoId){
        HttpRequest.get(context, "http://api.pymescontrol.com/producto"+productoId, requestResponse);
    }

    public static void bancos(Context context, HttpRequestResponse requestResponse){
        HttpRequest.get(context, "http://api.pymescontrol.com/cuentasBancarias", requestResponse);
    }

    public static void banco(Context context, HttpRequestResponse requestResponse, int bancoId){
        HttpRequest.get(context, "http://api.pymescontrol.com/bancos/"+bancoId, requestResponse);
    }

}
