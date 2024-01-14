package org.example.exceptions;

public class FifoEmptyException extends Exception {

    public FifoEmptyException() {
        super("Fifo empty");
    }

}
