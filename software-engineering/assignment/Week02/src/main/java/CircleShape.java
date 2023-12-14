public abstract class CircleShape extends Shape {
    private double radius = 30;

    public CircleShape(String message, String backgroundColor, String fontColor){
        super("Circle",message, backgroundColor, fontColor);

    }


    public double getArea(){
        return Math.PI*radius*radius;
    }
}
