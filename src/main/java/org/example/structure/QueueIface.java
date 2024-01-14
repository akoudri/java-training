package org.example.structure;

import org.example.exceptions.FifoEmptyException;
import org.example.exceptions.FifoFullException;

public interface QueueIface<E> {

    void add(E e) throws FifoFullException;

    E remove() throws FifoEmptyException;

    E examine() throws FifoEmptyException;

    boolean offer(E e);

    E peek();

    E poll();

}
