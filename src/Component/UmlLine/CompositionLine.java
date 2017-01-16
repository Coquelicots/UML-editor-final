package Component.UmlLine;

import Component.Utility.Point;
import Component.Utility.Port;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CompositionLine extends UmlLine {
    public CompositionLine ( Port s,Port e ) {
        super ( s,e );
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke( Color.BLACK);
        gc.strokeLine(startPort.getPosition ().getX(),startPort.getPosition ().getY(),
                endPort.getPosition ().getX(),endPort.getPosition ().getY());

        double[] squareX = {-10,-5,0,-5};
        double[] squareY = {0,5,0,-5};
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
        gc.fillPolygon(squareX,squareY,4);
        gc.strokePolygon(squareX,squareY,4);
        gc.restore();
    }
}
