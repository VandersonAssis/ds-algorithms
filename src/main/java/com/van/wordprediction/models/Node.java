package com.van.wordprediction.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Node {
    private Map<Character, Node> children;
    private boolean isWord;

    public Node() {
        this.isWord = false;
        this.children = new LinkedHashMap<>();
    }

    public Map<Character, Node> getChildren() {
        return this.children;
    }

    public boolean isWord() {
        return this.isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
}
