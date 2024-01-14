package org.example.structure;

import org.example.exceptions.FifoEmptyException;
import org.example.exceptions.FifoFullException;

import java.util.ArrayList;
import java.util.List;

public class Queue<E> implements QueueIface<E>{

    private List<E> elements;
    private int capacity;

    public Queue() {
        elements = new ArrayList<>();
        capacity = -1;
    }

    public Queue(int capacity) {
        elements = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void add(E e) throws FifoFullException {
        if (capacity == -1) {
            elements.add(e);
        } else {
            if (elements.size() == capacity) throw new FifoFullException();
            elements.add(e);
        }
    }

    @Override
    public E remove() throws FifoEmptyException {
        return null;
    }

    @Override
    public E examine() throws FifoEmptyException {
        return null;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }
}
