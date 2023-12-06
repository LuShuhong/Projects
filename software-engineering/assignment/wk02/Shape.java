package wk02;

//public interface Shape {
//    String getShape();
//    double getArea();
//}

public abstract class Shape implements Sign{

    private String message;
    private String backgroundColor;
    private String fontColor;

    public Shape(String message,String backgroundColor,String fontColor){
        this.message= message;
        this.backgroundColor= backgroundColor;
        this.fontColor= fontColor;
    }



    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public String getBackgroundColor(){
        return backgroundColor;
    }
    @Override
    public String getFontColor(){
        return fontColor;
    }

}
