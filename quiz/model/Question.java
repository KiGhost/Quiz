package gui.mvp.quiz.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question
{
    private SimpleStringProperty questionProp;
    private SimpleIntegerProperty answersProp;
    private SimpleIntegerProperty correctAnswersProp;
    
    private String sQuestion;
    private String[] aAnswers;
    
    private int answersGiven = 0;
    private int correctAnswersGiven = 0;

    public Question(String sQuestion, String[] aAnswers)
    {
        this.sQuestion = sQuestion;
        questionProp = new SimpleStringProperty(sQuestion);
        
        correctAnswersProp = new SimpleIntegerProperty(0);
        
        this.aAnswers = aAnswers;
        answersProp = new SimpleIntegerProperty(0);
    }
    
    public int getAnswersGiven()
    {
        return answersGiven;
    }

    public void incrementAnswersGiven()
    {
        answersGiven++;
        setAnswers(answersGiven);
    }
        
    public void setAnswersGiven(int answersGiven)
    {
        this.answersGiven = answersGiven;
        setAnswers(answersGiven);
    }
    
    public int getCorrectAnswersGiven()
    {
        return correctAnswersGiven;
    }
    
    public void setCorrectAnswersGiven(int correctAnswersGiven)
    {
        this.correctAnswersGiven = correctAnswersGiven;
        setCorrectAnswers(correctAnswersGiven);
    }

    public void incrementCorrectAnswersGiven()
    {
        this.correctAnswersGiven++;
        setCorrectAnswers(correctAnswersGiven);
    }
    
    public String[] getAnswers()
    {
        return aAnswers;
    }
    
    public String getQuestion()
    {
        return sQuestion;
    }
    
    public SimpleStringProperty getQuestionProperty()
    {
        return questionProp;
    }
    
    public void setQuestion(String question)
    {
        questionProp.set(question);
    }
    
    public SimpleIntegerProperty getAnswersProperty()
    {
        return answersProp;
    }
    
    public void setAnswers(int answers)
    {
        answersProp.set(answers);
    }
    
    public SimpleIntegerProperty getCorrectAnswersProperty()
    {
        return correctAnswersProp;
    }
    
    public void setCorrectAnswers(int correctAnswers)
    {
        correctAnswersProp.set(correctAnswers);
    }
}