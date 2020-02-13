package heap;

import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable> implements Heap<T>
{
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
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
