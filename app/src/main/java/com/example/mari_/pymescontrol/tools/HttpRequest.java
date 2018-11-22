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
                params.put("Cookie", "token = eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdWVudGFJZCI6IjEiLCJub21icmVzIjoiQWxhbiIsImFwZWxsaWRvcyI6IlBcdTAwZTlyZXoiLCJjdWVudGFUaXBvIjoiMSIsImVtcHJlc2FJZCI6IjEiLCJlbXByZXNhSWROYW1lIjoiYW51bm93IiwibGltaXQiOiIyMDE4LTExLTIyIDA1OjQ0OjE0IiwiaXBVc3VhcmlvIjoiMTc3LjI0MC4xMDEuMTI2In0.UQ5ED4QreRSCU87gDe8yObhJR2Drd5EZqOy8PXGTGPY");
                return params;
            }
        };
        queue.add(stringRequest);
    }
}
