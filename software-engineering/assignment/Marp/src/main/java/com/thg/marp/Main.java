package com.thg.marp;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

//./src/main/resources/testSlide.md

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter Dictionary Path");
        Scanner userInput = new Scanner(System.in);
        String dictionaryPath = userInput.nextLine();
        Dictionary dictionary = new Dictionary(dictionaryPath);
        Set<String> words = dictionary.parseDict();

        System.out.println("Enter Slide Deck Path");
        String slidePath = userInput.nextLine();
        Slide slide = new Slide(slidePath);
        slide.parseSlide(words);
        getSlideStatistics(slide);

    }

    public static void getSlideStatistics(Slide slide){
        System.out.println("Number of Slides: "+ slide.getNumberOfSlides());
        System.out.println("Number of Words: "+slide.getNumberOfWords());
        System.out.println("Number of Headings: "+slide.getNumberOfHeadings());;
        System.out.println("Number of Images: "+slide.getNumberOfImages());
        slide.getIncorrectWords().forEach((key,value) ->{
            StringBuilder lineNumbersToPrint = new StringBuilder();
            for(int i=0;i<value.size()-1;i++){
                lineNumbersToPrint.append(value.get(i)+", ");
            }
            lineNumbersToPrint.append(value.get(value.size()-1));
            System.out.println("Misspelled word " +key + " in line " + lineNumbersToPrint);
        });
    }
}
