package org.mariusz.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentencesReader {
    List<String> sentences = new ArrayList<String>();

    public void read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("\\Z|\\.|!|\\?");


        while(scanner.hasNext()){
            sentences.add(scanner.next());
        }

        System.out.println(String.join("\n", sentences));
    }


}
