package ph.edu.bulsu.compnetworkingapp;

import android.os.Bundle;
import android.widget.TextView;

import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Topic;
import ph.edu.bulsu.compnetworkingapp.views.HidingToolbarActivity;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class TopicContentActivity extends HidingToolbarActivity {

    private Topic topic;
    private TextView tvText;

    @Override

    protected int getContentViewId() {
        return R.layout.activity_topic_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topic = getIntent().getParcelableExtra(BundleIDs.TOPIC);

        tvText = (TextView) findViewById(R.id.tvText);

        setTitle(topic.getTitle());

        tvText.setText(topic.getText());
    }
}
