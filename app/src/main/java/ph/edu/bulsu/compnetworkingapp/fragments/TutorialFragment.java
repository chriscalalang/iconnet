package ph.edu.bulsu.compnetworkingapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.ViewPagerAdapter;

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
        final VideoTutorialsFragment videosTutorialsFragment = VideoTutorialsFragment.newInstance();

        adapter.addFragment(videosTutorialsFragment, "Video Tutorials");
        adapter.addFragment(ModelsFragment.newInstance(), "3D Models");
        vpTutorial.setAdapter(adapter);

        tabLayout = mainViewController.getTabLayout();
        tabLayout.setupWithViewPager(vpTutorial);


        vpTutorial.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mainViewController.getSearchView().setVisibility(position < 1 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.post(new Runnable() {
            @Override
            public void run() {


                allTutorialsFragment.requestTopics();

            }
        });
    }
}
