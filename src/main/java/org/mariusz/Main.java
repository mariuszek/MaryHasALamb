package org.mariusz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lines = Files.newBufferedReader(Paths.get("src","test","resources","small.in"));
        while (lines.ready()) {
            String line = lines.readLine();
            String[] split= line.split("(..\\.)|\\.|!");

            Arrays.stream(split).forEach(System.out::println);
        }


//
//        StreamTokenizer tokenizer = new StreamTokenizer(lines).;
//
//
//
//        final StringBuffer  buffer = new StringBuffer()
//
//        lines.forEach(line -> {
//               if(line.contains(".")){
//                   String[] parts = line.split("\\.");
//                   System.out.println("["+ Arrays.stream(parts).toList()+"]");
//                   buffer.append(parts[0]);
//                   System.out.println("\""+buffer.toString()+"\"");
//                   buffer.setLength(0);//clearing buffer
//                   if(parts.length > 1) {
//                       buffer.append(parts[1]);
//                   }
//               } else {
//                   buffer.append(line);
//               }
//            });
    }
}