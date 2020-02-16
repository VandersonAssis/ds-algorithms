package com.van.tictactoe.game;

public class TicTacToe {
    int[] rowCounter;
    int[] colCounter;
    int diagLeft;
    int diagRight;
    int n;

    public TicTacToe(int n) {
        this.rowCounter = new int[n];
        this.colCounter = new int[n];
        this.diagLeft = 0;
        this.diagRight = 0;
        this.n = n;
    }

    /**
     *
     * @param row The of the board
     * @param col The column of the board
     * @param player The player, can be either 1 or 2
     * @return The current winning condition, can be either:
     *         0: No one wins.
     *         1: Player 1 wins.
     *         2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;
        rowCounter[row] += move;
        colCounter[col] += move;
        if(row == col) diagLeft += move;
        if(row == n - col - 1) diagRight += move;
        if(rowCounter[row] == n || colCounter[col] == n || diagLeft == n || diagRight == n)
            return 1;
        else if(rowCounter[row] == -n || colCounter[col] == -n || diagLeft == -n || diagRight == -n)
            return 2;
        else
            return 0;
    }
}
