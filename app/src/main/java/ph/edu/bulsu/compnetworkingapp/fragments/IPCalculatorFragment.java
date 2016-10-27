package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.VideoDetailsActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.VideoTutorial;

public class IPCalculatorFragment extends BaseFragment {

    private static final String TAG = IPCalculatorFragment.class.getSimpleName();

    private EditText etIP;
    private Spinner sBitLength, sSubnetMask;
    private TextView tvResultsWillShowIf, tvBroadcastAddress, tvNetworkAddress, tvHomeAddressRange;
    private CardView cvBroadcastAddress, cvNetworkAddress, cvHomeAddressRange;
    private ScrollView svContent;
    private TextView tvSubnettingVideoLink;

    public static IPCalculatorFragment newInstance() {

        Bundle args = new Bundle();

        IPCalculatorFragment fragment = new IPCalculatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_ip_calculator;
    }

    @Override
    public void initializeParentView(View view) {
        svContent = (ScrollView) view.findViewById(R.id.svContent);
        etIP = (EditText) view.findViewById(R.id.etIP);
        sSubnetMask = (Spinner) view.findViewById(R.id.sSubnetMask);
        sBitLength = (Spinner) view.findViewById(R.id.sBitLength);
        tvResultsWillShowIf = (TextView) view.findViewById(R.id.tvResultsWillShowIf);
        tvBroadcastAddress = (TextView) view.findViewById(R.id.tvBroadcastAddress);
        tvNetworkAddress = (TextView) view.findViewById(R.id.tvNetworkAddress);
        tvHomeAddressRange = (TextView) view.findViewById(R.id.tvHomeAddressRange);
        cvBroadcastAddress = (CardView) view.findViewById(R.id.cvBroadcastAddress);
        cvNetworkAddress = (CardView) view.findViewById(R.id.cvNetworkAddress);
        cvHomeAddressRange = (CardView) view.findViewById(R.id.cvHomeAddressRange);
        tvSubnettingVideoLink = (TextView) view.findViewById(R.id.tvSubnettingVideoLink);

        tvSubnettingVideoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), VideoDetailsActivity.class);
                intent.putExtra(BundleIDs.VIDEO_TUTORIAL, new VideoTutorial("subnetting", "Subnetting tutorial", "A tutorial for you to properly do subnetting", R.drawable.subnetting));

                startActivity(intent);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                context, R.array.bitlengths, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBitLength.setAdapter(adapter);
        sBitLength.setOnItemSelectedListener(bitlengthSelectedListener);

        ArrayAdapter<CharSequence> subnetmask_adapter = ArrayAdapter.createFromResource(
                context, R.array.subnets, android.R.layout.simple_spinner_item);
        subnetmask_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSubnetMask.setAdapter(subnetmask_adapter);
        sSubnetMask.setOnItemSelectedListener(subnetMaskSelectedListener);


        etIP.addTextChangedListener(textWatcher);

    }

    private AdapterView.OnItemSelectedListener bitlengthSelectedListener = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            updateSubnetmaskFromBitlength();
            updateResults(true);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            updateSubnetmaskFromBitlength();
        }

    };

    private AdapterView.OnItemSelectedListener subnetMaskSelectedListener = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            updateBitlengthFromSubnetmask();
            updateResults(true);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            updateBitlengthFromSubnetmask();
        }

    };

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            doCalculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void doCalculate() {
        if (!updateResults(true)) {
            clearResults();
        } else {
            showResults();
        }
    }

    private boolean updateResults(boolean updateView) {
        CharSequence ipAddressText = etIP.getText();
        if (ipAddressText == null) {
            return false;
        }
        String ip = ipAddressText.toString();
        int ip32bit;
        try {
            ip32bit = stringIPtoInt(ip);
        } catch (Exception e) {
            clearResults();
            return false;
        }
        String selectedItem = (String) sBitLength.getSelectedItem();
        if (selectedItem == null) {
            return false;
        }
        int bitlength = Integer.parseInt(
                selectedItem.substring(1));
        Log.d(TAG, "bitlength=" + bitlength);

        int ip32bitmask = (1 << (32 - bitlength)) - 1;

        int firstip = ip32bit & (~ip32bitmask);
        int lastip = firstip | ip32bitmask;

        String ipFirst = IntIPToString(firstip);
        String ipLast = IntIPToString(lastip);

        int maximumAddresses;
        if (ip32bitmask > 0) {
            maximumAddresses = ip32bitmask - 1;
        } else {
            maximumAddresses = 0;
        }

        String wildcard = IntIPToString(ip32bitmask);
        String binary = convertIPIntDec2StringBinary(ip32bit);
        int netmask = (~ip32bitmask);
        String binaryNetmask = convertIPIntDec2StringBinary(netmask);

        if (updateView) {
            tvNetworkAddress.setText(ipFirst);
            tvBroadcastAddress.setText(ipLast);

            String ipFirstTweaked = (ipFirst.substring(0, ipFirst.lastIndexOf("."))) + ".1";
            tvHomeAddressRange.setText(ipFirstTweaked + " - " + ipLast);
        }

        return true;

    }

    private void updateSubnetmaskFromBitlength() {

        sSubnetMask.setSelection(sBitLength.getSelectedItemPosition());
    }

    private void updateBitlengthFromSubnetmask() {

        sBitLength.setSelection(sSubnetMask.getSelectedItemPosition());
    }

    public static String convertIPIntDec2StringBinary(int intIP) {
        Log.d(TAG, "convertIPIntDec2StringBinary(" + intIP + ")");
        String stringIP;
        stringIP = Integer.toBinaryString(intIP);
        int length = stringIP.length();
        if (length < 32) {
            int prependZeros = 32 - length;
            for (int i = 0; i < prependZeros; i++) {
                stringIP = "0" + stringIP;
            }
        }
        String octet1 = stringIP.substring(0, 8);
        String octet2 = stringIP.substring(8, 16);
        String octet3 = stringIP.substring(16, 24);
        String octet4 = stringIP.substring(24, 32);
        stringIP = octet1 + "." + octet2 + "." + octet3 + "." + octet4;
        return stringIP;
    }


    private String IntIPToString(int in) {
        int quad1 = ((in & 0xFF000000) >> 24) & 0xFF;
        int quad2 = (in & 0x00FF0000) >> 16;
        int quad3 = (in & 0x0000FF00) >> 8;
        int quad4 = (in & 0x000000FF);

        return String.format("%d.%d.%d.%d", quad1, quad2, quad3, quad4);
    }

    public static int stringIPtoInt(String ip) throws Exception {
        String[] quad = ip.split("\\.", 4);
        if (quad.length != 4) {
            throw new Exception();
        }
        int ip32bit = 0;
        for (String value : quad) {
            if (value.length() < 1) {
                throw new Exception();
            }
            int octet;
            try {
                octet = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new Exception();
            }

            if (octet > 255) {
                throw new Exception();
            }
            ip32bit = ip32bit << 8;
            ip32bit = ip32bit | octet;
        }
        return ip32bit;
    }

    private void clearResults() {
        tvResultsWillShowIf.setVisibility(View.VISIBLE);
        cvHomeAddressRange.setVisibility(View.GONE);
        cvBroadcastAddress.setVisibility(View.GONE);
        cvNetworkAddress.setVisibility(View.GONE);
    }

    private void showResults() {
        tvResultsWillShowIf.setVisibility(View.GONE);
        cvHomeAddressRange.setVisibility(View.VISIBLE);
        cvBroadcastAddress.setVisibility(View.VISIBLE);
        cvNetworkAddress.setVisibility(View.VISIBLE);
        svContent.post(new Runnable() {
            @Override
            public void run() {

                svContent.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
