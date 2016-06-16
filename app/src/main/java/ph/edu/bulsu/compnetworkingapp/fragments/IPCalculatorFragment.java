package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;

public class IPCalculatorFragment extends BaseFragment {

    public static IPCalculatorFragment newInstance() {

        Bundle args = new Bundle();

        IPCalculatorFragment fragment = new IPCalculatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_ip_calculator;
    }

    @Override
    public void initializeParentView(View view) {

    }

}
