package ph.edu.bulsu.compnetworkingapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.interfaces.MainWindowController;

public class TutorialFragment extends BaseFragment {

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
