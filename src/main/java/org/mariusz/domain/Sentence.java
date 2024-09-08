package org.mariusz.domain;

import java.util.Objects;
import java.util.TreeSet;

public class Sentence {

    private TreeSet<String> words;

    public Sentence() {
        this.words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence sentence)) return false;
        return Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(words);
    }
}
