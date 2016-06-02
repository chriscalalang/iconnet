package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar tbMain;
    private NavigationView nvDrawer;
    private DrawerLayout dlDrawer;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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

                switch (item.getItemId()) {
                    case R.id.miTutorials:
                        break;
                    case R.id.miTroubleshooting:
                        break;
                    case R.id.miIPCalculator:
                        break;
                    case R.id.miExit:
                        break;
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


        tabLayout = (TabLayout) findViewById(R.id.tlMain);
    }

    public TabLayout getTabLayout() {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new TroubleshootingFragment(), "TroubleshootingFragment");
//        adapter.addFragment(new Tutorial(), "Tutorials");
//        adapter.addFragment(new IPCalculator(), "IP Calculator");
//
//        viewPager.setAdapter(adapter);

        return tabLayout;
    }

}

