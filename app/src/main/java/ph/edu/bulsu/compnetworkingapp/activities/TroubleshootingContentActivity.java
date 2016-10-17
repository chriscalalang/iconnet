package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Troubleshooter;
import ph.edu.bulsu.compnetworkingapp.models.Tutorial;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class TroubleshootingContentActivity extends HidingToolbarActivity {

    private Troubleshooter troubleshooter;
    private LinearLayout llTroubleshooter;

    private List<View> solutionViews;

    private int currentPosition = 0;

    @Override

    protected int getContentViewId() {
        return R.layout.activity_troubleshooter_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        troubleshooter = getIntent().getParcelableExtra(BundleIDs.TOPIC);
        setTitle("Troubleshooting");

        llTroubleshooter = (LinearLayout) findViewById(R.id.llTroubleshooter);

        View titleView = getLayoutInflater().inflate(R.layout.item_text_card, null, false);
        ((TextView) titleView.findViewById(R.id.tvText)).setText(troubleshooter.getTitle());
        llTroubleshooter.addView(titleView);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
