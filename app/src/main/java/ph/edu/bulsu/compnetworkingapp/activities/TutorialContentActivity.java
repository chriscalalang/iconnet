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

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Tutorial;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class TutorialContentActivity extends HidingToolbarActivity {

    private Tutorial tutorial;
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


        tutorial = getIntent().getParcelableExtra(BundleIDs.TOPIC);


        setTitle(tutorial.getTitle());

        llContent = (LinearLayout) findViewById(R.id.llContent);
        rlImages = (RelativeLayout) findViewById(R.id.rlImages);
        llImages = (LinearLayout) findViewById(R.id.llImages);
        pbImages = (ProgressBar) findViewById(R.id.pbImages);


        Log.e("Images", "" + tutorial.getImages().size());
        Log.e("Tags", "" + tutorial.getTags().size() + " with content" + tutorial.getTags().toString());

//        setupSlideShowImages();
        pbImages.setVisibility(View.GONE);


        setupTextAndImageCards();


        if (tutorial.getHtml() != null) {
            wvHtml = (WebView) findViewById(R.id.wvHtml);
            wvHtml.getSettings();
            wvHtml.setBackgroundColor(Color.TRANSPARENT);
            wvHtml.getSettings().setDefaultTextEncodingName("utf-8");

            String wholeHtml = "<html>" + generateCssString() + tutorial.getHtml().substring(6);

            wvHtml.loadDataWithBaseURL(tutorial.getBaseFolderPath(), wholeHtml, "text/html", "utf-8", "");
        }
    }


    private String generateCssString() {
        return "<style>img{\n" +
                "    display: block !important;\n" +
                "    margin-left: auto !important;\n" +
                "    width: 100% !important;\n" +
                "    height: auto !important;\n" +
                "    margin-right: auto !important; }" +
                " br {\n" +
                "   display: block;\n" +
                "   margin: 10px 0;\n" +
                "}</style>";
    }

    private void setupTextAndImageCards() {
        if (tutorial.getText() != null) {
            String tutorialText = tutorial.getText();

            int index = 0;
            String subtext;
            llContent.removeAllViews();
            do {
                boolean containsCard = tutorialText.contains("<card />");
                subtext = tutorialText.substring(0, containsCard ? tutorialText.indexOf("<card />") : tutorialText.length());

                View view = getLayoutInflater().inflate(R.layout.item_text_card, llContent, false);
                TextView tvText = (TextView) view.findViewById(R.id.tvText);
                ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);

                tvText.setText(Html.fromHtml(subtext));

                if (index < tutorial.getImages().size()) {
                    Glide.with(TutorialContentActivity.this).load(Uri.parse(tutorial.getBaseFolderPath() + tutorial.getImages().get(index))).fitCenter().into(ivImage);
                } else {
                    ivImage.setVisibility(View.GONE);
                }
                index++;
                llContent.addView(view);

                tutorialText = tutorialText.substring(subtext.length() + (containsCard ? 8 : 0));
            } while (tutorialText.length() > 0);
        }

    }

    private void setupSlideShowImages() {

        if (tutorial.getImages().size() < 1) {
            rlImages.setVisibility(View.GONE);
        } else {
            for (final String image : tutorial.getImages()) {
                final View view = getLayoutInflater().inflate(R.layout.item_image, llImages, false);

                final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

                Log.e("Image name", image);
                llImages.addView(view);
                Glide.with(TutorialContentActivity.this).load(Uri.parse(tutorial.getBaseFolderPath() + image)).fitCenter().into(imageView);
                pbImages.setVisibility(View.GONE);

                view.findViewById(R.id.flImage).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TutorialContentActivity.this, ImageFullScreenActivity.class);
                        intent.putExtra(BundleIDs.IMAGE_URL, tutorial.getBaseFolderPath() + image);
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
