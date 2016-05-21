package ph.edu.bulsu.compnetworkingapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ph.edu.bulsu.compnetworkingapp.R;

public class Tutorial extends Fragment implements View.OnClickListener {

    private static final String TAG = "TutorialFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }


    protected LayoutManagerType mCurrentLayoutManagerType;
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;

    public Tutorial() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);

        Button search = (Button) view.findViewById(R.id.search);
        search.setOnClickListener(this);

        Button topology = (Button) view.findViewById(R.id.topology);
        topology.setOnClickListener(this);

        Button simulation = (Button) view.findViewById(R.id.simulation);
        simulation.setOnClickListener(this);

        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }

        return view;
    }

    public void onClick(View view) {

        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.search:
                ft.replace(R.id.tutorial, new TutorialSearch(), "TutorialSearch");
                break;
            case R.id.topology:
                ft.replace(R.id.tutorial, new TutorialTopology(), "TutorialTopology");
                break;
            case R.id.simulation:
                ft.replace(R.id.tutorial, new TutorialSearch(), "TutorialSimulation");
                break;
        }

        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
}
