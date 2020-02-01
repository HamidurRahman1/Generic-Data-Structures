package priorityQueue;

import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T>
{
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        private Node(T data)
        {
            this(data, null, null);
        }

        private Node(T data, Node<T> previous, Node<T> next)
        {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public PriorityQueue() {}

    @Override
    public void add(T element) throws NullPointerException
    {
        if(element == null) throw new NullPointerException("NULL given.");
        if(isEmpty())
        {
            head = new Node<>(element);
            size++;
        }
        else
        {
            bubbleDown(new Node<>(element));
            size++;
        }
    }

    private void bubbleDown(Node<T> node)
    {
        if(node.data.compareTo(head.data) < 0)
        {
            node.next = head;
            head.previous = node;
            head = node;
            return;
        }

        if(size() ==  1)
        {
            head.next = node;
            node.previous = head;
            return;
        }

        Node<T> temp = head;

        while (temp.next != null)
        {
            if(node.data.compareTo(temp.data) < 0)
            {
                if(temp.previous == null)
                {
                    node.next = temp;
                    temp.previous = node;
                    return;
                }
                else
                {
                    node.next = temp;
                    node.previous = temp.previous;
                    temp.previous.next = node;
                    return;
                }
            }
            else if(node.data.compareTo(temp.data) == 0)
            {
                node.next = temp.next;
                node.previous = temp;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }

        if(node.data.compareTo(temp.data) < 0)
        {
            node.next = temp;
            node.previous = temp.previous;
            temp.previous.next = node;
        }
        else
        {
            temp.next = node;
            node.previous = temp;
        }
    }

    @Override
    public T removeMin() throws NoSuchElementException
    {
        if(isEmpty()) throw new NoSuchElementException("Empty queue.");
        T data = head.data;
        if(head.next == null)
        {
            head = null;
            size = 0;
            return data;
        }
        else
        {
            head = head.next;
            size--;
            return data;
        }
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
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
//        while (head != null)
//        {
//            stringBuilder.append(head.data + " -> ");
//            head = head.next;
//        }
        return stringBuilder.toString();
    }
}
