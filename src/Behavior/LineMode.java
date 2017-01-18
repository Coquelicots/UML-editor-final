package Behavior;

import Component.Utility.Point;
import Component.Utility.Port;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public abstract class LineMode extends Mode{
    protected Port startPort;
    protected Port endPort;

    @Override
    public void onPress ( MouseEvent event ) {
        startPort = UmlModel.getInstance ().getClosePort(event.getX (),event.getY ());
    }

    @Override
    public void onDrag(MouseEvent event) {
        Point e = new Point (event.getX (),event.getY ());
        UmlModel.getInstance().print();
        UmlModel.getInstance ().drawPreviewLine(startPort,e);
    }

}
