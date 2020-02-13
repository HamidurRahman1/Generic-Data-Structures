package heap;

import java.util.NoSuchElementException;

public interface Heap<T>
{
    void add(T element) throws NullPointerException;
    T remove() throws NoSuchElementException;

    int size();
    int capacity();
    boolean isEmpty();
}
