package org.mariusz.utils.output;

import org.mariusz.domain.Sentence;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import java.io.BufferedWriter;
import java.io.OutputStream;

public class XMLOutputWriter extends OutputWriter{

    private final static String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    private final static String start = "<sentece>";
    private final static String end = "</sentece>";
    private final static String wStart = "<word>";
    private final static String wEnd = "</word>";


    public XMLOutputWriter() {

    }

    public String generateFirstLine(){
        return header;
    }

    @Override
    public String writeSentence(Sentence sentence) {
        StringBuilder sentenceBuilder = new StringBuilder();
        sentenceBuilder.append(start);
        sentence.getWords().forEach(word -> {
            sentenceBuilder.append(wStart);
            sentenceBuilder.append(word);
            sentenceBuilder.append(wEnd);
        });
        sentenceBuilder.append(end);

        return sentenceBuilder.toString();
    }
}
