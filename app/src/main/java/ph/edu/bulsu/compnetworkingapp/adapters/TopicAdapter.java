package ph.edu.bulsu.compnetworkingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.TopicContentActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Topic;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    private Context context;

    private LayoutInflater layoutInflater;

    private List<Topic> topicList;

    private List<String> splittedSentenceWords;

    private Random random;

    public TopicAdapter(Context context, List<Topic> topicList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.topicList = topicList;
        random = new Random();
    }

    public void setSplittedSentenceWords(List<String> splittedSentenceWords) {
        this.splittedSentenceWords = splittedSentenceWords;
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
            String topicText = topic.getText() + "";
            for (String string : splittedSentenceWords) {
                topicText = topicText.replaceAll("(?i)" + string, "<b><font color='#000000'>" + string + "</font></b>");
            }

            int firstKeyIndex = topicText.indexOf("<b>") - random.nextInt(40);
            if (firstKeyIndex < 0) firstKeyIndex = 0;

            String cutText = topicText.substring(firstKeyIndex, topicText.length());

            Log.e("TOPIC TEXT", cutText);
            holder.tvText.setText(Html.fromHtml(cutText));

        } else {
            if (topic.getHtml() != null) {
                boolean htmlMoreThan250Chars = topic.getHtml().length() > 250;
                holder.tvText.setText(Html.fromHtml(topic.getHtml().substring(0, htmlMoreThan250Chars ? 249 : topic.getHtml().length()) + (htmlMoreThan250Chars ? "..." : "")));
            }
        }
        holder.tagWin7.setVisibility(View.GONE);
        holder.tagWin8.setVisibility(View.GONE);
        holder.tagWin10.setVisibility(View.GONE);
        holder.tagUbuntu.setVisibility(View.GONE);
        holder.tagTopology.setVisibility(View.GONE);

        for (String tag : topic.getTags()) {
            try {
                Tag.valueOf(tag.toUpperCase()).recognizeTag(holder);
            } catch (Exception e) {
                e.printStackTrace();
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
        private TextView tagWin7, tagWin8, tagWin10, tagUbuntu, tagTopology;

        public TopicViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvText = (TextView) itemView.findViewById(R.id.tvText);
            tagWin7 = (TextView) itemView.findViewById(R.id.tagWin7);
            tagWin8 = (TextView) itemView.findViewById(R.id.tagWin8);
            tagWin10 = (TextView) itemView.findViewById(R.id.tagWin10);
            tagUbuntu = (TextView) itemView.findViewById(R.id.tagUbuntu);
            tagTopology = (TextView) itemView.findViewById(R.id.tagTopology);

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


    public enum Tag {

        WIN7 {
            @Override
            public void recognizeTag(TopicViewHolder holder) {
                holder.tagWin7.setVisibility(View.VISIBLE);
            }
        }, WIN8 {
            @Override
            public void recognizeTag(TopicViewHolder holder) {
                holder.tagWin8.setVisibility(View.VISIBLE);
            }
        }, WIN10 {
            @Override
            public void recognizeTag(TopicViewHolder holder) {
                holder.tagWin10.setVisibility(View.VISIBLE);
            }
        }, UBUNTU {
            @Override
            public void recognizeTag(TopicViewHolder holder) {
                holder.tagUbuntu.setVisibility(View.VISIBLE);
            }
        }, TOPO {
            @Override
            public void recognizeTag(TopicViewHolder holder) {
                holder.tagTopology.setVisibility(View.VISIBLE);
            }
        };

        public abstract void recognizeTag(TopicViewHolder holder);
    }


}
