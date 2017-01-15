package Behavior;

import Component.ClassObject;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class ClassMode extends Mode{

    @Override
    public void onClick(MouseEvent event) {
        ClassObject classObject = new ClassObject(event.getX(),event.getY());
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
