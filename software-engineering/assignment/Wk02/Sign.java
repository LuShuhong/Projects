//package wk02;
//
//public abstract class Sign{
//    private String message;
//    private String backGroundColor;
//    private String fontColor;
//
//    public Sign(String message, String backGroundColor, String fontColor){
//        this.message = message;
//        this.backGroundColor= backGroundColor;
//        this.fontColor = fontColor;
//
//    }
//
//}

package com.thg.accelerator.se.shuhong.assignments.Wk02;

public interface Sign {
    String getMessage();
    String getBackgroundColor();
    String getFontColor();
}