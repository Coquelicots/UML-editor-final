package Gui;

import Behavior.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

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
        umlCanvas.setOnMousePressed(event -> mode.onPress(event));
        umlCanvas.setOnMouseDragged(event -> mode.onDrag(event));
        umlCanvas.setOnMouseReleased(event -> mode.onRelease(event));
    }
}
