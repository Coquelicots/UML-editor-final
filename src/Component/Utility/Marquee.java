package Component.Utility;

import javafx.scene.canvas.GraphicsContext;

public class Marquee{
    private Point startPoint;
    private Point endPoint;
    private Point leftUpPoint;
    private Point rightDownPoint;
    private boolean active;
    public Marquee (){
        startPoint = new Point();
        endPoint = new Point();
        leftUpPoint = new Point();
        rightDownPoint = new Point();
        active = false;
    }

    public void draw(GraphicsContext gc){
        if(active) {
            gc.strokeRect(leftUpPoint.getX(), leftUpPoint.getY(),
                    rightDownPoint.getX() - leftUpPoint.getX(), rightDownPoint.getY() - leftUpPoint.getY());
        }
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(double x, double y) {
        startPoint.move(x,y);
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(double x, double y) {
        endPoint.move(x,y);
        double x1 = startPoint.getX();
        double y1 = startPoint.getY();
        double x2 = endPoint.getX();
        double y2 = endPoint.getY();
        leftUpPoint.move(((x1 <= x2) ? x1 : x2), ((y1 <= y2) ? y1 : y2));
        rightDownPoint.move(((x1 > x2) ? x1 : x2), ((y1 > y2) ? y1 : y2));
    }

    public Point getLeftUpPoint() {
        return leftUpPoint;
    }

    public Point getRightDownPoint() {
        return rightDownPoint;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
