package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;

//import ph.edu.bulsu.compnetworkingapp.adapter.TroubleshootingAdapter;
public class TroubleshootingFragment extends BaseFragment {


    private View parentView;

    public static TroubleshootingFragment newInstance() {
        Bundle args = new Bundle();

        TroubleshootingFragment fragment = new TroubleshootingFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_troubleshooting;
    }

    @Override
    public void initializeParentView(View view) {

    }

    @Nullable
    @Override
    public ViewPager getTabLayoutViewPager() {
        return null;
    }

}
