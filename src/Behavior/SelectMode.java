package Behavior;

import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class SelectMode extends Mode{

    @Override
    public void onClick(MouseEvent event) {
        UmlModel.getInstance().select(event.getX(),event.getY());
        UmlModel.getInstance().print();
    }

    @Override
    public void onPress(MouseEvent event) {
        UmlModel.getInstance().select(event.getX(),event.getY());
        UmlModel.getInstance().print();
    }

    @Override
    public void onDrag(MouseEvent event) {
        UmlModel.getInstance().moveSelected(event.getX(),event.getY());
        UmlModel.getInstance().print();
    }

    @Override
    public void onRelease(MouseEvent event) {
        UmlModel.getInstance().moveSelected(event.getX(),event.getY());
        UmlModel.getInstance().print();
    }
}
