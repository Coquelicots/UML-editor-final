package Behavior;

import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class SelectMode extends Mode{
    private boolean singleSelect;

    public SelectMode(){
        singleSelect = true;
    }

    @Override
    public void onPress(MouseEvent event) {
        if(!UmlModel.getInstance().select(event.getX(),event.getY())){
            UmlModel.getInstance().startSquareSelect(event.getX(),event.getY());
            singleSelect = false;
        }
        UmlModel.getInstance().print();
    }

    @Override
    public void onDrag(MouseEvent event) {
        if(singleSelect) {
            UmlModel.getInstance().moveSelected(event.getX(), event.getY());
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
