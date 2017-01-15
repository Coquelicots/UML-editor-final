package Gui;

import Component.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;


public class UmlModel {
    private static UmlModel instance = null;
    //---member
    private List<Shape> shapeList;
    private List<Shape> selectedShapeList;
    private GraphicsContext gc;
    //---Action
    private UmlModel(){
        shapeList = new ArrayList<>();
        selectedShapeList = new ArrayList<>();
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
    public void select(double x, double y){
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
        }
    }
    public void moveSelected(double x, double y){
        for(Shape s : selectedShapeList){
            s.move(x,y);
        }
    }
}
