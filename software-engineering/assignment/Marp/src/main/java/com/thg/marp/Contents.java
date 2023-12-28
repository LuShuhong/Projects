package com.thg.marp;

import java.util.ArrayList;

public class Contents {

    public static String replaceHashWithSpace(String string) {
        return string.replace("#","  ");
    }

    public static void contentsGenerator(ArrayList<String> headingInfo) {
        System.out.println();
        System.out.println("Contents: ");
        for (String heading : headingInfo) {
            String modifiedString = replaceHashWithSpace(heading);
            System.out.println(modifiedString);
        }
    }
}


