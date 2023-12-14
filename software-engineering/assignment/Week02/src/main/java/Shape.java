public abstract class Shape implements Sign{

    private String message;
    private String backgroundColor;
    private String fontColor;
    private String shape;

    public Shape(String shape,String message,String backgroundColor,String fontColor){
        this.shape= shape;
        this.message= message;
        this.backgroundColor= backgroundColor;
        this.fontColor= fontColor;
    }


    public String getShape() {
        return shape;
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