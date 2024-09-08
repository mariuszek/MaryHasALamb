package org.mariusz.utils.output;

import org.junit.Before;
import org.junit.Test;
import org.mariusz.domain.Sentence;

import java.util.TreeSet;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class XMLOutputWriterTest {
    Sentence sentence;

    Logger logger = Logger.getLogger(XMLOutputWriterTest.class.getName());

    @Before
    public void setup(){
        TreeSet<String> set = new TreeSet<String>();
        set.add("test");
        set.add("basic");
        set.add("a");
        set.add("sentence");

        sentence = new Sentence();
        sentence.setWords(set);
    }


    @Test
    public void writeSentenceTest() {
        OutputWriter writer = new XMLOutputWriter();
        assertEquals(expectedResult, writer.generateSentence(sentence));
    }

    String expectedResult = """
            
            <sentence>
            <word>a</word>
            <word>basic</word>
            <word>sentence</word>
            <word>test</word>
            </sentence>""";
}
