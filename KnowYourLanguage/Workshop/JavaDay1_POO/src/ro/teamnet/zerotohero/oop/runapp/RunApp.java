package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by user on 7/1/2016.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles cercuri = new Circles();
        System.out.println(cercuri.getAreaPub());
        Canvas canvas = new Canvas();
        //canvas.getArea();                 // NU NE LASA daca getArea() nu e public;
        cercuri.getAreaDef();
        Shape shape = new Circle(10);
        ShapeBehavior shapeBehavior = new Square(10);

        System.out.println(shapeBehavior.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));
    }
}
