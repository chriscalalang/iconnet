package ph.edu.bulsu.compnetworkingapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.MockQuizItems;
import ph.edu.bulsu.compnetworkingapp.fragments.QuizItemFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.QuizResultFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.QuizStartupFragment;
import ph.edu.bulsu.compnetworkingapp.interfaces.QuizViewController;
import ph.edu.bulsu.compnetworkingapp.models.QuizItem;

public class QuizActivity extends HidingToolbarActivity implements QuizViewController {

    private int DEFAULT_QUIZ_QUESTION_ITEMS_SIZE = 5;

    private ArrayList<QuizItem> items;
    private FrameLayout flMain;
    private ArrayList<QuizItemFragment> quizItemFragments;
    private ArrayList<String> answers;

    private int currentQuizFragmentPosition;

    private int totalPoints = 0;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Quiz");

        items = MockQuizItems.getQuizItems(DEFAULT_QUIZ_QUESTION_ITEMS_SIZE);
        quizItemFragments = new ArrayList<>();
        answers = new ArrayList<>();


        for (QuizItem item : items) {
            quizItemFragments.add(QuizItemFragment.newInstance(item));
        }


        useFragment(QuizStartupFragment.newInstance());

    }


    private void useFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.flMain, fragment, null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void nextQuiz() {
        currentQuizFragmentPosition++;
        if (currentQuizFragmentPosition < items.size())
            useFragment(quizItemFragments.get(currentQuizFragmentPosition));
        else
            showResults();

    }

    @Override
    public void startQuiz() {
        currentQuizFragmentPosition = 0;
        useFragment(quizItemFragments.get(currentQuizFragmentPosition));
    }

    @Override
    public void answer(String choice) {
        if (currentQuizFragmentPosition < items.size()) {
            answers.add(choice);
            nextQuiz();
        } else {
            showResults();
        }
    }

    @Override
    public void showResults() {
        useFragment(QuizResultFragment.newInstance(items, answers));
    }

}
