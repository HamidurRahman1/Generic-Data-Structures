package binarySearchTree;

public interface Tree<T extends Comparable>
{
    void add(T data);
    boolean contains(T data);
    void remove(T data);
    T get(T data);
    void clear();

    int size();
    boolean isEmpty();
}
