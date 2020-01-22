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
    public boolean add(int index, T element) throws NullPointerException, IllegalArgumentException
    {
        if(index < 0 || index > size()) throw new IllegalArgumentException("index is invalid, index="+index);
        if(element == null) throw new NullPointerException("Passed element cannot be null.");
        if(index == size()) add(element);
        if(index == 0)
        {
            Node<T> t = new Node<>(element);
            t.next = head;
            head = t;
            size++;
        }
        else
        {
            Node<T> temp = head;
            int i = 0;
            while (i < (index-1))
            {
                temp = temp.next;
                i++;
            }

            Node<T> newNode = new Node<>(element);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        return true;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException
    {
        if(isEmpty()) throw new IndexOutOfBoundsException("List is empty.");
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is invalid.");
        int i = 0;
        Node<T> tNode = head;
        while (i < index)
        {
            tNode = tNode.next;
            i++;
        }
        return tNode.data;
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
    public boolean update(int index, T element) throws IndexOutOfBoundsException, NullPointerException
    {
        if(element == null) throw new NullPointerException("Given argument is null");
        if(isEmpty()) throw new IndexOutOfBoundsException("List is empty.");
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is invalid.");
        int i = 0;
        Node<T> tNode = head;
        while (i < index)
        {
            tNode = tNode.next;
            i++;
        }
        tNode.data = element;
        return true;
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

    public void print()
    {
        Node<T> temp = head;
        while (temp.next != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
