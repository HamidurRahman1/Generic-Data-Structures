package priorityQueue;

import java.util.NoSuchElementException;

public interface Queue<T>
{
    void add(T element) throws NullPointerException;
    T removeMin() throws NoSuchElementException;

    int size();
    boolean isEmpty();
}
