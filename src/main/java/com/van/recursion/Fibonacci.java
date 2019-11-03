package com.van.recursion;

public class Fibonacci {

    /*
        Fibonacci numbers are 0, 1, 1, 2, 3, 5, 8, 13, 21...
     */

    public static void main(String[] args) {
        calculateFibonacciOne(1, 1);
        System.out.println("\n\nNumber in the passed position is " + calculateFibonacciTwo(9));
    }

    /**
     * This method prints all the fibonacci numbers
     * @param previous
     * @param current
     * @return
     */
    private static int calculateFibonacciOne(int previous, int current) {
        System.out.println(current);

        if(current >= 21) return current;
        int aux = current;
        current += previous;
        previous = aux;

        return calculateFibonacciOne(previous, current);
    }

    /**
     * This method returns which is the number in the position passed
     * @param position
     * @return
     */
    private static int calculateFibonacciTwo(int position) {
        if(position < 1)
            throw new RuntimeException("Number is less than one");
        else if (position == 1 || position == 2)
            return position - 1;
        else
            return calculateFibonacciTwo(position - 1) + calculateFibonacciTwo(position - 2);
    }

}
