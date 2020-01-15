package linkedList;

public interface List<T> extends Iterable<T>
{
    boolean add(T element) throws NullPointerException;
    boolean add(int index, T element) throws NullPointerException, IllegalArgumentException;
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;
    boolean remove(T element);

    int size();
    int capacity();
    boolean isEmpty();
    boolean isFull();
}
