package wk02;

public abstract class CircleShape implements Shape {
    private String shape = "Circle";
    private double radius;

    public CircleShape(double radius){
        this.radius = radius;
    }

    public String getShape() {
        return shape;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}
