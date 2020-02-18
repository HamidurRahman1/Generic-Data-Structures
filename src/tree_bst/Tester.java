package tree_bst;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        Tree<Integer> t = new BST<>();
        t.add(5);
//        t.add(4);
//        t.add(8);
//        t.add(6);
//        t.add(2);
//        t.add(8);
//        t.add(6);
//        t.add(10);
//        t.add(9);
        System.out.println(((BST<Integer>) t).levelOrder());
        t.remove(5);
        System.out.println(t.size());
        System.out.println(((BST<Integer>) t).levelOrder());
    }
}

