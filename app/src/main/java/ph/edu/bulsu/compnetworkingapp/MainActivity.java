package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ph.edu.bulsu.compnetworkingapp.adapter.ViewPagerAdapter;
import ph.edu.bulsu.compnetworkingapp.fragment.IPCalculator;
import ph.edu.bulsu.compnetworkingapp.fragment.TroubleshootingFragment;
import ph.edu.bulsu.compnetworkingapp.fragment.Tutorial;

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
        adapter.addFragment(new TroubleshootingFragment(), "TroubleshootingFragment");
        adapter.addFragment(new Tutorial(), "Tutorials");
        adapter.addFragment(new IPCalculator(), "IP Calculator");

        viewPager.setAdapter(adapter);
    }
}

