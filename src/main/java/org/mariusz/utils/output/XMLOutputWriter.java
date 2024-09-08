package org.mariusz.utils.output;

import org.mariusz.domain.Sentence;

public class XMLOutputWriter extends OutputWriter{

    private final static String metaHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private final static String header = "\n<text>";
    private final static String footer = "\n</text>\n";
    private final static String start = "\n<sentence>";
    private final static String end = "\n</sentence>";
    private final static String wStart = "\n<word>";
    private final static String wEnd = "</word>";


    public XMLOutputWriter() {

    }

    @Override
    public String generateHeader(){
        return metaHeader + header;
    }
    @Override
    public String generateFooter(){
        return footer;
    }


    @Override
    public String generateSentence(Sentence sentence) {
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
