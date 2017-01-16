package Component.Utility;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;


public class Group extends Shape{
    private List<Shape> shapeList;
    public Group(){
        shapeList = new ArrayList<>();
    }
    @Override
    public void move(double x, double y) {
        for (Shape s:shapeList) {
            s.move ( x,y );
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Shape s:shapeList) {
            s.draw ( gc );
        }
    }

    @Override
    public boolean isSelect(double x, double y) {
        for (Shape s:shapeList) {
            if(s.isSelect ( x,y )){
                for (Shape shape:shapeList){
                    shape.setSelected ( true );
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSelect(Point leftUp, Point rightDown) {
        for (Shape s:shapeList) {
            if(!s.isSelect ( leftUp,rightDown )){
                return false;
            }
        }
        for (Shape shape:shapeList){
            shape.setSelected ( true );
        }
        return false;
    }
    @Override
    public void setSelected(boolean select){
        for (Shape s:shapeList){
            s.setSelected ( select );
        }
    }
    @Override
    public Port getPort ( double x,double y ) {
        return null;
    }

    @Override
    public void add ( Shape s ) {
        shapeList.add ( s );
    }

    @Override
    public void remove ( Shape s ) {
        shapeList.remove ( s );
    }
}
