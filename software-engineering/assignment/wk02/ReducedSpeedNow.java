package wk02;

public class ReducedSpeedNow extends RectangleShape implements Sign  {
    private final String message = "Reduce Speed Now";
    private final String backgroundColor= "red";
    private final String fontColor = "white";

    public ReducedSpeedNow(){
        super(40,30);
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
