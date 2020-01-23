package stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T>
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
    private int size;

    @Override
    public void push(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(isEmpty())
        {
            head = new Node<>(element);
            size++;
        }
        else
        {
            head = new Node<>(element, head);
            size++;
        }
    }

    @Override
    public T pop() throws EmptyStackException
    {
        if(isEmpty()) throw new EmptyStackException();
        else
        {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    @Override
    public T top() throws EmptyStackException
    {
        if(isEmpty()) throw new EmptyStackException();
        return head.data;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
}
