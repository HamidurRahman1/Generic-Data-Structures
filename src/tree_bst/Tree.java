package tree_bst;

public interface Tree<T>
{
    void addRoot(T data) throws Exception;
    void add(T data) throws NullPointerException;
    boolean contains(T data) throws NullPointerException;
    void remove(T data) throws NullPointerException;
    T get(T data) throws NullPointerException;
    void clear();

    int size();
    boolean isEmpty();
}
