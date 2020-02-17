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
    public void addRoot(T data) throws NullPointerException, Exception
    {
        if(data == null) throw new NullPointerException("NULL given.");
        if(root != null) throw new Exception("Root already exists.");
        root = new Node<>(data);
        size++;
    }

    @Override
    public void add(T data) throws NullPointerException, Exception
    {
        if(data == null) throw new NullPointerException("NULL given.");
        if(root == null) addRoot(data);
        else if(data.compareTo(root.data) < 0)
        {
            if(root.left == null)
            {
                Node<T> node = new Node<>(data);
                root.left = node;
                node.parent = root;
                size++;
                return;
            }
            addLeft(data);
            inOrder(root);
        }
        else if(data.compareTo(root.data) > 0)
        {
            if(root.right == null)
            {
                Node<T> node = new Node<>(data);
                root.right = node;
                node.parent = root;
                size++;
                return;
            }
            addRight(data);
        }
        else if(root.data.compareTo(data) == 0)
            root.data = data;
    }

    private void addLeft(T data)
    {
        Node<T> parent = find(root.left, root.left, data);
        if(data.compareTo(parent.data) < 0)
        {
            Node<T> node = new Node<>(data);
            parent.left = node;
            node.parent = parent;
            size++;
        }
        else if(data.compareTo(parent.data) > 0)
        {
            Node<T> node = new Node<>(data);
            parent.right = node;
            node.parent = parent;
            size++;
        }
        else if(data.compareTo(parent.data) == 0)
            parent.data = data;
    }

    private void addRight(T data)
    {

    }

    private Node<T> find(Node<T> running, Node<T> parent, T data)
    {
        if(running == null) return parent;
        if(data.compareTo(running.data) < 0)
            return find(running.left, running, data);
        return find(running.right, running, data);
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
        root = null;
        size = 0;
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

    private void inOrder(Node<T> node)
    {
        if(node == null) return;
        if(node.left != null) inOrder(node.left);
        System.out.println(node.data);
        if(node.right != null) inOrder(node.right);
    }
}
