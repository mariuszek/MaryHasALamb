package org.mariusz.domain;

import java.util.TreeSet;
import java.util.regex.Pattern;

public class Sentence {

    private TreeSet<String> words;
    Pattern cleanRegex = Pattern.compile("");

    public Sentence() {
        this.words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    }

    public TreeSet<String> getWords() {return words;}
    public void setWords(TreeSet<String> words) {this.words = words;}

    public void addNonEmptyWord(String word) {
        if(!word.isEmpty()) {
            this.addWord(word);
        }
    }

    private void addWord(String word) {this.words.add(word);}

    @Override
    public String toString() {
        return words.stream().toList().toString();
    }


}
