package com.snalopainen.md.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * Created by snajdan on 2016/11/25.
 */

public class CountryDisplayActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aaaa);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        if (mViewPager != null) {
            setupViewPager(mViewPager);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private SimplePagerAdapter pagerAdapter;

    private void setupViewPager(ViewPager mViewPager) {
        pagerAdapter = new SimplePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new ListViewFragment(), "Tab 1");
        pagerAdapter.addFragment(new ListViewFragment(), "Tab 2");
        mViewPager.setAdapter(pagerAdapter);
    }


    public static class ListViewFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_listview, container, false);

            ListView list = (ListView) root.findViewById(android.R.id.list);
            ListCountryAdapter listAdapter = new ListCountryAdapter(getActivity(),
                    getResources().getStringArray(R.array.countries));
            list.setAdapter(listAdapter);
            return root;
        }
    }
}
