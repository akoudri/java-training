package org.example.structure;

public interface StackIface<E> {

    boolean empty();

    E peek();

    E pop();

    void push(E e);

    default void blob() {
        System.out.println("Doing blob");
    }

}
