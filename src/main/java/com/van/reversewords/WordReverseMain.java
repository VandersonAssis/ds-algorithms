package com.van.reversewords;

public class WordReverseMain {
    public static void main(String[] args) {
        String line = "RemoteIo is awesome\n" +
                "Candidates give interview\n" +
                "best candidates are selected";

        System.out.println(answer(line));
    }

    public static String answer(String line) {
        String[] words = line.split(" ");
        line = "";

        for(String word : words) {
            line += reverse(word.trim()) + " ";
        }

        return line.trim();
    }

    private static String reverse(String word) {
        String reversedWord = "";

        for(int i = (word.length() -1); i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        return reversedWord;
    }
}
