package org.example.algos;

import org.example.exceptions.NullValueException;

import java.util.Random;

public class LinkTable {

    private int length = 0;
    public Node first = null;
    private Node last = null;

    public LinkIterator getIterator() {
        return new LinkIterator(first);
    }

    public void add(int a) {
        if (first == null) {
            first = new Node(a, null);
            last = first;
        } else {
            Node n = new Node(a, null);
            last.setNext(n);
            last = n;
        }
        length ++;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void removeByIndex(int idx) {
        if (idx < 0 || idx >= length || isEmpty()) return;
        if (idx == 0) {
            first = first.getNext();
            length --;
            return;
        }
        int count = 1;
        Node current = first;
        while (count++ < idx) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        length --;
    }

    public void removeByValue(int value) {
        if (this.isEmpty()) return;
        if (first.getValue() == value) {
            first = first.getNext();
            length --;
            return;
        }
        Node current = first;
        while (current.hasNext()) {
            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                length --;
                break;
            }
            current = current.getNext();
        }
    }

    public void removeAllByValue(int value) {
        if (this.isEmpty()) return;
        while (first != null && first.getValue() == value) {
            first = first.getNext();
            length --;
        }
        Node current = first;
        while (current != null && current.hasNext()) {
            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                length --;
            } else {
                current = current.getNext();
            }
        }
    }

    public void setValue(int idx, int value) {
        //TODO
    }

    public void display() {
        LinkIterator it = this.getIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public int getValue(int idx) throws NullValueException {
        if (idx > length) throw new NullValueException();
        int counter = 0;
        Node n = first;
        while (++counter <= idx) {
            n = n.getNext();
        }
        return n.getValue();
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        LinkTable l = new LinkTable();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            l.add(1);
        }
        for (int i = 0; i < 5; i++) {
            l.add(2);
        }
        for (int i = 0; i < 10; i++) {
            l.add(1);
        }
        for (int i = 0; i < 5; i++) {
            l.add(2);
        }
        l.display();
        l.removeAllByValue(1);
        l.display();
    }
}
