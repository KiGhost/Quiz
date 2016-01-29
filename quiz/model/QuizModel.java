package gui.mvp.quiz.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuizModel
{
    private ObservableList<Question> data;
    
    private int currentQuestionIndex = 0;
    private int lastQuestionIndex = 4;
    
    
    public QuizModel()
    {
        Question question1 = new Question("Ordnen Sie die Nummern (absteigend)!", new String[]{"6","9", "12", "15", "18"});
        Question question2 = new Question("Ordnen Sie die Städte nach ihrer Einwohnerzahl (absteigend)!", new String[]{"23","42", "83", "30", "35"});
        Question question3 = new Question("Ordnen Sie die Personen nach ihren Geburtsjahren (aufsteigend)!", new String[]{"82","37", "43", "68", "63"});
        
        data = FXCollections.observableArrayList();
        data.add(question1);
        data.add(question2);
        data.add(question3);
    }
    
    public String[] getAnswers()
    {
        return data.get(currentQuestionIndex).getAnswers();
    }
    
    public String getQuestion()
    {
        return data.get(currentQuestionIndex).getQuestion();
    }
    
    public ObservableList<Question> getQuestionList()
    {
        return data;
    }
            
    public void setCurrentQuestionIndex(int c)
    {
        currentQuestionIndex = c;
    }  
    
    public void incrementCurrentQuestionIndex()
    {
        currentQuestionIndex++;
    }
    
    public int getCurrentQuestionIndex()
    {
        return currentQuestionIndex;
    }
    
    public int getLastQuestionIndex()
    {
        return lastQuestionIndex;
    }
    
    public void checkAnswer(String answer)
    {
        data.get(currentQuestionIndex).incrementAnswersGiven();
        
        if (true/*answer.equals((data.get(currentQuestionIndex).getCorrectAnswer()))*/)
        {
            System.out.println(answer); // DEBUG
            data.get(currentQuestionIndex).incrementCorrectAnswersGiven();
        }
    }
    
    public void resetQuiz()
    {
        for(int i = 0; i < lastQuestionIndex; ++i)
        {
            data.get(i).setAnswersGiven(0);
            data.get(i).setCorrectAnswersGiven(0);
        }
        currentQuestionIndex = 0;
    }

    public void eraseQuestion(int index)
    {
        data.remove(index);
        lastQuestionIndex--;
        resetQuiz();
    }
       
    public void addQuestion(String question, String[] answers)
    {
        Question newQuestion = new Question(question, new String[]{answers[0],answers[1], answers[2], answers[3], answers[4]});
        data.add(newQuestion);
        lastQuestionIndex++;
        resetQuiz();
    }

//    public void replaceQuestion(String question, int oldQuestionIndex, int correctAnswerInt, String[] answers)
//    {
//        data.remove(oldQuestionIndex);
//        Question newQuestion = new Question(question, new String[]{answers[0],answers[1], answers[2], answers[3], answers[4]});
//        data.add(newQuestion);
//        resetQuiz();
//    }
}
