package wk02;

public abstract class CircleShape implements Shape {
    private String shape = "Circle";
    private double radius = 30;

    public String getShape() {
        return shape;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}
