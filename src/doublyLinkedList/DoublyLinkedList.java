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

        private DNode(T data, DNode<T> previous, DNode<T> next)
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
        if(element == null) throw new NullPointerException("Data cannot be null");
        if(size() == 0 && index == 0) {
            addFirst(element);
            return;
        }
        if(index == size()) {
            addLast(element);
            return;
        }
        if(index < 0 || index > size()) throw new IndexOutOfBoundsException("Given index is not valid");

        int count = 0;
        DNode<T> temp = head;

        while (count < index)
        {
            temp = temp.next;
            count++;
        }

        if(temp.next == null)
        {
            addLast(element);
            swapData(temp, tail);
        }
        else
        {
            DNode<T> newNode = new DNode<>(element);

            newNode.next = temp.next;
            temp.next.previous = newNode;
            temp.next = newNode;
            newNode.previous = temp;

            swapData(temp, newNode);
            size++;
        }
    }

    private void swapData(DNode<T> n1, DNode<T> n2)
    {
        T tempData = n1.data;
        n1.data = n2.data;
        n2.data = tempData;
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
        if(isEmpty()) return null;
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T removeLast()
    {
        if(isEmpty()) return null;
        if(size() == 1)
        {
            T data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        else if(size() == 2)
        {
            T data = tail.data;
            head.next = null;
            tail.previous = null;
            tail = head;
            size--;
            return data;
        }
        else
        {
            T data = tail.data;
            tail = tail.previous;
            tail.next = null;
            size--;
            return data;
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is not valid");
        if(isEmpty()) return null;
        if((size() == 1 && index == 0) || (size() == 2 && index == 0)) return removeFirst();
        else if(size() == 2 && index == 1) return removeLast();
        else return null;
    }

    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException, NullPointerException {
        if(element == null) throw new NullPointerException("Data cannot be null");
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException("Given index is not valid");
        if(head == null) throw new IllegalArgumentException("Trying to set an element in an empty list");

        if(index == 0)
        {
            head.data = element;
            return;
        }

        int count = 0;
        DNode<T> node = head;
        while (count != index)
        {
            node = node.next;
            count++;
        }
        node.data = element;
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
    public Iterator<T> iterator()
    {
        return new AscendingIterator<>(head);
    }

    public Iterator<T> reverseIterator()
    {
        return new DescendingIterator <>(tail);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(head == null) return "";
        DNode<T> node = head;
        while (node.next != null)
        {
            stringBuilder.append(node.data).append(" -> ");
            node = node.next;
        }
        stringBuilder.append(node.data);
        return stringBuilder.toString();
    }

    private class AscendingIterator<T> implements Iterator<T>
    {
        private DNode<T> temp;

        public AscendingIterator(DNode<T> temp)
        {
            this.temp = temp;
        }

        @Override
        public boolean hasNext()
        {
            return temp != null;
        }

        @Override
        public T next()
        {
            T ans = temp.data;
            temp = temp.next;
            return ans;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private class DescendingIterator<T> implements Iterator<T>
    {
        private DNode<T> temp;

        public DescendingIterator(DNode <T> temp)
        {
            this.temp = temp;
        }

        @Override
        public boolean hasNext()
        {
            return temp != null;
        }

        @Override
        public T next()
        {
            T ans = temp.data;
            temp = temp.previous;
            return ans;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
