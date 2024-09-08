package org.mariusz.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class SentenceTest {
    Sentence sentence;
    List<String> order = List.of("a", "basic", "sentence", "test");

    @Before
    public void setup(){
        sentence = new Sentence();
    }


    @Test
    public void testSentenceOrderingAndAdding() {
        sentence.addNonEmptyWord("test");
        sentence.addNonEmptyWord("basic");
        sentence.addNonEmptyWord("a");
        sentence.addNonEmptyWord("");
        sentence.addNonEmptyWord("sentence");

        assertEquals(sentence.getWords().size(), 4);
        assertEquals(sentence.getWords().stream().toList(), order );
    }

}