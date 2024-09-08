package org.mariusz.utils;

import org.junit.Before;
import org.junit.Test;
import org.mariusz.utils.output.CSVOutputWriter;
import org.mariusz.utils.output.XMLOutputWriter;

import java.io.*;
import java.util.logging.Logger;

import static org.junit.Assert.*;


public class ParserTest {

    Logger logger = Logger.getLogger(ParserTest.class.getName());

    Parser xmlParser, csvParser;


    @Before
    public void setup(){
        xmlParser = new Parser(new XMLOutputWriter());
        csvParser = new Parser(new CSVOutputWriter());
    }

    @Test
    public void testNoneUnicodeCsvSentece() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        csvParser.parse(new BufferedReader(new StringReader(inputs[0])),
                new PrintStream(outStream));
        assertEquals(outputs[2],outStream.toString());
    }

    @Test
    public void testMarySenteceToCsv() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        csvParser.parse(new BufferedReader(new StringReader(inputs[1])),
                new PrintStream(outStream));

        assertEquals(outputs[3],outStream.toString());
    }

    @Test
    public void testNoneUnicodeXmlSentece() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outStream));
        xmlParser.parse(new BufferedReader(new StringReader(inputs[0])), new PrintStream(outStream));
        assertEquals(outputs[0],outStream.toString());
    }

    @Test
    public void testMarySenteceToXml() throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outStream));
        xmlParser.parse(new BufferedReader(new StringReader(inputs[1])), new PrintStream(outStream));

        assertEquals(outputs[1],outStream.toString());

    }

    String[] inputs = new String[] {"What\the  shouted was shocking:  停在那儿, 你这肮脏的掠夺者!",
            """
                 Mary had a little lamb .
        
                Peter called for the wolf , and Aesop came .
        Cinderella likes shoes..”;
        """};

    String[] outputs = new String[] {
            """
            <?xml version="1.0" encoding="UTF-8"?>
            <text>
            <sentence>
            <word>he</word>
            <word>shocking</word>
            <word>shouted</word>
            <word>was</word>
            <word>What</word>
            <word>你这肮脏的掠夺者</word>
            <word>停在那儿</word>
            </sentence>
            </text>
            """,
            """
            <?xml version="1.0" encoding="UTF-8"?>
            <text>
            <sentence>
            <word>a</word>
            <word>had</word>
            <word>lamb</word>
            <word>little</word>
            <word>Mary</word>
            </sentence>
            <sentence>
            <word>Aesop</word>
            <word>and</word>
            <word>called</word>
            <word>came</word>
            <word>for</word>
            <word>Peter</word>
            <word>the</word>
            <word>wolf</word>
            </sentence>
            <sentence>
            <word>Cinderella</word>
            <word>likes</word>
            <word>shoes</word>
            </sentence>
            </text>
            """,
            """
            , Word 1, Word 2, Word 3, Word 4, Word 5, Word 6, Word 7, Word 8, Word 9, Word 10, Word 11, Word 12, Word 13, Word 14, Word 15, Word 16, Word 17, Word 18, Word 19, Word 20, Word 21, Word 22, Word 23, Word 24, Word 25, Word 26, Word 27, Word 28, Word 29, Word 30, Word 31, Word 32
            Sentence 1, he, shocking, shouted, was, What, 你这肮脏的掠夺者, 停在那儿
            """
            ,
            """
            , Word 1, Word 2, Word 3, Word 4, Word 5, Word 6, Word 7, Word 8, Word 9, Word 10, Word 11, Word 12, Word 13, Word 14, Word 15, Word 16, Word 17, Word 18, Word 19, Word 20, Word 21, Word 22, Word 23, Word 24, Word 25, Word 26, Word 27, Word 28, Word 29, Word 30, Word 31, Word 32
            Sentence 1, a, had, lamb, little, Mary
            Sentence 2, Aesop, and, called, came, for, Peter, the, wolf
            Sentence 3, Cinderella, likes, shoes
            """};

}