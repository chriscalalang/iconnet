package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;

public class TutorialFragment extends BaseFragment {
    private ViewPager vpTutorial;


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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new TutorialTopology(), "Topology");
        adapter.addFragment(new TutorialSimulation(), "Simulation");
        vpTutorial.setAdapter(adapter);

    }

    @Nullable
    @Override
    public ViewPager getTabLayoutViewPager() {
        return vpTutorial;
    }


}
