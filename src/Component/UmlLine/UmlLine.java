package Component.UmlLine;

import Component.Utility.Point;
import Component.Utility.Port;
import Component.Utility.Shape;

/**
 * Created by Vincent on 1/15/2017.
 */
public abstract class UmlLine extends Shape {
    protected Port startPort;
    protected Port endPort;

    public UmlLine(Port s,Port e){
        startPort = s;
        endPort = e;
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
    @Override
    public Port getPort(double x,double y){
        return null;
    }
}
