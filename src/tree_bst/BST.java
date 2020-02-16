package tree_bst;

public class BST<T extends Comparable<T>> implements Tree<T>
{
    private static class Node<T>
    {
        private T data;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        private Node(T data) {
            this(data, null, null, null);
        }

        private Node(T data, Node<T> parent, Node<T> left, Node<T> right)
        {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;
    private int size;

    @Override
    public void addRoot(T data) throws Exception
    {

    }

    @Override
    public void add(T data) throws NullPointerException
    {

    }

    @Override
    public boolean contains(T data) throws NullPointerException
    {
        return false;
    }

    @Override
    public void remove(T data) throws NullPointerException
    {

    }

    @Override
    public T get(T data) throws NullPointerException
    {
        return null;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }
}
