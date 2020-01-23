package queue;

import java.util.NoSuchElementException;

public interface Queue<T>
{
    void enqueue(T element) throws NullPointerException;
    T dequeue() throws NoSuchElementException;
    T peek() throws NoSuchElementException;

    int size();
    boolean isEmpty();
}
