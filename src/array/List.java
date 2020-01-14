package array;

import java.util.NoSuchElementException;

public interface List<T> extends Iterable<T>
{
    void add(T element) throws NullPointerException;
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;
    T remove(T element) throws NoSuchElementException;
    void swap(int index1, int index2) throws IndexOutOfBoundsException, NoSuchElementException;

    Integer size();
    Integer capacity();
    Boolean isEmpty();
}
