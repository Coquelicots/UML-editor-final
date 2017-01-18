package Behavior;

import Component.UmlLine.AssociationLine;
import Component.Utility.Point;
import Component.Utility.Port;
import Component.Utility.PreviewLine;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class AssociationLineMode extends LineMode{

    @Override
    public void onRelease ( MouseEvent event ) {
        endPort = UmlModel.getInstance ().getClosePort(event.getX (),event.getY ());
        if(startPort!=null&&endPort!=null){
            AssociationLine asLine = new AssociationLine (startPort,endPort);
            UmlModel.getInstance ().addShape ( asLine );
        }
        UmlModel.getInstance().print();
    }
}
