package gui.mvp.quiz;

import gui.mvp.quiz.detail.DetailPresenter;
import gui.mvp.quiz.detail.DetailView;
import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.main.MainView;
import gui.mvp.quiz.model.QuizModel;
import gui.mvp.quiz.overview.OverviewPresenter;
import gui.mvp.quiz.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    public void start (Stage stage) throws Exception
    {
        MainPresenter mainPresenter = initApplication();
        mainPresenter.showDetailView();
        
        Scene scene = new Scene(mainPresenter.getView(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();
    }
    
    private MainPresenter initApplication()
    {
        MainView mainView = new MainView();
        MainPresenter mainPresenter = new MainPresenter();
        
        OverviewPresenter overviewPresenter = new OverviewPresenter();
        OverviewView overviewView = new OverviewView();
        
        DetailPresenter detailPresenter = new DetailPresenter();
        DetailView detailView = new DetailView();
        
        QuizModel model = new QuizModel();
        
        mainView.setMainPresenter(mainPresenter);
        
        mainPresenter.setOverviewPresenter(overviewPresenter);
        mainPresenter.setMainView(mainView);
        mainPresenter.setDetailPresenter(detailPresenter);
        //mainPresenter.setEditPresenter(editPresenter);
        
        overviewPresenter.setOverviewView(overviewView);
        overviewPresenter.setQuizModel(model);
        overviewView.setOverviewPresenter(overviewPresenter);
        
        detailPresenter.setDetailView(detailView);
        detailPresenter.setQuizModel(model);
        detailView.setDetailPresenter(detailPresenter);
        
        detailPresenter.initQ();
        return mainPresenter;
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
