package Behavior;

import Component.UmlLine.CompositionLine;
import Component.Utility.Point;
import Component.Utility.Port;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class CompositionLineMode extends LineMode{

    @Override
    public void onRelease ( MouseEvent event ) {
        endPort = UmlModel.getInstance ().getClosePort(event.getX (),event.getY ());
        if(startPort!=null&&endPort!=null){
            CompositionLine asLine = new CompositionLine (startPort,endPort);
            UmlModel.getInstance ().addShape ( asLine );
        }
        UmlModel.getInstance().print();
    }
}
