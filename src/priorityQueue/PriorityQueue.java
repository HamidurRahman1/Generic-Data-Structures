package priorityQueue;

import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T>
{
    private class Node<T>
    {
        private T data;
        private Node<T> next;

        private Node(T data)
        {
            this(data, null);
        }

        private Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public PriorityQueue() {}

    @Override
    public void add(T element) throws NullPointerException {

    }

    @Override
    public T removeMin() throws NoSuchElementException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null)
        {
            stringBuilder.append(head.data + " ->");
            head = head.next;
        }
        return stringBuilder.toString();
    }
}
