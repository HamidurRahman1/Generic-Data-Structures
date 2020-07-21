package avlTree;

public class Tester
{
    public static void main(String[] args) {
        Tree<Integer> avl = new AVLTree<>();
        avl.add(50);
        avl.add(5);
        avl.add(100);
        avl.add(30);
        avl.add(20);
        avl.add(10);
        avl.add(25);
        avl.add(8);
        avl.add(35);
        avl.add(-10);
        System.out.println(avl);
        System.out.println(((AVLTree<Integer>) avl).levelOrder());
    }
}
