package deque;

import java.util.NoSuchElementException;

public class DoubleLinkedDeque<T> implements Deque<T>
{
    private class Node<T>
    {
        private Node<T> next;
        private Node<T> previous;
        private T data;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> next, Node<T> previous) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addFirst(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(isEmpty())
        {
            head = new Node<>(element);
            tail = head;
            size++;
        }
        else
        {
            Node<T> tNode = new Node<>(element);
            tNode.next = head;
            head.previous = tNode;
            head = tNode;
            size++;
        }
    }

    @Override
    public void addLast(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(isEmpty())
        {
            addFirst(element);
        }
        else
        {
            Node<T> tNode = new Node<>(element);
            tNode.previous = tail;
            tail.next = tNode;
            tail = tNode;
            size++;
        }
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        return null;
    }

    @Override
    public T getFirst() throws NoSuchElementException
    {
        if(isEmpty()) throw new NoSuchElementException("Empty Deque.");
        return head.data;
    }

    @Override
    public T getLast() throws NoSuchElementException
    {
        if(isEmpty()) throw new NoSuchElementException("Empty Deque.");
        return tail.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public void print()
    {
        Node<T> t = head;
        while (t != null)
        {
            System.out.println("=> " + t.data);
            t = t.next;
        }
    }
}
