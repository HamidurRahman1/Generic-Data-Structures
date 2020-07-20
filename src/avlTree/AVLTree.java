package avlTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public void add(T data) {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public T get(T data) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
