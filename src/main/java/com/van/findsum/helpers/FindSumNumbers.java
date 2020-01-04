package com.van.findsum.helpers;

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
