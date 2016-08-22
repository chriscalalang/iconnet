package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
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

import ph.edu.bulsu.compnetworkingapp.IconNetApplication;
import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Topic;
import ph.edu.bulsu.compnetworkingapp.utils.DeviceUtils;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class TopicContentActivity extends HidingToolbarActivity {

    private Topic topic;
    private WebView wvHtml;
    private LinearLayout llImages;
    private RelativeLayout rlImages;
    private ProgressBar pbImages;
    private LinearLayout llContent;

    @Override

    protected int getContentViewId() {
        return R.layout.activity_topic_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        topic = getIntent().getParcelableExtra(BundleIDs.TOPIC);


        setTitle(topic.getTitle());

        llContent = (LinearLayout) findViewById(R.id.llContent);
        rlImages = (RelativeLayout) findViewById(R.id.rlImages);
        llImages = (LinearLayout) findViewById(R.id.llImages);
        pbImages = (ProgressBar) findViewById(R.id.pbImages);


        Log.e("Images", "" + topic.getImages().size());
        Log.e("Tags", "" + topic.getTags().size() + " with content" + topic.getTags().toString());

//        setupSlideShowImages();
        pbImages.setVisibility(View.GONE);


        setupTextAndImageCards();


        wvHtml = (WebView) findViewById(R.id.wvHtml);
        wvHtml.getSettings();
        wvHtml.setBackgroundColor(Color.TRANSPARENT);
        wvHtml.loadDataWithBaseURL(topic.getBaseFolderPath(), topic.getHtml(), "text/html", "UTF-8", "");
    }

    private void setupTextAndImageCards() {
        String topicText = topic.getText();

        int index = 0;
        String subtext;
        llContent.removeAllViews();
        do {
            boolean containsCard = topicText.contains("<card />");
            subtext = topicText.substring(0, containsCard ? topicText.indexOf("<card />") : topicText.length());

            View view = getLayoutInflater().inflate(R.layout.item_text_card, llContent, false);
            TextView tvText = (TextView) view.findViewById(R.id.tvText);
            ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);

            tvText.setText(Html.fromHtml(subtext));

            if (index < topic.getImages().size()) {
                Glide.with(TopicContentActivity.this).load(Uri.parse(topic.getBaseFolderPath() + topic.getImages().get(index))).fitCenter().into(ivImage);
            } else {
                ivImage.setVisibility(View.GONE);
            }
            index++;
            llContent.addView(view);

            topicText = topicText.substring(subtext.length() + (containsCard ? 8 : 0));
        } while (topicText.length() > 0);


    }

    private void setupSlideShowImages() {

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

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
