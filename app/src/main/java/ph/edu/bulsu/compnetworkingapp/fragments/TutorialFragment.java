package ph.edu.bulsu.compnetworkingapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;
import ph.edu.bulsu.compnetworkingapp.interfaces.ResourceUpdateStatusListener;
import ph.edu.bulsu.compnetworkingapp.managers.ResourcesManager;

public class TutorialFragment extends BaseFragment {
    private ViewPager vpTutorial;
    private TabLayout tabLayout;


    public static TutorialFragment newInstance() {
        Bundle args = new Bundle();

        TutorialFragment fragment = new TutorialFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_tutorial;
    }

    @Override
    public void initializeParentView(View view) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vpTutorial = (ViewPager) view.findViewById(R.id.vpTutorial);
        vpTutorial.setOffscreenPageLimit(3);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        final AllTutorialsFragment allTutorialsFragment = AllTutorialsFragment.newInstance();

        adapter.addFragment(allTutorialsFragment, "All");
        final TopologyFragment topologyFragment = TopologyFragment.newInstance();

        adapter.addFragment(topologyFragment, "Topology");
        adapter.addFragment(SimulationFragment.newInstance(), "Simulation");
        vpTutorial.setAdapter(adapter);

        tabLayout = mainViewController.getTabLayout();
        tabLayout.setupWithViewPager(vpTutorial);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {

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
                            allTutorialsFragment.requestTopics();
                            topologyFragment.requestTopics();
                            progressDialog.dismiss();
                        }
                    });
                } else {

                    allTutorialsFragment.requestTopics();
                    topologyFragment.requestTopics();
                }
            }
        });
    }
}
