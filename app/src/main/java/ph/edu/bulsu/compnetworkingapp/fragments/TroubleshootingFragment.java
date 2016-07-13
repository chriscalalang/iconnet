package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.TopicAdapter;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;
import ph.edu.bulsu.compnetworkingapp.database.daos.TopicsDAO;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

public class TroubleshootingFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private TopicAdapter adapter;

    private List<Topic> topicList;

    private MenuItem all, win7, win8, win10, ubuntu;

    public static TroubleshootingFragment newInstance() {
        Bundle args = new Bundle();

        TroubleshootingFragment fragment = new TroubleshootingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

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
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void populateListFromCheckedMenuItems() {
        List<String> tags = new ArrayList<>();
        if (win7.isChecked()) {
            tags.add("win7");
        }
        if (win8.isChecked()) {
            tags.add("win8");
        }
        if (win10.isChecked()) {
            tags.add("win10");
        }
        if (ubuntu.isChecked()) {
            tags.add("ubuntu");
        }
        populateList(TopicsDAO.getInstance().getAll(tags), false, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.troubleshooting, menu);
        all = menu.findItem(R.id.all);
        win7 = menu.findItem(R.id.win7);
        win8 = menu.findItem(R.id.win8);
        win10 = menu.findItem(R.id.win10);
        ubuntu = menu.findItem(R.id.ubuntu);

        populateListFromCheckedMenuItems();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(!item.isChecked());
        if (item.getItemId() == R.id.all) {
            if (all.isChecked()) {
                win7.setChecked(true);
                win8.setChecked(true);
                win10.setChecked(true);
                ubuntu.setChecked(true);
            }

        } else {
            if (!item.isChecked())
                all.setChecked(false);
        }
        populateListFromCheckedMenuItems();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_troubleshooting;
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
