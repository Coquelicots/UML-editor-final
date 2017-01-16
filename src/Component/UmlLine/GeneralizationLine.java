package Component.UmlLine;

import Component.Utility.Point;
import Component.Utility.Port;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GeneralizationLine extends UmlLine {
    public GeneralizationLine ( Port s,Port e ) {
        super ( s,e );
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke( Color.BLACK);
        gc.strokeLine(startPort.getPosition ().getX(),startPort.getPosition ().getY(),
                endPort.getPosition ().getX(),endPort.getPosition ().getY());

        double[] triangleX = {-7.5,0,-7.5};
        double[] triangleY = {7.5,0,-7.5};
        Point svector = startPort.getPosition ().subtract(endPort.getPosition ());
        Point2D vector = new Point2D ( svector.getX (),svector.getY () );
        Point2D zero = new Point2D(1,0);
        gc.save();
        gc.translate(startPort.getPosition ().getX(),startPort.getPosition ().getY());
        if(vector.getY()<0)
            gc.rotate(-zero.angle(vector));
        else
            gc.rotate(zero.angle(vector));
        gc.setFill(Color.WHITE);
        gc.fillPolygon(triangleX,triangleY,3);
        gc.strokePolygon(triangleX,triangleY,3);
        gc.restore();
    }
}
