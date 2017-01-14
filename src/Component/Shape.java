package Component;


import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {
    protected GraphicsContext gc;
    public abstract void draw();
    public abstract boolean isSelect(double x,double y);
    public Shape (GraphicsContext gc){
        this.gc = gc;
    }
}
