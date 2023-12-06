package wk02;

public abstract class CircleShape extends Shape {
    private String shape = "Circle";
    private double radius = 30;

    public CircleShape(String message, String backgroundColor, String fontColor){
        super(message, backgroundColor, fontColor);

    }

    public String getShape() {
        return shape;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}
