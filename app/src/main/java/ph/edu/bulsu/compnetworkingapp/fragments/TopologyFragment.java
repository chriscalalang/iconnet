package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.TopicAdapter;
import ph.edu.bulsu.compnetworkingapp.database.daos.TopicsDAO;
import ph.edu.bulsu.compnetworkingapp.models.Topic;
import ph.edu.bulsu.compnetworkingapp.utils.WordQueriesBuilder;

public class TopologyFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private TopicAdapter adapter;

    private List<Topic> topicList;


    private List<String> textQueries;

    private List<String> tags;

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
        topicList = new ArrayList<>();
        textQueries = new ArrayList<>();

        adapter = new TopicAdapter(context, topicList);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setItemViewCacheSize(0);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tags = new ArrayList<>();
        tags.add("Topo");

        populateList(TopicsDAO.getInstance().getAll(tags, null), false, new ArrayList<String>());
    }


    public void populateList(final List<Topic> topicList, boolean incremental, List<String> splittedSentenceWords) {
        adapter.setSplittedSentenceWords(splittedSentenceWords);
        int previousSize = this.topicList.size();
        if (previousSize > 0) {
            //this.topicList.get(previousSize - 1).setLoadMore(false);
            adapter.notifyItemChanged(previousSize - 1);
        }
        if (!incremental) {
            this.topicList.clear();
            adapter.notifyItemRangeRemoved(0, previousSize);
        }


        this.topicList.addAll(topicList);

        int newSize = this.topicList.size();

        adapter.notifyItemRangeInserted(previousSize, topicList.size());

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        textQueries = WordQueriesBuilder.getWordQueries(newText);
        populateList(TopicsDAO.getInstance().getAll(tags, null), false, newText.isEmpty() ? new ArrayList<String>() : Arrays.asList(newText.split("\\W+")));
        return super.onQueryTextChange(newText);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        hideKeyBoard();
        return super.onQueryTextSubmit(query);
    }
}
