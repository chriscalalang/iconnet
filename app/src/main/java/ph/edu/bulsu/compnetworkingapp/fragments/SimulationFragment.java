package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;

public class SimulationFragment extends BaseFragment {
    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_simulation;
    }

    public static SimulationFragment newInstance() {
        Bundle args = new Bundle();

        SimulationFragment fragment = new SimulationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initializeParentView(View view) {

    }

}
