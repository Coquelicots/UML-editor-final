package Component.Utility;


import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    public abstract void move(double x,double y);
    public abstract void draw(GraphicsContext gc);
    public abstract boolean isSelect(double x,double y);
    public abstract boolean isSelect(Point leftUp,Point rightDown);
    private boolean isSelected = false;
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean select) {
        isSelected = select;
    }
    public Port getPort(double x,double y){return null;}
    public void add(Shape s){}
    public List<Shape> getList(){
        List<Shape> shapeList = new ArrayList<> (  );
        shapeList.add ( this );
        return shapeList;
    }
}
