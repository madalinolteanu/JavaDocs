package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 7/1/2016.
 */

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle extends Shape {

    private int xPos;
    private int yPos;
    private int radius;

    public Circle(){

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }
    public Circle (int xPos){

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }
    public Circle (int xPos, int yPos){

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }
    public Circle (int xPos, int yPos, int radius){

        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }
    public double area(){

        return PI*pow(radius,2);
    }

    public String toString(){

        return "center = (" + xPos +"," +yPos +") and radius =" + radius;
    }

    public void fillColor(){
        System.out.println(super.getColor());
    }
    public void fillColor(int param){
        super.setColor(param);
        System.out.println("The circle color is now " + param);
    }
    public void fillColor(float param){
        super.setSaturation(param);
    }
}
