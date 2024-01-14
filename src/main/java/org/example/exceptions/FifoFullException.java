package org.example.exceptions;

public class FifoFullException extends Exception {

    public FifoFullException() {
        super("Fifo full");
    }

}
