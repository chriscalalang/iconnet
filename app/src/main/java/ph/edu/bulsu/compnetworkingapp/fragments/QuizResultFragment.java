package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.adapters.QuizItemAdapter;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.models.QuizItem;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class QuizResultFragment extends BaseFragment {

    private List<QuizItem> items;
    private List<String> answers;


    private RecyclerView rvQuizResults;
    private TextView tvRemark;
    private QuizItemAdapter adapter;

    public static QuizResultFragment newInstance(ArrayList<QuizItem> items, ArrayList<String> answers) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(BundleIDs.QUIZ_ITEMS, items);
        args.putStringArrayList(BundleIDs.ANSWERS, answers);
        QuizResultFragment fragment = new QuizResultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_quiz_result;
    }

    @Override
    public void initializeParentView(View view) {
        tvRemark = (TextView) view.findViewById(R.id.tvRemark);

        this.items = new ArrayList<>();
        this.answers = new ArrayList<>();

        adapter = new QuizItemAdapter(context, items, answers);

        rvQuizResults = (RecyclerView) view.findViewById(R.id.rvQuizResults);
        rvQuizResults.setAdapter(adapter);
        rvQuizResults.setLayoutManager(new LinearLayoutManager(context));
        rvQuizResults.setNestedScrollingEnabled(false);
        rvQuizResults.setItemAnimator(new DefaultItemAnimator());


        final List<QuizItem> items = getArguments().getParcelableArrayList(BundleIDs.QUIZ_ITEMS);
        List<String> answers = getArguments().getStringArrayList(BundleIDs.ANSWERS);


        for (int index = 0; index < items.size(); index++) {
            final QuizItem item = items.get(index);
            final String answer = answers.get(index);

            final int finalIndex = index;
            rvQuizResults.postDelayed(new Runnable() {
                @Override
                public void run() {
                    QuizResultFragment.this.items.add(item);
                    QuizResultFragment.this.answers.add(answer);

                    adapter.notifyItemInserted(QuizResultFragment.this.items.size() - 1);

                    if (finalIndex == items.size() - 1)
                        showQuizResult();
                }
            }, 500);
        }

    }

    private void showQuizResult() {
        double score = 0;

        for (int i = 0; i < items.size(); i++) {
            QuizItem item = items.get(i);
            String answer = answers.get(i);

            boolean correct = false;
            for (String acceptedAnswer : item.getAcceptedAnswers()) {
                if (acceptedAnswer.equalsIgnoreCase(answer)) {
                    correct = true;
                }
            }

            if (correct) {
                score += 1;
            }
        }

        String remark = "You got " + (score == items.size() ? " a perfect score." : (int) score == 0 ? "0" : (int) score + " out of " + items.size() + ". ");

        double percentage = (score / items.size()) * 100;

        if (percentage == 100) {
            remark += " Brillant!";
        } else if (percentage > 75) {
            remark += " Awesome!";
        } else if (percentage > 50) {
            remark += " You did well.";
        } else if (percentage > 0) {
            remark += " Unfortunately, you failed. But it's ok. You can use the app to learn more.";
        }

        tvRemark.setText(remark);
    }
}
