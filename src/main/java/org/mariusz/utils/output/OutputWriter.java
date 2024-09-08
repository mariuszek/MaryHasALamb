package org.mariusz.utils.output;

import org.mariusz.domain.Sentence;

public abstract class OutputWriter {


    public abstract String generateSentence(Sentence sentence);
    public abstract String generateHeader();
    public abstract String generateFooter();

}
