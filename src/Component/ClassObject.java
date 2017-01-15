package Component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ClassObject extends BasicObject{
    private String name;
    public ClassObject(double x, double y) {
        super(x, y, 60, 60);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(position.getX(),position.getY(),width,height);
        gc.strokeRect(position.getX(),position.getY(),width,height);
        gc.strokeLine(position.getX(),position.getY()+height/3,position.getX()+width,position.getY()+height/3);
        gc.strokeLine(position.getX(),position.getY()+height*2/3,position.getX()+width,position.getY()+height*2/3);
        gc.setFill(Color.BLACK);
        drawPort(gc);
        gc.fillText(name,position.getX()+5,position.getY()+15);
    }
}
