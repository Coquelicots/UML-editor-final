package Component.UmlLine;

import Component.Utility.Point;
import Component.Utility.Port;
import Component.Utility.Shape;

/**
 * Created by Vincent on 1/15/2017.
 */
public abstract class UmlLine extends Shape {
    private Port start;
    private Port end;

    public UmlLine(){

    }

    @Override
    public void move(double x, double y) {
        //do nothing
    }

    @Override
    public boolean isSelect(double x, double y) {
        // do nothing
        return false;
    }

    @Override
    public boolean isSelect(Point leftUp, Point rightDown) {
        // do nothing
        return false;
    }
}
