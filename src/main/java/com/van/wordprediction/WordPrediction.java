package com.van.wordprediction;

import com.van.wordprediction.helpers.Trie;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * This algorithm predicts a list of words based on what the user is typing. It predicts starting from the second character
 */
public class WordPrediction {
    //TODO it seems I should use stack here
    public static void main(String[] args) {
//        String[] words = new String[] { "Market", "Marriage", "Marry", "Mobile", "Making", "Match", "Mathematics", "House", "Hiding", "Brother",
//                "Computer", "Console", "Programming", "Matchmaking" };

        String[] words = new String[] { "Market", "Marriage", "Marry" };

        List<String> found = predict(words, "Mar");
        System.out.println(format("Size %d: %n Words: %s", found.size(), found));
    }

    private static List<String> predict(String[] database, String search) {
        List<String> wordsFound = new ArrayList<>();
        Trie trie = new Trie(database);

        wordsFound.addAll(trie.findPredictions(search));

        return wordsFound;
    }
}
