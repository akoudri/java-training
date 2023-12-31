package org.example.algos;

import org.example.exceptions.NullValueException;

public class DynamicTable<T> implements Table<T>{

    private int length = 0;
    private int capacity = 50;
    private T[] array = (T[]) new Object[capacity];

    /**
     * @param a : the number to be added
     */
    @Override
    public void add(T a) {
        if (length >= capacity) {
            T[] narray = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                narray[i] = array[i];
            }
            capacity *= 2;
            array = narray;
        }
        array[length] = a;
        length ++;
    }

    /**
     * @param idx
     * @return the value at index idx
     */
    @Override
    public T get(int idx) {
        if (idx < length) return array[idx];
        return null;
    }

    @Override
    public void remove(int idx) {
        array[idx] = null;
        length --;
    }

    public void setValue(int idx, T value) {
        array[idx] = value;
    }

    public T getValue(int idx) throws NullValueException {
        if (array[idx] == null) throw new NullValueException();
        return array[idx];
    }

    @Override
    public int getLength() {
        return length;
    }

    public void of(T... elements) {
        for (T e : elements) {
            System.out.println(e);
        }
    }

}
