package com.tictactoe.command;

import com.tictactoe.board.GameBoard;
import com.tictactoe.game.Game;
import com.tictactoe.player.Player;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Save implements Command {
    private GameBoard gameBoard;

    public Save(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    @Override
    public void execute() {
        Map<String,int[][]> record = new HashMap<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-HH-mm-ss");
        String time = localDateTime.format(dateTimeFormatter);

        record.put(time, gameBoard.getGameBoardArray());

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/java/com/tictactoe/record/gameRecord.txt",true))) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(record);
            writer.write(jsonString);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
