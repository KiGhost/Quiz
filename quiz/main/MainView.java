package gui.mvp.quiz.main;

import javafx.application.Platform;
// import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainView extends BorderPane
{
    private MainPresenter mainPresenter;
    
    public MainView()
    {
        initView();
    }
    
    public void setMainPresenter(MainPresenter mp)
    {
        mainPresenter = mp;
    }
    
    public void initView()
    {
        GridPane grid = new GridPane();

        MenuBar menuBar = new MenuBar();
        
        Menu menu = new Menu("Menü");
        menuBar.getMenus().add(menu);
        
        MenuItem menuStart = new MenuItem("Starten");
        menu.getItems().add(menuStart);
        menuStart.setOnAction(e ->
        {
            mainPresenter.restartQuiz();
        });
        
        MenuItem menuFortsetzen = new MenuItem("Fortsetzen");
        menu.getItems().add(menuFortsetzen);
        menuFortsetzen.setOnAction(e ->
        {
            mainPresenter.showDetailView();
        });
        
        MenuItem menuUebersicht = new MenuItem("Überblick");
        menu.getItems().add(menuUebersicht);
        menuUebersicht.setOnAction(e ->
        {
            mainPresenter.showOverviewView();
        });
        
//        MenuItem menuEdit = new MenuItem("Editieren");
//        menu.getItems().add(menuEdit);
//        menuEdit.setOnAction(e ->
//        {
//            mainPresenter.showEditView();
//        });
        
        menu.getItems().add(new SeparatorMenuItem());
        
        MenuItem menuClose = new MenuItem("Beenden");
        menu.getItems().add(menuClose);
        menuClose.setOnAction(e ->
        {
            Platform.exit();
        });

        
//        Button bStartQuiz = new Button("Quiz starten!");
//        Button bContinueQuiz = new Button("Quiz fortsetzen!");
//        Button bOverView = new Button("Überblick");
//        Button bEditQuiz = new Button ("Quiz editieren!");
//        
//        bStartQuiz.setOnAction(ev ->
//        {
//            mainPresenter.restartQuiz();
//        });
//        
//        bContinueQuiz.setOnAction(ev ->
//        {
//            mainPresenter.showDetailView();
//        });
//        
//        bOverView.setOnAction(ev ->
//        {
//            mainPresenter.showOverviewView();
//        });
//        
//        bEditQuiz.setOnAction(ev ->
//        {  
//            mainPresenter.showEditView();
//        });
//        
//        
//        grid.add(bStartQuiz, 0, 0);
//        grid.add(bContinueQuiz, 1, 0);
//        grid.add(bOverView, 2, 0);
//        grid.add(bEditQuiz, 3, 0);
        
        grid.getChildren().add(menuBar);
        
        this.setTop(grid);
    }
    
    public void setContent(Pane grid)
    {
        this.setCenter(grid);
    }
}
