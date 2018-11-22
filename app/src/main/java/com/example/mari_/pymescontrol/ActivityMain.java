package com.example.mari_.pymescontrol;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.mari_.pymescontrol.fragments.FragmentCatalogos;
import com.example.mari_.pymescontrol.fragments.FragmentCotizaciones;
import com.example.mari_.pymescontrol.fragments.FragmentFacturas;

public class ActivityMain extends AppCompatActivity {

    private BottomNavigationView mainNavigationView;
    private FrameLayout mainFrameLayout;

    private FragmentFacturas fragmentFacturas;
    private FragmentCotizaciones fragmentCotizaciones;
    private FragmentCatalogos fragmentCatalogos;

    private SwipeRefreshLayout fragmentFacturasRefresher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_app_bar_simple);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.nav_facturas);
        mainNavigationView = findViewById(R.id.main_nav);
        mainFrameLayout = findViewById(R.id.main_frame_layout);

        fragmentFacturas = new FragmentFacturas();
        fragmentCotizaciones = new FragmentCotizaciones();
        fragmentCatalogos = new FragmentCatalogos();

        setFragment(fragmentFacturas);

        mainNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_facturas:
                        getSupportActionBar().setTitle(R.string.nav_facturas);
                        setFragment(fragmentFacturas);
                        return true;

                    case R.id.nav_cotizaciones:
                        getSupportActionBar().setTitle(R.string.nav_cotizaciones);
                        setFragment(fragmentCotizaciones);
                        return true;

                    case R.id.nav_catalogos:
                        getSupportActionBar().setTitle(R.string.nav_catalogos);
                        setFragment(fragmentCatalogos);
                        return true;

                    default:
                        return true;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_bar_logout:
                Intent intent = new Intent(ActivityMain.this, ActivityLogIn.class);
                startActivity(intent);
                finish();
                return true;
        }
        return false;
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, fragment);
        fragmentTransaction.commit();
    }
}


