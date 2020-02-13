package heap;

import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable> implements Heap<T>
{
    private static int capacity = 99;
    private int size;
    private T[] elements;

    public MinHeap() {
        this(capacity);
    }

    public MinHeap(int capacity)
    {
        MinHeap.capacity = capacity;
        elements = (T[]) new Comparable[capacity];
    }

    @Override
    public void add(T element) throws NullPointerException
    {

    }

    @Override
    public T remove() throws NoSuchElementException
    {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
