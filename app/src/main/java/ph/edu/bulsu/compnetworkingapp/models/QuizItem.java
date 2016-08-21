package ph.edu.bulsu.compnetworkingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sheychan on 8/21/2016.
 */
public class QuizItem implements Parcelable {
    private String question;
    private List<String> choices;
    private List<String> acceptedAnswers;

    public QuizItem() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        Collections.shuffle(choices);
        this.choices = choices;
    }

    public List<String> getAcceptedAnswers() {
        return acceptedAnswers;
    }

    public void setAcceptedAnswers(List<String> acceptedAnswers) {
        this.acceptedAnswers = acceptedAnswers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringList(choices);
        dest.writeStringList(acceptedAnswers);
    }

    protected QuizItem(Parcel in) {
        question = in.readString();
        choices = in.createStringArrayList();
        acceptedAnswers = in.createStringArrayList();
    }

    public static final Creator<QuizItem> CREATOR = new Creator<QuizItem>() {
        @Override
        public QuizItem createFromParcel(Parcel in) {
            return new QuizItem(in);
        }

        @Override
        public QuizItem[] newArray(int size) {
            return new QuizItem[size];
        }
    };

}
