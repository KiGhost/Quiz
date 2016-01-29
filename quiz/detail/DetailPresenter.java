package gui.mvp.quiz.detail;

import gui.mvp.quiz.model.QuizModel;

public class DetailPresenter
{   
    private DetailView detailView;
    private QuizModel quizModel;
    
    public void setQuizModel(QuizModel qm)
    {
        quizModel = qm;
    }
    
    public DetailView getDetailView()
    {
        return detailView;
    }

    public void setDetailView(DetailView dv)
    {
        detailView = dv;
    }
    
    public void validateAnswer(String a)
    {
        quizModel.checkAnswer(a);
    }
    
    public void initQ()
    {
        detailView.clear();
        quizModel.setCurrentQuestionIndex(0);
        detailView.updateQuestions(quizModel.getQuestion(), quizModel.getAnswers());
    }

    public void nextQuestion()
    {
        quizModel.incrementCurrentQuestionIndex();
        
        if(quizModel.getCurrentQuestionIndex() < quizModel.getLastQuestionIndex())
        {   
            detailView.updateQuestions(quizModel.getQuestion(), quizModel.getAnswers());
        } 
        else
        {
            detailView.quizEnd();
        }
    }
}
