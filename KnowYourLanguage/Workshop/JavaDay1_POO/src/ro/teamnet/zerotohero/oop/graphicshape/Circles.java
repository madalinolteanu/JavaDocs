package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 7/1/2016.
 */
public class Circles {

    public double getAreaPub(){

        Circle cerc1 = new Circle();
        return cerc1.area();
    }
    public void getAreaDef(){
        Circle cerc2 = new Circle();
        int param1 = 0;
        float param2  = 0;

        cerc2.fillColor();
        cerc2.fillColor(param1);
        cerc2.fillColor(param2);

    }
}
