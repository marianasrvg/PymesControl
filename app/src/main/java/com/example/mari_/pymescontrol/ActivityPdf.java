package com.example.mari_.pymescontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ActivityPdf extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_pdf_app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("A11.pdf");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView = findViewById(R.id.activity_pdf_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://docs.google.com/gview?url=http://api.pymescontrol.com/facturas/81/pdf?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXByZXNhSWQiOiIxIiwidGlwb1Blcm1pc28iOiIxIiwiaWRQZXJtaXNvIjoiODEifQ.qncDD7wP7z2nRA6cN87jOPAhVpbvTFd2sz9VufzEIZU&embedded=true");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
