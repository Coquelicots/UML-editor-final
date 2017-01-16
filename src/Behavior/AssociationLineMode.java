package Behavior;

import Component.UmlLine.AssociationLine;
import Component.Utility.Point;
import Component.Utility.Port;
import Component.Utility.PreviewLine;
import Gui.UmlModel;
import javafx.scene.input.MouseEvent;

public class AssociationLineMode extends Mode{
    private Port startPort;
    private Port endPort;
    private PreviewLine previewLine;
    @Override
    public void onPress ( MouseEvent event ) {
        startPort = UmlModel.getInstance ().getClosePort(event.getX (),event.getY ());

    }

    @Override
    public void onDrag ( MouseEvent event ) {
        Point e = new Point (event.getX (),event.getY ());
        UmlModel.getInstance().print();
        UmlModel.getInstance ().drawPreviewLine(startPort,e);
    }

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
