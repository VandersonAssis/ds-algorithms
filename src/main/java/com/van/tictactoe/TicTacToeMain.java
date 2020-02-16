package com.van.tictactoe;

import com.van.tictactoe.game.TicTacToe;

public class TicTacToeMain {
    public static void main(String[] args) {
        /*
        player1 = o
        player2 = x

        |o| |x|
        |x|x| |
        |o|o|o|
         */
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.move(0, 0, 1);
        ticTacToe.move(0, 2, 2);
        ticTacToe.move(2, 2, 1);
        ticTacToe.move(1, 1, 2);
        ticTacToe.move(2, 0, 1);
        ticTacToe.move(1, 0, 2);
        System.out.println("Player" + ticTacToe.move(2, 1, 1) + " won.");

        /*
        player1 = o
        player2 = x

        |o|o|x|
        |x|x|x|
        |o| |o|
         */
        ticTacToe = new TicTacToe(3);
        ticTacToe.move(0, 0, 1);
        ticTacToe.move(1, 0, 2);
        ticTacToe.move(2, 2, 1);
        ticTacToe.move(1, 1, 2);
        ticTacToe.move(2, 0, 1);
        System.out.println("Player" + ticTacToe.move(1, 2, 2) + " won.");
    }
}
