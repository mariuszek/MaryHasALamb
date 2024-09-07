package org.mariusz.utils.output;

import org.mariusz.domain.Sentence;

public abstract class OutputWriter {

    public abstract String generateFirstLine();
    public abstract String writeSentence(Sentence sentence);

}
