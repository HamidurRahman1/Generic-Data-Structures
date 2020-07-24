package doublyLinkedList;

public interface List<T>
{
    void addFirst(T element) throws NullPointerException;
    void addLast(T element) throws NullPointerException;
    void add(int index, T element) throws IndexOutOfBoundsException, NullPointerException;

    T getFirst();
    T getLast();
    T get(int index) throws IndexOutOfBoundsException;

    T removeFirst();
    T removeLast();
    T remove(T element) throws NullPointerException;
    T remove(int index) throws IndexOutOfBoundsException;

    void set(int index, T element) throws IndexOutOfBoundsException, NullPointerException;

    int size();
    boolean isEmpty();
}
