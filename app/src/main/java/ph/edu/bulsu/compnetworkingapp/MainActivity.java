package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.fragments.IPCalculatorFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.TroubleshootingFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.TutorialFragment;
import ph.edu.bulsu.compnetworkingapp.interfaces.MainWindowController;

public class MainActivity extends AppCompatActivity implements MainWindowController {

    private Toolbar tbMain;
    private NavigationView nvDrawer;
    private DrawerLayout dlDrawer;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TutorialFragment tutorialFragment;
    private TroubleshootingFragment troubleshootingFragment;
    private IPCalculatorFragment ipCalculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMain = (Toolbar) findViewById(R.id.tbMain);
        setSupportActionBar(tbMain);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        nvDrawer = (NavigationView) findViewById(R.id.nvDrawer);
        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                dlDrawer.closeDrawers();


                Fragment fragment = null;
                String title = "";


                switch (item.getItemId()) {
                    case R.id.miTutorials:
                        if (tutorialFragment == null)
                            tutorialFragment = TutorialFragment.newInstance();
                        fragment = tutorialFragment;
                        title = getString(R.string.tutorials);
                        break;
                    case R.id.miTroubleshooting:
                        if (troubleshootingFragment == null)
                            troubleshootingFragment = TroubleshootingFragment.newInstance();
                        fragment = troubleshootingFragment;
                        title = getString(R.string.troubleshooting);
                        break;
                    case R.id.miIPCalculator:
                        if (ipCalculatorFragment == null)
                            ipCalculatorFragment = IPCalculatorFragment.newInstance();
                        fragment = ipCalculatorFragment;
                        title = getString(R.string.ip_calculator);
                        break;
                    case R.id.miExit:
                        finish();
                        return true;
                }


                final Fragment finalFragment = fragment;
                final String finalTitle = title;
                dlDrawer.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flMain, finalFragment, finalTitle);
                        fragmentTransaction.commitAllowingStateLoss();
                    }
                }, 350);
                getSupportActionBar().setTitle(title);


                return true;
            }
        });


        dlDrawer = (DrawerLayout) findViewById(R.id.dlDrawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dlDrawer, tbMain, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        dlDrawer.addDrawerListener(toggle);
        toggle.syncState();


        tabLayout = (TabLayout) findViewById(R.id.tlMain);
    }

    public TabLayout getTabLayout() {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new TroubleshootingFragment(), "TroubleshootingFragment");
//        adapter.addFragment(new TutorialFragment(), "Tutorials");
//        adapter.addFragment(new IPCalculatorFragment(), "IP Calculator");
//
//        viewPager.setAdapter(adapter);

        return tabLayout;
    }

}

