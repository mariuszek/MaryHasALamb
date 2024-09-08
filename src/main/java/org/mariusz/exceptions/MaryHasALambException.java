package org.mariusz.exceptions;

public class MaryHasALambException extends Exception {

    public MaryHasALambException(String message) {
        super(message);
    }

    public MaryHasALambException(Exception e){
        super(e);
    }

}
