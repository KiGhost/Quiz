package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.QuizModel;

public class OverviewPresenter
{
    private OverviewView overviewView;
    private QuizModel quizModel;
    
    public OverviewPresenter()
    {   
    }
    
    public void setOverviewView(OverviewView ov)
    {
        overviewView = ov;
    }
    
    public OverviewView getOverviewView()
    {
        return overviewView;
    }
    
    public void setQuizModel(QuizModel qm)
    {
        quizModel = qm;
    }
    
    public void reset()
    {
        quizModel.resetQuiz();
    }
    
    public void updateTableData()
    {
        overviewView.setTableData(quizModel.getQuestionList());
    }
}
