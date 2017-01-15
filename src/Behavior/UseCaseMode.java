package Behavior;

import Component.UseCaseObject;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class UseCaseMode extends Mode{

    @Override
    public void onClick(MouseEvent event) {
        UseCaseObject classObject = new UseCaseObject(event.getX(),event.getY());
        UmlModel.getInstance().addShape(classObject);
        UmlModel.getInstance().print();
    }

    @Override
    public void onPress(MouseEvent event) {

    }

    @Override
    public void onDrag(MouseEvent event) {

    }

    @Override
    public void onRelease(MouseEvent event) {

    }
}
