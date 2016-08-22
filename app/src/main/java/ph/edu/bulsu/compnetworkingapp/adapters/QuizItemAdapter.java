package ph.edu.bulsu.compnetworkingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.models.QuizItem;
import ph.edu.bulsu.compnetworkingapp.views.IconNetButton;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class QuizItemAdapter extends RecyclerView.Adapter<QuizItemAdapter.QuizItemViewHolder> {

    private Context context;

    private LayoutInflater layoutInflater;

    private List<QuizItem> quizItems;

    private List<String> answers;

    public QuizItemAdapter(Context context, List<QuizItem> quizItems, List<String> answers) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.quizItems = quizItems;
        this.answers = answers;
    }

    @Override
    public QuizItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_quiz_item, parent, false);
        return new QuizItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final QuizItemViewHolder holder, int position) {
        final QuizItem quizItem = quizItems.get(position);
        final String answer = answers.get(position);

        holder.tvQuestion.setText(quizItem.getQuestion());

        boolean correct = false;
        for (String acceptedAnswer : quizItem.getAcceptedAnswers()) {
            if (answer.equalsIgnoreCase(acceptedAnswer)) {
                correct = true;
            }
        }

        if (correct) {
            holder.btnCorrectAnswer.setVisibility(View.VISIBLE);
            holder.btnCorrectAnswer.setText(answer);
            holder.btnCorrectAnswer.setButtonTheme(IconNetButton.BUTTON_THEME_GREEN);
            holder.btnWrongAnswer.setVisibility(View.GONE);
        } else {
            holder.btnCorrectAnswer.setVisibility(View.VISIBLE);
            holder.btnCorrectAnswer.setText(quizItem.getAcceptedAnswers().get(0));
            holder.btnCorrectAnswer.setButtonTheme(IconNetButton.BUTTON_THEME_FACEBOOK);
            holder.btnWrongAnswer.setVisibility(View.VISIBLE);
            holder.btnWrongAnswer.setText(answer);
        }

    }

    @Override
    public int getItemCount() {
        return quizItems.size();
    }

    public class QuizItemViewHolder extends RecyclerView.ViewHolder {


        private TextView tvQuestion;
        private Button btnWrongAnswer;
        private IconNetButton btnCorrectAnswer;

        public QuizItemViewHolder(View itemView) {
            super(itemView);
            tvQuestion = (TextView) itemView.findViewById(R.id.tvQuestion);
            btnWrongAnswer = (Button) itemView.findViewById(R.id.btnWrongAnswer);
            btnCorrectAnswer = (IconNetButton) itemView.findViewById(R.id.btnCorrectAnswer);
        }
    }
}
