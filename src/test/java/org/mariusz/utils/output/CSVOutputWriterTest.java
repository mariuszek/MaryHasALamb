package org.mariusz.utils.output;

import org.junit.Before;
import org.junit.Test;
import org.mariusz.domain.Sentence;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class CSVOutputWriterTest {
    Sentence sentence;

    @Before
    public void setup(){
        TreeSet<String> set = new TreeSet<>();
        set.add("test");
        set.add("basic");
        set.add("a");
        set.add("sentence");

        sentence = new Sentence();
        sentence.setWords(set);
    }


    @Test
    public void writeSentenceTest() {
        OutputWriter writer = new CSVOutputWriter();
        assertEquals(expectedResult,writer.generateSentence(sentence));

    }

    String expectedResult = """
            Sentence 1, a, basic, sentence, test
            """;
}
