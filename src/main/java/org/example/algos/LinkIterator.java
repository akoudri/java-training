package org.example.algos;

public class LinkIterator {

    private Node next;

    public LinkIterator(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public int next() {
        Node n = next;
        next = next.getNext();
        return n.getValue();
    }
}
