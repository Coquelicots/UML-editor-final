package Behavior;

import javafx.scene.input.MouseEvent;

/**
 * Created by Vincent on 1/15/2017.
 */
public abstract class Mode {
    public abstract void onPress(MouseEvent event);
    public abstract void onDrag(MouseEvent event);
    public abstract void onRelease(MouseEvent event);
}
