package ph.edu.bulsu.compnetworkingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.activities.TroubleshootingContentActivity;
import ph.edu.bulsu.compnetworkingapp.activities.TutorialContentActivity;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.Topic;
import ph.edu.bulsu.compnetworkingapp.models.Troubleshooter;
import ph.edu.bulsu.compnetworkingapp.models.Tutorial;
import ph.edu.bulsu.compnetworkingapp.utils.DeviceUtils;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    private Context context;

    private LayoutInflater layoutInflater;

    private List<Topic> topicList;

    private List<String> splittedSentenceWords;

    public TopicAdapter(Context context, List<Topic> topicList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.topicList = topicList;
        splittedSentenceWords = new ArrayList<>();
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

        holder.tvTitle.setText(Html.fromHtml(topic.getTitle()));


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


        if (topic instanceof Tutorial) {
            Tutorial tutorial = (Tutorial) topic;
            if (tutorial.getText() != null) {
                String tutorialText = tutorial.getText() + "";
                for (String string : splittedSentenceWords) {
                    tutorialText = tutorialText.replaceAll("(?i)" + string, "<b><font color='#000000'>" + string + "</font></b>");
                }

                int firstKeyIndex = tutorialText.indexOf("<b>") - 39;
                if (firstKeyIndex < 0) firstKeyIndex = 0;

                String cutText = tutorialText.substring(firstKeyIndex, tutorialText.length());
                holder.tvText.setText(Html.fromHtml(cutText));

            } else if (tutorial.getHtml() != null) {
                holder.tvText.setText(Html.fromHtml(tutorial.getHtml()));
            } else {
                holder.tvText.setText("");
            }


            if (tutorial.getImages().size() > 0) {
                holder.ivImage.setVisibility(View.VISIBLE);
                Glide.with(context).load(tutorial.getBaseFolderPath() + tutorial.getImages().get(0)).centerCrop().into(holder.ivImage);
            } else {
                holder.ivImage.setVisibility(View.GONE);
                Glide.clear(holder.ivImage);
            }
        } else if (topic instanceof Troubleshooter) {
            Troubleshooter troubleshooter = (Troubleshooter) topic;
            if (troubleshooter.getSolutions().size() > 0) {
                holder.tvText.setText(troubleshooter.getSolutions().get(0));
            }
        }
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvText;
        private TextView tagWin7, tagWin8, tagWin10, tagUbuntu, tagTopology;

        public TopicViewHolder(View itemView) {
            super(itemView);

            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
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
                    Intent intent;

                    if (topicList.get(getAdapterPosition()) instanceof Tutorial) {
                        intent = new Intent(context, TutorialContentActivity.class);
                    } else if (topicList.get(getAdapterPosition()) instanceof Troubleshooter) {
                        intent = new Intent(context, TroubleshootingContentActivity.class);
                    } else {
                        intent = null;
                    }

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

