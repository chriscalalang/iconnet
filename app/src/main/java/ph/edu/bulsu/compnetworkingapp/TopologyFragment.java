package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.adapters.TopicAdapter;
import ph.edu.bulsu.compnetworkingapp.fragments.BaseFragment;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

public class TopologyFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private TopicAdapter adapter;

    private List<Topic> topicList;

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


}
