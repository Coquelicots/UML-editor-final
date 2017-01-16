package Behavior;

import Component.UmlLine.CompositionLine;
import Component.Utility.Port;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class CompositionLineMode extends Mode{
    private Port startPort;
    private Port endPort;

    @Override
    public void onPress ( MouseEvent event ) {
        startPort = UmlModel.getInstance ().getClosePort(event.getX (),event.getY ());
    }

    @Override
    public void onDrag ( MouseEvent event ) {

    }

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
