package tree_bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

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
            add(find(root.left, root.left, data), data);
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
            add(find(root.right, root.right, data), data);
        }
        else if(root.data.compareTo(data) == 0)
            root.data = data;
    }

    private void add(Node<T> parent, T data)
    {
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

    private Node<T> find(Node<T> running, Node<T> parent, T data)
    {
        if(running == null)
            return parent;
        if(data.compareTo(running.data) == 0)
            return running;
        if(data.compareTo(running.data) < 0)
            return find(running.left, running, data);
        else
            return find(running.right, running, data);
    }

    @Override
    public boolean contains(T data) throws NullPointerException
    {
        if(data == null) throw new NullPointerException("NULL given.");
        Node<T> node = find(root, root, data);
        if(node == null)
            return false;
        return node.data.equals(data);
    }

    @Override
    public void remove(T data) throws NullPointerException
    {
        if(data == null) throw new NullPointerException("NULL given.");
        Node<T> node = find(root, root, data);
        if(node == null || !node.data.equals(data)) return;
        if(node.left == null && node.right == null)
            removeAsLeaf(node);
//        if(node.left != null && node.right != null)
//            removeAsDecendent(node);
        else if(node.left != null && node.right == null)
            relinkLeftChild(node);
//        else
//            relinkRightChild(node);
    }

    private void relinkLeftChild(Node<T> node)
    {
        if(node.parent != null)
        {
            node.parent.left = node.left;
            size--;
        }
        else
        {
            root.data = node.data;
            root.left = null;
            size--;
        }
    }

    private void removeAsLeaf(Node<T> node)
    {
        if(node.parent != null)
        {
            if(node.data.compareTo(node.parent.data) < 0)
            {
                node.parent.left = null;
                size--;
            }
            else if(node.data.compareTo(node.parent.data) > 0)
            {
                node.parent.right = null;
                size--;
            }
        }
        else
        {
            root = null;
            size = 0;
        }
    }

    private void remove(Node<T> node, T data)
    {

    }

    @Override
    public T get(T data) throws NullPointerException
    {
        if(data == null) throw new NullPointerException("NULL given.");
        Node<T> node = find(root, root, data);
        if(node == null)
            return null;
        if(node.data.equals(data))
            return node.data;
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

    public List<T> levelOrder()
    {
        Queue<Node<T>> queue = new ConcurrentLinkedQueue<>();
        List<T> list = new LinkedList<>();
        if(root == null) return null;
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node<T> node = queue.poll();
            list.add(node.data);

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return list;
    }
}
