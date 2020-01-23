package queue;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T>
{
    private class Node<T>
    {
        private Node<T> next;
        private T data;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.next = next;
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> current;
    private int size;

    public LinkedQueue() {}

    @Override
    public void enqueue(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(isEmpty())
        {
            head = new Node<>(element);
            current = head;
            size++;
        }
        else
        {
            Node<T> tNode = new Node<>(element);
            current.next = tNode;
            current = tNode;
            size++;
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException
    {
        if(isEmpty()) throw new NoSuchElementException("Empty queue.");
        else
        {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    @Override
    public T peek() throws NoSuchElementException
    {
        if(isEmpty()) throw new NoSuchElementException("Empty queue.");
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
