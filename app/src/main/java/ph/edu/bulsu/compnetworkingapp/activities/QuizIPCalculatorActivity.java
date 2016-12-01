package ph.edu.bulsu.compnetworkingapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.fragments.IPCalculatorFragment;

public class QuizIPCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ipcalculator);

        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, IPCalculatorFragment.newInstance(false)).commit();


    }
}
