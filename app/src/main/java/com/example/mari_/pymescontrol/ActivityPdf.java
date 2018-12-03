package com.example.mari_.pymescontrol;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.mari_.pymescontrol.beans.Cotizacion;
import com.example.mari_.pymescontrol.beans.Factura;
import com.example.mari_.pymescontrol.dialogs.DialogSend;
import com.example.mari_.pymescontrol.tools.GetCalls;
import com.example.mari_.pymescontrol.tools.HttpRequestResponse;

public class ActivityPdf extends AppCompatActivity {

    private WebView webView;
    private int tipo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_pdf_app_bar);
        setSupportActionBar(toolbar);

        if(getIntent().getExtras()!=null) {
            tipo = getIntent().getIntExtra("tipo",0);
            if(tipo == 1) {
                final Factura factura = getIntent().getParcelableExtra("facturas");
                getSupportActionBar().setTitle("Factura " + factura.getSerie() + " " + factura.getFolio());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                GetCalls.facturaToken(this, new HttpRequestResponse() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.equals("false")) {
                            webView = findViewById(R.id.activity_pdf_webview);
                            WebSettings webSettings = webView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                            webView.loadUrl("https://docs.google.com/gview?url=http://api.pymescontrol.com/facturas/" + factura.getId() + "/pdf?token=" + response + "&embedded=true");
                        }
                    }
                }, Integer.parseInt(factura.getId()));
            }else if(tipo == 2){
                final Cotizacion cotizacion = getIntent().getParcelableExtra("cotizacion");
                getSupportActionBar().setTitle("Cotizacion " + cotizacion.getFolio());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                GetCalls.cotizacionToken(this, new HttpRequestResponse() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.equals("false")) {
                            webView = findViewById(R.id.activity_pdf_webview);
                            WebSettings webSettings = webView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                            webView.loadUrl("https://docs.google.com/gview?url=http://api.pymescontrol.com/cotizaciones/" + cotizacion.getId() + "/pdf?token=" + response + "&embedded=true");
                        }
                    }
                }, Integer.parseInt(cotizacion.getId()));
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_pdf_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_pdf_enviar:
                if(tipo == 1) {
                    final Factura factura = getIntent().getParcelableExtra("facturas");
                    Dialog dialogSend = new DialogSend(this, factura);
                    dialogSend.show();
                }else if(tipo == 2){
                    final Cotizacion cotizacion = getIntent().getParcelableExtra("cotizacion");
                    Dialog dialogSend = new DialogSend(this, cotizacion);
                    dialogSend.show();
                }
        }
        return super.onOptionsItemSelected(item);
    }
}