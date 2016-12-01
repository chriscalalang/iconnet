package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.MockQuizItems;
import ph.edu.bulsu.compnetworkingapp.fragments.QuizItemFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.QuizResultFragment;
import ph.edu.bulsu.compnetworkingapp.fragments.QuizStartupFragment;
import ph.edu.bulsu.compnetworkingapp.interfaces.QuizViewController;
import ph.edu.bulsu.compnetworkingapp.models.QuizItem;

public class QuizActivity extends HidingToolbarActivity implements QuizViewController {

    private static final int DEFAULT_QUIZ_QUESTION_ITEMS_SIZE = 10;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.quiz, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                exit();
                return true;
            case R.id.miIPCalculator:
                startActivity(new Intent(QuizActivity.this, QuizIPCalculatorActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void exit() {

        new AlertDialog.Builder(QuizActivity.this)
                .setMessage("Your quiz will be terminated. Are you sure you want to exit?")
                .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();

    }


    @Override
    public void onBackPressed() {
        exit();
    }
}
