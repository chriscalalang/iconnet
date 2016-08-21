package ph.edu.bulsu.compnetworkingapp.interfaces;

public interface QuizViewController {
    void nextQuiz();

    void startQuiz();

    void answer(String choice);

    void showResults();
}