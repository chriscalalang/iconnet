package ph.edu.bulsu.compnetworkingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.interfaces.QuizViewController;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class QuizStartupFragment extends BaseFragment {

    private QuizViewController quizViewController;
    private Button btnStart;

    public static QuizStartupFragment newInstance() {

        Bundle args = new Bundle();

        QuizStartupFragment fragment = new QuizStartupFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        quizViewController = (QuizViewController) context;
    }

    @Override
    public int getParentLayoutId() {
        return R.layout.fragment_quiz_startup;
    }

    @Override
    public void initializeParentView(View view) {
        btnStart = (Button) view.findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizViewController.startQuiz();
            }
        });
    }
}
