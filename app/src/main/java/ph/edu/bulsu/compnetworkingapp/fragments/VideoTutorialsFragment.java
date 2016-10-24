package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.VideoActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;

public class VideoTutorialsFragment extends BaseFragment implements View.OnClickListener {

    private CardView cvCentralized, cvCollaborative, cvDistributed, cvSubnetting;


    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_video_tutorials;
    }

    public static VideoTutorialsFragment newInstance() {
        Bundle args = new Bundle();

        VideoTutorialsFragment fragment = new VideoTutorialsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initializeParentView(View view) {
        cvCentralized = (CardView) view.findViewById(R.id.cvCentralized);
        cvCollaborative = (CardView) view.findViewById(R.id.cvCollaborative);
        cvDistributed = (CardView) view.findViewById(R.id.cvDistributed);
        cvSubnetting = (CardView) view.findViewById(R.id.cvSubnetting);

        cvCentralized.setOnClickListener(this);
        cvCollaborative.setOnClickListener(this);
        cvDistributed.setOnClickListener(this);
        cvSubnetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(), VideoActivity.class);
        switch (v.getId()) {
            case R.id.cvCentralized:
                intent.putExtra(BundleIDs.VIDEO_FILE_NAME, "centralized");

                break;
            case R.id.cvCollaborative:

                intent.putExtra(BundleIDs.VIDEO_FILE_NAME, "collaborative");

                break;
            case R.id.cvDistributed:

                intent.putExtra(BundleIDs.VIDEO_FILE_NAME, "distributed");

                break;
            case R.id.cvSubnetting:

                intent.putExtra(BundleIDs.VIDEO_FILE_NAME, "subnetting");

                break;
        }

        startActivity(intent);
    }
}
