package com.van.wordprediction.helpers;

import com.van.wordprediction.models.Node;

import java.util.*;

public class Trie {
    private Node root;

    public Trie(String[] words) {
        this.root = new Node();
        this.fill(words);
    }

    public List<String> findPredictions(String search) {
        StringBuilder prefix = new StringBuilder();
        List<String> wordsFound = new ArrayList<>();
        Node current = this.root.getChildren().get(search.charAt(0));
        if(current == null) return wordsFound;
        prefix.append(this.root.getChildren().entrySet().stream().findFirst().get().getKey());

        while (current != null && current.getChildren().size() > 0) {
            if(current.getChildren().size() == 1) {
                prefix.append(current.getChildren().entrySet().stream().findFirst().get().getKey());
            } else {
                for(Map.Entry<Character, Node> currentChild : current.getChildren().entrySet()) {
                    String suffix = currentChild.getKey() + this.loadWord(currentChild.getValue());
                    wordsFound.add(prefix + suffix);
                }
            }

            current = current.getChildren().entrySet().stream().findFirst().get().getValue();
        }

//        if(current.getChildren().size() == 1) {
//            prefix.append(current.getChildren().entrySet().stream().findFirst().get().getKey());
//        } else {
//            for(Map.Entry<Character, Node> currentEntry : current.getChildren().entrySet()) {
//                wordsFound.add(prefix.toString() + this.loadWord(currentEntry.getValue()));
//            }
//        }

        return wordsFound;
    }

    private String loadWord(Node root) {
        StringBuilder word = new StringBuilder();
        Node current = root;

        while (current != null && current.getChildren().size() > 0) {
            word.append(current.getChildren().entrySet().stream().findFirst().get().getKey());
            current = current.getChildren().entrySet().stream().findFirst().get().getValue();
        }

        return word.toString();
    }































//    public List<String> findPredictions(String search) {
//        int threshold = 2;
//        List<String> wordsFound = new ArrayList<>();
//        List<Node> adjacentNodes = new ArrayList<>();
//        if(search.length() < threshold) return wordsFound;
//
//        StringBuilder strBuilder = new StringBuilder();
//        Node current = this.root.getChildren().get(search.charAt(0));
//
//        if(current == null)
//            return wordsFound; //If nothing found, it returns an empty list
//        else
//            strBuilder.append(search.charAt(0));
//
//        String test = this.loadWord(current);
//        System.out.println(test);
//
//        return wordsFound;
//    }
//
//    private String loadWord(Node node) {
//        if(node == null) return "";
//
//        Node current = node;
//        StringBuilder word = new StringBuilder();
//
//        while(true) {
//            word.append(current.getChildren().entrySet().stream().findFirst().get().getKey());
//            Optional<Map.Entry<Character, Node>> currentEntry = current.getChildren().entrySet().stream().map(Optional::ofNullable).findFirst().get();
//
//            if(currentEntry.isEmpty() || currentEntry.get().getValue().getChildren().size() == 0)
//                break;
//            else
//                current = currentEntry.get().getValue();
//        }
//
//        return word.toString();
//    }

    private void insert(String word) {
        Node current = this.root;

        for(int i = 0; i < word.length(); i++)
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new Node()); //If not in the LinkedHashMap yet, then the char will be added.

        current.setIsWord(true);
    }

    private void fill(String[] words) {
        Arrays.asList(words).stream().forEach(w -> this.insert(w));
    }
}
