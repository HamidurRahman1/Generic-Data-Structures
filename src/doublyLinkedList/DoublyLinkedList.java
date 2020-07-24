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

    @Override
    public void addFirst(T element) throws NullPointerException {

    }

    @Override
    public void addLast(T element) throws NullPointerException {

    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, NullPointerException {

    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
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
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
