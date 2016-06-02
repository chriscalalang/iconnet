package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.edu.bulsu.compnetworkingapp.interfaces.MainWindowController;

/**
 * Created by Sheychan on 6/3/2016.
 */
public abstract class BaseFragment extends Fragment {

    protected View parentView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof MainWindowController)) {
            throw new RuntimeException("Activity this fragment attached into should implement MainWindowController Interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(getParentLayoutId(), container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        parentView = view;
    }

    public abstract int getParentLayoutId();

}
