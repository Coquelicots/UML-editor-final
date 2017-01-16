package Component.BasicObj;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class UseCaseObject extends BasicObject{

    public UseCaseObject(double x, double y) {
        super(x, y, 60, 20);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(position.getX(),position.getY(),width,height);
        gc.strokeOval(position.getX(),position.getY(),width,height);
        drawPort(gc);
        gc.setFill(Color.BLACK);
        gc.fillText(name,position.getX()+5,position.getY()+15);
    }
}
