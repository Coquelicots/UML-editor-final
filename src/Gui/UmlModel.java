package Gui;

import Component.Utility.Marquee;
import Component.Utility.Port;
import Component.Utility.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;


public class UmlModel {
    private static UmlModel instance = null;
    //---member
    private List<Shape> shapeList;
    private List<Shape> selectedShapeList;
    private GraphicsContext gc;
    private Marquee marquee;
    //---Action
    private UmlModel(){
        shapeList = new ArrayList<>();
        selectedShapeList = new ArrayList<>();
        marquee = new Marquee();
    }
    public static UmlModel getInstance(){
        if(instance == null) {
            instance = new UmlModel();
        }
        return instance;
    }
    public void setGc(GraphicsContext gc){
        this.gc = gc;
    }
    public void addShape(Shape s){
        shapeList.add(s);
    }
    public void print(){
        if(gc!=null) {
            gc.clearRect(0, 0, 800, 800);
            for (Shape s : shapeList) {
                s.draw(gc);
            }
        }
    }
    public void startSquareSelect(double x,double y){
        marquee.setStartPoint(x,y);
        marquee.setActive(true);
    }
    public void endSquareSelect(){
        marquee.setActive(false);
    }
    public void drawMarquee(){
        marquee.draw(gc);
    }
    public boolean select(double x, double y){
        int last=-1;
        selectedShapeList.clear();
        for(int i=0;i<shapeList.size();i++){
            shapeList.get(i).setSelected(false);
            if(shapeList.get(i).isSelect(x,y)) {
                last = i;
            }
        }
        if(last>=0) {
            shapeList.get(last).setSelected(true);
            selectedShapeList.add(shapeList.get(last));
            return true;
        }
        return false;
    }
    public void squareSelect(double x, double y){
        marquee.setEndPoint(x,y);
        selectedShapeList.clear();
        for(Shape s :shapeList){
            if(s.isSelect(marquee.getLeftUpPoint(),marquee.getRightDownPoint())){
                selectedShapeList.add(s);
            }
        }
    }
    public void moveSelected(double x, double y){
        for(Shape s : selectedShapeList){
            s.move(x,y);
        }
    }
    public Port getClosePort(double x, double y){
        for(Shape s:shapeList){
            if(s.getPort ( x,y )!=null)
                return s.getPort ( x,y );
        }
        return null;
    }
}
