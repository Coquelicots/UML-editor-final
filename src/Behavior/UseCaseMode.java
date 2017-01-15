package Behavior;

import Component.BasicObj.UseCaseObject;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class UseCaseMode extends Mode{

    @Override
    public void onPress(MouseEvent event) {

    }

    @Override
    public void onDrag(MouseEvent event) {

    }

    @Override
    public void onRelease(MouseEvent event) {
        UseCaseObject useCaseObject = new UseCaseObject(event.getX(),event.getY());
        UmlModel.getInstance().addShape(useCaseObject);
        UmlModel.getInstance().print();
    }
}
