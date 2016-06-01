package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.adapter.TroubleshootingAdapter;
import ph.edu.bulsu.compnetworkingapp.adapter.ViewPagerAdapter;
import ph.edu.bulsu.compnetworkingapp.fragment.IPCalculator;
import ph.edu.bulsu.compnetworkingapp.fragment.Troubleshooting;
import ph.edu.bulsu.compnetworkingapp.fragment.Tutorial;
import ph.edu.bulsu.compnetworkingapp.handler.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Troubleshooting(), "Troubleshooting");
        adapter.addFragment(new Tutorial(), "Tutorials");
        adapter.addFragment(new IPCalculator(), "IP Calculator");

        viewPager.setAdapter(adapter);
    }
}

