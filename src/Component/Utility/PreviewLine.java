package Component.Utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PreviewLine {
    Point endpoint;
    Port start;
    public PreviewLine(){
        endpoint = null;
        start = null;
    }
    public void setStartEnd(Port s,Point e){
        start = s;
        endpoint = e;
    }
    public void draw(GraphicsContext gc){
        if(endpoint!=null&&start!=null) {
            gc.setStroke ( Color.BLACK );
            gc.strokeLine ( start.getPosition ().getX (),start.getPosition ().getY (),endpoint.getX (),endpoint.getY () );
        }
    }
}
