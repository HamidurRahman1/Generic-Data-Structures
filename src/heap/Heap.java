package heap;

import java.util.NoSuchElementException;

public interface Heap<T>
{
    void add(T element) throws NullPointerException, Exception;
    T remove() throws NoSuchElementException;

    int size();
    int capacity();
    boolean isEmpty();
}
