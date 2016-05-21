package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.adapter.TroubleshootingAdapter;
import ph.edu.bulsu.compnetworkingapp.fragment.IPCalculator;
import ph.edu.bulsu.compnetworkingapp.fragment.Troubleshooting;
import ph.edu.bulsu.compnetworkingapp.fragment.Tutorial;
import ph.edu.bulsu.compnetworkingapp.handler.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Troubleshooting> troubleshootingList = new ArrayList<>();
    private TroubleshootingAdapter tAdapter;
    private RecyclerView recyclerView;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);
        db.getWritableDatabase();

        db.addTopic(new Troubleshooting(1, "Dockers", " 475 Brannan St #330, San Francisco, CA 94107, United States"));
        db.addTopic(new Troubleshooting(2, "Dunkin Donuts", "White Plains, NY 10601"));

        // Reading all shops
        Log.d("Reading: ", "Reading all shops..");
        List<Troubleshooting> shops = db.getAllTopics();

        for (Troubleshooting troubleshooting : troubleshootingList) {
            String log = "Id: " + troubleshooting.getID() + " ,Topic: " + troubleshooting.getTopic() + " ,Content: " + troubleshooting.getContent();
            // Writing shops to log
            Log.d("Topic: : ", log);
        }

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

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }
}

