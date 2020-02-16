package com.van.rockpaperscissors;

import com.van.rockpaperscissors.helpers.RockPaperScissorsGame;

public class RockPaperScissorsMain {
    public static void main(String[] args) {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        System.out.println(game.playRound('p', 's'));
    }
}
