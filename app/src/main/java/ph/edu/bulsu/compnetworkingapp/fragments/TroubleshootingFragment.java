package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;

public class TroubleshootingFragment extends BaseFragment {

    public static TroubleshootingFragment newInstance() {
        Bundle args = new Bundle();

        TroubleshootingFragment fragment = new TroubleshootingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.troubleshooting, menu);
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_troubleshooting;
    }

    @Override
    public void initializeParentView(View view) {
    }

}
