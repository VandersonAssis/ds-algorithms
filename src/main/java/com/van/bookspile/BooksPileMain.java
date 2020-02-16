package com.van.bookspile;

public class BooksPileMain {
    private static int calculatedStack = 0;

    public static void main(String[] args) {

//        int starting_stack_size = 13;
//        int max_stable_height = 3;
//        int partition = 2;

        int starting_stack_size = 3;
        int max_stable_height = 2;
        int partition = 5;

        divide(starting_stack_size, max_stable_height, partition);
        System.out.println(calculatedStack);
    }

    private static void divide(int stackSize, int maxStableHeight, int partition) {
        int[] outcome = new int[2];

        if(stackSize > maxStableHeight) {
            int division = stackSize / partition;
            int remainder = stackSize % partition;

            if(division == 0) {
                calculatedStack = stackSize;
                return;
            }

            outcome[0] = division + remainder;
            outcome[1] = division;

            divide(outcome[0], maxStableHeight, partition);
            divide(outcome[1], maxStableHeight, partition);
        } else {
            ++calculatedStack;
        }
    }
}
