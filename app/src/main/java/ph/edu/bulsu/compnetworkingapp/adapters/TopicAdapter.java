package ph.edu.bulsu.compnetworkingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Logger;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.TopicContentActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private static final Logger logger = Logger.getLogger(TopicAdapter.class.getSimpleName());

    private Context context;

    private LayoutInflater layoutInflater;

    private List<Topic> topicList;


    public TopicAdapter(Context context, List<Topic> TopicList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.topicList = TopicList;
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TopicViewHolder holder, int position) {
        final Topic topic = topicList.get(position);

        if (position % 2 == 1)
            holder.itemView.setBackgroundResource(R.drawable.background_simple_item_white);
        else holder.itemView.setBackgroundResource(R.drawable.background_simple_item_gray);


        holder.tvTitle.setText(Html.fromHtml(topic.getTitle()));

        if (topic.getText() != null) {
            boolean textMoreThan250Chars = topic.getText().length() > 250;
            holder.tvText.setText(Html.fromHtml(topic.getText().substring(0, textMoreThan250Chars ? 249 : topic.getText().length()) + (textMoreThan250Chars ? "..." : "")));
        } else {
            if (topic.getHtml() != null) {
                boolean htmlMoreThan250Chars = topic.getHtml().length() > 250;
                holder.tvText.setText(Html.fromHtml(topic.getHtml().substring(0, htmlMoreThan250Chars ? 249 : topic.getHtml().length()) + (htmlMoreThan250Chars ? "..." : "")));
            }
        }
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvText;

        public TopicViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvText = (TextView) itemView.findViewById(R.id.tvText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TopicContentActivity.class);
                    intent.putExtra(BundleIDs.TOPIC, topicList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
