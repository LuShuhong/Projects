package wk02;

public class SpeedLimitCircle extends CircleShape implements Sign  {
    private String message;
    private String backgroundColor= "white";
    private String fontColor = "black";

    public SpeedLimitCircle(String message){
        this.message = message;
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
