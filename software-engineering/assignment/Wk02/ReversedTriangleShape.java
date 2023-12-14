package com.thg.accelerator.se.shuhong.assignments.Wk02;

public abstract class ReversedTriangleShape extends Shape {
    private double length = 30;

    public ReversedTriangleShape(String message, String backgroundColor, String fontColor){
        super(" Reversed Triangle",message, backgroundColor, fontColor);

    }


    public double getArea(){
        return Math.sqrt(3)/4 * length * length;
    }
}
