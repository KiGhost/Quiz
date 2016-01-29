package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class OverviewView extends BorderPane
{
    
    private OverviewPresenter overviewPresenter; 
    
    private TableView<Question> table;
    private TableColumn<Question, String> questionColumn;
    private TableColumn<Question, Number> answersColumn, correctColumn;

    public OverviewView()
    {
        initView();
    }
    
    public void setOverviewPresenter(OverviewPresenter ov)
    {
        overviewPresenter = ov;
    }
    
    @SuppressWarnings("unchecked")
    public void initView()
    {
        Label lOverView = new Label("Übersicht");
        
        table = new TableView<Question>();
        table.setPrefSize(600, 400);
        
        questionColumn = new TableColumn<Question, String>("Frage");
        questionColumn.setPrefWidth(300);
        answersColumn = new TableColumn<Question, Number>("Antworten");
        answersColumn.setPrefWidth(150);
        correctColumn = new TableColumn<Question, Number>("davon richtig");
        correctColumn.setPrefWidth(150);
        
        questionColumn.setCellValueFactory(item -> item.getValue().getQuestionProperty());
        answersColumn.setCellValueFactory(item -> item.getValue().getAnswersProperty());
        correctColumn.setCellValueFactory(item -> item.getValue().getCorrectAnswersProperty());
        
        table.getColumns().addAll(questionColumn, answersColumn, correctColumn);        
        
        Button bDeleteResults = new Button("Ergebnisse löschen");  
        bDeleteResults.setOnAction(e->
        {
            overviewPresenter.reset();
            overviewPresenter.updateTableData();
        });
        
        this.setTop(lOverView);
        this.setCenter(table);
        this.setBottom(bDeleteResults);
    }
    
    public void setTableData(ObservableList<Question> data)
    {
        table.setItems(data);
    }
}
