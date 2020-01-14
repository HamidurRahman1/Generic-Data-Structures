package array;

import java.util.NoSuchElementException;

public interface Array<T>
{
    Boolean add(T element) throws NullPointerException;
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;
    Boolean remove(T element) throws NoSuchElementException;
    void swap(int index1, int index2) throws IndexOutOfBoundsException, NoSuchElementException;

    Integer size();
    Integer capacity();
    Boolean isEmpty();
    Boolean isFull();
}
