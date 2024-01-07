package com.tictactoe.command;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tictactoe.board.GameBoard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Load {
    private GameBoard gameBoard;

    public ArrayList<Map<String,int[][]>> readFromTxt() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Map<String,int[][]>> gameRecords = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/com/tictactoe/record/gameRecord.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                Map<String, int[][]> record = mapper.readValue(line, new TypeReference<Map<String, int[][]>>() {});
                gameRecords.add(record);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return gameRecords;
    }

    public int chooseRecord(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Map<String,int[][]>> gameRecords = readFromTxt();
        System.out.println("Choose Record to Load (1 - %s)".formatted(gameRecords.size()));
        for(int i =0; i< gameRecords.size();i++){
            Map<String, int[][]> record = gameRecords.get(i);
            for(String key: record.keySet()){
                System.out.println("Record " + (i+1) + ": " + key);
            }
        }

        try {
            String recordNumberStr = scanner.nextLine();
            int recordNumber = Integer.parseInt(recordNumberStr);
            if (recordNumber < 1 || recordNumber > gameRecords.size()) {
                throw new IllegalArgumentException("Invalid record number. Please choose a number between 1 and " + gameRecords.size());
            }
            return recordNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a numeric value.");
        }

    }

    public int[][] getRecordArray(int recordNumber){
        ArrayList<Map<String,int[][]>> gameRecords = readFromTxt();
        Map<String,int[][]> selectedRecord = gameRecords.get(recordNumber-1);
        for(int[][] array: selectedRecord.values()){
            return array;
        }
        return null;
    }

    public void load(){
        int[][] recordArray = getRecordArray(chooseRecord());

    }

}
