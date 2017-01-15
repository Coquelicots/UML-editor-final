package Component.BasicObj;


import Component.Utility.Point;
import Component.Utility.Port;
import Component.Utility.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicObject extends Shape {
    protected Point position;
    protected double height;
    protected double width;
    protected List<Port> portList;
    public BasicObject(double x, double y, double width, double height){
        position = new Point (x,y);
        this.height = height;
        this.width = width;
        portList = new ArrayList<>();
        Port p1 = new Port(x+width/2,y);//top port
        Port p2 = new Port(x+width,y+height/2);//right port
        Port p3 = new Port(x+width/2,y+height);//bot port
        Port p4 = new Port(x,y+height/2);//left port
        portList.add(p1);
        portList.add(p2);
        portList.add(p3);
        portList.add(p4);
    }
    public void move(double x,double y){
        for(Port p:portList){
            p.move(x-position.getX(),y-position.getY());
        }
        position.move(x,y);
    }
    @Override
    public boolean isSelect(double x,double y) {
        if (x>=position.getX()&&x<=position.getX()+width
                &&y>=position.getY()&&y<=position.getY()+height){
            return true;
        }
        return false;
    }
    @Override
    public boolean isSelect(Point leftUp,Point rightDown) {
        if(leftUp.getX()<position.getX()&&rightDown.getX()>position.getX()+width
                &&leftUp.getY()<position.getY()&&rightDown.getY()>position.getY()+height){
            setSelected(true);
            return true;
        }
        setSelected(false);
        return false;
    }
    public void drawPort(GraphicsContext gc){
        if(isSelected()) {
            for (Port p : portList) {
                p.draw(gc);
            }
        }
    }
}