package array;

import java.util.NoSuchElementException;

public class ArrayImpl<T> implements Array<T>
{
    private static int CAPACITY = 100;
    private int currentIndex;
    private T[] array;

    public ArrayImpl() {
        this(CAPACITY);
    }

    public ArrayImpl(int capacity) throws IllegalArgumentException
    {
        if(capacity <= 0) throw new IllegalArgumentException("ArrayImpl capacity must be at least 1, given " + capacity);
        CAPACITY = capacity;
        currentIndex = 0;
        this.array = (T[]) new Object[CAPACITY];
    }

    @Override
    public boolean add(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("ArrayImpl can contains only non null value.");
        if(!isFull())
        {
            array[currentIndex++] = element;
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= CAPACITY) throw new IndexOutOfBoundsException("Given index is out of bound, index="+index);
        return array[index];
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= CAPACITY)
            throw new IndexOutOfBoundsException("Given currentIndex is out of bound, index="+index);

        T temp = array[index];
        bubbleDown(index);
        array[--currentIndex] = null;

        return temp;
    }

    @Override
    public boolean remove(T element) throws NoSuchElementException
    {
        if(element == null) throw new IllegalArgumentException("NULL element passed in as an argument");
        for(int i = 0; i < currentIndex; i++)
        {
            if(array[i].equals(element))
            {
                bubbleDown(i);
                array[--currentIndex] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void swap(int index1, int index2) throws IndexOutOfBoundsException, NoSuchElementException
    {
        if(index1 < 0 || index1 >= CAPACITY || index2 < 0 || index2 >= CAPACITY)
            throw new IndexOutOfBoundsException("Invalid index given.");
        if(array[index1] == null || array[index2] == null)
            throw new NoSuchElementException("Given index does have any value associated with it.");

        T firstElem = array[index1];
        array[index1] = array[index2];
        array[index2] = firstElem;
    }

    private void bubbleDown(int index)
    {
        for(int i = index; i < currentIndex-1; i++)
        {
            swap(i, i+1);
        }
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public int capacity() {
        return CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public boolean isFull() {
        return currentIndex == CAPACITY;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for(int i = 0; i < currentIndex; i++)
        {
            stringBuilder.append(array[i] + ", ");
        }
        return stringBuilder.append("]").toString();
    }
}
