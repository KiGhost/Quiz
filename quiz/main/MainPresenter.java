package gui.mvp.quiz.main;

import gui.mvp.quiz.detail.DetailPresenter;
//import gui.mvp.quiz.edit.EditPresenter;
import gui.mvp.quiz.overview.OverviewPresenter;

public class MainPresenter
{
    private MainView mainView;
    private OverviewPresenter overviewPresenter;
    private DetailPresenter detailPresenter;
    //private EditPresenter editPresenter;
    
    public MainPresenter()
    {
    }
    
    public void showOverviewView()
    {
        overviewPresenter.updateTableData();
        mainView.setContent(overviewPresenter.getOverviewView());
    }

    public void showDetailView()
    {
        mainView.setContent(detailPresenter.getDetailView());
    }
    
//    public void showEditView()
//    {
//        mainView.setContent(editPresenter.getEditView());
//    }
    
    public void setOverviewPresenter(OverviewPresenter overviewPresenter)
    {
        this.overviewPresenter = overviewPresenter;
    }
    
    public void setDetailPresenter(DetailPresenter detailPresenter)
    {
        this.detailPresenter = detailPresenter;
    }
    
//    public void setEditPresenter(EditPresenter editPresenter)
//    {
//        this.editPresenter = editPresenter;
//    }
     
    public MainView getView()
    {
        return mainView;
    }
    
    public void setMainView(MainView mv)
    {
        mainView = mv;
    }
    
    public void restartQuiz()
    {
        detailPresenter.initQ();
    }
}
