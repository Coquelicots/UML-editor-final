package Component;


import javafx.scene.canvas.GraphicsContext;

public abstract class BasicObject extends Shape{
    protected Point position;
    protected double height;
    protected double width;
    protected String name;
    public void move(double x,double y){
        position.move(x,y);
    }
    public BasicObject(GraphicsContext gc, double x, double y, double width, double height){
        super(gc);
        position = new Point (x,y);
        this.height = height;
        this.width = width;
    }
    @Override
    public boolean isSelect(double x,double y) {
        if (x>=position.getX()&&x<=position.getX()+width
                &&y>=position.getY()&&y<=position.getY()+height){
            return true;
        }
        return false;
    }
}