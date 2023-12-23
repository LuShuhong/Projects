package com.thg.marp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Slide {
    private String slidePath;
    private Set<String> dictionarySet;
    private int numberOfWords;
    private int numberOfSlides;
    private Map<String,Integer> incorrectWords;

    public Slide(String slidePath, Set<String> dictionarySet){
        this.slidePath = slidePath;
        this.dictionarySet = dictionarySet;
        this.numberOfWords =0;
        this.numberOfSlides = 0;
        this.incorrectWords= new HashMap<>();
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfSlides() {
        return numberOfSlides;
    }

    public Map<String, Integer> getIncorrectWords() {
        return incorrectWords;
    }

    public void parseSlide() throws FileNotFoundException {
        Pattern wordPattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        Pattern slideDelimiterPattern = Pattern.compile("^[-*_]{3,}$");

        File myFile = new File(slidePath);
        int lineNumber = 0;
        numberOfWords = 0;
        numberOfSlides = 0;


        try (Scanner scanner = new Scanner(myFile)) {
            while(scanner.hasNextLine()){
                lineNumber ++;
                String line = scanner.nextLine();

                if(slideDelimiterPattern.matcher(line).matches()){
                    numberOfSlides ++;
                }

                String[] tokens = line.split("\\s+");

                for(String token: tokens){
                    token = token.toLowerCase();
                    if(wordPattern.matcher(token).matches() && !token.contains("://")){
                        numberOfWords ++;
                        if(!dictionarySet.contains(token)){
//                            System.out.println("Incorrectly spelled word " + token +" at line " + lineNumber);
                            incorrectWords.put(token,lineNumber);
                        }
                    }


                }
                }

        } catch (FileNotFoundException e) {

            //should decouple?
//            System.out.println("Slides not found");
            throw new FileNotFoundException("Slides not Found");
        }



    }
}