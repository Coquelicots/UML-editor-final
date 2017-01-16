package Component.Utility;


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
    public double getY() {
        return y;
    }
    public void move(double x,double y){
        this.x = x;
        this.y = y;
    }
    public double distance(Point p){
        return Math.sqrt((p.getX()-x)*(p.getX()-x)+(p.getY()-y)*(p.getY()-y));
    }
    public Point subtract(Point p){
        Point newP = new Point ( x-p.getX (),y-p.getY () );
        return newP;
    }
}
