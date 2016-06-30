package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 7/1/2016.
 */
public class Shape extends AbstractShape implements ShapeBehavior {

    private int color;
    private float saturation;

    public void setColor(int color) {
        this.color = color;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    @Override
    public double area() {
        return 0;
    }

    public int getColor() {
        return color;
    }
}
