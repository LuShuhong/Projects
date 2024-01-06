package com.tictactoe.player;


public class PlayerFactory {
    public Player getPlayer(String player){
        player = player.toLowerCase();
        if(player == "human") return new HumanPlayer();
        if(player == "ai") return new AiPlayer();
        return null;
    }

    public String getPlayerFromPlayerNumber(int number){
        if(number == 1) return "You";
        else if(number == 2) return "AI";
        else return "Unknown Player";
    }
}
