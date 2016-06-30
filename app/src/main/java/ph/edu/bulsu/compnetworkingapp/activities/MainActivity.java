package ph.edu.bulsu.compnetworkingapp.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.fragments.IPCalculatorFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.TroubleshootingFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.TutorialFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar tbMain;
    private NavigationView nvDrawer;
    private SearchView searchView;
    private DrawerLayout dlDrawer;

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

        searchView = (SearchView) findViewById(R.id.searchView);


        nvDrawer = (NavigationView) findViewById(R.id.nvDrawer);
        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                dlDrawer.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.miTutorials:
                        showTutorialsPage();
                        break;
                    case R.id.miTroubleshooting:
                        showTroubleShootingPage();
                        break;
                    case R.id.miIPCalculator:
                        showIPCalculatorPage();
                        break;
                    case R.id.miExit:
                        finish();
                        return true;
                }
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

        showTutorialsPage();
    }

    private void useFragment(Fragment fragment, String title) {
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
    }

    private void showIPCalculatorPage() {
        if (ipCalculatorFragment == null)
            ipCalculatorFragment = IPCalculatorFragment.newInstance();
        useFragment(ipCalculatorFragment, getString(R.string.ip_calculator));

        searchView.setVisibility(View.GONE);
    }

    private void showTroubleShootingPage() {
        if (troubleshootingFragment == null)
            troubleshootingFragment = TroubleshootingFragment.newInstance();
        useFragment(troubleshootingFragment, getString(R.string.troubleshooting));

        searchView.setVisibility(View.VISIBLE);
    }

    private void showTutorialsPage() {
        if (tutorialFragment == null)
            tutorialFragment = TutorialFragment.newInstance();
        useFragment(tutorialFragment, getString(R.string.tutorials));


        searchView.setVisibility(View.VISIBLE);
    }
}

