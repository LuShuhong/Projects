package com.thg.shuhong.witcherFinder;
import java.util.Scanner;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

public class WitcherFinder {

    public static void main(String[] str){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a string");

        String inputString = myObj.nextLine();
        findingWitcher(inputString);
    }
    public static boolean findingWitcher(String str){
        String lowerCaseStr = str.toLowerCase();
        int num = 0;
        if(lowerCaseStr.contains("!geralt!")){
            for(int i = 0; i<lowerCaseStr.length();i++){
                if(Character.isDigit(lowerCaseStr.charAt(i))){
                    int numValue = Character.getNumericValue(lowerCaseStr.charAt(i));
                    num += numValue;
                }
            }
            System.out.println(num);
            if(num == 10){
//                System.out.println("very true");
                return true;
            }

        }
//        System.out.println("very wrong");
        return false;
    }
}