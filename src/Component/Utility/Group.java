package Component.Utility;

import javafx.scene.canvas.GraphicsContext;


public class Group extends Shape{
    @Override
    public void move(double x, double y) {

    }

    @Override
    public void draw(GraphicsContext gc) {

    }

    @Override
    public boolean isSelect(double x, double y) {
        return false;
    }

    @Override
    public boolean isSelect(Point leftUp, Point rightDown) {
        return false;
    }
}
