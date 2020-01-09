package com.van.findsum.helpers;

/**
 * Challenge 1)Given an array A[] and a number x, check for pair in A[] with sum as x
 * Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
 * Example :
 * INPUT:
 * Let Array be {1, 4, 45, 6, 10, -8} and sum to find be 16
 * OUTPUT: 6, 10
 * Big O Notation
 */
public class FindSumNumbers {
    //O(n^2) horrible, I know.
    public String findNotTheBestApproach(int[] numbers, int find) {
        String numbersFound = "";

        for(int i = 0; i < numbers.length; i++) {
            for(int k = 1; k < numbers.length; k++) {
                if(numbers[i] + numbers[k] == find) {
                    numbersFound = numbers[i] + ", " + numbers[k];
                    break;
                }
            }
        }

        return numbersFound;
    }
}
