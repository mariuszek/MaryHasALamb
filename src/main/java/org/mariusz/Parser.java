package org.mariusz;



import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {





    public List<String> extractWords(String sentence){
        return Arrays.stream(sentence
                .split("\\W+",0)).toList();

    }
}