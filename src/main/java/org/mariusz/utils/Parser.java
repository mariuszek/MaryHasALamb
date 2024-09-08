package org.mariusz.utils;



import org.mariusz.domain.Sentence;
import org.mariusz.utils.output.OutputWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Parser class is used to parse input and delegate the construction of output to specific OutputWriter
    
 */
public class Parser {

    OutputWriter output;
    
    // supporting patterns
    Pattern endOfSentencePattern = Pattern.compile(".*!|.*\\?|.*\\.",Pattern.CASE_INSENSITIVE);
    Pattern typicalShorts = Pattern.compile("Mr.|Mrs.|Ms.",Pattern.CASE_INSENSITIVE);
    Pattern cleringPatter = Pattern.compile("[^a-zA-Z_0-9'-'\\p{IsHan}]");

    public Parser(OutputWriter outputWriter) {
        output = outputWriter;
    }

    
    /*
        parse method use the lines from any BufferedReader extracts Sentences and put them to 
        the output Print writer in the same loop cycle to safe memory utilization. All the words/sentences while used
        are garbage collected automatically. 
         
     */
    public void parse(BufferedReader lines, PrintStream writer) throws IOException {
        //First sentence container will be filled while end of sentence found or EOF
        Sentence currentSentence = new Sentence();
        
        //Prints header of the specific output
        writer.print(output.generateHeader());

        //While reading lines from input
        while (lines.ready()) {
            String line = lines.readLine();
            if(line == null) break; // bug of some bufferedReaders - wrong ready method implementation.
            
            //Tokenize the line to words 
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                
                //Each token (word) is being check is an end of Sentence and added to the Sentence object
                if(typicalShorts.matcher(token).matches()) { //Skips the common abbreviation 
                    currentSentence.addNonEmptyWord(token);
                }else if(endOfSentencePattern.matcher(token).matches()) { //if end of sentence found
                    currentSentence.addNonEmptyWord(clearToken(token));
                    //Write the full sentence to the output and GC the sentence by removing reference and creating new instance of Sentence
                    writer.print(output.generateSentence(currentSentence));
                    currentSentence = new Sentence();
                }else{
                    //if not an end of sentence add to the Sentence object
                    currentSentence.addNonEmptyWord(clearToken(token));
                }
            }
        }
        //edge case:
        //check if text ended and last Sentence was not terminated properly, creating last Sentence of it regardless.
        if(!currentSentence.getWords().isEmpty()){
            writer.print(output.generateSentence(currentSentence));
        }

        //write footer
        writer.print(output.generateFooter());
        writer.close();
    }


    String clearToken(String token){
        List<String> foundClearToken = Arrays.stream(cleringPatter.split(token))
                .filter(clearedToken -> !clearedToken.isEmpty())
                .toList();

        if(foundClearToken.isEmpty()){ // Trying non-Latin tokens
            return "";//return empty token as no match was found (not a word)
        } else {
            return foundClearToken.getFirst();
        }


    }
}