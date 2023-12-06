package wk02;

public abstract class EquilateralTriangleShape implements Shape{
    private String shape = "Rectangle";
    private double length;
    private double width;

    public EquilateralTriangleShape(double length){
        this.length = length;
        this.width = width;
    }

    public String getShape() {
        return shape;
    }

    public double getArea(){
        return length*width;
    }
}


