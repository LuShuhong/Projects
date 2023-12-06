package wk02;

public class OnComingVehicle extends RectangleShape implements Sign{
    private final String message = "Oncoming vehicles in middle of road";
    private final String backgroundColor= "black";
    private final String fontColor = "white";

    public String getMessage() {
        return message;
    }

    public String getBackgroundColor(){
        return backgroundColor;
    }

    public String getFontColor(){
        return fontColor;
    }
}