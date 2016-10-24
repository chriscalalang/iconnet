package ph.edu.bulsu.compnetworkingapp.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;

public class VideoActivity extends AppCompatActivity {
    private VideoView videoView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.videoView);

        String uriPath = "android.resource://ph.edu.bulsu.compnetworkingapp/raw/" + getIntent().getStringExtra(BundleIDs.VIDEO_FILE_NAME);
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();

        MediaController controller = new MediaController(this);
        controller.setAnchorView(this.videoView);
        controller.setMediaPlayer(this.videoView);
        this.videoView.setMediaController(controller);

    }
}
