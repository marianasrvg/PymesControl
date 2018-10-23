package com.example.mari_.pymescontrol;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        setFragment(fragmentFacturas);
                        return true;

                    case R.id.nav_cotizaciones:
                        setFragment(fragmentCotizaciones);
                        return true;

                    case R.id.nav_catalogos:
                        setFragment(fragmentCatalogos);
                        return true;

                    default:
                        return true;
                }
            }
        });

        }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame_layout, fragment);
        fragmentTransaction.commit();
    }

}


