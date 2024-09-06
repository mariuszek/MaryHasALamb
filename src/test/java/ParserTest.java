import org.junit.Before;
import org.junit.Test;
import org.mariusz.Parser;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;


public class ParserTest {

    Logger logger = Logger.getLogger(ParserTest.class.getName());
    List<String> inputs;
    Parser parser;

    @Before
    public void setup(){
        parser = new Parser();
        inputs = prapareStrings();
    }

    @Test
    public void testSimpleExtractionSentece(){

        inputs.forEach(line -> {
            List<String> result = parser.extractWords(line);
            assertNotNull(result);
            logger.info(result.toString());

        });
    }


    private List<String> prapareStrings() {
        return List.of( "What\the  shouted was shocking:  停在那儿, 你这肮脏的掠夺者!"
                ,"""
                 Mary had a little lamb .
        
                Peter called for the wolf , and Aesop came .
        Cinderella likes shoes..”;
        """);
    }


}