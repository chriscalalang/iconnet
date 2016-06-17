package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.TopologyFragment;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;

public class TutorialFragment extends BaseFragment {
    private ViewPager vpTutorial;
    private TabLayout tabLayout;


    public static TutorialFragment newInstance() {
        Bundle args = new Bundle();

        TutorialFragment fragment = new TutorialFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_tutorial;
    }

    @Override
    public void initializeParentView(View view) {

        vpTutorial = (ViewPager) view.findViewById(R.id.vpTutorial);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(AllTutorialsFragment.newInstance(), "All");
        adapter.addFragment(TopologyFragment.newInstance(), "Topology");
        adapter.addFragment(SimulationFragment.newInstance(), "Simulation");
        vpTutorial.setAdapter(adapter);

        tabLayout = (TabLayout) parentView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(vpTutorial);

    }
}
