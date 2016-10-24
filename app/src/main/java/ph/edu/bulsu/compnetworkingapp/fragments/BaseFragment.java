package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import ph.edu.bulsu.compnetworkingapp.interfaces.MainViewController;

/**
 * Created by Sheychan on 6/3/2016.
 */
public abstract class BaseFragment extends Fragment implements SearchView.OnQueryTextListener {

    protected View parentView;

    protected Context context;

    protected MainViewController mainViewController;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if ((context instanceof MainViewController)) {
            this.mainViewController = (MainViewController) context;
            if (mainViewController.getQueryTextListeners() != null)
                mainViewController.getQueryTextListeners().add(this);
        }


        this.context = context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mainViewController != null)
            mainViewController.getQueryTextListeners().remove(this);
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }

    protected void hideKeyBoard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
