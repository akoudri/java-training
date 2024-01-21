package org.example.structure;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> implements StackIface<E> {
    private List<E> elements;

    public Stack() {
        this.elements = new ArrayList<>();
    }

    @Override
    public boolean empty() {
        return elements.isEmpty();
    }

    @Override
    public E peek() {
        if (empty()) return null;
        return elements.get(elements.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) return null;
        E e = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return e;
    }

    @Override
    public void push(E e) {
        elements.add(e);
    }


    public void display() {
        elements.forEach(System.out::println);
    }

}
