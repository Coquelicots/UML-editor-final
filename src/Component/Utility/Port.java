package Component.Utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Port{
    private Point position;
    private double width;
    private double height;
    public Port(double x, double y) {
        position = new Point(x,y);
        width = 5;
        height = 5;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(position.getX() - width/2, position.getY() - height/2, width, height);
    }
    public void move(double x,double y){
        position.move(position.getX()+x,position.getY()+y);
    }
    public Point getPosition(){
        return position;
    }
}
