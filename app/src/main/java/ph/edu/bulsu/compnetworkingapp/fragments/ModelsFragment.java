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
        return R.layout.fragment_3d_models;
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
        view.findViewById(R.id.cvCableStraight).setOnClickListener(this);
        view.findViewById(R.id.cvCableCrossOver).setOnClickListener(this);
        view.findViewById(R.id.cvModem).setOnClickListener(this);
        view.findViewById(R.id.cvSwitch).setOnClickListener(this);
        view.findViewById(R.id.cvWirelessUSBAdapter).setOnClickListener(this);
        view.findViewById(R.id.cvCoaxialCable).setOnClickListener(this);
        view.findViewById(R.id.cvFirewall).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Model3DViewerActivity.class);
        switch (v.getId()) {
            case R.id.cvRouter:
                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "router_obj");
                intent.putExtra(BundleIDs.PARTS, "A. Antenna \n B. Reset button \n C. Lan ports \n D. Modem port \n E. Power and connection indicators");
                break;
            case R.id.cvCableStraight:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "cable_straight_obj");
                break;
            case R.id.cvCableCrossOver:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "cable_cross_over_obj");
                break;
            case R.id.cvModem:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "modem_obj");
                break;
            case R.id.cvSwitch:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "switch_obj");
                break;
            case R.id.cvWirelessUSBAdapter:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "wireless_usb_adapter_obj");
                break;
            case R.id.cvCoaxialCable:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "coaxial_cable_obj");
                break;
            case R.id.cvFirewall:

                intent.putExtra(BundleIDs.MODEL_FILE_NAME, "firewall_obj");
                intent.putExtra(BundleIDs.PARTS, "A. Power button \n B. NIC modules");
                break;
        }
        startActivity(intent);
    }
}
