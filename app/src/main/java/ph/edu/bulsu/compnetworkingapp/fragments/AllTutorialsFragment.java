package ph.edu.bulsu.compnetworkingapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.TopicAdapter;
import ph.edu.bulsu.compnetworkingapp.database.daos.TopicsDAO;
import ph.edu.bulsu.compnetworkingapp.interfaces.ResourceUpdateStatusListener;
import ph.edu.bulsu.compnetworkingapp.managers.ResourcesManager;
import ph.edu.bulsu.compnetworkingapp.models.Topic;
import ph.edu.bulsu.compnetworkingapp.utils.WordQueriesBuilder;

public class AllTutorialsFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private TopicAdapter adapter;

    private List<Topic> topicList;

    private List<String> textQueries;

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
        textQueries = new ArrayList<>();

        adapter = new TopicAdapter(context, topicList, textQueries);

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

        final ProgressDialog progressDialog = new ProgressDialog(context);

        Log.e("TOPICS COUNT", "" + ResourcesManager.getTopicAssetsCount());
        if (ResourcesManager.hasNewTopicAssets()) {
            progressDialog.setMessage("Loading resources");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
            ResourcesManager.updateTopicAssets(new ResourceUpdateStatusListener() {
                @Override
                public View getHandler() {
                    return parentView;
                }

                @Override
                public void onUpdateCompleted() {
                    populateList(TopicsDAO.getInstance().getAll(null, textQueries), false);
                    progressDialog.dismiss();
                }
            });
        } else {
            populateList(TopicsDAO.getInstance().getAll(null, textQueries), false);
        }
    }

    public void populateList(final List<Topic> topicList, boolean incremental) {
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
        populateList(TopicsDAO.getInstance().getAll(null, textQueries), false);
        return super.onQueryTextChange(newText);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        hideKeyBoard();
        return super.onQueryTextSubmit(query);
    }
}
