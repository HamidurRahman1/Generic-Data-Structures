package array;

import java.util.NoSuchElementException;

public interface Array<T>
{
    boolean add(T element) throws NullPointerException;
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;
    boolean remove(T element) throws NoSuchElementException;
    void swap(int index1, int index2) throws IndexOutOfBoundsException, NoSuchElementException;

    int size();
    int capacity();
    boolean isEmpty();
    boolean isFull();
}
