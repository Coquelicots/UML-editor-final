package Component.Utility;


import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {
    public abstract void move(double x,double y);
    public abstract void draw(GraphicsContext gc);
    public abstract boolean isSelect(double x,double y);
    public abstract boolean isSelect(Point leftUp,Point rightDown);
    private boolean isSelected = false;
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean select) {
        isSelected = select;
    }
    public abstract Port getPort(double x,double y);
}
