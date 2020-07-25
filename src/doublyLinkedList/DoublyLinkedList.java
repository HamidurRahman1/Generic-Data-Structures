package doublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T>, Iterable<T>
{
    private static class DNode<T> {
        private T data;
        private DNode<T> previous;
        private DNode<T> next;

        private DNode(T data)
        {
            this(data, null, null);
        }

        private DNode(T data, DNode <T> previous, DNode <T> next)
        {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private int size;
    private DNode<T> head;
    private DNode<T> tail;

    public DoublyLinkedList() {}

    @Override
    public void addFirst(T element) throws NullPointerException {
        if(element == null) throw new NullPointerException("Data cannot be null");
        DNode<T> node = new DNode <>(element);

        if(isEmpty()) head = tail = node;
        else
        {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T element) throws NullPointerException {
        if(element == null) throw new NullPointerException("Data cannot be null");
        DNode<T> node = new DNode <>(element);

        if(isEmpty()) head = tail = node;
        else
        {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, NullPointerException {

    }

    @Override
    public T getFirst() {
        if(isEmpty()) return null;
        return head.data;
    }

    @Override
    public T getLast() {
        if(isEmpty()) return null;
        return tail.data;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is not valid");

        int count = 0;
        DNode<T> temp = head;

        while (count < size())
        {
            if(count == index) return temp.data;
            temp = temp.next;
            count++;
        }

        return null;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T remove(T element) throws NullPointerException {
        return null;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException, NullPointerException {

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
    public Iterator<T> iterator() {
        return null;
    }

    public Iterator<T> reverseIterator()
    {
        return null;
    }
}
