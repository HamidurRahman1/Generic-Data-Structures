package avlTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AVLTree<T extends Comparable> implements Tree<T>
{
    private static class Node<T>
    {
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;
        private T data;
        private int leftChildHeight;
        private int rightChildHeight;

        private Node(T data)
        {
            this(null, null, null, data);
        }

        private Node(Node<T> parent, Node<T> left, Node<T> right, T data)
        {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.data = data;
            fixHeight();
        }

        private int fixHeight()
        {
            leftChildHeight = rightChildHeight = -1;
            Node<T> left = this.left;
            Node<T> right = this.right;
            if (left != null)
                leftChildHeight = 1 + MAX(left.leftChildHeight, left.rightChildHeight);
            if (right != null)
                rightChildHeight = 1 + MAX(right.leftChildHeight, right.rightChildHeight);
            if (leftChildHeight > rightChildHeight)
                return leftChildHeight;
            return rightChildHeight;
        }

        public void removeChild(Node<T> child)
        {
            if(child == null) return;
            if(this.right == child)
                this.right = null;
            if(this.left == child)
                this.left = null;
        }

        public Iterator<Node> children()
        {
            List<Node> childList = new LinkedList<>();
            if(this.left != null) childList.add(this.left);
            if(this.right != null) childList.add(this.right);
            return childList.iterator();
        }

        private static int MAX(int x, int y)
        {
            if(x > y) return x;
            return y;
        }
    }

    private Node<T> root;
    private int size;

    public AVLTree() {}

    private void addRoot(T data)
    {
        if(root == null)
        {
            root = new Node<>(data);
            size++;
        }
    }

    @Override
    public void add(T data) {
        Node<T> parent = find(data);
        if (parent == null)
            addRoot(data);
        else if (parent.data.compareTo(data) > 0)
            addLeft(parent, data);
        else if (parent.data.compareTo(data) < 0)
            addRight(parent, data);
    }

    private void addLeft(Node<T> parent, T data)
    {
        Node<T> left = new Node<>(data);
        left.parent = parent;
        parent.left = left;
        size++;
        reBalance(parent);
    }

    private void addRight(Node<T> parent, T data)
    {
        Node<T> right = new Node<>(data);
        right.parent = parent;
        parent.right = right;
        size++;
        reBalance(parent);
    }

    @Override
    public boolean contains(T data) {
        Node<T> node = find(data);
        if(node == null || !node.data.equals(data)) return false;
        return true;
    }

    @Override
    public void remove(T data) {
        Node<T> node = find(data);
        if(node == null || !node.data.equals(data)) return;
        Node<T> parent = remove(node);
        reBalance(parent);
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

    private boolean isInternal(Node<T> node)
    {
        return node.children().hasNext();
    }

    private boolean isLeaf(Node<T> node)
    {
        return !isInternal(node);
    }

    private Node<T> find(T data)
    {
        if(root == null) return null;
        return findRecursively(root, data);
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
    public T get(T data) {
        Node<T> node = find(data);
        if(node == null || !node.data.equals(data)) return null;
        return node.data;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void reBalance(Node<T> node)
    {
        if(node == null) return;
        int oldMaxHeight = Node.MAX(node.leftChildHeight, node.rightChildHeight);
        int newHeight = node.fixHeight();

        if(newHeight > node.leftChildHeight + 1 || newHeight > node.rightChildHeight + 1)
        {
            //LL
            if(node.leftChildHeight > node.rightChildHeight && node.left.leftChildHeight >= node.left.rightChildHeight)
            {
                rotate(node, node.left, node.left.left, node, node.left.left.left, node.left.left.right, node.left.right, node.right);
            }
            else if(node.leftChildHeight > node.rightChildHeight && node.left.rightChildHeight > node.left.leftChildHeight) //LR
            {
                rotate(node, node.left.right, node.left, node, node.left.left, node.left.right.left, node.left.right.right, node.right);
            }
            else if(node.rightChildHeight > node.leftChildHeight && node.right.rightChildHeight >= node.right.leftChildHeight) //RR
            {
                rotate(node, node.right, node, node.right.right, node.left, node.right.left, node.right.right.left, node.right.right.right);
            }
            else if(node.rightChildHeight > node.leftChildHeight && node.right.leftChildHeight > node.right.rightChildHeight) //RL
            {
                rotate(node, node.right.left, node, node.right, node.left, node.right.left.left, node.right.left.right, node.right.right);
            }
        }
        newHeight = node.fixHeight();
        if(oldMaxHeight != newHeight) reBalance(node.parent);
    }

    private void rotate(Node<T> problemNode, Node<T> root, Node<T> left, Node<T> right, Node<T> subTree1, Node<T> subTree2, Node<T> subTree3, Node<T> subTree4) {
        Node<T> newLeft = new Node <>(problemNode, subTree1, subTree2, left.data);
        Node<T> newRight = new Node <>(problemNode, subTree3, subTree4, right.data);

        if(subTree1 != null) subTree1.parent = newLeft;
        if(subTree2 != null) subTree2.parent = newLeft;
        if(subTree3 != null) subTree3.parent = newRight;
        if(subTree4 != null) subTree4.parent = newRight;

        newLeft.fixHeight();
        newRight.fixHeight();

        problemNode.data = root.data;
        problemNode.left = newLeft;
        problemNode.right = newRight;
    }

    public List<T> levelOrder()
    {
        List<T> dataList = new LinkedList <>();

        if(root == null) return dataList;

        Queue<Node<T>> nodeQueue = new ConcurrentLinkedQueue<>();

        try
        {
            dataList.add(root.data);
            nodeQueue.add(root);

            while (!nodeQueue.isEmpty())
            {
                Node<T> node = nodeQueue.poll();
                Iterator<Node> nodeItr = node.children();

                while (nodeItr.hasNext())
                {
                    Node<T> cNode = nodeItr.next();
                    nodeQueue.add(cNode);
                    dataList.add(cNode.data);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return dataList;
    }

    @Override
    public String toString()
    {
        return levelOrder().toString();
    }
}
