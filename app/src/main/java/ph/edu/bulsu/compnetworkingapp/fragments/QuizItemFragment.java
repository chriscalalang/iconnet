package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;
import ph.edu.bulsu.compnetworkingapp.interfaces.QuizViewController;
import ph.edu.bulsu.compnetworkingapp.models.QuizItem;
import ph.edu.bulsu.compnetworkingapp.views.IconNetButton;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class QuizItemFragment extends BaseFragment {

    private QuizItem quizItem;
    private TextView tvQuestion;
    private LinearLayout llQuiz;
    private QuizViewController quizViewController;

    public static QuizItemFragment newInstance(QuizItem quizItem) {

        Bundle args = new Bundle();
        args.putParcelable(BundleIDs.QUIZ_ITEM, quizItem);
        QuizItemFragment fragment = new QuizItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizItem = getArguments().getParcelable(BundleIDs.QUIZ_ITEM);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        quizViewController = (QuizViewController) context;
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_quiz_item;
    }

    @Override
    public void initializeParentView(View view) {
        llQuiz = (LinearLayout) view.findViewById(R.id.llQuiz);
        tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);

        tvQuestion.setText(quizItem.getQuestion());

        int theme = 5;
        for (final String choice : quizItem.getChoices()) {
            Button button = new Button(getActivity());
            button.setAllCaps(false);
            button.setText(choice);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quizViewController.answer(choice);
                }
            });
            llQuiz.addView(button);
            theme--;
        }

    }
}
