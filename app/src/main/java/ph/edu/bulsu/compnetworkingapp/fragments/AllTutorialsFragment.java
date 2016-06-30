package ph.edu.bulsu.compnetworkingapp.fragments;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.IconNetApplication;
import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.TopicAdapter;
import ph.edu.bulsu.compnetworkingapp.managers.ResourcesManager;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

public class AllTutorialsFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private TopicAdapter adapter;

    private List<Topic> topicList;

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_all_tutorials;
    }

    public static AllTutorialsFragment newInstance() {
        Bundle args = new Bundle();

        AllTutorialsFragment fragment = new AllTutorialsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initializeParentView(View view) {
        topicList = new ArrayList<>();

        adapter = new TopicAdapter(context, topicList);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setItemViewCacheSize(0);

        topicList.add(new Topic("A title", "Text content text content text content"));
        topicList.add(new Topic("I want food", "blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"));
        topicList.add(new Topic("Android is cool", "I'm the coolest though. . . . . . . . . . . . ."));
        topicList.add(new Topic("A title", "Text content text content text content"));
        topicList.add(new Topic("I want food", "blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"));
        topicList.add(new Topic("Android is cool", "I'm the coolest though. . . . . . . . . . . . ."));
        topicList.add(new Topic("A title", "Text content text content text content"));
        topicList.add(new Topic("I want food", "blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"));
        topicList.add(new Topic("Android is cool", "I'm the coolest though. . . . . . . . . . . . ."));
        topicList.add(new Topic("A title", "Text content text content text content"));
        topicList.add(new Topic("I want food", "blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"));
        topicList.add(new Topic("Android is cool", "I'm the coolest though. . . . . . . . . . . . ."));

        Log.e("TOPICS COUNT", "" + ResourcesManager.getTopicAssetsCount());
    }


    public void populateList(final List<Topic> topicList, boolean incremental, boolean shouldLoadMore) {
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

        if (shouldLoadMore && newSize > 0) {
            //this.topicList.get(newSize - 1).setLoadMore(true);
        }


        adapter.notifyItemRangeInserted(previousSize, topicList.size());

    }
}
