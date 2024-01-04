package com.tictactoe.player;

import com.tictactoe.strategy.Strategy;

import java.util.Locale;

public class PlayerFactory {
    public static Player getPlayer(String player){
        player = player.toLowerCase();
        if(player == "human") return new HumanPlayer();
        if(player == "ai") return new AiPlayer();
        return null;
    }
}
