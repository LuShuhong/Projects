package com.thg.marp;

import java.util.ArrayList;

public class Contents {

    public static void contentsGenerator(ArrayList<String> headingInfo) {
        System.out.println();
        System.out.println("Contents: ");
        for (String heading : headingInfo) {
            String modifiedString = heading.replace("#", "  ");
            System.out.println(modifiedString);
        }
    }
}


