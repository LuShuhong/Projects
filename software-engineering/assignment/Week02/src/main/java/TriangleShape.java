public abstract class TriangleShape extends Shape {
    private double length = 30;

    public TriangleShape(String message, String backgroundColor, String fontColor){
        super("Triangle",message, backgroundColor, fontColor);

    }


    public double getArea(){
        return Math.sqrt(3)/4 * length * length;
    }
}