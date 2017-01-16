package Behavior;

import Component.Utility.Point;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class SelectMode extends Mode{
    private boolean singleSelect;
    Point previous;
    public SelectMode(){
        singleSelect = true;
        previous = new Point ( );
    }

    @Override
    public void onPress(MouseEvent event) {
        previous.setPoint ( event.getX (),event.getY () );
        if(!UmlModel.getInstance().select(event.getX(),event.getY())){
            UmlModel.getInstance().startSquareSelect(event.getX(),event.getY());
            singleSelect = false;
        }
        UmlModel.getInstance().print();
    }

    @Override
    public void onDrag(MouseEvent event) {
        if(singleSelect) {
            UmlModel.getInstance().moveSelected(event.getX()-previous.getX (), event.getY()-previous.getY ());
            previous.setPoint ( event.getX (),event.getY () );
        }else{
            UmlModel.getInstance().squareSelect(event.getX(),event.getY());
        }
        UmlModel.getInstance().print();
        UmlModel.getInstance().drawMarquee();
    }

    @Override
    public void onRelease(MouseEvent event) {
        singleSelect = true;
        UmlModel.getInstance().endSquareSelect();
        UmlModel.getInstance().print();
    }
}
