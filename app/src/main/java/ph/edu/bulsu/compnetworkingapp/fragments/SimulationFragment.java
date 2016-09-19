package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.Model3DViewerActivity;

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
        view.findViewById(R.id.btnSample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Model3DViewerActivity.class));
            }
        });
    }

}
