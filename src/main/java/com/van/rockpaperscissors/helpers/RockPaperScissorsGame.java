package com.van.rockpaperscissors.helpers;

public class RockPaperScissorsGame {

    /**
     * Combinations are:
     * rr, rp, rs | pp, ps, pr | ss, sr, sp
     *
     * Rules are:
     * rock = rock
     * rock < paper
     * rock > scissors
     *
     * paper = paper
     * paper < scissors
     * paper > rock
     *
     * scissors = scissors
     * scissors < rock
     * scissors > paper
     *
     * @return the winner of the round. Possible values are; 0 for draw, 1 for player1 and 2 for player2
     */
    public int playRound(char playerOneHand, char playerTwoHand) {
        String moves = String.format("%s%s", playerOneHand, playerTwoHand);
        if(moves.equals("rr")) return 0;
        if(moves.equals("rp")) return 2;
        if(moves.equals("rs")) return 1;
        if(moves.equals("pp")) return 0;
        if(moves.equals("ps")) return 2;
        if(moves.equals("pr")) return 1;
        if(moves.equals("ss")) return 0;
        if(moves.equals("sr")) return 2;
        else return 1;
    }
}
