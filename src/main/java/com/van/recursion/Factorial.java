package com.van.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(calculateFactorial(5));
    }

    private static int calculateFactorial(int number) {
        if(number == 0) return 1;

        return (number * calculateFactorial(number - 1));
    }

}
