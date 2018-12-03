package com.example.mari_.pymescontrol.tools;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    public static String token = null;
    public static void get(Context context, String url, final HttpRequestResponse responseAction){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseAction.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseAction.onResponse(null);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Cookie", "token="+token);
                return params;
            }
        };
        queue.add(stringRequest);
    }
    public static void postNoAuto(Context context, String url, final Map<String, String> params, final HttpRequestResponse responseAction){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseAction.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseAction.onResponse(null);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
            @Override
            public Map<String, String> getParams(){
                return params;
            }
        };
        queue.add(stringRequest);
    }
    public static void postAuto(Context context, String url, final Map<String, String> params, final HttpRequestResponse responseAction){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseAction.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseAction.onResponse(null);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Cookie", "token="+token);
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
            @Override
            public Map<String, String> getParams(){
                return params;
            }
        };
        queue.add(stringRequest);
    }
}