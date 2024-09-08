package org.mariusz.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class SentenceTest {
    Sentence sentence, sentenceEqual, sentenceNotEqual;

    List<String> order = List.of("a", "basic", "sentence", "test");

    @Before
    public void setup(){
        sentence = new Sentence();
        sentence.addNonEmptyWord("test");
        sentence.addNonEmptyWord("basic");
        sentence.addNonEmptyWord("a");
        sentence.addNonEmptyWord("");
        sentence.addNonEmptyWord("sentence");

        sentenceEqual = new Sentence();
        sentenceEqual.addNonEmptyWord("test");
        sentenceEqual.addNonEmptyWord("basic");
        sentenceEqual.addNonEmptyWord("a");
        sentenceEqual.addNonEmptyWord("");
        sentenceEqual.addNonEmptyWord("sentence");

        sentenceNotEqual = new Sentence();
        sentenceNotEqual.addNonEmptyWord("test");
        sentenceNotEqual.addNonEmptyWord("different");
        sentenceNotEqual.addNonEmptyWord("a");
        sentenceNotEqual.addNonEmptyWord("");
        sentenceNotEqual.addNonEmptyWord("sentence");

    }

    @Test
    public void testSentenceOrderingAndAdding() {
        assertEquals(sentence.getWords().size(), 4);
        assertEquals(sentence.getWords().stream().toList(), order );
    }

    @Test
    public void testEquals(){
        assertEquals(sentenceEqual, sentence);
        assertNotEquals(sentenceNotEqual, sentence);
    }

    @Test
    public void testHashCodes(){
        assertEquals(sentenceEqual.hashCode(), sentence.hashCode());
        assertNotEquals(sentenceNotEqual.hashCode(), sentence.hashCode());
    }
}