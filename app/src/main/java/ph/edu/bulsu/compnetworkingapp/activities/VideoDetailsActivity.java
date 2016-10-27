package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.VideoTutorial;

public class VideoDetailsActivity extends HidingToolbarActivity {

    private VideoTutorial videoTutorial;
    private TextView tvText;
    private CardView cvPlay;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        videoTutorial = getIntent().getParcelableExtra(BundleIDs.VIDEO_TUTORIAL);

        tvText = (TextView) findViewById(R.id.tvText);
        cvPlay = (CardView) findViewById(R.id.cvPlay);
        ivImage = (ImageView) findViewById(R.id.ivImage);

        tvText.setText(videoTutorial.getDescription());
        cvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVideo();
            }
        });
        ivImage.setImageResource(videoTutorial.getDrawable());

        setToolbarTitle(videoTutorial.getTitle());
    }

    private void goToVideo() {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra(BundleIDs.VIDEO_FILE_NAME, videoTutorial.getFileName());
        startActivity(intent);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_video_details;
    }
}
