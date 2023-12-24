package org.example.algos;

public class LinkIterator<X> {

    private Node<X> next;

    public LinkIterator(Node<X> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public X next() {
        Node<X> n = next;
        next = next.getNext();
        return n.getValue();
    }
}
