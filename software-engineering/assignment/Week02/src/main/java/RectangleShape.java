public abstract class RectangleShape extends Shape{
    private double length=40;
    private double width=30;

    public RectangleShape(String message, String backgroundColor, String fontColor){
        super("Rectangle",message, backgroundColor, fontColor);
    }

    public double getArea(){
        return length*width;
    }
}
