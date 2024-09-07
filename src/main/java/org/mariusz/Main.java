package org.mariusz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("src","test","resources","small.in")));
            String
              final StringBuffer  buffer = new StringBuffer();
//            lines.forEach(line -> {
//               if(line.contains(".")){
//                   String[] parts = line.split('\\.');
//                   buffer.append(parts[0]);
//                   System.out.println(buffer.toString());
//                   buffer = new StringBuffer();
//                   buffer.append(parts[1]);
//
//               } else {
//                   buffer.append(line);
//               }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}