package Gui;

import Behavior.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UmlController {
    @FXML
    private Canvas umlCanvas;
    @FXML
    private Button classButton;
    @FXML
    private Button usecaseButton;
    @FXML
    private Button selectBtn;
    @FXML
    private Button ALButton;
    @FXML
    private Button GLButton;
    @FXML
    private Button CLButton;
    @FXML
    private MenuItem groupMenuItem;
    @FXML
    private MenuItem unGroupMenuItem;
    @FXML
    private MenuItem changeObjName;
    //----Self
    private Mode mode;
    @FXML
    private void initialize() {
        mode = new SelectMode();
        UmlModel.getInstance().setGc(umlCanvas.getGraphicsContext2D());
        selectBtn.setOnMouseClicked(event -> mode = new SelectMode());
        classButton.setOnMouseClicked(event -> mode = new ClassMode());
        usecaseButton.setOnMouseClicked(event -> mode = new UseCaseMode());
        ALButton.setOnMouseClicked ( event -> mode = new AssociationLineMode () );
        CLButton.setOnMouseClicked ( event -> mode = new CompositionLineMode () );
        GLButton.setOnMouseClicked ( event -> mode = new GeneralizationLineMode () );
        groupMenuItem.setOnAction ( new EventHandler<ActionEvent> () {
            @Override
            public void handle ( ActionEvent event ) {
                UmlModel.getInstance ().groupSelected();
            }
        } );
        unGroupMenuItem.setOnAction ( new EventHandler<ActionEvent> () {
            @Override
            public void handle ( ActionEvent event ) {
                UmlModel.getInstance ().unGroup ();
            }
        } );
        changeObjName.setOnAction ( new EventHandler<ActionEvent> () {
            @Override
            public void handle ( ActionEvent event ) {
                createNameDialog();
            }
        } );
        umlCanvas.setOnMousePressed(event -> mode.onPress(event));
        umlCanvas.setOnMouseDragged(event -> mode.onDrag(event));
        umlCanvas.setOnMouseReleased(event -> mode.onRelease(event));
    }
    public void createNameDialog(){
        final TextInputDialog textInputDialog = new TextInputDialog("Name"); // 實體化TextInputDialog物件，並直接在建構子設定預設的文字內容。由於輸入一定是字串，所以對話框會直接回傳String物件，而不使用泛型
        textInputDialog.setTitle("Change Name"); //設定對話框視窗的標題列文字
        textInputDialog.setHeaderText("Change Name"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
        textInputDialog.setContentText("Name: "); //設定對話框的訊息文字
        final Optional<String> opt = textInputDialog.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式。
        String rtn;
        try{
            rtn = opt.get(); //可以直接用「textInputDialog.getResult()」來取代
        }catch(final NoSuchElementException ex){
            rtn = null;
        }
        if(rtn!=null){
            UmlModel.getInstance ().changeName ( rtn );
            UmlModel.getInstance ().print ();
        }
    }
}
