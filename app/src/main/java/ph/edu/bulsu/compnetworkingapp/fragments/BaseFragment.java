package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.edu.bulsu.compnetworkingapp.interfaces.MainViewController;

/**
 * Created by Sheychan on 6/3/2016.
 */
public abstract class BaseFragment extends Fragment {

    protected View parentView;

    protected Context context;

    protected MainViewController mainViewController;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof MainViewController)) {
            throw new RuntimeException("BaseFragment should be attached to a MainViewController Activity");
        }

        this.mainViewController = (MainViewController) context;
        this.context = context;
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
    }

    public abstract int getParentLayoutId();

    public abstract void initializeParentView(View view);

}
