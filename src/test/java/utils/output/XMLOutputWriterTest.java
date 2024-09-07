package utils.output;

import org.junit.Before;
import org.junit.Test;
import org.mariusz.domain.Sentence;
import org.mariusz.utils.output.OutputWriter;
import org.mariusz.utils.output.XMLOutputWriter;

import java.util.List;
import java.util.logging.Logger;

public class XMLOutputWriterTest {
    Sentence sentence;

    Logger logger = Logger.getLogger(XMLOutputWriterTest.class.getName());

    @Before
    public void setup(){
        sentence = new Sentence(List.of("test", "basic","a", "sentence"));
    }


    @Test
    public void writeSentenceTest() {
        OutputWriter writer = new XMLOutputWriter();
        logger.info(writer.writeSentence(sentence));
    }
}
