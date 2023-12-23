package com.thg.marp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Slide {
    private String slidePath;
//    private Set<String> dictionarySet;
    private int numberOfWords;
    private int numberOfSlides;
    private int numberOfHeadings;

    private int numberOfImages;
    private Map<String,ArrayList<Integer>> incorrectWords;

    public Slide(String slidePath){
        this.slidePath = slidePath;
//        this.dictionarySet = dictionarySet;
        this.numberOfWords =0;
        this.numberOfSlides = 0;
        this.incorrectWords= new LinkedHashMap<>();
        this.numberOfHeadings = 0;
        this.numberOfImages =0;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfSlides() {
        return numberOfSlides;
    }

    public int getNumberOfHeadings() {
        return numberOfHeadings;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public Map<String, ArrayList<Integer>> getIncorrectWords() {
        return incorrectWords;
    }


    public void parseSlide(Set<String> dictionarySet) throws FileNotFoundException {
        Pattern wordPattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        Pattern slideDelimiterPattern = Pattern.compile("^[-*_]{3,}$");
        Pattern headingPattern = Pattern.compile("^#+ .*");
        Pattern imagePattern = Pattern.compile("\\!\\[.*\\]\\(.*\\)");

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

                if(headingPattern.matcher(line).matches()){
                    numberOfHeadings ++;
                }



                String[] tokens = line.split("\\s+");

                for(String token: tokens){
                    token = token.toLowerCase();
                    if(wordPattern.matcher(token).matches() && !token.contains("://")){
                        numberOfWords ++;
                        if(!dictionarySet.contains(token)){
//                            System.out.println("Incorrectly spelled word " + token +" at line " + lineNumber);
//                            incorrectWords.put(token,lineNumber);
                            if(incorrectWords.containsKey(token)){
                                incorrectWords.get(token).add(lineNumber);
                            } else {
                                ArrayList<Integer> lineNumbers = new ArrayList<>();
                                lineNumbers.add(lineNumber);
                                incorrectWords.put(token,lineNumbers);
                            }
                        }
                    }
                    if(imagePattern.matcher(token).matches()){
                        numberOfImages ++;
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