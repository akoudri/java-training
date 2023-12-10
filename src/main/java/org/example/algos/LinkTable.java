package org.example.algos;

import org.example.exceptions.NullValueException;

import java.util.Random;

public class LinkTable {

    private int length = 0;
    public Node first = null;
    private Node last = null;

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

    public void remove(int idx) {
        //TODO
    }

    public void setValue(int idx, int value) {
        //TODO
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
        for (int i = 0; i < 50; i++) {
            l.add(r.nextInt(100));
        }
        try {
            Node n = l.first;
            while (n.hasNext()) {
                System.out.print(n.getValue() + " ");
                n = n.getNext();
            }
            System.out.println();
            System.out.println(l.getValue(5));
        } catch (NullValueException e) {
            throw new RuntimeException(e);
        }
    }
}
