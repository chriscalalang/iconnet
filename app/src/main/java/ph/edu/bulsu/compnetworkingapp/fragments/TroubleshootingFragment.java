package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;

//import ph.edu.bulsu.compnetworkingapp.adapter.TroubleshootingAdapter;
public class TroubleshootingFragment extends BaseFragment {

    private ViewPager vpTutorial;

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
        vpTutorial = (ViewPager) view.findViewById(R.id.vpTutorial);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TroubleshootingWin7(), "Windows 7");
        adapter.addFragment(new TroubleshootingWin8(), "Windows 8");
        adapter.addFragment(new TroubleshootingWin10(), "Windows 10");
        adapter.addFragment(new TroubleshootingUbuntu(), "Ubuntu");
        vpTutorial.setAdapter(adapter);
    }

    @Nullable
    @Override
    public ViewPager getTabLayoutViewPager() {
        return vpTutorial;
    }

}
