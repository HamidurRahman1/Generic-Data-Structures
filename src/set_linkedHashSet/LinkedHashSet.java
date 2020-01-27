package set_linkedHashSet;

import java.util.Iterator;
import java.util.List;

public class LinkedHashSet<E> implements Set<E>
{
    private int size;
    private int capacity;
    private List<E> buckets[];

    public LinkedHashSet() {
        this(50);
    }

    public LinkedHashSet(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public E get(E e) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
