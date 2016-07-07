package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.fragments.IPCalculatorFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.TroubleshootingFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.TutorialFragment;
import ph.edu.bulsu.compnetworkingapp.interfaces.MainViewController;

public class MainActivity extends AppCompatActivity implements MainViewController {

    private Toolbar tbMain;
    private NavigationView nvDrawer;
    private SearchView searchView;
    private AppBarLayout ablSearch;
    private TabLayout tabLayout;
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

        ablSearch = (AppBarLayout) findViewById(R.id.ablSearch);
        searchView = (SearchView) findViewById(R.id.searchView);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        nvDrawer = (NavigationView) findViewById(R.id.nvDrawer);
        nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                dlDrawer.closeDrawers();
                ablSearch.setExpanded(true, true);

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
                hideKeyBoard();
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
        tabLayout.setVisibility(View.GONE);
    }

    private void showTroubleShootingPage() {
        if (troubleshootingFragment == null)
            troubleshootingFragment = TroubleshootingFragment.newInstance();
        useFragment(troubleshootingFragment, getString(R.string.troubleshooting));

        searchView.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.GONE);
    }

    private void showTutorialsPage() {
        if (tutorialFragment == null)
            tutorialFragment = TutorialFragment.newInstance();
        useFragment(tutorialFragment, getString(R.string.tutorials));


        searchView.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);
    }

    private void hideKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public TabLayout getTabLayout() {
        return tabLayout;
    }


}

