package ph.edu.bulsu.compnetworkingapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.edu.bulsu.compnetworkingapp.interfaces.MainWindowController;

/**
 * Created by Sheychan on 6/3/2016.
 */
public abstract class BaseFragment extends Fragment {

    protected View parentView;

    protected MainWindowController mainWindowController;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof MainWindowController)) {
            throw new RuntimeException("Activity this fragment attached into should implement MainWindowController Interface");
        }
        mainWindowController = (MainWindowController) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(getParentLayoutId(), container, false);
        initializeParentView(parentView);
        return parentView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainWindowController.useTabLayout(getTabLayoutViewPager());
    }

    public abstract int getParentLayoutId();

    public abstract void initializeParentView(View view);

    @Nullable
    public abstract ViewPager getTabLayoutViewPager();
}
