package Component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Vincent on 1/14/2017.
 */
public class ClassObject extends BasicObject{
    public ClassObject(GraphicsContext gc, double x, double y) {
        super(gc, x, y, 60, 60);
    }

    @Override
    public void draw() {
        /*
        connectPoints.set(0,new Point2D(position.getX() + width/2,position.getY()));
        connectPoints.set(1,new Point2D(position.getX() + width/2, position.getY()+height*3));
        connectPoints.set(2,new Point2D(position.getX() + width, position.getY()+height*1.5));
        connectPoints.set(3,new Point2D(position.getX(), position.getY()+height*1.5));
        */
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        gc.rect(position.getX(),position.getY(),width,height);
        gc.moveTo(position.getX(),position.getY()+height/3);
        gc.lineTo(position.getX()+width,position.getY()+height/3);
        gc.moveTo(position.getX(),position.getY()+height*2/3);
        gc.lineTo(position.getX()+width,position.getY()+height*2/3);
        gc.setFill(Color.BLACK);
        /*
        if(isSelect()) {
            gc.fillRect(position.getX() + width/2 - 2.5, position.getY() - 2.5, 5, 5);
            gc.fillRect(position.getX() + width/2 - 2.5, position.getY()+height*3 - 2.5, 5, 5);
            gc.fillRect(position.getX()- 2.5, position.getY()+height*1.5 - 2.5, 5, 5);
            gc.fillRect(position.getX() + width - 2.5, position.getY()+height*1.5 - 2.5, 5, 5);
        }
        */
        gc.setFill(Color.BLACK);
        gc.fillText(name,position.getX()+5,position.getY()+15);
    }
}
