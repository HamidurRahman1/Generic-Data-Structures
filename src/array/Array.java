package array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<T> implements List<T>
{
    private static Integer CAPACITY = 100;
    private int currentIndex;
    private T[] array;

    public Array() {
        this(CAPACITY);
    }

    public Array(Integer capacity) throws IllegalArgumentException
    {
        if(capacity <= 0) throw new IllegalArgumentException("Array capacity must be at least 1, given " + capacity);
        CAPACITY = capacity;
        currentIndex = 0;
        this.array = (T[]) new Object[CAPACITY];
    }

    @Override
    public Boolean add(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("Array can contains only non null value.");
        if(!isFull())
        {
            array[currentIndex++] = element;
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= CAPACITY) throw new IndexOutOfBoundsException("Given currentIndex is out of bound, index="+index);
        return array[index];
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T remove(T element) throws NoSuchElementException {
        return null;
    }

    @Override
    public void swap(int index1, int index2) throws IndexOutOfBoundsException, NoSuchElementException {

    }

    @Override
    public Integer size() {
        return currentIndex;
    }

    @Override
    public Integer capacity() {
        return CAPACITY;
    }

    @Override
    public Boolean isEmpty() {
        return currentIndex == 0;
    }

    public Boolean isFull() {
        return currentIndex == CAPACITY;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public static void main(String[] args)
    {

    }
}
