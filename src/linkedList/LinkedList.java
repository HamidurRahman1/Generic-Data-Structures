package linkedList;

import java.util.Iterator;

public class LinkedList<T> implements List<T>
{
    class Node<T>
    {
        T data;
        Node<T> next;

        Node(T data)
        {
            this.data = data;
            this.next = null;
        }

        Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public LinkedList() {}

    @Override
    public boolean add(T element) throws NullPointerException
    {
        if(isEmpty())
        {
            head = new Node<>(element);
            size++;
            return true;
        }
        else
        {
            Node<T> temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = new Node<>(element);
            size++;
            return true;
        }
    }

    @Override
    public boolean add(int index, T element) throws NullPointerException, IllegalArgumentException {
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean update(int index, T element) throws IndexOutOfBoundsException, NullPointerException {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
