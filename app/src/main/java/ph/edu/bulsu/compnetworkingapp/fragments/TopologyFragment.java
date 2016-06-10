package ph.edu.bulsu.compnetworkingapp.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.edu.bulsu.compnetworkingapp.R;

public class TopologyFragment extends BaseFragment {

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_topology;
    }

    public static TopologyFragment newInstance() {
        Bundle args = new Bundle();

        TopologyFragment fragment = new TopologyFragment();
        fragment.setArguments(args);
        return fragment;
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
