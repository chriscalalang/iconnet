package ph.edu.bulsu.compnetworkingapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;

//import ph.edu.bulsu.compnetworkingapp.adapter.TroubleshootingAdapter;
public class TroubleshootingFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_LAYOUT_MANAGER = "layoutManager";

    private int id;
    private String topic;
    private String content;

    protected RecyclerView.LayoutManager mLayoutManager;

    public TroubleshootingFragment() {
        // Required empty public constructor
    }

    public TroubleshootingFragment(int id, String topic, String content) {
        this.id = id;
        this.topic = topic;
        this.content = content;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getID() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_troubleshooting, container, false);

        Button win7 = (Button) view.findViewById(R.id.win7);
        win7.setOnClickListener(this);

        Button win8 = (Button) view.findViewById(R.id.win8);
        win8.setOnClickListener(this);

        Button win10 = (Button) view.findViewById(R.id.win10);
        win10.setOnClickListener(this);

        Button ubuntu = (Button) view.findViewById(R.id.ubuntu);
        ubuntu.setOnClickListener(this);

        return view;
    }


    public void onClick(View v) {

        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.win7:
                ft.replace(R.id.llTroubleshooting, new TroubleshootingWin7(), "TroubleshootingWin7");
                break;
            case R.id.win8:
                ft.replace(R.id.llTroubleshooting, new TroubleshootingWin8(), "TroubleshootingWin8");
                break;
            case R.id.win10:
                ft.replace(R.id.llTroubleshooting, new TroubleshootingWin10(), "TroubleshootingWin10");
                break;
            case R.id.ubuntu:
                ft.replace(R.id.llTroubleshooting, new TroubleshootingUbuntu(), "TroubleshootingUbuntu");
                break;
        }

        ft.addToBackStack(null);
        ft.commit();
    }
}
