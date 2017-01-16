package Component.UmlLine;

import Component.Utility.Port;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AssociationLine extends UmlLine {

    public AssociationLine(Port s, Port e){
        super(s,e);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke( Color.BLACK);
        gc.strokeLine(startPort.getPosition ().getX(),startPort.getPosition ().getY(),
                endPort.getPosition ().getX(),endPort.getPosition ().getY());
    }
}
