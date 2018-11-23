package com.example.mari_.pymescontrol.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.pymescontrol.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentCatalogos extends Fragment {

    public FragmentCatalogos() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_catalogos, container, false);
        ViewPager viewPager = rootView.findViewById(R.id.container_catalogos);
        setUpViewPager(viewPager);
        TabLayout tabs = rootView.findViewById(R.id.tabs_catalogos);
        tabs.setupWithViewPager(viewPager);
        return rootView;
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentProductoServicio(), getString(R.string.frag_pys));
        adapter.addFragment(new FragmentClientes(), getString(R.string.frag_clientes));
        adapter.addFragment(new FragmentCuentasBancarias(), getString(R.string.frag_cuantas_bancarias));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    static class SectionPageAdapter extends FragmentPagerAdapter{
        private final List<android.support.v4.app.Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public SectionPageAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
