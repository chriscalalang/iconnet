package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ph.edu.bulsu.compnetworkingapp.IconNetApplication;
import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class TopicContentActivity extends HidingToolbarActivity {

    private Topic topic;
    private TextView tvText;
    private WebView wvHtml;
    private LinearLayout llImages;
    private RelativeLayout rlImages;
    private ProgressBar pbImages;

    @Override

    protected int getContentViewId() {
        return R.layout.activity_topic_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        topic = getIntent().getParcelableExtra(BundleIDs.TOPIC);


        setTitle(topic.getTitle());

        rlImages = (RelativeLayout) findViewById(R.id.rlImages);
        llImages = (LinearLayout) findViewById(R.id.llImages);
        pbImages = (ProgressBar) findViewById(R.id.pbImages);
        tvText = (TextView) findViewById(R.id.tvText);


        Log.e("Images", "" + topic.getImages().size());
        Log.e("Tags", "" + topic.getTags().size() + " with content" + topic.getTags().toString());

        if (topic.getImages().size() < 1) {
            rlImages.setVisibility(View.GONE);
        } else {
            for (final String image : topic.getImages()) {
                final View view = getLayoutInflater().inflate(R.layout.item_image, llImages, false);

                final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

                Log.e("Image name", image);
                llImages.addView(view);
                Glide.with(TopicContentActivity.this).load(Uri.parse(topic.getBaseFolderPath() + image)).fitCenter().into(imageView);
                pbImages.setVisibility(View.GONE);

                view.findViewById(R.id.flImage).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TopicContentActivity.this, ImageFullScreenActivity.class);
                        intent.putExtra(BundleIDs.IMAGE_URL, topic.getBaseFolderPath() + image);
                        startActivity(intent);
                    }
                });
            }
        }

        tvText.setText(topic.getText());

        wvHtml = (WebView) findViewById(R.id.wvHtml);
        wvHtml.getSettings();
        wvHtml.setBackgroundColor(Color.TRANSPARENT);
        wvHtml.loadDataWithBaseURL(topic.getBaseFolderPath(), topic.getHtml(), "text/html", "UTF-8", "");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
