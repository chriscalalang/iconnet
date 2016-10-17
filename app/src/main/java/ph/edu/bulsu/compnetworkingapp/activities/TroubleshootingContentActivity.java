package ph.edu.bulsu.compnetworkingapp.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Troubleshooter;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class TroubleshootingContentActivity extends HidingToolbarActivity {

    private Troubleshooter troubleshooter;
    private LinearLayout llTroubleshooter;

    private List<View> solutionViews;

    private int currentPosition = -1;

    @Override

    protected int getContentViewId() {
        return R.layout.activity_troubleshooter_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        solutionViews = new ArrayList<>();

        troubleshooter = getIntent().getParcelableExtra(BundleIDs.TOPIC);
        setTitle("Troubleshooting");

        Log.e("SOLUTIONS COUNT", "" + troubleshooter.getSolutions().size());

        llTroubleshooter = (LinearLayout) findViewById(R.id.llTroubleshooter);
        ((TextView) findViewById(R.id.tvTitle)).setText(troubleshooter.getTitle());

        attemptNewSolution();
    }

    private void attemptNewSolution() {

        if (currentPosition + 1 >= troubleshooter.getSolutions().size()) {
            Toast.makeText(this, "Sorry we cannot find any other solutions", Toast.LENGTH_SHORT).show();
        } else {
            currentPosition++;
            View itemSolution = getLayoutInflater().inflate(R.layout.item_solution, llTroubleshooter, false);

            solutionViews.add(itemSolution);
            llTroubleshooter.addView(itemSolution);


            for (int i = 0; i < solutionViews.size(); i++) {

                String solution = troubleshooter.getSolutions().get(i);

                View view = solutionViews.get(i);
                TextView tvText = (TextView) view.findViewById(R.id.tvText);
                LinearLayout llHelpful = (LinearLayout) view.findViewById(R.id.llHelpful);
                Button btnYes = (Button) view.findViewById(R.id.btnYes);
                Button btnNo = (Button) view.findViewById(R.id.btnNo);

                tvText.setText(solution);
                if (i == solutionViews.size() - 1) {
                    llHelpful.setVisibility(View.VISIBLE);
                    btnYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    btnNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            attemptNewSolution();
                        }
                    });
                } else {
                    llHelpful.setVisibility(View.GONE);
                }
            }


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
