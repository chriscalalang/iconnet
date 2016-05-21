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

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;

//import ph.edu.bulsu.compnetworkingapp.adapter.TroubleshootingAdapter;
public class Troubleshooting extends Fragment implements View.OnClickListener {

    private static final String TAG = "TroubleshootingFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private int id;
    private String topic;
    private String content;


    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }


    private String title, genre, year;
    protected LayoutManagerType mCurrentLayoutManagerType;
    private List<Troubleshooting> troubleshootingList = new ArrayList<>();
    //    private TroubleshootingAdapter tAdapter;
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;

    public Troubleshooting() {
        // Required empty public constructor
    }

    public Troubleshooting(int id, String topic, String content) {
        this.id = id;
        this.topic = topic;
        this.content = content;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getID() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        prepareTroubleShootingData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_troubleshooting, container, false);

        Button win7 = (Button) view.findViewById(R.id.win7);
        win7.setOnClickListener(this);

        Button win8 = (Button) view.findViewById(R.id.win8);
        win8.setOnClickListener(this);

        Button win10 = (Button) view.findViewById(R.id.win10);
        win10.setOnClickListener(this);

        Button ubuntu = (Button) view.findViewById(R.id.ubuntu);
        ubuntu.setOnClickListener(this);

//        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
//        recyclerView.addOnItemTouchListener(new RecyclerItemClickHandler(getActivity(), recyclerView, new RecyclerItemClickHandler.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Log.d("Position", String.valueOf(position));
//            }
//        }));

        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }

//        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

//        tAdapter = new TroubleshootingAdapter(troubleshootingList);
        // Set CustomAdapter as the adapter for RecyclerView.
//        recyclerView.setAdapter(tAdapter);

//        tAdapter = new TroubleshootingAdapter(troubleshootingList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(tAdapter);

        return view;
    }


    public void onClick(View v) {

        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.win7:
                ft.replace(R.id.troubleshooting, new TroubleshootingWin7(), "TroubleshootingWin7");
                break;
            case R.id.win8:
                ft.replace(R.id.troubleshooting, new TroubleshootingWin8(), "TroubleshootingWin8");
                break;
            case R.id.win10:
                ft.replace(R.id.troubleshooting, new TroubleshootingWin10(), "TroubleshootingWin10");
                break;
            case R.id.ubuntu:
                ft.replace(R.id.troubleshooting, new TroubleshootingUbuntu(), "TroubleshootingUbuntu");
                break;
        }

        ft.addToBackStack(null);
        ft.commit();
    }


//    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
//        int scrollPosition = 0;
//
//        // If a layout manager has already been set, get current scroll position.
//        if (recyclerView.getLayoutManager() != null) {
//            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
//                    .findFirstCompletelyVisibleItemPosition();
//        }
//
//        switch (layoutManagerType) {
//            case GRID_LAYOUT_MANAGER:
//                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
//                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
//                break;
//            case LINEAR_LAYOUT_MANAGER:
//                mLayoutManager = new LinearLayoutManager(getActivity());
//                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
//                break;
//            default:
//                mLayoutManager = new LinearLayoutManager(getActivity());
//                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
//        }
//
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.scrollToPosition(scrollPosition);
//    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

//    private void prepareTroubleShootingData() {
//        Troubleshooting trouble = new Troubleshooting("Windows 7", "lorem ipsum dolor aquilas", "");
//        troubleshootingList.add(trouble);
//
//        trouble = new Troubleshooting("Windows 8", "lorem ipsum dolor aquilas", "");
//        troubleshootingList.add(trouble);
//
//        trouble = new Troubleshooting("Windows 10", "lorem ipsum dolor aquilas", "");
//        troubleshootingList.add(trouble);
//
//        trouble = new Troubleshooting("Ubuntu", "lorem ipsum dolor aquilas", "");
//        troubleshootingList.add(trouble);
//
////        tAdapter.notifyDataSetChanged();
//    }

}
