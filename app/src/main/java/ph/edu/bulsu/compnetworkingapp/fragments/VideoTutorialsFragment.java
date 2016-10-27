package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.VideoActivity;
import ph.edu.bulsu.compnetworkingapp.activities.VideoDetailsActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.VideoTutorial;

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

        Intent intent = new Intent(getActivity(), VideoDetailsActivity.class);
        switch (v.getId()) {
            case R.id.cvCentralized:

                intent.putExtra(BundleIDs.VIDEO_TUTORIAL, new VideoTutorial("centralized", "Centralized computer network model", "The network resources are placed and managed from a main location. Centralized network model allows administrators to manage the resources centrally (typically in Head Office). The network servers and other critical network resources are located in a central location in a secure and dedicated server room. This computer network model provides the following advantages to Network and System Administrators, and also provides a better access to Network Devices. Centralized network provides better Network Security.", R.drawable.centralized));

                break;
            case R.id.cvCollaborative:

                intent.putExtra(BundleIDs.VIDEO_TUTORIAL, new VideoTutorial("collaborative", "Collaborative network", "This is a network consisting of a variety of entities that are largely autonomous, geographically distributed, and heterogeneous in terms of their operating environment, culture, social capital and goals, but that collaborate to better achieve common or compatible goals, and whose interactions are supported by computer networks. The discipline of collaborative networks focuses on the structure, behavior, and evolving dynamics of networks of autonomous entities that collaborate to better achieve common or compatible goals. There are several manifestations of collaborative networks like: \n \n Virtual enterprise (VE). \n •\tVirtual Organization (VO). \n  Dynamic Virtual Organization. \n Extended Enterprise. \n VO Breeding environment (VBE). \n Professional virtual community (PVC). \n Business Ecosystem \n Virtual manufacturing network", R.drawable.collaborative));


                break;
            case R.id.cvDistributed:

                intent.putExtra(BundleIDs.VIDEO_TUTORIAL, new VideoTutorial("distributed", "Distributed network model", "The network resources are placed and managed from different geographical locations. Designated network and system administrators manage the network resources in different locations. These days most of the Enterprise network models are distributed.", R.drawable.distributed));

                break;
            case R.id.cvSubnetting:

                intent.putExtra(BundleIDs.VIDEO_TUTORIAL, new VideoTutorial("subnetting", "Subnetting tutorial", "A tutorial for you to properly do subnetting", R.drawable.subnetting));

                break;
        }

        startActivity(intent);
    }
}
