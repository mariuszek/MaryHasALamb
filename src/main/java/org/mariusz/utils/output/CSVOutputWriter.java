package org.mariusz.utils.output;

import org.mariusz.domain.Sentence;

public class CSVOutputWriter extends OutputWriter{
    private long sentenceCounter = 0;

    public CSVOutputWriter() {

    }

    @Override
    public String generateHeader(){
        StringBuilder header = new StringBuilder();
        for(int i = 1; i < 33; i++){
            header.append(", Word ").append(i);
        }
        header.append("\n");
        return header.toString();
    }

    /*
        Due to format needs (the indexing need of all words)
        all the document is being generated at once while calling generate footer method.

     */
    @Override
    public String generateFooter(){
        return "";
    }


    @Override
    public String generateSentence(Sentence sentence) {
        StringBuilder sentenceString = new StringBuilder();
        sentenceCounter++;
        sentenceString.append("Sentence ").append(sentenceCounter);
        sentence.getWords().forEach(word -> {
            sentenceString.append(", ");
            sentenceString.append(word);
        });
        sentenceString.append("\n");
        return sentenceString.toString();
    }
}
