package heap;

import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable> implements Heap<T>
{
    private static int capacity = 5;
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
    public void add(T element) throws NullPointerException, Exception
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(size() == capacity()) throw new Exception("Heap is full.");
        elements[size++] = element;
        bubbleUp();
    }

    public void bubbleUp()
    {
        int child = size()-1;
        int parent = (child-1)/2;

        while(parent >= 0 && elements[child].compareTo(elements[parent]) < 0)
        {
            swap(child, parent);
            child = parent;
            parent = (child-1)/2;
        }
    }

    private void swap(int child, int parent)
    {
        T t = elements[child];
        elements[child] = elements[parent];
        elements[parent] = t;
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

    @Override
    public String toString()
    {
        for(T d : elements)
            System.out.print(d + " -> ");
        System.out.println();
        return "MinHeap{}";
    }
}
