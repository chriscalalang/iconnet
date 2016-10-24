package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.Model3DViewerActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;

public class ModelsFragment extends BaseFragment implements View.OnClickListener {
    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_simulation;
    }

    public static ModelsFragment newInstance() {
        Bundle args = new Bundle();

        ModelsFragment fragment = new ModelsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initializeParentView(View view) {
        view.findViewById(R.id.cvRouter).setOnClickListener(this);
        view.findViewById(R.id.cvRj45).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Model3DViewerActivity.class);
        switch (v.getId()){
            case R.id.cvRouter:
                intent.putExtra(BundleIDs.MODEL_FILE_NAME,"router_obj");
                break;
            case R.id.cvRj45:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME,"rj45_obj");
                break;
        }
        startActivity(intent);
    }
}
