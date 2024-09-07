package org.mariusz.domain;

import java.util.List;

public class Sentence {

    private List<String> words;

    public Sentence(List<String> words) {
        this.words = words;
    }
    public List<String> getWords() {return words;}


}
