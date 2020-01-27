package set_hashSet;

import java.util.LinkedList;
import java.util.List;

public class LinkedHashSet<E> implements Set<E>
{
    private int size;
    private int capacity;
    private List<E> buckets[];

    public LinkedHashSet()
    {
        this(50);
    }

    public LinkedHashSet(int capacity)
    {
        this.capacity = capacity;
        this.buckets = (LinkedList<E>[]) new LinkedList[capacity];
    }

    @Override
    public boolean add(E e)
    {
        int i = e.hashCode() % capacity;

        if(buckets[i] == null)
            buckets[i] = new LinkedList<>();

        for (int j = 0; j < buckets[i].size(); j++)
        {
            if(e.equals(buckets[i].get(j)))
            {
                buckets[i].set(j, e);
                return false;
            }
        }

        buckets[i].add(e);
        size++;
        return true;
    }

    @Override
    public boolean contains(E e)
    {
        return get(e) != null;
    }

    @Override
    public boolean remove(E e)
    {
        int i = e.hashCode() % capacity;

        if(buckets[i] != null)
        {
            for(int j = 0; j < buckets[i].size(); j++)
            {
                if(e.equals(buckets[i].get(j)))
                {
                    buckets[i].remove(e);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(E e)
    {
        int i = e.hashCode() % capacity;

        if(buckets[i] != null)
        {
            for(int j = 0; j < buckets[i].size(); j++)
            {
                if(e.equals(buckets[i].get(j)))
                    return buckets[i].get(j);
            }
        }
        return null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }
}
