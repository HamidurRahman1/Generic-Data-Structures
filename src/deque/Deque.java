package deque;

import java.util.NoSuchElementException;

public interface Deque<T>
{
    void addFirst(T element) throws NullPointerException;
    void addLast(T element) throws NullPointerException;

    T removeFirst() throws NoSuchElementException;
    T removeLast() throws NoSuchElementException;

    T getFirst() throws NoSuchElementException;
    T getLast() throws NoSuchElementException;

    int size();
    boolean isEmpty();
}
