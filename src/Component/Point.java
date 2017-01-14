package Component;


public class Point {
    private double x;
    private double y;
    public Point(){
        x = 0;
        y = 0;
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void move(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p){
        return Math.sqrt((p.getX()-x)*(p.getX()-x)+(p.getY()-y)*(p.getY()-y));
    }
}
