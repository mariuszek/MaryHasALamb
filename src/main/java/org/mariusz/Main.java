package org.mariusz;

import org.mariusz.exceptions.MaryHasALambException;
import org.mariusz.utils.Parser;
import org.mariusz.utils.output.CSVOutputWriter;
import org.mariusz.utils.output.XMLOutputWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/*
Converts the plain text with statements into XML or CVS output.

                Usage: [options] [args...]

                where options include:
                    -xml XML type of output will be produced Default -xml option.
                    -csv CSV type of output will be produced.
                    -f <file> input file that will be used to produce output. File must exist. Default Std in is used
                        Example: -f ./src/test/resources/small.in

                    -o <file> output file that will be used. The output file will be erased if exists without a warning.
                              Default Std out is used.
 */
public class Main {
    Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws MaryHasALambException {
        List<String> arguments = Arrays.stream(args).toList();
        Main main = new Main();
        main.execute(arguments);
    }

    /*
        Executes program with desired parameters
     */
    private void execute(List<String> arguments) throws MaryHasALambException {
        if (arguments.contains("-h")) { // proceed with default settings using STD in/out
            printHelp();
            return;
        }

        //getting desired output format
        Parser parser = getParser(arguments);
        //getting reader for input
        BufferedReader reader = getInputReader(arguments);
        //getting writer for output
        PrintStream writer = getOutputWriter(arguments);

        try {
            //parsing input to output
            parser.parse(reader, writer);
        } catch (IOException e) {
            throw new MaryHasALambException(e);
        }
    }

    private  PrintStream getOutputWriter(List<String> arguments) throws MaryHasALambException {
        int index = arguments.indexOf("-o");
        if(index == -1) {
            return new PrintStream(System.out);
        } else {
            try {
                String pathToOutputFile = arguments.get(index+1);
                return new PrintStream(Files.newOutputStream(Paths.get(pathToOutputFile)));
            } catch (IndexOutOfBoundsException e) {
                throw new MaryHasALambException("Missing arguments for output");
            } catch (IOException e) {
                throw new MaryHasALambException(e);
            }
        }
    }

    private  BufferedReader getInputReader(List<String> arguments) throws MaryHasALambException {
        int index = arguments.indexOf("-f");
        if(index == -1) {
            return new BufferedReader(new InputStreamReader(System.in));
        } else {
            try {
                String pathToInputFile = arguments.get(index+1);
                return Files.newBufferedReader(Paths.get(pathToInputFile));
            } catch (IndexOutOfBoundsException e) {
                throw new MaryHasALambException("Missing arguments for input");
            } catch (IOException e) {
                throw new MaryHasALambException(e);
            }
        }
    }


    /*
        Gets the parser type based on desired output indicated in parameter
        By default returns the Parser that will generate XML output
        Params: args if contains -cvs
     */
    private Parser getParser(List<String> arguments){
        if(arguments.contains("-csv")){
            return new Parser(new CSVOutputWriter());
        } else {
            return new Parser(new XMLOutputWriter());
        }

    }

    private void printHelp(){
        System.err.println("""
                Converts the plain text with statements into XML or CVS output.

                Usage: [options] [args...]
                
                where options include:
                    -xml XML type of output will be produced Default -xml option.
                    -csv CSV type of output will be produced.
                    -f <file> input file that will be used to produce output. File must exist. Default Std in is used
                        Example: -f ./src/test/resources/small.in
                        
                    -o <file> output file that will be used. The output file will be erased if exists without a warning. 
                              Default Std out is used.
                """);

    }


}