package ph.edu.bulsu.compnetworkingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;
import java.util.logging.Logger;

import ph.edu.bulsu.compnetworkingapp.R;
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

        holder.tvTitle.setText(topic.getTitle());
        holder.tvText.setText(topic.getText());
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

                }
            });
        }
    }
}
