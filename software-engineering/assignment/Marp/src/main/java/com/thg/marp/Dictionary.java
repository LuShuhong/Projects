package com.thg.marp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {

    private String dictionaryPath;
    String defaultDictPath = "./src/main/resources/words_alpha.txt";

    public Dictionary(String dictionaryPath){
        this.dictionaryPath = dictionaryPath;
    }

    public Set<String> parseDict() {
        File myFile = new File(dictionaryPath);
        Set<String> words = new HashSet<>();

        try (Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                words.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            //should I decouple this printing line?
            System.out.println("File not found, switching to default dictionary");
            try( Scanner defaultReader = new Scanner(new File(defaultDictPath))){
                while (defaultReader.hasNextLine()) {
                    words.add(defaultReader.nextLine());
                }
            }catch(FileNotFoundException exception){
                //should I decouple this printing line?
                System.out.println("Default dictionary also not found");

            }

        }
        return words;
    }

    }