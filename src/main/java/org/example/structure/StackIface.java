package org.example.structure;

public interface StackIface<E> {

    boolean empty();

    E peek();

    E pop();

    void push(E e);

}
