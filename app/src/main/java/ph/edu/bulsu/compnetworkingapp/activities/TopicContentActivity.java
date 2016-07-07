package ph.edu.bulsu.compnetworkingapp.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

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

    @Override

    protected int getContentViewId() {
        return R.layout.activity_topic_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topic = getIntent().getParcelableExtra(BundleIDs.TOPIC);

        tvText = (TextView) findViewById(R.id.tvText);

        wvHtml = (WebView) findViewById(R.id.wvHtml);

        setTitle(topic.getTitle());

        tvText.setText(topic.getText());

        wvHtml.loadDataWithBaseURL("", topic.getHtml(), "text/html", "UTF-8", "");
    }
}
