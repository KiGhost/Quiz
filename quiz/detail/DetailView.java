package gui.mvp.quiz.detail;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class DetailView extends GridPane
{
    private DetailPresenter detailPresenter;
    
    private Label lQuestion, lEnd,  lAnswerOne, lAnswerBoxOne,
                                    lAnswerTwo, lAnswerBoxTwo,
                                    lAnswerThree, lAnswerBoxThree,
                                    lAnswerFour, lAnswerBoxFour,
                                    lAnswerFive, lAnswerBoxFive;
    private Button bNext;
    
    public DetailView()
    {
        initView();
    }
    
    public void initView()
    {
        lQuestion = new Label();
        this.add(lQuestion, 0, 1);
        
//        Label source = new Label("DRAG ME");
//        source.setLayoutX(50);
//        source.setLayoutY(100);
//        source.setScaleX(2.0);
//        source.setScaleY(2.0);
//        this.add(source, 0, 2);

//        Label target = new Label("DROP HERE");
//        target.setLayoutX(250);
//        target.setLayoutY(100);
//        target.setScaleX(2.0);
//        target.setScaleY(2.0);
//        this.add(target, 0, 3);
        
        lEnd = new Label();
        lEnd.setText("Ende des Quiz");
        lEnd.setVisible(false);
        this.add(lEnd, 0, 1, 1, 1);
        
        bNext = new Button("=>");
        bNext.setOnAction(e->
        {
            //detailPresenter.validateAnswer(rb.getText());
            detailPresenter.nextQuestion();
        });      
        this.add(bNext, 0, 8);
    }
    
    public void setDetailPresenter (DetailPresenter dp)
    {
        detailPresenter = dp;
    }
    
    public void clear()
    {
        
        lQuestion.setVisible(true);
        lEnd.setVisible(false);
        bNext.setDisable(false);
    }
    
    public void quizEnd()
    {
        lQuestion.setVisible(false);
        lEnd.setVisible(true);
        bNext.setDisable(true);
    }
    
    public void updateQuestions(String question, String[] answers)
    {
        lQuestion.setText(question);
        
        lAnswerOne = new Label(answers[0]);
        lAnswerOne.setStyle("-fx-border-color: black;");
        lAnswerOne.setOnDragDetected(e -> onDragDetected(e));
        lAnswerOne.setOnDragDone(e -> onDragDone(e));
        this.add(lAnswerOne, 0, 2);
        
        lAnswerTwo = new Label(answers[1]);
        lAnswerTwo.setStyle("-fx-border-color: black;");
        lAnswerTwo.setOnDragDetected(e -> onDragDetected(e));
        lAnswerTwo.setOnDragDone(e -> onDragDone(e));
        this.add(lAnswerTwo, 1, 2);
        
        lAnswerThree = new Label(answers[2]);
        lAnswerThree.setStyle("-fx-border-color: black;");
        lAnswerThree.setOnDragDetected(e -> onDragDetected(e));
        lAnswerThree.setOnDragDone(e -> onDragDone(e));
        this.add(lAnswerThree, 2, 2);
        
        lAnswerFour = new Label(answers[3]);
        lAnswerFour.setStyle("-fx-border-color: black;");
        lAnswerFour.setOnDragDetected(e -> onDragDetected(e));
        lAnswerFour.setOnDragDone(e -> onDragDone(e));
        this.add(lAnswerFour, 3, 2);
        
        lAnswerFive = new Label(answers[4]);
        lAnswerFive.setStyle("-fx-border-color: black;");
        lAnswerFive.setOnDragDetected(e -> onDragDetected(e));
        lAnswerFive.setOnDragDone(e -> onDragDone(e));
        this.add(lAnswerFive, 4, 2);

        lAnswerBoxOne = new Label();
        lAnswerBoxOne.setMinSize(300, 10);
        lAnswerBoxOne.setStyle("-fx-border-color: black;");
        lAnswerBoxOne.setOnDragOver(e -> onDragOver(e));
        lAnswerBoxOne.setOnDragEntered(e -> onDragEntered(e));
        lAnswerBoxOne.setOnDragExited(e -> onDragExited(e));
        lAnswerBoxOne.setOnDragDropped(e -> onDragDropped(e));
        this.add(lAnswerBoxOne, 0, 3);
        
        lAnswerBoxTwo = new Label();
        lAnswerBoxTwo.setMinSize(300, 10);
        lAnswerBoxTwo.setStyle("-fx-border-color: black;");
        lAnswerBoxTwo.setOnDragOver(e -> onDragOver(e));
        lAnswerBoxTwo.setOnDragEntered(e -> onDragEntered(e));
        lAnswerBoxTwo.setOnDragExited(e -> onDragExited(e));
        lAnswerBoxTwo.setOnDragDropped(e -> onDragDropped(e));
        this.add(lAnswerBoxTwo, 0, 4);
        
        lAnswerBoxThree = new Label();
        lAnswerBoxThree.setMinSize(300, 10);
        lAnswerBoxThree.setStyle("-fx-border-color: black;");
        lAnswerBoxThree.setOnDragOver(e -> onDragOver(e));
        lAnswerBoxThree.setOnDragEntered(e -> onDragEntered(e));
        lAnswerBoxThree.setOnDragExited(e -> onDragExited(e));
        lAnswerBoxThree.setOnDragDropped(e -> onDragDropped(e));
        this.add(lAnswerBoxThree, 0, 5);
        
        
        lAnswerBoxFour = new Label();
        lAnswerBoxFour.setMinSize(300, 10);
        lAnswerBoxFour.setStyle("-fx-border-color: black;");
        lAnswerBoxFour.setOnDragOver(e -> onDragOver(e));
        lAnswerBoxFour.setOnDragEntered(e -> onDragEntered(e));
        lAnswerBoxFour.setOnDragExited(e -> onDragExited(e));
        lAnswerBoxFour.setOnDragDropped(e -> onDragDropped(e));
        this.add(lAnswerBoxFour, 0, 6);
        
        
        lAnswerBoxFive = new Label();
        lAnswerBoxFive.setMinSize(300, 10);
        lAnswerBoxFive.setStyle("-fx-border-color: black;");
        lAnswerBoxFive.setOnDragOver(e -> onDragOver(e));
        lAnswerBoxFive.setOnDragEntered(e -> onDragEntered(e));
        lAnswerBoxFive.setOnDragExited(e -> onDragExited(e));
        lAnswerBoxFive.setOnDragDropped(e -> onDragDropped(e));
        this.add(lAnswerBoxFive, 0, 7);
    }
    
    private void onDragDetected(MouseEvent e)
    {
        System.out.println("onDragDetected");
        Label source = (Label)e.getSource();

        Dragboard db = source.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);
    }
    
    private void onDragOver(DragEvent e)
    {
        System.out.println("onDragOver");
        Label target = (Label)e.getSource();
        if(e.getGestureSource() != target && e.getDragboard().hasString())
        {
            e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
    }

    private void onDragEntered(DragEvent e)
    {
        System.out.println("onDragEntered");
        Label target = (Label)e.getSource();
        if(e.getGestureSource() != target && e.getDragboard().hasString())
        {
            target.setTextFill(Color.RED);
        }
    }

    private void onDragExited(DragEvent e)
    {
        System.out.println("onDragExited");
        Label target = (Label)e.getSource();
        target.setTextFill(Color.BLACK);
    }

    private void onDragDropped(DragEvent e)
    {
        System.out.println("onDragDropped");
        Label target = (Label)e.getSource();
        Dragboard db = e.getDragboard();
        boolean success = false;
        if(db.hasString())
        {
            target.setText(db.getString());
            success = true;
        }
        e.setDropCompleted(success);
    }

    private void onDragDone(DragEvent e)
    {
        System.out.println("onDragDone");
        Label source = (Label)e.getSource();
        if (e.getTransferMode() == TransferMode.MOVE)
        {
            source.setText("");
        }
    }

}
