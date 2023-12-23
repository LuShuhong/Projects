package com.thg.marp;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

//./src/main/resources/testSlide.md

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Dictionary Path");
        String dictionaryPath = userInput.nextLine();
        Dictionary dictionary = new Dictionary(dictionaryPath);
        Set<String> words = dictionary.parseDict();

        System.out.println("Enter Slide Deck Path");
        String slidePath = userInput.nextLine();
        Slide slide = new Slide(slidePath,words);
        slide.parseSlide();
    }
}
