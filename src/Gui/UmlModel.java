package Gui;

import Component.Utility.*;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class UmlModel {
    private static UmlModel instance = null;
    //---member
    private List<Shape> shapeList;
    private List<Shape> selectedShapeList;
    private GraphicsContext gc;
    private Marquee marquee;
    private PreviewLine previewLine;
    private int depthRecord = 0;
    //---Action
    private UmlModel(){
        shapeList = new ArrayList<>();
        selectedShapeList = new ArrayList<>();
        marquee = new Marquee();
        previewLine = new PreviewLine();
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
        if(s.getDepth()<0) {
            s.setDepth(depthRecord++);
        }
        shapeList.add(s);
    }
    public void removeShape(Shape s){
        shapeList.remove ( s );
    }
    public void print(){
        sortListByDepth();
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
            s.setSelected ( false );
            if(s.isSelect(marquee.getLeftUpPoint(),marquee.getRightDownPoint())){
                selectedShapeList.add(s);
                s.setSelected ( true );
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
    public void groupSelected(){
        if(selectedShapeList.size ()>1) {
            int greatestDepth = 100;
            Group g = new Group ();
            for ( Shape s : selectedShapeList ) {
                g.add ( s );
                removeShape ( s );
                greatestDepth = (greatestDepth>s.getDepth())?s.getDepth():greatestDepth;
            }
            g.setDepth(greatestDepth);
            addShape ( g );
        }
    }
    public void unGroup(){
        if(selectedShapeList.size ()==1) {
            removeShape ( selectedShapeList.get ( 0 ) );
            List<Shape> sList = selectedShapeList.get ( 0 ).getList ();
            sList.forEach ( this::addShape );
        }
    }
    public void changeName(String name){
        for(Shape s:selectedShapeList){
            s.changeName ( name );
        }
    }
    public void drawPreviewLine(Port s,Point e){
        previewLine.setStartEnd ( s,e );
        previewLine.draw ( gc );
    }
    private void sortListByDepth(){
        Collections.sort(shapeList, new Comparator<Shape>() {
            @Override
            public int compare(Shape shape1, Shape shape2)
            {

                return  shape2.getDepth()-shape1.getDepth();
            }
        });
    }
}
