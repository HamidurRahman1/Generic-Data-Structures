package tree_bst;

import java.util.Iterator;
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

        private void removeChild(Node<T> child)
        {
            if(child == null) return;
            else if(this.right == child)
                this.right = null;
            else if(this.left == child)
                this.left = null;
        }

        private Iterator<Node> children()
        {
            List<Node> childList = new LinkedList<>();
            if(this.left != null) childList.add(left);
            if(this.right != null) childList.add(right);
            return childList.iterator();
        }
    }
    
    private Node<T> root;
    private int size;

    public BST() {}

    private Node<T> root()
    {
        return root;
    }

    private void addRoot(T data)
    {
        if(root != null) return;
        root = new Node <>(data);
        size++;
    }

    @Override
    public void add(T data)
    {
        Node<T> node = find(data);
        if (node == null)
            addRoot(data);
        else if (node.data.compareTo(data) > 0)
            addLeft(node, data);
        else if (node.data.compareTo(data) < 0)
            addRight(node, data);
        else node.data = data;
    }

    private void addLeft(Node<T> parent, T data)
    {
        Node<T> left = new Node <>(data);
        parent.left = left;
        left.parent = parent;
        size++;
    }

    private void addRight(Node<T> parent, T data)
    {
        Node<T> right = new Node <>(data);
        parent.right = right;
        right.parent = parent;
        size++;
    }

    @Override
    public void remove(T data)
    {
        Node<T> node = find(data);
        if(node == null || !node.data.equals(data)) return;
        remove(node);
    }

    private Node<T> remove(Node<T> node)
    {
        if (isLeaf(node))
        {
            Node<T> parent = node.parent;
            if (parent == null) root = null;
            else parent.removeChild(node);
            size--;
            return parent;
        }
        Node<T> descendant = descendant(node);
        promoteDescendant(node, descendant);
        return remove(descendant);
    }

    private void promoteDescendant(Node<T> parent, Node<T> descendant)
    {
        parent.data = descendant.data;
    }

    private Node<T> descendant(Node<T> parent)
    {
        Node<T> child = parent.left;
        if (child != null)
        {
            while (child.right != null) child = child.right;
            return child;
        }
        child = parent.right;
        if (child != null)
        {
            while (child.left != null) child = child.left;
            return child;
        }
        return child;
    }

    @Override
    public T get(T data)
    {
        Node<T> node = find(data);
        if(node == null || !node.data.equals(data)) return null;
        return node.data;
    }

    @Override
    public boolean contains(T data)
    {
        Node<T> node = find(data);
        if(node == null || !node.data.equals(data)) return false;
        return true;
    }

    private Node<T> find(T data)
    {
        if(root() == null) return null;
        return findRecursively(root(), data);
    }

    private Node<T> findRecursively(Node<T> parent, T data)
    {
        int comparison = data.compareTo(parent.data);
        if(comparison == 0) return parent;
        else if(comparison < 0 && parent.left != null) return findRecursively(parent.left, data);
        else if(comparison > 0 && parent.right != null) return findRecursively(parent.right, data);
        return parent;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public int size()
    {
        return size;
    }

    private boolean isInternal(Node<T> node)
    {
        return node.children().hasNext();
    }

    private boolean isLeaf(Node<T> node)
    {
        return !isInternal(node);
    }

    @Override
    public void clear()
    {
        root = null;
        size = 0;
    }

    public List<T> levelOrder()
    {
        List<T> nodeList = new LinkedList <>();

        if(root() == null) return nodeList;

        Queue<Node> nodeQueue = new ConcurrentLinkedQueue <>();

        try
        {
            nodeList.add(root().data);
            nodeQueue.add(root());

            while (!nodeQueue.isEmpty())
            {
                Node<T> node = nodeQueue.poll();
                Iterator<Node> nodeItr = node.children();

                while (nodeItr.hasNext())
                {
                    Node<T> treeNode = nodeItr.next();
                    nodeQueue.add(treeNode);
                    nodeList.add(treeNode.data);
                }
            }
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return nodeList;
    }

    @Override
    public String toString()
    {
        return levelOrder().toString();
    }
}
