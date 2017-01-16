package Behavior;

import Component.UmlLine.GeneralizationLine;
import Component.Utility.Port;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class GeneralizationLineMode extends Mode{
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
            GeneralizationLine asLine = new GeneralizationLine (startPort,endPort);
            UmlModel.getInstance ().addShape ( asLine );
        }
        UmlModel.getInstance().print();
    }
}
