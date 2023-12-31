package org.example.algos;

public interface Table<T> {

    void add(T value);

    T get(int idx);

    int getLength();

    void remove(int idx);

}
