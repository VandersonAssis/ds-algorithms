package com.van.findsum;

import com.van.findsum.helpers.FindSumNumbers;

public class FindSum {
    public static void main(String[] args) {
        int numberToBeFound = 16;
        int[] numbers = new int[] {1, 4, 45, 6, 10, -8};
        System.out.println(new FindSumNumbers().findNotTheBestApproach(numbers, numberToBeFound));
    }
}
