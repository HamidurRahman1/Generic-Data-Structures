package linkedList;

import java.util.Iterator;

public class LinkedList<T> implements List<T>
{
    private class Node<T>
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
    private Node<T> current;
    private int size;

    public LinkedList() {}

    @Override
    public boolean add(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(isEmpty())
        {
            head = new Node<>(element);
            current = head;
            size++;
            return true;
        }
        else
        {
            Node<T> tNode = new Node<>(element);
            current.next = tNode;
            current = tNode;
            size++;
            return true;
        }
    }

    @Override
    public boolean add(int index, T element) throws NullPointerException, IllegalArgumentException
    {
        if(index < 0 || index > size()) throw new IllegalArgumentException("index is invalid, index="+index);
        if(element == null) throw new NullPointerException("Passed element cannot be null.");
        if(index == size()) return add(element);
        if(index == 0)
        {
            Node<T> tNode = new Node<>(element);
            tNode.next = head;
            head = tNode;
            size++;
            return true;
        }
        else
        {
            Node<T> newNode = new Node<>(element);
            Node<T> positionNode = findNodeBefore(index);
            newNode.next = positionNode.next;
            positionNode.next = newNode;
            size++;
            return true;
        }
    }

    private Node<T> findNodeBefore(int index)
    {
        int i = 0;
        Node<T> tNode = head;

        while (i < index-1)
        {
            tNode = tNode.next;
            i++;
        }
        return tNode;
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
    public T remove(int index) throws IndexOutOfBoundsException
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
