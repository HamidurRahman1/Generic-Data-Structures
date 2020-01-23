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
        if(index == 0) return head.data;
        if(index == size()-1) return current.data;
        Node<T> positionNode = findNodeBefore(index);
        return positionNode.next.data;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException
    {
        if(isEmpty()) throw new IndexOutOfBoundsException("List is empty.");
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is invalid.");
        if(index == 0)
        {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
        else
        {
            Node<T> positionNode = findNodeBefore(index);
            T data = positionNode.data;
            if(index == size()-1)
            {
                positionNode.next = null;
                size--;
                return data;
            }
            else
            {
                positionNode.next = positionNode.next.next;
                size--;
                return data;
            }
        }
    }

    @Override
    public boolean remove(T element) throws IllegalAccessException
    {
        if(isEmpty()) throw new IllegalAccessException("List is empty.");
        if(element == null) throw new NullPointerException("NULL given.");
        if(head.data.equals(element))
        {
            head = head.next;
            size--;
            return true;
        }
        int i = 1;
        while (i < size())
        {
            Node<T> positionNode = findNodeBefore(i);
            if(positionNode.next.data.equals(element))
            {
                if(positionNode.next.next == null)
                {
                    positionNode.next = null;
                    current = positionNode;
                    size--;
                    return true;
                }
                else
                {
                    positionNode.next = positionNode.next.next;
                    size--;
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean update(int index, T element) throws IndexOutOfBoundsException, NullPointerException
    {
        if(element == null) throw new NullPointerException("Given argument is null");
        if(isEmpty()) throw new IndexOutOfBoundsException("List is empty.");
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is invalid.");
        if(index == 0)
        {
            head.data = element;
            return true;
        }
        else if(index == (size()-1))
        {
            current.data = element;
            return true;
        }
        else
        {
            Node<T> positionNode = findNodeBefore(index);
            positionNode.next.data = element;
            return true;
        }
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
        return new ListIterator<>(head);
    }

    private class ListIterator<T> implements Iterator<T>
    {
        private Node<T> node;

        public ListIterator(Node<T> node)
        {
            this.node = node;
        }

        @Override
        public boolean hasNext()
        {
            return node != null;
        }

        @Override
        public T next()
        {
            T data = node.data;
            node = node.next;
            return data;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("This operation is not supported.");
        }
    }
}
