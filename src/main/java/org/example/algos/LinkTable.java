package org.example.algos;

public class LinkTable<T> implements Table<T> {

    private int length = 0;
    public Node<T> first = null;
    private Node<T> last = null;

    public LinkIterator<T> getIterator() {
        return new LinkIterator<T>(first);
    }

    @Override
    public void add(T a) {
        if (first == null) {
            first = new Node<T>(a, null);
            last = first;
        } else {
            Node<T> n = new Node<T>(a, null);
            last.setNext(n);
            last = n;
        }
        length ++;
    }

    @Override
    public T get(int idx) {
        return getValue(idx);
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
        Node<T> current = first;
        while (count++ < idx) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        length --;
    }

    public void removeByValue(T value) {
        if (this.isEmpty()) return;
        if (first.getValue() == value) {
            first = first.getNext();
            length --;
            return;
        }
        Node<T> current = first;
        while (current.hasNext()) {
            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                length --;
                break;
            }
            current = current.getNext();
        }
    }

    public void removeAllByValue(T value) {
        if (this.isEmpty()) return;
        while (first != null && first.getValue() == value) {
            first = first.getNext();
            length --;
        }
        Node<T> current = first;
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
        LinkIterator<T> it = this.getIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public T getValue(int idx) {
        if (idx > length) return null;
        int counter = 0;
        Node<T> n = first;
        while (++counter <= idx) {
            n = n.getNext();
        }
        return n.getValue();
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void remove(int idx) {
        this.removeByIndex(idx);
    }
}
