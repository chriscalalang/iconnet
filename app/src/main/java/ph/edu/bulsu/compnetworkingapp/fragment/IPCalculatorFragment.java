package ph.edu.bulsu.compnetworkingapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
