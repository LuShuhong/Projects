package com.thg.accelerator.se.shuhong.assignments.Wk02;

public class OctagonShape extends Shape{
    private double side = 30;

    public OctagonShape(String message, String backgroundColor, String fontColor){
        super("Octagon",message, backgroundColor, fontColor);

    }


    public double getArea(){
        return 2*side*side*(1+Math.sqrt(2));
    }
}
