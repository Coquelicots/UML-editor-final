package Behavior;

import Component.BasicObj.ClassObject;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class ClassMode extends Mode{

    @Override
    public void onPress(MouseEvent event) {

    }

    @Override
    public void onDrag(MouseEvent event) {

    }

    @Override
    public void onRelease(MouseEvent event) {
        ClassObject classObject = new ClassObject(event.getX(),event.getY());
        UmlModel.getInstance().addShape(classObject);
        UmlModel.getInstance().print();
    }
}
