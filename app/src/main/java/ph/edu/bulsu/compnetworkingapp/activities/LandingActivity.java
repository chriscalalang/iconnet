package ph.edu.bulsu.compnetworkingapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.interfaces.ResourceUpdateStatusListener;
import ph.edu.bulsu.compnetworkingapp.managers.ResourcesManager;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cvTutorials, cvTroubleshooting, cvQuiz, cvIpCalculator;
    private ImageView ivLogo;
    private LinearLayout llButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        cvTutorials = (CardView) findViewById(R.id.cvTutorials);
        cvIpCalculator = (CardView) findViewById(R.id.cvIpCalculator);
        cvQuiz = (CardView) findViewById(R.id.cvQuiz);
        cvTroubleshooting = (CardView) findViewById(R.id.cvTroubleshooting);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        llButtons = (LinearLayout) findViewById(R.id.llButtons);

        llButtons.postDelayed(new Runnable() {
            @Override
            public void run() {
                llButtons.setVisibility(View.VISIBLE);
                cvTutorials.setOnClickListener(LandingActivity.this);
                cvIpCalculator.setOnClickListener(LandingActivity.this);
                cvQuiz.setOnClickListener(LandingActivity.this);
                cvTroubleshooting.setOnClickListener(LandingActivity.this);
                ivLogo.setOnClickListener(LandingActivity.this);


                final ProgressDialog progressDialog = new ProgressDialog(LandingActivity.this);

                Log.e("TOPICS COUNT", "" + ResourcesManager.getAssetsCount());
                if (ResourcesManager.hasNewTopicAssets()) {
                    progressDialog.setMessage("Loading resources");
                    progressDialog.setIndeterminate(true);
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    ResourcesManager.updateTroubleShootingAssets();
                    ResourcesManager.updateTutorialAssets(new ResourceUpdateStatusListener() {
                        @Override
                        public View getHandler() {
                            return ivLogo;
                        }

                        @Override
                        public void onUpdateCompleted() {
                            progressDialog.dismiss();
                        }
                    });
                }

            }
        }, 1500);

    }

    @Override
    public void onClick(View v) {
        int page = 0;
        switch (v.getId()) {
            case R.id.cvTroubleshooting:
                page = 1;
                break;
            case R.id.cvIpCalculator:
                page = 2;
                break;
            case R.id.cvQuiz:
                page = 3;
                break;
        }

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(BundleIDs.PAGE_NUMBER, page);
        startActivity(i);
        finish();
    }
}